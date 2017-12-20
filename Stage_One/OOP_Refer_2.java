package com.TestDemo;

public class OOP_Refer_2 {
	
	public static void main(String args[]){
		
		run();
	
	}
	
	public static void run(){
		
		People p1 = new People(18,"Jason");
		People p2 = new People(6,"Small Jason");
		House h1 = new House(777,"Heaven");
		House h2 = new House(776,"Paradise");
		
		p1.setHouse(h1);
		h1.setPeople(p1);
		p2.setHouse(h2);
		h2.setPeople(p2);
		p1.setChild(p2);
		
		System.out.println(p1.getHouse().getInfo());
		System.out.println(p2.getHouse().getInfo());
		System.out.println(p1.getChild().getInfo());
		System.out.println(p1.getInfo());
		System.out.println(p1.getChild().getHouse().getInfo());
		
		
	}
	
}

class House{
	private String hname;
	private int hno;
	private People people;
	
	public House(int no , String name){
		this.hno = no;
		this.hname = name;
	}
	
	public void setHname(String name){
		this.hname = name;
	}
	
	public String getHname(){
		return this.hname;
	}
	
	public void setHno(int no){
		this.hno = no;
	}
	
	public int getHno(){
		return this.hno;
	}
	
	public void setPeople(People people){
		this.people = people;
	}
	
	public People getPeople(){
		return this.people;
	}
	
	public String getInfo(){
		return hno + " : " + hname;
	}
}

class People{
	
	private House house;
	private People child;
	private int age;
	private String name;
	
	public People(int age , String name){
		this.age = age;
		this.name = name;
	}
	
	public void setHouse(House house){
		this.house = house;
	}
	
	public House getHouse(){
		return this.house;
	}
	
	public void setChild(People child){
		this.child = child;
	}
	
	public People getChild(){
		return this.child;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age ;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getInfo(){
		return name + " (" + age + ")";
	}
	
}