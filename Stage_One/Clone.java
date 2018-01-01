package com.TestDemo_2;

public class Clone {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Book bookA = new Book("JAVA WEB" , 90);
			Book bookB = (Book) bookA.clone();
			bookB.setTitle("JAVA DEVE_R");
			System.out.println(bookA + "\n" + bookB);
			
	}

}

class Book implements Cloneable{
	private String title;
	private int price;
	
	public Book(){
		
	}
	public Book(String t , int p){
		this.title = t;
		this.price = p;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		while (true){
			return title + ":" + price;
		}
	}
}
