package com.capg.pbms.account_management_system.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.account_management_system.model.BankAccountDetails;
import com.capg.pbms.account_management_system.service.PecuniaBankService;


@RestController
@RequestMapping("/pecuniabank")
class PecuniaBankController {
	@Autowired
	PecuniaBankService service;

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BankAccountDetails addAccount(@RequestBody BankAccountDetails details) throws Exception  {
		return service.addAccount(details);
	}

	@DeleteMapping("/delete/accNum/{accNum}")
	public void deleteAccount(@PathVariable long accNum) throws Exception  {
		service.deleteAccount(accNum);
	}

	@PutMapping("/update")
	public BankAccountDetails updateAccount(@RequestBody BankAccountDetails details) throws AccountNotFoundException  {
		return service.updateAccount(details);
	}
	@GetMapping("/all")
	public List<BankAccountDetails> getAllDetails() throws Exception{
		return service.getAllAccounts();
	}
	@GetMapping("/get/accNum/{accNumber}")
	public BankAccountDetails getById(@PathVariable("accNumber") Long accNumber) throws AccountNotFoundException {
		return service.getById(accNumber);
		
	}

}
