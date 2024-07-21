package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.entity.Books;
import com.vermau2k01.RentRead.entity.Rental;
import com.vermau2k01.RentRead.entity.User;
import com.vermau2k01.RentRead.exception.*;
import com.vermau2k01.RentRead.repository.BookRepository;
import com.vermau2k01.RentRead.repository.RentalRepository;
import com.vermau2k01.RentRead.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class RentalService implements IRentalService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private IUserService userService;

    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

    @Override
    @Transactional
    public Rental borrowBook(UUID bookId) {
        String email = userService.getUserDetails();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotExistsException(email));
        if (user.getRentals().size() > 2) {
            throw new BookLimitExceedException();
        }
        Books books = bookRepository.findById(bookId)
                .orElseThrow(() -> new
                        BookNotFoundException("Book not found with id: " + bookId));
        if (!books.isAvailable()) {
            throw new BookNotAvailableException();
        }
        Rental rental = new Rental();
        rental.setUsers(user);
        rental.setBooks(books);
        rental.setBorrowDate(LocalDate.now());
        Rental savedRental = rentalRepository.save(rental);
        books.getRentals().add(savedRental);
        books.setAvailable(false);
        bookRepository.save(books);
        user.getRentals().add(savedRental);
        userRepository.save(user);

        return savedRental;
    }




    @Override
    @Transactional
    public Rental returnBook(UUID bookId) {

        try{

            String email = userService.getUserDetails();

            User user = userRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new UserNotExistsException(email));

            Books books = bookRepository
                    .findById(bookId)
                    .orElseThrow(() -> new BookNotFoundException(bookId.toString()));

            Rental rental = rentalRepository.findByBooks(books)
                    .orElseThrow(RentalNotExistsException::new);

            user.getRentals().remove(rental);
            books.getRentals().remove(rental);
            books.setAvailable(true);
            rental.setReturnDate(LocalDate.now());
            userRepository.save(user);
            bookRepository.save(books);
            rentalRepository.delete(rental);
            return rental;


        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }


}
