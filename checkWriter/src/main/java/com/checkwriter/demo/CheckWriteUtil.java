/**
 * 
 */
package com.checkwriter.demo;

import java.text.NumberFormat;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

/**
 * @author user
 *
 */
public class CheckWriteUtil {
	public static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	public static final String[] tens = { "", // 0
			"", // 1
			"Twenty", // 2
			"Thirty", // 3
			"Forty", // 4
			"Fifty", // 5
			"Sixty", // 6
			"Seventy", // 7
			"Eighty", // 8
			"Ninety" // 9
	};

	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}
	public static String doubleConvert(final double n) {
	    String pass = n + "";
	    StringTokenizer token = new StringTokenizer(pass, ".");
	    String firstToken = token.nextToken();
	    String lastToken = token.nextToken();
	    try {
	    	
	        pass = convert(Integer.parseInt(firstToken));
	        if(!StringUtils.isEmpty(lastToken)){
	    		int lastTokenIntVal = Integer.parseInt(lastToken);
	    		if(lastTokenIntVal>0){
	    			pass += " dollors and " + lastToken+"/100";
	    		}else {
	    			pass += " dollars only";
	    		}
	    	}else {
	    		pass += " dollars only";
	    	}
	        

	    } catch (NumberFormatException nf) {
	    }
	    return pass;
	}

	public static void main(final String[] args) {

		double n=69;
		
		System.out.println(NumberFormat.getInstance().format(n) + "='" + doubleConvert(n) + "'");

	}

}
