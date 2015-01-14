package com.piropanda.projectx.helpers;

public class NumberFormatter {
	
	public static String format(double number) {
		if(number >= 1000000000000000.0) return String.valueOf(Math.round(number / 1000000000000000.0 * 100.0) / 100.0) + " q";
		if(number >= 1000000000000.0) return String.valueOf(Math.round(number / 1000000000000.0 * 100.0) / 100.0) + " t";
		if(number >= 1000000000.0) return String.valueOf(Math.round(number / 1000000000.0 * 100.0) / 100.0) + " b";
		if(number >= 1000000.0) return String.valueOf(Math.round(number / 1000000.0 * 100.0) / 100.0) + " m";
		if(number >= 1000.0) return String.valueOf(Math.round(number / 1000.0 * 100.0) / 100.0) + " k";
		
		return String.valueOf(Math.round(number * 100) / 100.0);
	}
	
}
