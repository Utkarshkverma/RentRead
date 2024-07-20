package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.dtos.BookDto;
import com.vermau2k01.RentRead.entity.Books;
import com.vermau2k01.RentRead.exception.BookNotFoundException;
import com.vermau2k01.RentRead.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBookById(UUID id) {
        return bookRepository
                .findById(id)
                .orElseThrow(()->new BookNotFoundException(id.toString()));
    }

    @Override
    public Books addBook(BookDto bookDto) {
        Books book = new Books();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(UUID id) {

        Books books = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id.toString()));
        bookRepository.delete(books);
    }
}
