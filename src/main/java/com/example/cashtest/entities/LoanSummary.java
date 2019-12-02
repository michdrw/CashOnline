package com.example.cashtest.entities;


/**
 * LoanSummary
 */
public class LoanSummary {

    private int items;
    private int paging;

    public LoanSummary() {
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getPaging() {
        return paging;
    }

    public void setPaging(int paging) {
        this.paging = paging;
    }
}