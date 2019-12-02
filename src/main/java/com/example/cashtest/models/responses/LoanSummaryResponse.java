package com.example.cashtest.models.responses;

import java.util.List;

import com.example.cashtest.entities.Loan;
import com.example.cashtest.entities.LoanInfo;

/**
 * LoanSummaryResponse
 */
public class LoanSummaryResponse {

    public List<Loan> items;
    public LoanInfo paging = new LoanInfo();
}