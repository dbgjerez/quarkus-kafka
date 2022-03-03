package io.dborrego.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BookConsumer {

    private static final Logger log = Logger.getLogger(BookConsumer.class);

    @ConfigProperty(name = "mp.messaging.incoming.books-new.lag")
    Optional<Long> lag;

    @Incoming("books-new")
    public void toUpperCase(String message) {
        lag.ifPresent(l -> {
            log.info("Sleeping: " + l.toString());
            sleep(l);
        });
        log.info(message);
    }

    private void sleep(Long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

}
