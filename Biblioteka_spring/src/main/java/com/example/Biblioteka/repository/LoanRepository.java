package com.example.Biblioteka.repository;

import com.example.Biblioteka.Employee;
import com.example.Biblioteka.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
