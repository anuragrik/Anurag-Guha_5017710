package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@Data
public class BookDTO {
    @XmlElement(name = "id")
    @JsonProperty("id")
    private Long id;

    @XmlElement(name = "book_title")
    @JsonProperty("book_title")
    private String title;

    @XmlElement(name = "book_author")
    @JsonProperty("book_author")
    private String author;

    @XmlElement(name = "book_price")
    @JsonProperty("book_price")
    private Double price;

    @XmlElement(name = "book_isbn")
    @JsonProperty("book_isbn") 
    private String isbn;
}

