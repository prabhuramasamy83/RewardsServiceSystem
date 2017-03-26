/**
 * Exception to handle the null value for the channel subscription
 */
package com.skytest.exception;

/**
 * @author Prabhu Ramasamy
 *
 */
@SuppressWarnings("serial")
public class PortfolioNullException extends RewardsServiceException {

	final static String  message = "Channel Subscription is null";
	public PortfolioNullException(){
		super(message);
	}
}
