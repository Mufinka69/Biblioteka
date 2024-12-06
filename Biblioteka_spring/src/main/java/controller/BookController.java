package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookService;
import com.example.Biblioteka.Book;

import java.util.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("./books")
    public String getBooks(Model model){
        List<Book> books = bookService.getAllBooks();

        for (Book book : books) {
            System.out.println("Tytuł: " + book.getTitle() + ", Autor: " + book.getAuthor());
        }

        System.out.println("======================xdd===================================");
        System.out.println("======================xdd===================================");
        System.out.println("======================xdd===================================");
        System.out.println("======================xdd===================================");
        System.out.println("======================xdd===================================");

        model.addAttribute("books", books);
        return "books";
    }
}
