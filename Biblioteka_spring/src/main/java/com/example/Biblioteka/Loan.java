package com.example.Biblioteka;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanID;

    // tutaj zmienic na list i many to one
//    @OneToOne
//    private Book book;

//    @JoinColumn(name = "book_id")
    @OneToMany
    private List<Book> books = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Date rentalDate;

    @Column
    private Date returnDate;


    public List<Book> getBookID() {
        return books;
    }

    public void setBookID(Book bookID) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(bookID);
    }

    public User getUserID() {
        return user;
    }

    public void setUserID(User userID) {
        this.user = userID;
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
}
