package com.example.Biblioteka;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "bookID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "publishing_house")
    private String publishing_house;

    @Column(name = "isbn")
    private String isbn;

//    @OneToMany(mappedBy = "book")
    public List<Loan> getLoans() {
        return loans;
    }

    public int howManyLoans(){
        return loans.size();
    }

    //Gettery i settery

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
