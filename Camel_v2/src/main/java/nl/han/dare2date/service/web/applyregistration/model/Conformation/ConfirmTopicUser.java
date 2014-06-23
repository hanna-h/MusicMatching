package nl.han.dare2date.service.web.applyregistration.model.Conformation;


import nl.han.dare2date.service.web.applyregistration.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by root on 18-6-14.
 */
public class ConfirmTopicUser extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("activemq:topic:ConfirmUser").
                process(new displayMessage());
    }
    private static final class displayMessage implements Processor {
        public void process(Exchange exchange) throws Exception {
            User user = exchange.getIn().getBody(User.class);
            System.out.println("New user; " + user.getFirstname() + " " + user.getLastname());
        }
    }
}

