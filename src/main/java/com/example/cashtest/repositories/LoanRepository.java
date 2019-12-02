package com.example.cashtest.repositories;

import java.util.List;
import java.util.Optional;

import com.example.cashtest.entities.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PrestamoRepository
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    Optional<Loan> findById(Integer id);

    List<Loan> findLoans(int offset, int size);

    List<Loan> findLoansByUserId(int userId, int offset, int size);

    int countLoansByUserId(int userId);


}