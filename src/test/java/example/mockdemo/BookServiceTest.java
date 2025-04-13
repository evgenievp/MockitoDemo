package example.mockdemo;



import org.example.model.Book;
import org.example.repo.BookRepository;
import org.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    public void testGetBookTitleFound() {
        // Arrange: мокваме репозиторито
        BookRepository repo = mock(BookRepository.class);
        BookService service = new BookService(repo);

        when(repo.findById(1L)).thenReturn(Optional.of(new Book(1L, "Mocked Book")));

        String title = service.getBookTitle(1L);


        assertEquals("Mocked Book", title);
    }

    @Test
    public void testGetBookTitleNotFound() {
        BookRepository repo = mock(BookRepository.class);
        BookService service = new BookService(repo);

        when(repo.findById(99L)).thenReturn(Optional.empty());

        String title = service.getBookTitle(99L);

        assertEquals("Not found", title);
    }
}
