package com.TestDemo_2;

import java.math.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Math_Func {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		BigInteger bigA = new BigInteger("1234567890");
		BigInteger bigB = new BigInteger("1123456789");
		
		BigInteger result[] = bigA.divideAndRemainder(bigB);
		System.out.println(result[0] + " | " + result[1]);
		
		long cur = System.currentTimeMillis();
		Date date = new Date(cur);
		System.out.println(date);
		System.out.println(date.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String s = sdf.format(date);
		System.out.println(s);
		Date d = sdf.parse(s);
		System.out.println(d);
	}
	
	public static double round(double num , int scale){
		return Math.round(num*Math.pow(10.0, scale)) / Math.pow(10.0, scale);
	}

}

class MyMath{
	public static double round(double num , int scale){
		BigDecimal big = new BigDecimal(num);
		BigDecimal result = big.divide(new BigDecimal(1), scale, BigDecimal.ROUND_HALF_UP);
		return result.doubleValue();
	}
}