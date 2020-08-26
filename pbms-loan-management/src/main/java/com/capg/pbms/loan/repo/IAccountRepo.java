package com.capg.pbms.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.loan.model.Customer;

public interface IAccountRepo extends JpaRepository<Customer, Long>{
   

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     20-08-2020
-Description              :     Account Repository Interface with Customer as Type and Long as PrimaryKey
*******************************************************************************************************************************/



}