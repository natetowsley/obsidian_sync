//Nathan Towsley
//CSCI_305
package homeworkPackage;
import java.util.Scanner;

public class Towsley_JF_5_1_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		double num1 = in.nextDouble();
		System.out.print("Enter another number: ");
		double num2 = in.nextDouble();
		System.out.print("Enter an operator(+, -, *, /, %): ");
		char op = in.next().charAt(0);
		double answer;
		switch (op) {
		case '+' :
			answer = num1 + num2;
			break;
		case '-':
			answer = num1 - num2;
			break;
		case '*':
			answer = num1 * num2;
			break;
		case '/':
			answer = num1 / num2;
			break;
		case '%':
			answer = num1 % num2;
			break;
		default:
			System.out.println("Invalid operator");
			return;
		}
		System.out.println(num1 + " " + op + " " + num2 + " = " + answer);
	}
}
