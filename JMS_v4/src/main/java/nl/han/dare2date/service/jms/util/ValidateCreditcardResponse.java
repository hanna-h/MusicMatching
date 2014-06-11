package nl.han.dare2date.service.jms.util;

import java.io.Serializable;
/**
 * Created by root on 6-6-14.
 */
public class ValidateCreditcardResponse implements Serializable {
    private boolean isValid;
    public ValidateCreditcardResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }
}
