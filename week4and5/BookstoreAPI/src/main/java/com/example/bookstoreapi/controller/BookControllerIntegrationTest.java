package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import com.example.bookstoreapi.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateAndGetBook() throws Exception {
        // Create a new book
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType("application/json")
                .content("{\"title\":\"Integration Book\", \"author\":\"Integration Author\", \"price\":10.99, \"isbn\":\"9876543210\"}"))
                .andExpect(status().isCreated());

        // Retrieve the created book
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Integration Book"))
                .andExpect(jsonPath("$[0].author").value("Integration Author"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        // Create a new book
        Book book = new Book();
        book.setTitle("Update Book");
        book.setAuthor("Update Author");
        book.setPrice(20.99);
        book.setIsbn("1234567890");
        book = bookRepository.save(book);

        // Update the book
        mockMvc.perform(MockMvcRequestBuilders.put("/books/{id}", book.getId())
                .contentType("application/json")
                .content("{\"title\":\"Updated Book\", \"author\":\"Updated Author\", \"price\":25.99, \"isbn\":\"1234567890\"}"))
                .andExpect(status().isOk());

        // Retrieve the updated book
        mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", book.getId())
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Book"))
                .andExpect(jsonPath("$.author").value("Updated Author"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Create a new book
        Book book = new Book();
        book.setTitle("Delete Book");
        book.setAuthor("Delete Author");
        book.setPrice(30.99);
        book.setIsbn("1122334455");
        book = bookRepository.save(book);

        // Delete the book
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}", book.getId()))
                .andExpect(status().isNoContent());

        // Attempt to retrieve the deleted book
        mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", book.getId()))
                .andExpect(status().isNotFound());
    }
}

