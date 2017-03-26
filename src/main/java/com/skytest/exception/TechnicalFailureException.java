/**
 * Exception to handle the technical failures
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public class TechnicalFailureException extends SkytestException {

	final static String  message = "Service technical failure";
	public TechnicalFailureException(){
	     super(message);
	} 
}
