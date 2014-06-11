package nl.han.dare2date.service.jms.util;

import java.io.Serializable;
import nl.han.dare2date.*;
/**
 * Created by root on 11-6-14.
 */
public class ConfirmRegistrationRequest implements Serializable {
    private Registration reg;

    public ConfirmRegistrationRequest(Registration reg) {
        this.reg = reg;
    }

    public Registration getRegistration() {
        return reg;
    }

    public String toString() {
        String message = "User " + reg.getUser().getFirstname() + " " + reg.getUser().getLastname()
                + " (registration number " + reg.getNumber() + ") has registered succesfully on "
                + reg.getDate();
        return message;
    }
}
