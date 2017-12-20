package com.TestDemo;

/**
 * 
 * @date   2017-12-18
 * @author Jason Dai
 * @e-mail dyming66@sina.cn
 *
 * New lesson for JAVA extension;
 * It includes sort/reverse sorts;
 */


public class OOP_Extends {
	
	public static void main(String args[]){
		SortArray ar = new SortArray(3);
		System.out.println(ar.add(34));
		System.out.println(ar.add(98));
		System.out.println(ar.add(56));
		
		SortArray arr = new SortArray(2);
		System.out.println(arr.add(78));
		System.out.println(arr.add(67));
		
		ReverseArray arrr = new ReverseArray(2);
		System.out.println(arrr.add(98));
		System.out.println(arrr.add(56));
		
		int [] temp = ar.getData();
		for ( int x = 0 ; x < temp.length ; x ++){
			System.out.print(temp[x] + "/");
		}	System.out.println();
		
		int [] temp2 = arr.getData();
		for ( int x = 0 ; x < temp2.length ; x ++){
			System.out.print(temp2[x] + "/");
		}	System.out.println();
		
		int [] temp3 = arrr.getData();
		for (int x = 0 ; x < temp3.length ; x ++){
			System.out.print(temp3[x] + "/");
		}	System.out.println();
	}
}

class Array{
	private int [] data;
	private int foot;
	
	public Array(int len){
		if (len > 0){
			this.data = new int[len];
		} else {
			this.data = new int[1];
		}
	}
	
	public boolean add(int index){
		if (this.foot < this.data.length){
			this.data[this.foot ++] = index;
			return true;
		} else {
			return false;
		}
	}
	
	public int [] getData(){
		return this.data;
	}
}

class SortArray extends Array{
	
	public SortArray(int len){
		super(len);
	}
	
	public int[] getData(){
		java.util.Arrays.sort(super.getData());
		return super.getData();
	}
}

class ReverseArray extends Array{
	public ReverseArray(int len){
		super(len);
	}
	
	public int[] getData(){
		int center = super.getData().length / 2;
		int head = 0;
		int tail = super.getData().length - 1;
		for (int x = 0 ; x < center ; x++){
			int temp = super.getData()[head];
			super.getData()[head] = super.getData()[tail];
			super.getData()[tail] = temp;
			head ++ ;
			tail -- ;
		}
		return super.getData();
	}
}
