/**
 * Parent exception class
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public abstract class SkytestException extends Exception {

	public SkytestException(String message){
	     super(message);
	} 
}
