package com.TestDemo_2;
import java.util.Random;;

public class RandomFunc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Random r = new Random();
		int data[] = new int[7];
		int foot = 0;
		while(foot < 7){
			int t = r.nextInt(37);
			if(!isEmpty(data,t)){
				data[foot ++] = t;
			}
		}
		java.util.Arrays.sort(data);
		for (int x = 0 ; x < data.length ; x ++){
			System.out.println(data[x] + "/");
		}
	}
	
	public static boolean isEmpty(int temp[] , int num){
		if (num == 0){
			return true;
		}
		
		for (int x = 0 ; x < temp.length ; x ++){
			if (temp[x] == num){
				return true;
			}
		}
		return false;
	}

}
