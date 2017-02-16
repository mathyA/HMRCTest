package com.hotel.test.utils.common;


import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;


public class Utils {

    
	public static String generateRandomString(int len){
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
	
	public static String getRandomString(int numberOfchars){
		return RandomStringUtils.randomAlphanumeric(numberOfchars).toUpperCase();
		}
	
	public static String getRandomNumeric(int noOfDigits){
		return RandomStringUtils.randomNumeric(noOfDigits);
		}
	
}