/**
 * Test suite for the customer rewards system
 */
package com.skytest.service.main;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.skytest.service.RewardsServiceMockBadTest;
import com.skytest.service.RewardsServiceMockHappyTest;
import com.skytest.service.RewardsServiceMockSadTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	RewardsServiceMockBadTest.class,
	RewardsServiceMockHappyTest.class,
	RewardsServiceMockSadTest.class
})

/**
 * 
 * @author prabhu ramasamy
 *
 */
public class RewardsSystemTestSuite {

}
