/**
 * Rewards service parent exception class
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public abstract class RewardsServiceException extends SkytestException {

	public RewardsServiceException(String message){
	     super(message);
	} 
	
}
