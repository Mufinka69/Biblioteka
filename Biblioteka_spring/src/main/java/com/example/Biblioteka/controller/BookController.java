package com.example.Biblioteka.controller;

import com.example.Biblioteka.DTO.BookDTO;
import com.example.Biblioteka.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Biblioteka.service.BookService;
import com.example.Biblioteka.Book;

import java.util.*;

@RestController
@RequestMapping("bookPanel")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("./books")
    public String getBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("findByAuthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return bookService.findBookByAuthor(author);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody BookDTO bookdto){
        Book book = new Book();
        book.setTitle(bookdto.getTitle());
        book.setAuthor(bookdto.getAuthor());
        book.setPublishing_house(bookdto.getPublishing_house());
        book.setDate(bookdto.getDate());
        book.setIsbn(bookdto.getIsbn());
        return bookService.addBook(book);
    }

    @DeleteMapping("/book/{bookID}")
    public List<Book> deleteRole(@PathVariable Long bookID){
        bookService.deleteBook(bookID);
        return bookService.getAllBooks();
    }

    @GetMapping("/howManyBooksLeft/{bookID}")
    public int loansCount(@PathVariable Long bookID){
        Book book = bookService.findByID(bookID);
        return book.howManyLoans();
    }
}
