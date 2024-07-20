package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.dtos.BookDto;
import com.vermau2k01.RentRead.entity.Books;


import java.util.List;
import java.util.UUID;

public interface IBookService {

    List<Books> getAllBooks();
    Books getBookById(UUID id);
    Books addBook(BookDto bookDto);
    void deleteBook(UUID id);

}
