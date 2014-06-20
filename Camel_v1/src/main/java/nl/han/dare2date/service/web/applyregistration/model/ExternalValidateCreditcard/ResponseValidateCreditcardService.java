package nl.han.dare2date.service.web.applyregistration.model.ExternalValidateCreditcard;

import nl.han.dare2date.service.web.applyregistration.ApplyRegistrationRoute;
import nl.han.dare2date.service.web.applyregistration.model.ApplyRegistrationRequest;
import nl.han.dare2date.service.web.applyregistration.model.ApplyRegistrationResponse;
import nl.han.dare2date.service.web.applyregistration.model.Creditcard;
import nl.han.dare2date.service.web.applyregistration.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

/**
 * Created by root on 18-6-14.
 */
public class ResponseValidateCreditcardService extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:queue:RequestQueue")
                .log("${body}")
                    .process(new ValidateCard())
                            .to("activemq:queue:ReplyQueue");
    }

    private static final class ValidateCard implements Processor {
        public void process(Exchange exchange) throws Exception {
            System.out.println("yay");
            Creditcard card = new Creditcard();
            card = exchange.getIn().getBody(Creditcard.class);
            boolean isValid = false;
            exchange.getOut().setHeader("false", "valid");
            if (card.getCvc().intValue() == 1234 && card.getNumber().intValue() == 4321) {
                isValid = true;
                exchange.getOut().setHeader("true", "valid");
            }
            exchange.getOut().setBody(card);
        }
    }
}
