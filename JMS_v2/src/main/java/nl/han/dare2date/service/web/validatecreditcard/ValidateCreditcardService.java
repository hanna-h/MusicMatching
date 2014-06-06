/*
    Copyright (C) [2013] by [Rody Middelkoop, HAN University]

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
*/

package nl.han.dare2date.service.web.validatecreditcard;

import nl.han.dare2date.*;
import nl.han.dare2date.service.jms.util.JMSUtil;
import nl.han.dare2date.service.jms.util.Queues;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.NamingException;
import nl.han.dare2date.service.jms.util.*;


/**
 * 
 * @author mdkr
 *
 * Is used as a JMS client using request-reply
 */
public class ValidateCreditcardService implements IValidateCreditcardService {

	public boolean validate(Creditcard cc) {
        Connection conn = JMSUtil.getConnection();

        String requestQueueName = Queues.REQUEST_QUEUE;
        String replyQueueName = Queues.RESPONSE_QUEUE;
        String invalidQueueName = Queues.INVALID_QUEUE;

        nl.han.dare2date.Creditcard card =
                new nl.han.dare2date.Creditcard();
        card.setCvc(cc.getCvc());
        card.setNumber(cc.getNumber());
        card.setValidThrough(cc.getValidThrough());

        try {
            ValidateCreditcardRequestor requestor =
                    new ValidateCreditcardRequestor(conn, requestQueueName,
                            replyQueueName, invalidQueueName, card);
            requestor.send();
            requestor.receiveSync();
            ValidateCreditcardResponse response = requestor.getResponse();
            conn.close();
            return response.isValid();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return false;
	}
}
