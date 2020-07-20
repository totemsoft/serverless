package au.com.totemsoft.serverless.elixir.service;

import javax.jms.JMSException;

public interface MessageService {

    void sendMessage(Object message) throws JMSException;

}
