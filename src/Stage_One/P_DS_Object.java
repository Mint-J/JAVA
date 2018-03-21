package Stage_One;

/**
 * 
 * @date   2017-12-23
 * @author Jason Dai
 * @e-mail dyming66@sina.cn
 *
 * Object class receives various parameters;
 * Add petshop as example;
 * One more time to be familiar with DA;
 * 
 */


public class P_DS_Object {
	
	public static void main(String args[]){
		
		PetShop shop = new PetShop();
		shop.add(new Dog("A Dog" , 1));
		shop.add(new Dog("B Dog" , 2));
		shop.add(new Cat("A Cat" , 1));
		shop.add(new Cat("B Cat" , 2));
		shop.add(new Cat("C Cat" , 3));
		
		Link_one all = shop.search("B");
		Object obj[] = all.toArray();
		for (int x = 0 ; x < obj.length ; x ++){
			System.out.println(obj[x]);
		}
		
	}
	
}

// General form of pets;
interface Pet{
	
	public String getName();
	public int getAge();
	
}

// Real instance of a petshop;
class PetShop{
	
	public PetShop(){
		
	}
	
	private Link_one pets = new Link_one();
	
	public void add(Pet pet){
		this.pets.add(pet);
	}
	
	public void delete(Pet pet){
		this.pets.remove(pet);
	}
	
	public Link_one search(String key){
		Link_one result = new Link_one();
		Object obj[] = this.pets.toArray();
		for (int x = 0 ; x < obj.length ; x ++){
			Pet p = (Pet) obj[x];
			if (p.getName().contains(key)){
				result.add(p);
			}
		}
		return result;
	}
}

// Real-life Dog;
class Dog implements Pet{
	
	public Dog(){
		
	}
	
	private String name;
	private int age;
	
	public Dog(String n , int a){
		this.name = n;
		this.age = a;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int a){
		this.age = a;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		
		if (obj == null){
			return false;
		}
		
		if(!(obj instanceof Dog)){
			return false;
		}
		
		Dog d = (Dog) obj;
		if (this.name.equals(d.name) && this.age == d.age){
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		return "|- Dog's name: " + this.name + " | Age: " + age; 
	}
	
}

//Real-life Cat;
class Cat implements Pet{
	
	public Cat(){
		
	}
	
	private String name;
	private int age;
	
	public Cat(String n , int a){
		this.name = n;
		this.age = a;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int a){
		this.age = a;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		
		if (obj == null){
			return false;
		}
		
		if(!(obj instanceof Cat)){
			return false;
		}
		
		Cat c = (Cat) obj;
		if (this.name.equals(c.name) && this.age == c.age){
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		return "|- Cat's name: " + this.name + " | Age: " + age; 
	}
	
}

// Dynamic Array !

class Link_one{
	
	public Link_one(){
		
	}
	
	private class Node{
		
		private Object data;
		private Node next;
		
		public Node(Object data){
			this.data = data;
		}
		
		public void addNode(Node newNode){
			if (this.next == null){
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}
		
		public boolean containsNode(Object data){
			if (data.equals(this.data)){
				return true;
			} else {
				if (this.next != null){
					return this.next.containsNode(data);
				}
			}
			return false;
		}
		
		public Object getNode(int index){
			if (Link_one.this.foot ++ == index){
				return this.data;
			} else {
				return this.next.getNode(index);
			}
		}
		
		public void setNode(int index , Object data){
			if (Link_one.this.foot ++ == index){
				this.data = data;
			} else {
				this.next.setNode(index, data);
			}
		}
		
		public void removeNode(Node previous , Object data){
			if (data.equals(this.data)){
				previous.next = this.next;
			} else {
				this.next.removeNode(this, data);
			}
		}
		
		public void toArrayNode(){
			Link_one.this.retArray[Link_one.this.foot ++] = this.data;
			if (this.next != null){
				this.next.toArrayNode();
			}
		}
		
	}
	
	private Node root;
	private int count = 0;
	int foot = 0;
	private Object [] retArray;
	
	public void add(Object data){
		if (data == null){
			return;
		}
		
		Node newNode = new Node(data);
		if(this.root == null){
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count ++;
	}
	
	public int size(){
		return this.count;
	}
	
	public boolean isEmpty(){
		return this.count == 0;
	}
	
	public boolean contains(Object data){
		if (data == null || this.root == null){
			return false;
		}
		
		return this.root.containsNode(data);
	}
	
	public Object get(int index){
		if (index > this.count){
			return null;
		}
		
		this.foot = 0;
		return this.root.getNode(index);
	}
	
	public void set(int index , Object data){
		if (index > this.count){
			return;
		}
		
		this.foot = 0;
		this.root.setNode(index , data);
	}
	
	public void remove(Object data){
		if (this.contains(data)){
			if (data.equals(this.root.data)){
				this.root = this.root.next;
			} else {
				this.root.next.removeNode(this.root , data);
			}
		}
	}
	
	public Object [] toArray(){
		if (this.root == null){
			return null;
		}
		this.foot = 0;
		this.retArray = new Object[this.count];
		this.root.toArrayNode();
		return retArray;
	}
	
	public void clear(){
		this.root = null;
		this.count = 0;
	}
	
}