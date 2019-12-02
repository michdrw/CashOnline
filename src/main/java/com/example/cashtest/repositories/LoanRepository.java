package com.example.cashtest.repositories;

import java.util.List;
import java.util.Optional;

import com.example.cashtest.entities.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * LoanRepository
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Optional<Loan> findById(Integer id);

    @Query(value ="SELECT * FROM loan LIMIT ?,?", nativeQuery = true)
    List<Loan> findLoans(int offset, int size);
    @Query(value = "SELECT * FROM loan WHERE user_id = ? LIMIT ?,?", nativeQuery = true)
    List<Loan> findLoansByUserId(int userId, int offset, int size);
    @Query(value = "SELECT count(*) FROM loan WHERE user_id = ? ", nativeQuery = true)
    int countLoansByUserId(int userId);

    

}