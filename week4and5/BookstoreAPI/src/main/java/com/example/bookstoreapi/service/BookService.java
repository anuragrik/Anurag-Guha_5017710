package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.service;

import week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<BookDTO> books = new ArrayList<>();

    public BookService() {
        books.add(new BookDTO(1L, "Spring Boot in Action", "Craig Walls", 29.99, "978-1617292545"));
        books.add(new BookDTO(2L, "Effective Java", "Joshua Bloch", 39.95, "978-0134685991"));
    }

    public List<BookDTO> getAllBooks() {
        return books;
    }

    public BookDTO getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addBook(BookDTO book) {
        books.add(book);
    }

    public void updateBook(Long id, BookDTO updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            BookDTO book = books.get(i);
            if (book.getId().equals(id)) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}

