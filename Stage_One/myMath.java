package com.TestDemo;

public class myMath {
	public static void main(String args[]){
		try {
			System.out.println(Math.div(10, 0));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

class Math{
	public static int div(int x , int y) throws Exception{
		System.out.println("Start");
		int result = 0;
		try {
			result = x / y;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("End");
		}
		return result;
	}
}