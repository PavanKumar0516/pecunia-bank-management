package com.capg.pbms.transaction.exception;

/**
 * The AccountNotFound class with constructor
 *
 * @author :P.AkashPawar
 * @since :2020-08-20
 */
public class AccountNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountNotFound(String msg) {
		super(msg);
	}

}
