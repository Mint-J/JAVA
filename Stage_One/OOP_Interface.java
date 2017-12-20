package com.TestDemo;

// import javafx.application.Application;

public class OOP_Interface {
	
	public static void main(String args[]){
		Network net = null;
		net = new Proxy(new Real());
		net.browse();
	}
}

interface Network{
	public void browse();
}

class Real implements Network{
	public void browse(){
		System.out.println("Has Network !");
	}
}

class Proxy implements Network{
	
	private Network network;
	public Proxy(Network network){
		this.network = network;
	}
	
	public void check(){
		System.out.println("Check whether legal user !");
	}
	
	public void browse(){
		this.check();
		this.network.browse();
	}

}
