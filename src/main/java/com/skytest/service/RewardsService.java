/**
 * Service to find the regards available for the customer
 */
package com.skytest.service;

import java.util.Set;

import com.skytest.constant.RewardsEnumChannel;
import com.skytest.exception.SkytestException;

/**
 * @author Prabhu Ramasamy
 *
 */
public interface RewardsService {
	
	/**
	 * Method used to get the rewards for the eligible customers 
	 * throws sub class of eligibility service exception for invalid account number
	 * throws portfolio null pointer exception if the channel subscription is null
	 * otherwise provides the eligible rewards
	 * @param accountNumber
	 * @param channelSubscriptions
	 * @return
	 * @throws SkytestException
	 */
	public Set<String> getRewards(long accountNumber, Set<RewardsEnumChannel> channelSubscriptions) throws SkytestException;

}
