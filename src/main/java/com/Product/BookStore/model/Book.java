package com.Product.BookStore.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bId", nullable=false)
    private int bId;

    @Column(name="book_name", nullable=false)
    //not blank annotation
    private String bookName;

    @Column(name="author", nullable=false)
    private String author;

    @Column(name="category", nullable=false)
    private String category;

    @Column(name="price", nullable=false)
    private int price;

    @Column(name="likes")
    private int likes;

    @Column(name="date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
