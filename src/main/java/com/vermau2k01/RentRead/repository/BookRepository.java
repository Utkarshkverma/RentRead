package com.vermau2k01.RentRead.repository;

import com.vermau2k01.RentRead.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Books, UUID> {
}
