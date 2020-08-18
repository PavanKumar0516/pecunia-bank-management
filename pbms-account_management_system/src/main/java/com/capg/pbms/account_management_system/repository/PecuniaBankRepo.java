package com.capg.pbms.account_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.account_management_system.model.BankAccountDetails;

public interface PecuniaBankRepo extends JpaRepository<BankAccountDetails, Long> {

}
