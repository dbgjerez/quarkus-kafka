package io.juanmabm.service;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import javax.enterprise.context.ApplicationScoped;

import io.juanmabm.model.Book;

@ApplicationScoped
public class BookService {

    private RandomGenerator randomGenerator = RandomGenerator.of("L128X256MixRandom");
    private List<String> availableBooks = Arrays.asList(
        "The lord of the rings",
        "Game of thrones",
        "Dragonlance",
        "Mistborn",
        "Stormlight",
        "Harry Potter"
    );

    public Book generateBook() {
        return Book.builder()
            .name(availableBooks.get(randomGenerator.nextInt(0, 5)))
            .pages(randomGenerator.nextInt(1000))
            .build();
    }
}