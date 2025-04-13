package org.example.service;


import org.example.model.Book;
import org.example.repo.BookRepository;

import java.util.Optional;

public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public String getBookTitle(Long id) {
        Optional<Book> book = repo.findById(id);
        return book.map(Book::getTitle).orElse("Not found");
    }
}
