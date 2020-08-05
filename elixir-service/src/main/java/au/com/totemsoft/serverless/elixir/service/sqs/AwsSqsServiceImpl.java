package au.com.totemsoft.serverless.elixir.service.sqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.totemsoft.serverless.elixir.service.MessageService;

/**
 * https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-jms-code-examples.html
 * @author shibaevv
 */
@Service("sqsService")
public class AwsSqsServiceImpl implements MessageService {

    @Value("#{environment.PUBLISH_QUEUE_NAME}")
    private String publishQueueName;

    @Value("#{environment.SUBSCRIBE_QUEUE_NAME}")
    private String subscribeQueueName;

    //** WorkDoks does not require region selection ??? */
    //@Value("#{environment.AWS_REGION ?: 'ap-southeast-2'}")
    //private String region;
    //private Region DEFAULT_REGION = Region.getRegion(Regions.AP_SOUTHEAST_2);

    private AmazonSQSClientBuilder builder;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Check the queue exists.
     * @param queueName
     * @throws JMSException
     */
    private void ensureQueueExists(String queueName) throws JMSException {
        AmazonSQSMessagingClientWrapper client = connection(builder.build()).getWrappedAmazonSQSClient();
        if (!client.queueExists(queueName)) {
            //client.createQueue(queueName);
            throw new JMSException("SQS Queue does not exist: " + queueName);
        }
    }

    private AmazonSQS client(String queueName) throws JMSException {
        if (builder == null) {
            builder = AmazonSQSClientBuilder.standard()
                //.withCredentials(new EnvironmentVariableCredentialsProvider())
                //.withRegion(region)
                ;
        }
        ensureQueueExists(queueName);
        return builder.build();
    }

    private SQSConnection connection(AmazonSQS client) throws JMSException {
        final SQSConnectionFactory cf = new SQSConnectionFactory(new ProviderConfiguration(), client);
        return cf.createConnection();
    }

    @Override
    public void sendMessage(Object message) throws JMSException {
        final SQSConnection connection = connection(client(publishQueueName));
        try {
            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            final MessageProducer producer = session.createProducer(session.createQueue(publishQueueName));
            final String text;
            if (message instanceof String) {
                text = (String) message;
            } else {
                text = mapper.writeValueAsString(message);
            }
            producer.send(session.createTextMessage(text));
        } catch (JsonProcessingException e) {
            throw new JMSException(e.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public List<Message> receiveMessages() throws JMSException {
        final long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        final SQSConnection connection = connection(client(subscribeQueueName));
        try {
            final Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            final MessageConsumer consumer = session.createConsumer(session.createQueue(subscribeQueueName));
            List<Message> messages = new ArrayList<Message>();
            while (true) {
                // Wait timeout duration for a message
                Message message = consumer.receive(timeoutMillis);
                //Message message = consumer.receiveNoWait();
                if (message == null) {
                    break;
                }
                messages.add(message);
                message.acknowledge();
            }
            return messages;
        } finally {
            // Close the connection. This closes the session automatically
            connection.close();
        }
    }

    @Override
    public void receiveMessages(MessageListener callback) throws JMSException {
        final long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        final SQSConnection connection = connection(client(subscribeQueueName));
        try {
            final Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            final MessageConsumer consumer = session.createConsumer(session.createQueue(subscribeQueueName));
            consumer.setMessageListener(callback);
            // No messages are processed until this is called
            connection.start();
            try {
                waitForTimeoutOfSilence(timeoutMillis);
            } catch (InterruptedException ignore) {}
        } finally {
            // Close the connection. This closes the session automatically
            connection.close();
        }
    }

    private void waitForTimeoutOfSilence(long timeoutMillis) throws InterruptedException {
        final long timeOfLastMessage = System.nanoTime();
        for (;;) {
            long timeSinceLastMessage = System.nanoTime() - timeOfLastMessage;
            long remainingTillOneMinuteOfSilence = TimeUnit.MILLISECONDS.toNanos(timeoutMillis) - timeSinceLastMessage;
            if (remainingTillOneMinuteOfSilence < 0) {
                break;
            }
            TimeUnit.NANOSECONDS.sleep(remainingTillOneMinuteOfSilence);
        }
    }

}
