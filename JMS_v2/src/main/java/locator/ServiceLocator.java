package locator;

import nl.han.dare2date.service.web.confirmregistration.*;
import nl.han.dare2date.service.web.validatecreditcard.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 6-6-14.
 */
public class ServiceLocator implements IServiceLocator {
    private final Map<Class, Object> services = new HashMap<Class, Object>();

    ServiceLocator() {
        ConfirmRegistrationService cr = new ConfirmRegistrationService();
        ValidateCreditcardService cs = new ValidateCreditcardService();
        services.put(IConfirmRegistrationService.class, cr);
        services.put(IValidateCreditcardService.class, cs);
    }

    public <T> T getService(Class<T> key) {
        return (T) services.get(key);
    }

}
