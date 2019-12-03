package com.example.cashtest.services;

import java.util.List;
import com.example.cashtest.entities.Loan;
import com.example.cashtest.entities.User;
import com.example.cashtest.repositories.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PrestamoService
 */
@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserService userService;

    public void save(Loan p) {
        loanRepository.save(p);
    }

    public void createLoan(int id, double total) {

        User u = userService.getById(id);

        if (u != null) {
            Loan p = new Loan();
            p.setTotal(total);
            p.setUser(u);
            save(p);
            u.addLoan(p);
        }

    }

    public long countLoans() {
        return loanRepository.count();
    }

    public long countLoansByUserId(Integer userId) {
        return loanRepository.countLoansByUserId(userId);
    }

    public List<Loan> getLoans(int size, int offset) {
        return loanRepository.findLoans(offset, size);
    }

    public List<Loan> getLoansWUserId(int size, int offset, int userId) {
        return loanRepository.findLoansByUserId(userId, offset, size);
    }

    public enum LoanValidationType {
        LOAN_OK, LOAN_INVALID_DATA
    }

    public LoanValidationType verifyLoan(Loan loan) {
        if (loan.getTotal() <= 0) {
            return LoanValidationType.LOAN_INVALID_DATA;
        }
        return LoanValidationType.LOAN_OK;

    }
}