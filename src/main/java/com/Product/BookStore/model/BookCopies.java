package com.Product.BookStore.model;

import javax.persistence.*;

@Entity
@Table(name="bookCount")
public class BookCopies {

    @Id
    @Column(name="bookId", nullable=false, unique = true)
    private long bId;

    @Column(name = "bookCopies", nullable=false)
    private int copies;


    public long getbId() {
        return bId;
    }

    public void setbId(long bId) {
        this.bId = bId;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
