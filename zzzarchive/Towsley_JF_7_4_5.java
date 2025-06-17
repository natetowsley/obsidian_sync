package homeworkPackage;

public class Towsley_JF_7_4_5 {
	
}

class Instrument {
	private boolean onSale;
	private double price;
	private int numInStock;
	
	public double getPrice() {
		if(onSale) {
			return price * .85;
		}
		else {
			return price;	
		}
	}
	public double applyEmployeeDiscount() {
		return price * .75;
	}
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
	public boolean getOnSale() {
		return onSale;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumInStock() {
		return numInStock;
	}
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}
}

class StringInstrument extends Instrument {
	private int numStrings;
	
	public int getNumString() {
		return numStrings;
	}
	public void setNumStrings(int numString) {
		this.numStrings = numStrings;
	}
}