package ru.example.bookstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.service.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@Slf4j
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) throws EntityNotFoundException {
        log.info("User requested book with id: {} ", id);
        return bookService.getBook(id);
    }
}
