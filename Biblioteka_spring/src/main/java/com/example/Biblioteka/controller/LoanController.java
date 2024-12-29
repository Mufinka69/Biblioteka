package com.example.Biblioteka.controller;


import com.example.Biblioteka.Book;
import com.example.Biblioteka.DTO.LoanDTO;
import com.example.Biblioteka.DTO.UserDTO;
import com.example.Biblioteka.Loan;
import com.example.Biblioteka.Role;
import com.example.Biblioteka.User;
import com.example.Biblioteka.service.BookService;
import com.example.Biblioteka.service.LoansService;
import com.example.Biblioteka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanPanel")
public class LoanController {

    @Autowired
    private LoansService loansService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("loans")
    public List<Loan> getLoans(){
        return loansService.getAllLoans();
    }

    @PostMapping("/addLoan")
    public Loan addLoan(@RequestBody LoanDTO loanDTO){
        Loan loan = new Loan();
        User user = userService.findByID(loanDTO.getUserID());
        Book book = bookService.findByID(loanDTO.getBookID());

        loan.setBook(book);
        loan.setUser(user);

        loan.setRentalDate(loanDTO.getRentalDate());
        loan.setReturnDate(loanDTO.getReturnDate());
        return loansService.addLoan(loan);
    }

    @DeleteMapping("/loan/{loanID}")
    public List<Loan> deleteRole(@PathVariable Long loanID) {
        loansService.deleteLoan(loanID);
        return loansService.getAllLoans();
    }
}
