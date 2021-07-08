package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.repository.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    private static final String BOOK_NOT_FOUND_MESSAGE = "Book [ID={%d}] not found";

    @Autowired
    public BookService(BookRepository bookRepository, DiscountService discountService) {
        this.bookRepository = bookRepository;
        this.discountService = discountService;
    }

    public Book getBook(Long bookId) throws EntityNotFoundException {
        final var book = bookRepository
                .findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        BOOK_NOT_FOUND_MESSAGE,
                        bookId
                )));
        return book;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll().stream().peek(book -> book.setPrice(book.getPrice().subtract(
                book.getPrice().multiply(
                        discountService.getDiscount(book.getGroupCode())
                ).divide(new BigDecimal(100),
                       RoundingMode.DOWN))))
                .collect(Collectors.toList());
    }
}
