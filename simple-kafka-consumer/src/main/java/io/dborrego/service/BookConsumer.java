package io.dborrego.service;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BookConsumer {

    private static final Logger log = Logger.getLogger(BookConsumer.class);

    @Incoming("books-new")
    public void toUpperCase(String message) {
        log.info(message);
    }

}
