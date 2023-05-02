package io.juanmabm.processor;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.juanmabm.model.Book;
import io.juanmabm.service.BookService;
import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class BookProducer {

    private BookService bookService;

    BookProducer(BookService bookService) {
        this.bookService = bookService;
    }

    @Outgoing("books-new")
    public Multi<Book> generate() {
        return Multi.createFrom()
            .ticks()
            .every(Duration.ofSeconds(1))
            .map(any -> bookService.generateBook());
    }

}