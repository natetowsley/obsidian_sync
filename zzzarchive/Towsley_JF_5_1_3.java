//Nathan Towsley
//CSCI_305
package homeworkPackage;
import java.util.Scanner;

public class Towsley_JF_5_1_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your weight(lbs): ");
		double weight = in.nextDouble();
		System.out.print("**************\n"
				       + "* 1. Venus   *\n"
				       + "**************\n"
				       + "* 2. Mars    *\n"
				       + "**************\n"
				       + "* 3. Jupiter *\n"
				       + "**************\n"
				       + "* 4. Saturn  *\n"
				       + "**************\n"
				       + "Enter number of planet: ");
		int planet = in.nextInt();
		switch (planet) {
		case 1:
			System.out.println("Your weight on Venus is " + weight * .91);
			break;
		case 2:
			System.out.println("Your weight on Mars is " + weight * .38);
			break;
		case 3:
			System.out.println("Your weight on Jupiter is " + weight * 2.36);
			break;
		case 4:
			System.out.println("Your weight on Saturn is " + weight * .92);
			break;
		default:
			System.out.println("Invalid Planet");
		}
		in.close();
	}
}
