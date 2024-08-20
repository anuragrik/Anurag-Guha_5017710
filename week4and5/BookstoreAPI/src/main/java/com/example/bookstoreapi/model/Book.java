package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.model;

import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    private String author;

    @Min(0)
    private Double price;

    @NotNull
    private String isbn;

    @Version
    private Integer version;

}

