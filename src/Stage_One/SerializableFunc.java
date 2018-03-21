package Stage_One;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableFunc {
	public static void main(String args[]) throws Exception{
		ser();
		dser();
	}
	
	public static void ser() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File("C:" + File.separator + "Game" + File.separator + "book.ser")));
		oos.writeObject(new Book_two("JAVA" , 90.0));
		oos.close();
	}
	
	public static void dser() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(
				"C:" + File.separator + "Game" + File.separator + "book.ser")));
		Object obj = ois.readObject();
		Book_two book = (Book_two) obj;
		System.out.println(book);
		ois.close();
	}
	
}

@SuppressWarnings("serial")
class Book_two implements Serializable{
	private String title;
	private transient double price;
	
	public Book_two(String title , double price){
		this.title = title;
		this.price = price;
	}
	@Override
	public String toString(){
		return title + ":" + price;
	}
	
}

