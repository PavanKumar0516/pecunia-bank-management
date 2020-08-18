package com.capg.pbms.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.loan.model.Customer;

public interface IAccountRepo extends JpaRepository<Customer, Long>{


}