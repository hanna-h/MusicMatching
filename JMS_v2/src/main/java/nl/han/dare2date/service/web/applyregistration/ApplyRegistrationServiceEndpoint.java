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

package nl.han.dare2date.service.web.applyregistration;

import nl.han.dare2date.*;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import nl.han.dare2date.service.web.confirmregistration.*;
import nl.han.dare2date.service.web.validatecreditcard.*;
import locator.*;

@Endpoint
public class ApplyRegistrationServiceEndpoint {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
    private IServiceLocator serviceLocator;

	public ApplyRegistrationServiceEndpoint(Marshaller marshaller,
			Unmarshaller unmarshaller, IServiceLocator serviceLocator) {
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
        this.serviceLocator = serviceLocator;
	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	@PayloadRoot(localPart = "ApplyRegistrationRequest", namespace = "http://www.han.nl/schemas/messages")
	public ApplyRegistrationResponse applyRegistration(ApplyRegistrationRequest req) {
        Registration reg = req.getRegistration();
        int regNumber = reg.getNumber();
        User usr = reg.getUser();
        Creditcard cc = usr.getCard();

        IValidateCreditcardService vcs = serviceLocator.getService(
                IValidateCreditcardService.class);
        boolean isValid = vcs.validate(cc);
        if (isValid) {
            IConfirmRegistrationService crs = serviceLocator.getService(
                    IConfirmRegistrationService.class);
            crs.confirm(reg);
        }
        reg.setSuccesFul(isValid);
        ApplyRegistrationResponse response =
                new ObjectFactory().createApplyRegistrationResponse();
        response.setRegistration(reg);
        return response;
	}
}
