package nl.han.dare2date.service.jms.util;

import java.util.Observable;
/**
 * Created by root on 6-6-14.
 */
public class PublisherNotification extends DurableObserver {
    public void update(Observable arg0, Object arg1) {
        System.out.println(getClass().getName() + " Received a Notification: " + arg1);
    }

    @Override
    public String getSubscriberName() {
        return "Publisher";
    }
}
