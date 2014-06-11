package creditcheck.service.jms;

/**
 * Created by root on 5-6-14.
 */

import nl.han.dare2date.*;
import nl.han.dare2date.service.jms.util.Replier;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.ServerSession;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.Serializable;
import nl.han.dare2date.service.jms.util.*;

public class ExternalValidateCreditcardReplier extends Replier {
    private Creditcard card;

    protected ExternalValidateCreditcardReplier(Connection connection,
        String requestQueueName, String invalidQueueName)
    throws JMSException, NamingException {
        super(connection, requestQueueName, invalidQueueName);
    }

    @Override
    public ObjectMessage getReplyMessage() {
        ObjectMessage msg = null;
        try {
            msg = getSession().createObjectMessage();
            boolean isValid = false;
            if (card.getCvc() == 1234 && card.getNumber() == 4321) {
                isValid = true;
            }
            ValidateCreditcardResponse response =
                    new ValidateCreditcardResponse(isValid);
            msg.setObject(response);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public void handleMessage(Serializable contents) {
        ValidateCreditcardRequest request =
                (ValidateCreditcardRequest) contents;
        this.card = request.getCard();
    }
}
