import java.util.Scanner;
public class jf_4_3_NathanTowsley {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base of triangle: ");
		double base = in.nextDouble();
		System.out.print("Enter height of tirangle: ");
		double height = in.nextDouble();
		double area = 0.5 * base * height;
		System.out.println("The area of your triangle is " + area);
	}
}