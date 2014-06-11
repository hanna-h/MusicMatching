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

package nl.han.dare2date.service.web.confirmregistration;

import nl.han.dare2date.*;
import nl.han.dare2date.service.jms.util.ConfirmRegistrationRequest;
import nl.han.dare2date.service.jms.util.SubjectGateway;
import nl.han.dare2date.service.jms.util.Queues;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.Serializable;

/**
 * 
 * @author mdkr
 *
 * Is used as a JMS publisher
 */
public class ConfirmRegistrationService implements IConfirmRegistrationService {
	public void confirm(Registration reg) {
        String topicName = Queues.UPDATE_TOPIC_NAME;
        try {
            SubjectGateway sg = new SubjectGateway(topicName);
            ConfirmRegistrationRequest crr = new ConfirmRegistrationRequest(reg);
            Serializable contents = crr.getRegistration();
            sg.notifyObservers(contents);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
	}
}
