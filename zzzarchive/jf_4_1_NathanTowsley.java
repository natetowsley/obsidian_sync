import java.util.Scanner;
public class jf_4_1_NathanTowsley {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of gallons: ");
		double gallons = in.nextDouble();
		double liters = gallons * 3.78541;
		System.out.println(gallons + " gallons is " + liters + " liters");
	}
}