package week2.module3.exercise9.LibraryManagement.src.main.java.com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}