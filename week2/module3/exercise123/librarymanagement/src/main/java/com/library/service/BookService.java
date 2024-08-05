package week2.module3.exercise123.librarymanagement.src.main.java.com.library.service;

import week2.module3.exercise123.librarymanagement.src.main.java.com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
