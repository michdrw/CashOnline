package com.example.cashtest;

import com.example.cashtest.entities.Loan;
import com.example.cashtest.entities.User;
import com.example.cashtest.services.LoanService;
import com.example.cashtest.services.UserService;
import com.example.cashtest.services.UserService.UserValidationType;
import com.example.cashtest.services.LoanService.LoanValidationType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	LoanService loanService;
	
	@Test
	void contextLoads() {
	}

	@Test
	void verifyUserData() {

		User user = new User();
		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_INVALID_DATA, validationType);
	}

	@Test
	void verifyDuplicatedUser(){

		User user = new User();
		user.setFirstName("Pepe");
		user.setLastName("Argento");
		user.setEmail("test@app.com.ar");
		
		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_DUPLICATED, validationType);

	}

	@Test
	void verifyNonDuplicatedUser(){

		User user = new User();
		user.setFirstName("Paola");
		user.setLastName("Argento");
		user.setEmail("test1@app.com.ar");
		
		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_OK, validationType);

	}

	@Test
	void verifyLoanData(){
		
		Loan loan = new Loan();
		LoanValidationType validationType = loanService.verifyLoan(loan);
		assertEquals(LoanValidationType.LOAN_INVALID_DATA, validationType);

	}

	@Test
	void verifyCorrectLoanData(){
		Loan loan = new Loan();
		loan.setTotal(2500);

		LoanValidationType validationType = loanService.verifyLoan(loan);
		assertEquals(LoanValidationType.LOAN_OK, validationType);
	}
}
