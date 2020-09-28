package com.capgemini.pbms.account_management_system;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import javax.security.auth.login.AccountNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.pbms.account_management_system.PbmsAccountManagementSystemApplication;
import com.capg.pbms.account_management_system.model.BankAccountDetails;
import com.capg.pbms.account_management_system.model.CustomerAddress;
import com.capg.pbms.account_management_system.repository.PecuniaBankRepo;
import com.capg.pbms.account_management_system.service.IPecuniaBankService;
import com.capg.pbms.account_management_system.service.PecuniaBankService;
/**
*PbmsAccountManagementSystemApplicationTests class or TestCases
*
* @author   :P.Akshitha, J.PavanKumar
* @version  :1.0
* @since    :2020-08-20
*/
@SpringBootTest(classes = PbmsAccountManagementSystemApplication.class)
class PbmsAccountManagementSystemApplicationTests {
	@Autowired
	PecuniaBankRepo repo;
	@Autowired
	static IPecuniaBankService service;
	static BankAccountDetails accountDetails;
	static CustomerAddress address;

	@BeforeEach
	public void init() {
		service = new PecuniaBankService();
		LocalDate date = LocalDate.now();
		address = new CustomerAddress(123, "dn colony", "hyd", "hyd", "ts", "india", 502315);
		accountDetails = new BankAccountDetails(122245678922l, "savings", 4.0, 50000.0, "abc123", "pavan", 9553017205l,
				"in use", 531246695123l, "acv123k", date, "male", address);

	}

	@Test
	public void testAddAccount() throws Exception {
		BankAccountDetails accountDetailsTest = repo.save(accountDetails);
		assertEquals(accountDetailsTest.getAccNumber(), accountDetails.getAccNumber());
		assertEquals(accountDetailsTest.getAccountBalance(), accountDetails.getAccountBalance());
		assertEquals(accountDetailsTest.getAccountBranchId(), accountDetails.getAccountBranchId());
		assertEquals(accountDetailsTest.getAccountInterest(), accountDetails.getAccountInterest());
		assertEquals(accountDetailsTest.getCustomerAdharId(), accountDetails.getCustomerAdharId());
		assertEquals(accountDetailsTest.getCustomerDob(), accountDetails.getCustomerDob());
		assertNotEquals("kiran", accountDetails.getCustomerName());

	}

//	@Test
//	public void testUpdateAccount() {
//		BankAccountDetails accountDetailsTest = repo.save(accountDetails);
//		assertEquals(accountDetailsTest.getCustomerName(), accountDetails.getCustomerName());
//		assertEquals(accountDetailsTest.getCustomerPhno(), accountDetails.getCustomerPhno());
//		assertEquals(accountDetailsTest.getCustomerAddress().getAddId(), accountDetails.getCustomerAddress().getAddId());
//
//	}
	
	

}