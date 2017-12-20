package com.TestDemo;

public class OOP_Conversion {
	
	public static void main(String args[]){
			fun(new B());
			funb(new D());
			E e = E.getInstance();
			e.print();
	}
	
	public static void fun(A a){
		a.print();
		if (a instanceof B){
			B b = (B) a;
			b.funB();
		}
	}
	
	public static void funb(C c){
		if (c instanceof D){
			D d = (D) c;
			d.fun();
			c.fun();
		}
	}
}

class A{
	public void print(){
		System.out.println("AAA");
	}
}

class B extends A{
	public void print(){
		System.out.println("BBB");
	}
	
	public void funB(){
		System.out.println("B++");
	}
}

abstract class C{
	public abstract void fun();
}

class D extends C{
	public void fun(){
		System.out.println("DDD");
	}
}

abstract class E{
	
	public abstract void print();
	
	private static class F extends E{
		
		public void print(){
			System.out.println("FFF");
		}	
	}
	
	public static E getInstance(){
		return new F();
	}
}
