package io.dborrego.processor;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.dborrego.model.Book;

@ApplicationScoped
public class BookConsumer {

    private static final Logger LOGGER = Logger.getLogger(BookConsumer.class.getName());

    @Incoming("stock")
    public void generate(Book book) {
        LOGGER.info(String.format("Received %s", book));
    }

}