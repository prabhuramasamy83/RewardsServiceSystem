/**
 * Happy path test cases for the customer rewards system
 */
package com.skytest.service;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
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
import com.skytest.exception.SkytestException;

import junit.framework.Assert;

/**
 * @author Prabhu Ramasamy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class RewardsServiceMockHappyTest {
	
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
	 * Verify service with the eligible customer, expected customer rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible() throws SkytestException{
		long accountNumber = 12345671;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			Assert.assertNotNull(rewards);
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
		
	}
	
	/**
	 * Verify service with the eligible SPORTS portfolio customer, expected SPORTS pack rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_SPORTS() throws SkytestException{
		long accountNumber = 12345673;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.SPORTS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(1,rewards,Arrays.asList(RewardsEnumChannel.SPORTS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify service with the eligible KIDS portfolio customer, expected KIDS pack rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_KIDS() throws SkytestException{
		long accountNumber = 12345674;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.KIDS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(1,rewards,Arrays.asList(RewardsEnumChannel.KIDS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify service with the eligible MUSIC portfolio customer, expected MUSIC pack rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_MUSIC() throws SkytestException{
		long accountNumber = 12345675;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MUSIC);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(1,rewards,Arrays.asList(RewardsEnumChannel.MUSIC.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
		
	}
	
	/**
	 * Verify service with the eligible NEWS portfolio customer, expected NEWS pack rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_NEWS() throws SkytestException{
		long accountNumber = 12345676;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.NEWS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(1,rewards,Arrays.asList(RewardsEnumChannel.NEWS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
		
	}

	/**
	 * Verify service with the eligible MOVIES portfolio customer, expected MOVIES pack rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_MOVIES() throws SkytestException{
		long accountNumber = 12345677;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(1,rewards,Arrays.asList(RewardsEnumChannel.MOVIES.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify service with the eligible customer with 2 portfolios, expected 2 sets of rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_2Subscriptions() throws SkytestException{
		long accountNumber = 12345678;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES,RewardsEnumChannel.KIDS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(2,rewards,Arrays.asList(RewardsEnumChannel.MOVIES.getReward(),RewardsEnumChannel.KIDS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify service with the eligible customer with 3 portfolios, expected 3 sets of rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_3Subscriptions() throws SkytestException{
		long accountNumber = 12345679;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES,RewardsEnumChannel.KIDS,RewardsEnumChannel.SPORTS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(3,rewards,Arrays.asList(RewardsEnumChannel.MOVIES.getReward(),RewardsEnumChannel.KIDS.getReward(),RewardsEnumChannel.SPORTS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Verify service with the eligible customer with 4 portfolios, expected 4 sets of rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_4Subscriptions() throws SkytestException{
		long accountNumber = 12345670;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES,RewardsEnumChannel.KIDS,RewardsEnumChannel.SPORTS,RewardsEnumChannel.MUSIC);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(4,rewards,Arrays.asList(RewardsEnumChannel.MOVIES.getReward(),RewardsEnumChannel.KIDS.getReward(),RewardsEnumChannel.SPORTS.getReward(),RewardsEnumChannel.MUSIC.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	
	}
	
	/**
	 * Verify service with the eligible customer with 5 portfolios, expected 4 sets of rewards
	 * @throws SkytestException
	 */
	@Test
	public void getRewards_Eligible_5Subscriptions() throws SkytestException{
		long accountNumber = 22345670;
		Set<RewardsEnumChannel> channelSubscriptions = EnumSet.of(RewardsEnumChannel.MOVIES,RewardsEnumChannel.KIDS,RewardsEnumChannel.SPORTS,RewardsEnumChannel.MUSIC,RewardsEnumChannel.NEWS);
		Mockito.when(eligibilityServiceMock.checkCustomerEligible(accountNumber)).thenReturn(EligibilityStatuses.CUSTOMER_ELIGIBLE);
		Set<String> rewards;
		try {
			rewards = rewardsServiceImpl.getRewards(accountNumber, channelSubscriptions);
			assertReturn(4,rewards,Arrays.asList(RewardsEnumChannel.MOVIES.getReward(),RewardsEnumChannel.KIDS.getReward(),RewardsEnumChannel.SPORTS.getReward(),RewardsEnumChannel.MUSIC.getReward(),RewardsEnumChannel.NEWS.getReward()));
		} catch (SkytestException e) {
			Assert.fail("Unexpected Exception is thrown " + e.getMessage());
		}
	}
	
	/**
	 * Private method used to verifying the rewards returned back for the eligible customers
	 * @param expectedSize
	 * @param rewards
	 * @param expectedRewards
	 */
	private void assertReturn(int expectedSize,Set<String> rewards,List<String> expectedRewards) {
		if(rewards!=null){
			Assert.assertEquals(expectedSize,rewards.size());
			Assert.assertTrue(rewards.containsAll(expectedRewards));
		}else{
			Assert.assertFalse(true);
		}
	}
		

}
