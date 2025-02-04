package com.example.Biblioteka.service;

import com.example.Biblioteka.Book;
import com.example.Biblioteka.Loan;
import com.example.Biblioteka.exception.BookNotFoundException;
import com.example.Biblioteka.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LoansService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }


    public Loan addLoan(Loan loan){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        loan.setRentalDate(c.getTime());
        c.add(Calendar.WEEK_OF_YEAR, 2);
        loan.setReturnDate(c.getTime());
        return loanRepository.save(loan);
    }

//    public List<Book> findLoanByUser(String author){
//        List<Book> books = BookRepository.findByAuthor(author);
//        if(books.isEmpty()){
//            throw new BookNotFoundException("No books found for author: "+author);
//        }
//        return books;
//    }

    public void deleteLoan(Long loanID){
        loanRepository.deleteById(loanID);
    }

}
