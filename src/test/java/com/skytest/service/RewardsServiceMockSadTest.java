/**
 * Sad path test cases for the customer rewards system
 */
package com.skytest.service;

import java.util.EnumSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.skytest.constant.EligibilityStatuses;
import com.skytest.constant.RewardsEnumChannel;
import com.skytest.exception.AccountNoInvalidException;
import com.skytest.exception.SkytestException;

import junit.framework.Assert;

/**
 * @author Prabhu Ramasamy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class RewardsServiceMockSadTest {
	
	@Autowired
	RewardsService rewardsServiceImpl;
	
	@Autowired
	EligibilityService eligibilityServiceMock;
	
	/**
	 * Mock object initialised before every test case
	 */
	@Before
	public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	/**
	 * Verify the service with the negative account number,expected invalid account number exception
	 * @throws SkytestException
	 */
	@Test(expected=AccountNoInvalidException.class)
	public void getRewards_AccNoNegative() throws SkytestException{
		long accountNumber = -22345675;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenThrow(new AccountNoInvalidException());
		rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
		Assert.fail("Account number invalid Exception is expected ");
    }
	
	/**
	 * Verify the service with the not eligible  customer, expected no rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_NotEligible() throws SkytestException{
		long accountNumber = 12345672;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_INELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			Assert.assertEquals(rewards.size(), 0);
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify the service with the invalid account number,expected invalid account number exception
	 * @throws SkytestException
	 */
	@Test(expected=AccountNoInvalidException.class)
	public void getRewards_InvalidAccNo() throws SkytestException{
		long accountNumber = 22345671;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenThrow(new AccountNoInvalidException());
		rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
		Assert.fail("Account number invalid Exception is expected ");
	}


}
