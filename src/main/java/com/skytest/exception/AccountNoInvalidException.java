/**
 * Exception created to handle invalid account number
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public class AccountNoInvalidException extends EligibilityServiceException {

	final static String  message = "The supplied account number is invalid";
	public AccountNoInvalidException(){
		super(message);
	}
}
