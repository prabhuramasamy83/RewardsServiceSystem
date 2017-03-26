/**
 * Test class to verify the rewards channel subscription constants 
 */
package com.skytest.constant;

import org.junit.Assert;
import org.junit.Test;

public class RewardsEnumChannelTest {

	
	/**
	 * Unit test to verify the enum (portfolio and the corresponding relevant rewards)
	 */
	 @Test
	 public void ascertain_constants(){
		 Assert.assertEquals(RewardsEnumChannel.KIDS.getReward(),"N/A");
		 Assert.assertEquals(RewardsEnumChannel.SPORTS.getReward(),"CHAMPIONS_LEAGUE_FINAL_TICKET");
		 Assert.assertEquals(RewardsEnumChannel.MUSIC.getReward(),"KARAOKE_PRO_MICROPHONE");
		 Assert.assertEquals(RewardsEnumChannel.NEWS.getReward(),"N/A");
		 Assert.assertEquals(RewardsEnumChannel.MOVIES.getReward(),"PIRATES_OF_THE_CARIBBEAN_COLLECTION");
	 }
	
}
