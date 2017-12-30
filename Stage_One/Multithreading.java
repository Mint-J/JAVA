package com.TestDemo;

public class Multithreading{
	
	public static void main(String args[]) throws Exception{
		
		Message m = new Message();
		new Thread(new Producer(m)).start();
		new Thread(new Consumer(m)).start();
	
	}
}

class Message{
	private String title;
	private String content;
	private boolean flag = true;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public synchronized void set(String title , String content){
		
		if (flag == false) {
			try {
				super.wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		this.title = title;
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		this.content = content;
		this.flag = false;
		super.notify();
	}
	
	public synchronized void get(){
		
		if (flag == true){
			try {
				super.wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println(this.title + "-->" + this.content);
		this.flag = true;
		super.notify();
	}
}

class Consumer implements Runnable{
	
	private Message m = null;
	public Consumer(Message m){
		this.m = m;
	}
	
	@Override
	public void run(){
		for (int x = 0 ; x < 10 ; x ++){
			if (x % 2 == 0){
				this.m.set("JAVA_1", "AAA");
			} else {
				this.m.set("JAVA_2", "BBB");
			}
		}
	}
}

class Producer implements Runnable{
	private Message m = null;
	public Producer(Message m){
		this.m = m;
	}
	
	@Override
	public void run(){
		for (int x = 0 ; x < 10 ; x ++){
			this.m.get();
		}
	}
}