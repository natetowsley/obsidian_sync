// Nathan Towsley
// CSCI_305
package homeworkPackage;
import java.util.Scanner;

public class Towsley_JF_6_4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] scores = new int[5];
		for(int i = 0; i < scores.length; i++) {
			System.out.print("Enter test score " + (i + 1) + ": ");
			scores[i] = in.nextInt();
		}
		System.out.println("Your student's average is " + findAverage(scores));
	}
	public static double findAverage(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum+= arr[i];
		}
		double average = (double)sum / arr.length;
		return average;
	}
}