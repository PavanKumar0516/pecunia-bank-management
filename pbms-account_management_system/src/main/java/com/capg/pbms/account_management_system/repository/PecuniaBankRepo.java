package com.capg.pbms.account_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.pbms.account_management_system.model.BankAccountDetails;

/**
* The PecuniaBankRepo Interface for accessing PecniaBank Account Management System
*
* @author   :P.Akshitha, J.PavanKumar
* @version  :1.0
* @since    :2020-08-18
*/
public interface PecuniaBankRepo extends JpaRepository<BankAccountDetails, Long> {

}
