/**
 * Service to check the customer eligibility
 */
package com.skytest.service;

import com.skytest.constant.EligibilityStatuses;
import com.skytest.exception.SkytestException;

/**
 * @author Prabhu Ramasamy
 *
 */
public interface EligibilityService {

	/**
	 * Method used to check the customer eligibility for the rewards
	 * throws account invalid exception for invalid account number
	 * throws technical failure exception if there is any service technical failure
	 * @param accountNumber
	 * @return
	 * @throws SkytestException
	 */
	public EligibilityStatuses checkCustomerEligible(long accountNumber) throws SkytestException;
}
