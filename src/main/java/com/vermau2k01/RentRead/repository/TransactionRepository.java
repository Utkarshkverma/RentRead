package com.vermau2k01.RentRead.repository;

import com.vermau2k01.RentRead.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory, UUID> {

    @Query("DELETE FROM TransactionHistory t WHERE t.returnedDate <= :removalSpanDate")
    void deleteOneMonthBackTransaction(LocalDate removalSpanDate);

}
