package com.example.cashtest.entities;


/**
 * LoanInfo
 */
public class LoanInfo {

    public int page;
    public int size;
    public long total;

    public LoanInfo() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
}