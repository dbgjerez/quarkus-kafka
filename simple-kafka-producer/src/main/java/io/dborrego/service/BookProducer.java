package io.dborrego.service;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class BookProducer {

    // Pages contains the seconds of the msg is sended
    private static final String BOOK_FORMAT_STRING = "Book[ title: {0}, Pages: {1} ]";

    @Outgoing("books-new")
    public Multi<String> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1)).map(generateBook);
    }

    Function<Long, String> generateBook = l -> MessageFormat.format(BOOK_FORMAT_STRING, "The Lord of the Rings",
            String.valueOf(l));

}
