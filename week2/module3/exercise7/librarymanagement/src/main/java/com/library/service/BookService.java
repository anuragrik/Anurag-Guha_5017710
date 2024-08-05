package week2.module3.exercise7.librarymanagement.src.main.java.com.library.service;

import week2.module3.exercise7.librarymanagement.src.main.java.com.library.repository.BookRepository;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
