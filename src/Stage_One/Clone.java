package Stage_One;

public class Clone {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Book_one bookA = new Book_one("JAVA WEB" , 90);
			Book_one bookB = (Book_one) bookA.clone();
			bookB.setTitle("JAVA DEVE_R");
			System.out.println(bookA + "\n" + bookB);
			
	}

}

class Book_one implements Cloneable{
	private String title;
	private int price;
	
	public Book_one(){
		
	}
	public Book_one(String t , int p){
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
