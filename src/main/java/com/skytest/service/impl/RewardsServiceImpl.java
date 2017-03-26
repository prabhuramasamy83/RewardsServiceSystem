/**
 * 
 */
package com.skytest.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skytest.constant.EligibilityStatuses;
import com.skytest.constant.RewardsEnumChannel;
import com.skytest.exception.AccountNoInvalidException;
import com.skytest.exception.PortfolioNullException;
import com.skytest.exception.SkytestException;
import com.skytest.exception.TechnicalFailureException;
import com.skytest.service.EligibilityService;
import com.skytest.service.RewardsService;

/**
 * @author Prabhu Ramasamy
 *
 */
@Service
public class RewardsServiceImpl implements RewardsService{
	
	final static Logger logger = Logger.getLogger(RewardsServiceImpl.class);
	
	@Autowired
	EligibilityService eligibilityService;
	
	/*
	 * (non-Javadoc)
	 * @see com.skytest.service.RewardsService#getRewards(long, java.util.Set)
	 */
	public Set<String> getRewards(long accountNumber, Set<RewardsEnumChannel> channelSubscriptions) throws SkytestException{
		logger.debug("Entering getRewards method");
		if(channelSubscriptions!=null){
			Set<String> rewards =new HashSet<String>();
			try{
				if(eligibilityService.checkCustomerEligible(accountNumber).equals(EligibilityStatuses.CUSTOMER_ELIGIBLE)){
					for(RewardsEnumChannel channelSubscription:channelSubscriptions){
						addRewards(rewards, channelSubscription);
					}	
				}

			}catch(TechnicalFailureException ex){
				logger.debug("Service technical exception has occured");
			}catch(AccountNoInvalidException ex){
				logger.debug("Account number null invalid exception is thrown");
				throw ex;
			}catch(SkytestException ex){
				logger.debug("Sky test parent  exception is thrown");
				throw ex;
			}
			logger.debug("Leaving getRewards method");
			return rewards;
			
		}else{
			logger.debug("Portfolio null pointer execption is thrown");
			throw new PortfolioNullException();
		}
		
	}

	/**
	 * Method used to add the eligible rewards of the customer,
	 * throws portfolio null pointer exception if the channel subscription is null
	 * otherwise add the appropriate rewards
	 * @param rewards
	 * @param channelSubscription
	 * @throws PortfolioNullException
	 */
	private void addRewards(Set<String> rewards, RewardsEnumChannel channelSubscription) throws PortfolioNullException {
		logger.debug("Entering addRewards method");
		if(channelSubscription!=null){
				switch(channelSubscription){
					case SPORTS:
						rewards.add(RewardsEnumChannel.SPORTS.getReward());
						break;
					case KIDS:
						rewards.add(RewardsEnumChannel.KIDS.getReward());
						break;
					case MUSIC:
						rewards.add(RewardsEnumChannel.MUSIC.getReward());
						break;
					case NEWS:
						rewards.add(RewardsEnumChannel.NEWS.getReward());
						break;
					case MOVIES:
						rewards.add(RewardsEnumChannel.MOVIES.getReward());
				}
				logger.debug("Leaving addRewards method");
		}else{
			logger.debug("Portfolio null pointer exception is thrown");
			throw new PortfolioNullException();
		}
	}

}
