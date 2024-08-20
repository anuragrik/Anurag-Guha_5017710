package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

import week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.model.Customer;

import com.example.bookstoreapi.assembler.BookResourceAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(tags = "Book API", description = "Operations pertaining to books in the online bookstore")
public class BookController {

    private final BookService bookService;
    private final BookResourceAssembler assembler;

    public BookController(BookService bookService, BookResourceAssembler assembler) {
        this.bookService = bookService;
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestHeader(value = HttpHeaders.ACCEPT, defaultValue = "application/json") String acceptHeader) {
        List<BookDTO> books = bookService.getAllBooks();

        if (acceptHeader.equals("application/xml")) {
            return ResponseEntity.ok()
                    .contentType(HttpMediaType.APPLICATION_XML)
                    .body(books); 
        } else {
            return ResponseEntity.ok()
                    .contentType(HttpMediaType.APPLICATION_JSON)
                    .body(books);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a book by its ID", notes = "Provide an ID to look up a specific book", response = BookDTO.class)
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        if (bookDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assembler.toModel(bookDTO));
    }

    @GetMapping
    @ApiOperation(value = "Get all books", response = PagedModel.class)
    public PagedModel<EntityModel<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return PagedModel.of(books.stream().map(assembler::toModel).toList());
    }


    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam(required = false) String title,
                                                      @RequestParam(required = false) String author) {
        List<BookDTO> books = bookService.searchBooks(title, author);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new book", response = Book.class)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing book", response = Book.class)
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a book by its ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }s

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Created customer with name " + customer.getName());
    }
}
