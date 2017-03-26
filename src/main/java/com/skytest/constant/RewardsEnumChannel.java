/**
 * enum holds the channel type and the relevant reward
 */
package com.skytest.constant;

/**
 * @author Prabhu Ramasamy
 *
 */
public enum RewardsEnumChannel {

	SPORTS("CHAMPIONS_LEAGUE_FINAL_TICKET"), KIDS("N/A"), MUSIC("KARAOKE_PRO_MICROPHONE"), NEWS("N/A"),MOVIES("PIRATES_OF_THE_CARIBBEAN_COLLECTION");
	 
	private String reward;
 
	private RewardsEnumChannel(String reward) {
		this.reward = reward;
	}
 
	public String getReward() {
		return this.reward;
	}
	
}