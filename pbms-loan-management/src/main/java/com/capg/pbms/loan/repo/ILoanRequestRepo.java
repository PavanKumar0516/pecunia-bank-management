package com.capg.pbms.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanRequestRepo extends JpaRepository<LoanRequest, Long> {


/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     20-08-2020
-Description              :     LoanRequest Repository Interface with LoanRequest as Type and Long as PrimaryKey
*******************************************************************************************************************************/


}