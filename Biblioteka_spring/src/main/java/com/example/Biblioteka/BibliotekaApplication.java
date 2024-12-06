package com.example.Biblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.BookService;

@SpringBootApplication
public class BibliotekaApplication  {


	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotekaApplication.class, args);
	}
}
