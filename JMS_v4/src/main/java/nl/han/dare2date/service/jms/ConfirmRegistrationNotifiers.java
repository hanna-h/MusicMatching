package nl.han.dare2date.service.jms.util;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * Created by root on 6-6-14.
 */
public class ConfirmRegistrationNotifiers {
    public static void main(String[] args) {
        DurableObserver obs1 = new UserNotification();
        DurableObserver obs2 = new SubscriberNotification();
        DurableObserver obs3 = new PublisherNotification();

        try {
            ObserverGateway gtw1 = new ObserverGateway(obs1, Queues.UPDATE_TOPIC_NAME);
            ObserverGateway gtw2 = new ObserverGateway(obs2, Queues.UPDATE_TOPIC_NAME);
            ObserverGateway gtw3 = new ObserverGateway(obs3, Queues.UPDATE_TOPIC_NAME);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
