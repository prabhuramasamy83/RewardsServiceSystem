/**
 * Customer rewards system test suite runner
 */
package com.skytest.service.main;

import org.junit.runner.JUnitCore;
 import org.junit.runner.Result;
 import org.junit.runner.notification.Failure;
 
 /**
  * @author prabhu ramasamy
  *
  */
 public class RewardsSystemTestSuiteRunner {
 	
 	
 	/**
 	 * Java main method, starting point of the test cases
 	 * @param args
 	 */
 	 public static void main(String[] args) {
 
 	      Result result = JUnitCore.runClasses(RewardsSystemTestSuite.class);
 	      for (Failure failure : result.getFailures()) {
 	    	 System.out.println("Failure : \n" +failure.toString());
 	      }
 	      System.out.println("Test Suite Run Result " + result.wasSuccessful());

 	   }
 }