package nl.han.dare2date.service.jms.util;

import java.util.Observer;

/**
 * Created by root on 6-6-14.
 */
public abstract class DurableObserver implements Observer {
    /**
     * Provide the subscriber name
     * @return
     */
    public abstract String getSubscriberName();
}
