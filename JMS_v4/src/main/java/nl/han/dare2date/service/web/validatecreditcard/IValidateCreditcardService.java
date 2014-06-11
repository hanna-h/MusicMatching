package nl.han.dare2date.service.web.validatecreditcard;

import nl.han.dare2date.Creditcard;

/**
 * Created by root on 5-6-14.
 */
public interface IValidateCreditcardService {
    boolean validate(Creditcard cc);
}
