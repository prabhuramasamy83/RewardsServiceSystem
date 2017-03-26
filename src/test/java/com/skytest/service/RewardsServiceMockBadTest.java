/**
 * Bad path test cases for the customer rewards system
 */
package com.skytest.service;

import java.util.EnumSet;
import java.util.HashSet;
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
import com.skytest.exception.PortfolioNullException;
import com.skytest.exception.SkytestException;
import com.skytest.exception.TechnicalFailureException;

import junit.framework.Assert;

/**
 * @author Prabhu Ramasamy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class RewardsServiceMockBadTest {
	
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
	 * Verify the rewards with mock created for service technical failure exception, expected service technical failure exception
	 * @throws SkytestException
	 */
    @Test
	public void getRewards_ServiceTechFailure() throws SkytestException{
		long accountNumber = 22345672;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenThrow(new TechnicalFailureException());
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			Assert.assertEquals(0,rewards.size());
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
    
    /**
     * Verify the service with the null object passed in as portfolio object, expected portfolio null pointer exception
     * @throws SkytestException
     */
    @Test(expected=PortfolioNullException.class)
	public void getRewards_NullPortfolioObject() throws SkytestException{
		long accountNumber = 22345673;
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		rewardsServiceImpl.getRewards(accountNumber, null);
	}
    
    /**
     * Verify the service with the empty object passed in as portfolio object, expected no rewards
     * @throws SkytestException
     */
    @Test
	public void getRewards_EmptyPortfolio() throws SkytestException{
		long accountNumber = 22345674;
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, new HashSet<RewardsEnumChannel>());
			Assert.assertEquals(0,rewards.size());
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
    }
    
    /**
     * Verify the service with portfolio object containing only null value, expected portfolio null pointer exception
     * @throws SkytestException
     */
    @Test(expected=PortfolioNullException.class)
	public void getRewards_PortfolioOnlyNullValue() throws SkytestException{
		long accountNumber = 22345673;
		Set<RewardsEnumChannel> channelSubscriptions = new HashSet<RewardsEnumChannel>();
		channelSubscriptions.add(null);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
	}
    
    /**
     * Verify the service with portfolio object containing null value with other channel subscriptions, expected portfolio null pointer exception
     * @throws SkytestException
     */
    @Test(expected=PortfolioNullException.class)
	public void getRewards_PortfolioContainNullValue() throws SkytestException{
		long accountNumber = 22345673;
		Set<RewardsEnumChannel> channelSubscriptions = new HashSet<RewardsEnumChannel>();
		channelSubscriptions.add(RewardsEnumChannel.KIDS);
		channelSubscriptions.add(null);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
	}


}
