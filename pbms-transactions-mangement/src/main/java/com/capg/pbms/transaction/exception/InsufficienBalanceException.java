package com.capg.pbms.transaction.exception;

/*******************************************************************************************************************************
-Author                   :     P.AkashPawar
-Created/Modified Date    :     16-08-2020
-Description              :     InsufficienBalanceException class with constructor
*******************************************************************************************************************************/

public class InsufficienBalanceException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficienBalanceException(String message) {
		super(message);

	}

}
