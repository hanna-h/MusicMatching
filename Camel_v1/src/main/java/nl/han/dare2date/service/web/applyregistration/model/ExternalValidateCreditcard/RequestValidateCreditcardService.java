package nl.han.dare2date.service.web.applyregistration.model.ExternalValidateCreditcard;

/**
 * Created by root on 18-6-14.
 */
public class RequestValidateCreditcardService {
    public static void main(String[] args) throws Exception {
        System.out.println("RequestValidateCreditcardService entered");
        org.apache.camel.main.Main main = new org.apache.camel.main.Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new ResponseValidateCreditcardService());
        main.run();
    }
}
