package au.com.totemsoft.serverless.elixir.service;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public interface MessageService {

    /**
     * Message producer.
     * @param message
     * @throws JMSException
     */
    void sendMessage(Object message) throws JMSException;

    /**
     * Synchronous message consumer.
     * @return
     */
    List<Message> receiveMessages() throws JMSException;

    /**
     * Asynchronous message consumer.
     * @param callback
     */
    void receiveMessages(MessageListener callback) throws JMSException;

}
