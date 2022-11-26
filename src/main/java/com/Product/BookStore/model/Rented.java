//package com.Product.BookStore.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name="rented")
//public class Rented {
//
//    @Column(name="bookId", nullable=false)
//    private int bId;
//
//    @Column(name="userId", nullable=false)
//    private int uId;
//
//    @Column(name="issueDateTime", columnDefinition = "TIMESTAMP", nullable=false)
//    private LocalDateTime issueDateTime;
//
//    @Column(name="returnDateTime", columnDefinition = "TIMESTAMP")
//    private LocalDateTime returnDateTime;
//
//    @Column(name="amount", nullable=false)
//    private int amount;
//
//    public int getbId() {
//        return bId;
//    }
//
//    public void setbId(int bId) {
//        this.bId = bId;
//    }
//
//    public int getuId() {
//        return uId;
//    }
//
//    public void setuId(int uId) {
//        this.uId = uId;
//    }
//
//    public LocalDateTime getIssueDateTime() {
//        return issueDateTime;
//    }
//
//    public void setIssueDateTime(LocalDateTime issueDateTime) {
//        this.issueDateTime = issueDateTime;
//    }
//
//    public LocalDateTime getReturnDateTime() {
//        return returnDateTime;
//    }
//
//    public void setReturnDateTime(LocalDateTime returnDateTime) {
//        this.returnDateTime = returnDateTime;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//}
