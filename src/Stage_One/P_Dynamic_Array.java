package Stage_One;

/**
 * 
 * @date   2017-12-19
 * @author Dai YiMing
 * @e-mail dyming66@sina.cn
 * 
 * The file is regarded as the final of primary 
 *     combination of algorithm and OOP;
 * With complex structure and precise parameters,
 * project is completed in an hour;
 */

public class P_Dynamic_Array {
	
	// Test most functions. Be sure they function properly.``
	public static void main(String args[]){
		
		Link_two car = new Link_two();
		car.add(new Car("Ferrari 458" , 300000.0));
		car.add(new Car("Benz 320i" , 80000.0));
		car.add(new Car("Ford F1" , 500000.0));
		car.add(new Car("Audi R8" , 200000.0));
		
		System.out.println("Amount of cars: " + car.size());
		System.out.println(car.contains(new Car("Ford F1" , 500000.0)));
		
		Car [] cars = car.toArray();
		for (int x = 0 ; x < cars.length ; x ++){
			System.out.print(cars[x].getInfo());
		}	System.out.println();
		
		car.remove(new Car("Benz 320i" , 80000));
		System.out.println("After removing one car, "
				+ "the amount of cars: " + car.size());
		System.out.println(car.get(1).getInfo());
		
		car.set(1, new Car("Aventador" , 500000.0));
		
		Car [] carsb = car.toArray();
		for (int x = 0 ; x < carsb.length ; x ++){
			System.out.print(carsb[x].getInfo());
		}	System.out.println();
		
		
		
	}
}

// OOP_Car demonstrates operation of information of cars;

class Car{
	private String name;
	private double price;
	
	public Car(String name , double price){
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getname(){
		return this.name;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public boolean compare(Car car){
		if (car == null){
			return false;
		}
		
		if (this == car){
			return true;
		}
		
		if (this.price == car.price && this.name.equals(car.name)){
			return true;
		} else {
			return false;
		}
	}
	
	public String getInfo(){
		return "|- " + name + " : " + price;
	}
}

/**
 * 
 * @date   2017-12-19
 * @author Dai YiMing
 * @e-mail dyming66@sina.cn
 *
 * Outer class processes SIMPLE tasks;
 * Inner class processes ADVANCED tasks;
 * Not all functions has "ELSE" after "IF";
 */

//Outer class Link control relatively simple judgment tasks.

class Link_two{
	
	//Inner class Link control relatively advanced judgment tasks.
	private class Node{
		private Car data;
		private Node next;
		
		// One parameter method.
		public Node(Car data){
			this.data = data;
		}
		
		// Add data.
		public void addNode(Node newNode){
			if (this.next == null){
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}
		
		//Judge whether a data exists.
		public boolean containsNode(Car data){
			if (data.compare(this.data)){
				return true;
			} else {
				if (this.next != null){
					return this.next.containsNode(data);
				} else {
					return false;
				}
			}
		}
		
		// Search for a specific data.
		public Car getNode(int index){
			if (Link_two.this.foot ++ == index){
				return this.data;
			}
				return this.next.getNode(index);
		}
		
		// Revise a specific data.
		public void setNode(int index , Car data){
			if (Link_two.this.foot ++ == index){
				this.data = data;
			} else {
				this.next.setNode(index, data);
			}
		}
		
		// Delete certain data.
		public void removeNode(Node previous , Car data){
			if (data.compare(this.data)){
				previous.next = this.next;
			} else {
				this.next.removeNode(this, data);
			}
		}
		
		// Export as the form of array.
		public void toArrayNode(){
			Link_two.this.retArray[Link_two.this.foot ++] = this.data;
			if (this.next != null){
				this.next.toArrayNode();
			}
		}
	}
	
	private Node root;
	private int count = 0;
	private int foot = 0;
	Car [] retArray;
	
	public void add(Car data){
		if (data == null){
			return;
		}
		
		Node newNode = new Node(data);
		if (this.root == null){
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
			count ++;
	}
	
	// Show length.
	public int size(){
		return this.count;
	}
	
	// Judge whether is empty.
	public boolean isEmpty(){
		return this.count == 0;
	}
	
	public boolean contains(Car data){
		if (data == null || this.root == null){
			return false;
		}
			return this.root.containsNode(data);
	}
	
	public Car get(int index){
		if (index > this.count){
			return null;
		}
		
		this.foot = 0 ;
		return this.root.getNode(index);
	}
	
	public void set(int index, Car data){
		if (index > this.count){
			return;
		} 
			this.foot = 0;
			this.root.setNode(index , data);
	}
	
	public void remove(Car data){
		if (this.contains(data)){
			if (data.compare(this.root.data)){
				this.root = this.root.next;
			} else {
				this.root.next.removeNode(this.root , data);
			}
			this.count --;
		}
	}
	
	public Car [] toArray(){
		if (this.root == null){
			return null;
		}
		
		this.foot = 0 ;
		this.retArray = new Car[this.count];
		this.root.toArrayNode();
		return this.retArray;
	}
	
	// Erase all data.
	public void clear(){
		this.root = null;
		this.count = 0;
	}
}