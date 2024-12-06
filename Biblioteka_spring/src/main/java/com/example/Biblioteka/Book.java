package com.example.Biblioteka;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Book(){}


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

    public String getIsbn() {
        return isbn;
    }
}
