package Stage_One;

public class OOP_Object {
	
	public static void main(String args[]){
		Carb car = new Carb("Ford" , 300000);
		System.out.println(car);
	}
}

class Carb{
	private String name;
	private double price;
	
	public Carb(String name , double price){
		this.name = name;
		this.price = price;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPrice(double p){
		this.price = p;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public String toString(){
		return "|- " + this.name + ": " + this.price;
	}
	
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		
		if (this == obj){
			return true;
		}
		
		if (!(obj instanceof Carb)){
			return false;
		}
		
		Carb car = (Carb) obj;
		if (this.price == car.price && this.name.equals(car.name)){
			return true;
		}
		
		return false;
	}
	
}
