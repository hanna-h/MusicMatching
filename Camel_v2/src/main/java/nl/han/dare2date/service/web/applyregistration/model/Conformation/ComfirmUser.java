package nl.han.dare2date.service.web.applyregistration.model.Conformation;

/**
 * Created by root on 18-6-14.
 */
public class ComfirmUser {
    public static void main(String[] args) throws Exception {
        org.apache.camel.main.Main main = new org.apache.camel.main.Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new ConfirmTopicUser());
        main.addRouteBuilder(new ConfirmTopicUser());
        main.addRouteBuilder(new ConfirmTopicUser());
        main.run();

    }
}
