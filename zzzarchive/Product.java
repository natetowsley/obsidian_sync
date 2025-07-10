package inventory;

public class Product {
	//Instance field declarations
	private int number;
	private String name;
	private int qty;
	private double price;
	private boolean active;
	
	//default constructor - initializes all instance variables with default values
	public Product() {
		number = 0;
		name = "n/a";
		qty = 0;
		price = 0;
		active = true;
	}
	
	//constructor with parameters
	public Product(int number, String name, int qty, double price) {
		this.number = number;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.active = true;
		
	}
	//getNum - returns item number
	public int getNum() {
		return number;
	}
	//getName - returns item name
	public String getName() {
		return name;
	}
	//getQty - returns number of items in stock
	public int getQty() {
		return qty;
	}
	//getPrice - returns the price of the item
	public double getPrice() {
		return price;
	}
	//getActive - returns whether the product is active or not
	public boolean getActive() {
		return active;
	}
	//setNum - sets item number
	public void setNum(int number) {
		this.number = number;
	}
	//setName - sets item name
	public void setName(String name) {
		this.name = name;
	}
	//setQty - sets amount of items in stock
	public void setQty(int qty) {
		this.qty = qty;
	}
	//setPrice - sets the price of an item
	public void setPrice(double price) {
		this.price = price;
	}
	//setActive - sets whether product is active or not
	public void setActive(boolean active) {
		this.active = active;
	}
	//getInventoryValue - returns the price of all units left in stock
	public double getInventoryValue() {
		return price * qty;
	}
	//toString - Prints product's info in formatted form
	public String toString() { //String.format found through stack overflow
		return "Item Number      : " + number + "\n" +
				"Name             : " + name + "\n" +
				"Quantity in stock: " + qty + "\n" +
				"Price            : " + price + "\n" +
				"Stock Value      : " + String.format("%.2f", getInventoryValue()) + "\n" +
				"Product Status   : " + (active ? "Active" : "Discontinued") + "\n";
	}
}
