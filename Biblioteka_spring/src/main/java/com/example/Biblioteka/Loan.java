package com.example.Biblioteka;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanID;

    @ManyToOne
    @JoinColumn(name = "bookID")
    @JsonIgnoreProperties("loans")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties("loans")
    private User user;

    @Column
    private Date rentalDate;

    @Column
    private Date returnDate;

    public Long getLoanID() {
        return loanID;
    }

    public void setLoanID(Long loanID) {
        this.loanID = loanID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
