package org.example.repo;

import org.example.model.Book;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long id);
}
