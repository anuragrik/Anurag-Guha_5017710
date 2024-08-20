package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;
import com.example.bookstoreapi.controller.BookController;
import com.example.bookstoreapi.security.JwtUtil;
import com.example.bookstoreapi.security.JwtFilter;
import com.example.bookstoreapi.service.MyUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private JwtUtil jwtUtil;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void testGetBookById() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Sample Book");
        bookDTO.setAuthor("Author Name");
        bookDTO.setPrice(29.99);
        bookDTO.setIsbn("1234567890");

        given(bookService.getBookById(1L)).willReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.book_title").value("Sample Book"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.book_author").value("Author Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.book_price").value(29.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value("1234567890"));
    }

    @Test
    void testGetAllBooks() throws Exception {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setId(1L);
        bookDTO1.setTitle("Sample Book 1");
        bookDTO1.setAuthor("Author 1");
        bookDTO1.setPrice(19.99);
        bookDTO1.setIsbn("1234567891");

        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setId(2L);
        bookDTO2.setTitle("Sample Book 2");
        bookDTO2.setAuthor("Author 2");
        bookDTO2.setPrice(39.99);
        bookDTO2.setIsbn("1234567892");

        given(bookService.getAllBooks()).willReturn(Arrays.asList(bookDTO1, bookDTO2));

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].book_title").value("Sample Book 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].book_title").value("Sample Book 2"));
    }

    @Test
    void testSearchBooks() throws Exception {
        given(bookService.searchBooks("Sample Title", "Sample Author")).willReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/books/search")
                .param("title", "Sample Title")
                .param("author", "Sample Author")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void testCreateBook() throws Exception {
        Book book = new Book();
        book.setTitle("New Book");
        book.setAuthor("New Author");
        book.setPrice(15.99);
        book.setIsbn("0987654321");

        given(bookService.createBook(book)).willReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Book\", \"author\":\"New Author\", \"price\":15.99, \"isbn\":\"0987654321\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}

