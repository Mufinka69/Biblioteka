package com.example.Biblioteka.service;

import com.example.Biblioteka.Book;
import java.util.*;

import com.example.Biblioteka.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Biblioteka.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookID){
        if(!bookRepository.existsById(bookID)){
            throw new BookNotFoundException("Book with ID " + bookID+ " not found.");
        }
        bookRepository.deleteById(bookID);
    }

    public Book findByID(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> findBookByAuthor(String author){
        List<Book> books = bookRepository.findByAuthor(author);
        if(books.isEmpty()){
            throw new BookNotFoundException("No books found for author: "+author);
        }
        return books;
    }
}
