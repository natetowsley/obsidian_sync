package inventory;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
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
		
		/*int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		*/
		if (maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			Product products[] = new Product[maxSize];
			
			addToInventory(products, in);
			
			/*for (int i = 0; i < maxSize; i++) {
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
			}*/
			displayInventory(products);
		}
		in.close();
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
}
