package nl.han.dare2date.service.jms.util;

import nl.han.dare2date.Creditcard;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import javax.jms.Connection;
import nl.han.dare2date.service.jms.util.Requestor;

/**
 * Created by root on 6-6-14.
 */
public class ValidateCreditcardRequestor extends Requestor {
    private Creditcard card;

    public ValidateCreditcardRequestor(Connection connection, String requestQueueName,
                                       String replyQueueName, String invalidQueueName, Creditcard card) throws JMSException, NamingException{
        super(connection, requestQueueName, replyQueueName, invalidQueueName);
        this.card = card;
    }
    @Override
    public ObjectMessage getObjectMessage(){
        ObjectMessage msg;
        try{
            msg = getSession().createObjectMessage();
            msg.setObject(new ValidateCreditcardRequest(card));
            return msg;
        } catch (JMSException e){
            e.printStackTrace();
        }
        return null;
    }

    public ValidateCreditcardResponse getResponse()
    {
        ObjectMessage replyMessage = getReplyMessage();
        try {
            return (ValidateCreditcardResponse) replyMessage.getObject();
        }catch (JMSException e){
            e.printStackTrace();
        }
            return null;
    }


}
