package com.capg.pbms.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanRequestRepo extends JpaRepository<LoanRequest, Long> {

}