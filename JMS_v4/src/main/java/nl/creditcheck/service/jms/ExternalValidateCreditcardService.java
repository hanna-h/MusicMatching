package creditcheck.service.jms;

import nl.han.dare2date.service.jms.util.JMSUtil;
import nl.han.dare2date.service.jms.util.Queues;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * Created by root on 5-6-14.
 */
public class ExternalValidateCreditcardService {

    public static void main(String args[]) {
        new ExternalValidateCreditcardService().initialize();
    }

    public void initialize() {
        try {
            Connection conn = JMSUtil.getConnection();
            new ExternalValidateCreditcardReplier(conn, Queues.REQUEST_QUEUE,
                    Queues.INVALID_QUEUE);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
