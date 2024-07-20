package com.vermau2k01.RentRead.controller;

import com.vermau2k01.RentRead.dtos.BookDto;
import com.vermau2k01.RentRead.entity.Books;
import com.vermau2k01.RentRead.service.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable UUID id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.FOUND);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Books> addBook(@Valid @RequestBody BookDto bookDto) {

        Books books = bookService.addBook(bookDto);
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
