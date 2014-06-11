package nl.han.dare2date.service.jms.util;

import nl.han.dare2date.*;
import java.io.Serializable;
/**
 * Created by root on 6-6-14.
 */
public class ValidateCreditcardRequest implements Serializable {
    private Creditcard card;

    public ValidateCreditcardRequest(Creditcard card) {
        this.card = card;
    }

    public Creditcard getCard() {
        return card;
    }
}
