package au.com.totemsoft.serverless.elixir.service.sqs;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import au.com.totemsoft.serverless.elixir.service.MessageService;

@Service("sqsService")
public class AwsSqsServiceImpl implements MessageService {

    @Value("#{environment.AWS_SQS_QUEUE_NAME}")
    private String queueName;

    //** WorkDoks does not require region selection ??? */
    //@Value("#{environment.AWS_REGION ?: 'ap-southeast-2'}")
    //private String region;
    //private Region DEFAULT_REGION = Region.getRegion(Regions.AP_SOUTHEAST_2);

    private AmazonSQSClientBuilder builder;

    private AmazonSQS client() throws JMSException {
        if (builder == null) {
            builder = AmazonSQSClientBuilder.standard()
                //.withCredentials(new EnvironmentVariableCredentialsProvider())
                //.withRegion(region)
                ;
            // check the queue exists
            AmazonSQSMessagingClientWrapper client = connection().getWrappedAmazonSQSClient();
            if (!client.queueExists(queueName)) {
                throw new JMSException("SQS Queue does not exist: " + queueName);
                //client.createQueue(queueName);
            }
        }
        return builder.build();
    }

    private SQSConnection connection() throws JMSException {
        final SQSConnectionFactory cf = new SQSConnectionFactory(
            new ProviderConfiguration(), client());
        return cf.createConnection();
    }

    @Override
    public void sendMessage(Object message) throws JMSException {
        final SQSConnection connection = connection();
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(session.createQueue(queueName));
            final String text;
            if (message instanceof String) {
                text = (String) message;
            } else {
                text = message.toString(); // TODO: json
            }
            producer.send(session.createTextMessage(text));
        } finally {
            connection.close();
        }
    }

}
