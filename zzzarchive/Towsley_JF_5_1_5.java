//Nathan Towsley
//CSCI_305
package homeworkPackage;
import java.util.Scanner; 
public class Towsley_JF_5_1_5{ 
	public static void main(String[] args) { 
		double average; 
		int daysAbsent; 
		boolean exempt=false; 
		Scanner reader= new Scanner(System.in); 
		System.out.println("This program will determine if you can get out of the final exam."); 
		System.out.println("Please answer the following questions."); 
		System.out.println("What is your average in the class?"); 
		average=reader.nextDouble(); 
		System.out.println("How class lectures have you missed?"); 
		daysAbsent=reader.nextInt(); 
		exempt = (average>=90 && daysAbsent <= 3) || (average>=80 && daysAbsent<=0);
		if(exempt)
			System.out.println("Congratulations! You are exempt from the final exam."); 
		else 
			System.out.println("You are not exempt from the final exam.");
		
		reader.close();
	}//end of main 
}//end of class 