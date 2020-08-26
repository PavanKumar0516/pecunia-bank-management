package com.capg.pbms.loan.exception;

public class AccountNotFoundException extends RuntimeException {
	
	/*******************************************************************************************************************************
	-Author                       :     Nagasri
	-Created/Modified Date        :     20-08-2020
	-Description                  :     AccountNotFound class with constructor
	*******************************************************************************************************************************/

	public AccountNotFoundException(String message) {
		super(message);
	}
}