package com.example.cashtest.controllers;

import java.util.List;

import com.example.cashtest.entities.Loan;
import com.example.cashtest.entities.User;
import com.example.cashtest.models.requests.AltaRequest;
import com.example.cashtest.models.requests.LoanRequest;
import com.example.cashtest.models.responses.BasicResponse;
import com.example.cashtest.models.responses.LoanSummaryResponse;
import com.example.cashtest.services.LoanService;
import com.example.cashtest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
public class ApiController {

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @PostMapping("/users")
    public BasicResponse createUser(@RequestBody AltaRequest req) {

        BasicResponse b = new BasicResponse();
        userService.createUser(req.first_name, req.last_name, req.email);

        b.isOk = true;
        b.message = "User registered succesfully";

        return b;

    }

    @PostMapping("/users/{id}/loans")
    public BasicResponse createLoan(@PathVariable int id, @RequestBody LoanRequest req) {

        BasicResponse b = new BasicResponse();
        loanService.createLoan(id, req.total);

        b.isOk = true;
        b.message = "Loan registered succesfully";

        return b;

    }

    @DeleteMapping("/users/{id}")
    public BasicResponse deleteUser(@PathVariable int id){
        
        BasicResponse b = new BasicResponse();
        User u = userService.getById(id);
        
        userService.delete(u);

        b.isOk = true;
        b.message = "User deleted succesfully";

        return b;
}

    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User u = userService.getById(id);

        return ResponseEntity.ok(u);
    }

    @GetMapping("/loans?page={page}&size={size}")
    public LoanSummaryResponse getLoans(@RequestParam(value = "size", required = true) Integer size, @RequestParam(value = "page", required = true) Integer pagination, @RequestParam(value = "user_id", required = false) Integer userId)  {
        

        LoanSummaryResponse lsm = new LoanSummaryResponse();

        int offset = (pagination - 1) * size;
        List<Loan> lp;

        if (userId == null) {
            lp = loanService.getLoans(size, offset);
            lsm.paging.total = loanService.countLoans();
        } else {
            lp = loanService.getLoansWUserId(size, offset, userId);
            lsm.paging.total = loanService.countLoansByUserId(userId);
        }

        lsm.items = lp;
        lsm.paging.page = pagination;
        lsm.paging.size = size;
        

        return lsm;

    }
}