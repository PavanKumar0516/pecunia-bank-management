package com.capg.pbms.transaction.exception;



/*******************************************************************************************************************************
-Author                   :     P.AkashPawar
-Created/Modified Date    :     16-08-2020
-Description              :    AccountNotFound class with constructor
*******************************************************************************************************************************/

public class AccountNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountNotFound(String msg) {
		super(msg);
	}

}
