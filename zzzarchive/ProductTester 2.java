package inventory;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int maxSize = getNumProducts(in);

		if (maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			Product products[] = new Product[maxSize];
			
			addToInventory(products, in);
			displayInventory(products);
		}
		in.close();
	}
	
	public static int getMenuChoice(Scanner in) {
		int choice = -9999;
		do {
			try {
				System.out.print("1. View Inventory\n" 
				+ "2. Add Stock\n"
				+ "3. Deduct Stock\n"
				+ "4. Discontinue Product\n"
				+ "0. Exit\n"
				+ "Please enter a menu option");
				choice = in.nextInt();			
				if(choice < 0 || choice > 4) {
					System.out.println("Incorrect Value entered");
				}
			}
			catch(InputMismatchException e) {
				in.nextLine();
				System.out.println("Incorrect data type entered!");
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println(e);
			}
		}while(choice > 4 || choice < 0);
		return choice;
	}
	
	public static int getProductNumber(Product[] products, Scanner in) {
		int productChoice = -1;
		do {
			try {
				for(int i = 0; i < products.length; i++) {
					System.out.println(i + ": " + products[i].getName());
				}
				productChoice = in.nextInt();
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println(e);
			}
		}while(productChoice > (products.length - 1) || productChoice < 0);
		return productChoice;
	}
	
	public static void displayInventory(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].toString());
		}
	}
	
	public static void addToInventory(Product[] products, Scanner in) {
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		for (int i = 0; i < products.length; i++) {
			in.nextLine();
			System.out.print("Enter Product Number: ");
			tempNumber = in.nextInt();
			System.out.print("Enter Product Name: ");
			tempName = in.next();
			System.out.print("Enter Product Quantity: ");
			tempQty = in.nextInt();
			System.out.print("Enter Product Price: ");
			tempPrice = in.nextDouble();
			products[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
			System.out.println("Product " + (i + 1) + " entered\n");
		}
	}
	
	public static int getNumProducts(Scanner in) {
		int maxSize = -1;
		do {
			try {
				System.out.print("Enter the number of products you would like to add \n"
							+ "Enter 0 (zero) if you do not wish to add products: ");
				maxSize = in.nextInt();			
				if(maxSize < 0) {
					System.out.println("Incorrect Value entered");
				}
			}
			catch(InputMismatchException e) {
				in.nextLine();
				System.out.println("Incorrect data type entered!");
				
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println(e);
			}
		}while(maxSize < 0);
		
		return maxSize;
	}
}
