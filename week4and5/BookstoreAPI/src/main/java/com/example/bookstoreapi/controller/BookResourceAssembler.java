package week4and5.BookstoreAPI.src.main.java.com.example.bookstoreapi.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler extends RepresentationModelAssemblerSupport<BookDTO, EntityModel<BookDTO>> {

    public BookResourceAssembler() {
        super(BookController.class, BookDTO.class);
    }

    @Override
    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel();
        bookResource.add(selfLink);
        return bookResource;
    }
}

