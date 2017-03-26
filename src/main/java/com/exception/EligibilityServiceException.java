/**
 * Eligibility service parent exception class
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public abstract class  EligibilityServiceException extends SkytestException {
	
	public EligibilityServiceException(String message){
	     super(message);
	} 

}
