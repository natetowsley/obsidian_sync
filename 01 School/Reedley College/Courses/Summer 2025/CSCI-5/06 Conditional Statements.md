---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created:
---
```table-of-contents
```
---
# Relational Operators
- Java has six relational operators used to test primitive or literal numerical values
- Relational operators are used to evaluate if-else and loop conditions

| **Relational Operator** | **Definition**           |
| ----------------------- | ------------------------ |
| >                       | Greater than             |
| >=                      | Greater than or equal to |
| ==                      | Equal to                 |
| <                       | Less than                |
| <=                      | Less than or equal to    |
| !=                      | Not equal to             |
## Relational Operators Example
- Values are tested on either side of the operator and a true or false value is returned
- This value can be stored or used as part of a control structure to control program flow
- In this example, the variable madeHonorRoll is assigned a true value when the expression grade >= 88 evaluates to true
```java
int grade = 99;
boolean madeHonorRoll = grade >= 88;
if (madeHonorRoll) {
	System.out.println("You made the Honor Roll.");
}
```
- The same can be evaluated with the use of the boolean variable
```java
int grade = 99;

if (grade >= 88) {
	System.out.println("You made the Honor Roll.");
}
```
- However, the expression grade >= 88 evaluates to true or false depending on the value assigned to grade
- Boolean values are necessary as a condition in an if-else statement or loop

# Logic Operators
- Java has three logic operators used to combine boolean expressions into complex tests

| **Logic Operator** | **Meaning** |
| ------------------ | ----------- |
| &&                 | AND         |
| \|\|               | OR          |
| !                  | NOT         |
## Logic Operators Example
- In this example, the phrase "You qualify for the scholarship" will print if both conditions are true
- For the message to print, madeHonorRoll must be true and the numberDaysAbsent must be equal to zero
```java
int numberDaysAbsent = 0;
int grade = 99;
boolean madeHonorRoll = grade >= 88;

if (madeHonorRoll && numberDaysAbsent == 0) {
	System.out.println("You qualify for the scholarship.");
}
```

# Syntax for If-Else Statements
- To build an if-else statement, remember the following rules:
	- An if-else statement needs a condition or method that is tested for true/false
	- EX:
```java
if(y > 17)

if(x == 5)

if(s1.equals(s2))
```
- Likewise, an optional else if statement can be tested, for example:
```java
if(y > 17) {
	System.out.println("y > 17");
}
else if(y == 17) {
	System.out.println("y == 17");
}
```
- The optional else statement will take care of every other possibility
```java
if(y > 17) {
	System.out.println("y > 17");
}
else if(y == 17) {
	System.out.println("y == 17");
}
else {
	System.out.println("y < 17");
}
```
## If-else Statements with the char Data Type
```java
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int answer = 0;
		System.out.print("Enter a number: ");
		int num1 = in.nextInt();
		System.out.print("Enter another number: ");
		int num2 = in.nextInt();
		System.out.print("Enter the operand(* / % + -): ");
		char input = in.next().charAt(0);
		if (input == '*')
			answer = num1 * num2;
		else if (input == '/')
			answer = num1 / num2;
		else if (input == '%')
			answer = num1 % num2;
		else if (input == '+')
			answer = num1 + num2;
		else if (input == '-')
			answer = num1 - num2;
		else
			System.out.println("Invalid Command");
		System.out.println("The result is: " + answer);
	} // end main method
} // end class Calculator
```
- It can be useful to use `print` instead of `println` when prompting the user, so that the cursor remains on the same line
- nextLine() reads in all the text regardless of spaces
```java
import java.util.Scanner
public class StringChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name = "";
		System.out.print("Enter your name: ");
		name = in.nextLine();
		if (name.equals("Elvis")) {
			System.out.println("You are the kind of Rock and Roll");
		}
		else if (name.equals("Michael Jackson")) {
			System.out.println("You are the king of pop!");
		}
		else {
			System.out.println("You are not the king!");
		}
	} //end method main
} // end class StringChecker
```

# Switch Statement
- Like the if-else example earlier, consider a program that takes two integer inputs from a user and performs a specified mathematical operation
- To support different operators a test in needed to see if the input was any of the following:
	- * / + - %
- How would you check to see what the user typed?
## Switch Statement Changes Program Flow
- A switch statement is another way of changing program flow depending on the input value
```java
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int answer = 0;
		System.out.print("Enter a number: ");
		int num1 = in.nextInt();
		System.out.print("Enter another number: ");
		int num2 = in.nextInt();
		System.out.print("Enter the operand(* / % + -): ");
		char input = in.next().charAt(0);
		switch(input){
			case '*' : answer = num1 * num2;
						break;
			case '/' : answer = num1 / num2;
						break;
			case '%' : answer = num1 % num2;
						break;
			case '+' : answer = num1 + num2;
						break;
			case '-' : answer = num1 - num2;
						break;
			default: System.out.println("Invalid Command.");
		} //end switch
		System.out.println("The result is: " + answer);
	} //end method main
} //end class Calculator
```
## Switch Statement Keywords
- A switch statement uses 3 keywords: switch, case, and default
	- switch:
		- specifies which variable to test for value
	- case:
		- compares the value of the switch variable
	- default:
		- when the input does not match any of the cases, the compiler chooses the default action (like else in a list of if statements)
## Additional Information about Switch Statements
- After each case, include the keyword break
- If not included, the code will "fall through" and execute each case until break is encountered
- In Java SE 7 and later, you can use a String object in the switch statement's expression

# Switch Expressions
- Since Java 14 a switch expression has been included in the Java language
- The switch label is now written as: case value -> code;
- Only the code to the right of the label is going to be executed if the label is matched
- After each case, the keyword break is not required
- The cases of a switch expression must be exhaustive, all possible values must have a matching switch label
- A default is normally required
## Switch Expression Example
```java
import java.util.Scanner;
public class ClassYear {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What grade are you in?");
		int grade = in.nextInt();
		switch(grade) {
			case 9 -> System.out.println("You are a freshman");
			case 10 -> System.out.println("You are a sophomore");
			case 11 -> System.out.println("You are a junior");
			case 12 -> System.out.println("You are a senior");
			default -> System.out.println("Invalid grade");
		} //end switch
	} //end method main
} //end class ClassYear
```

# Ternary Operator
- The ternary operator `(?:)` in Java is used to create a shorter version of an if-else statement
- In the following example, there are three parameters using this operator
	- The first is the boolean test (c>9)
	- The second (6) is the value to return if the test is true
	- The third (7) is the value to return if the test is false
	- It is often used as part of an assignment
```java
int x = c > 9 ? 6 : 7;
//If c is greater than 9, x is 6; else x is 7
```
## Ternary Operator Example
- Using if-else statement
```java
String s1 = "Hello";
String s2 = "Goodbye";
if(s1.equals(s2))
	System.out.println("Yes");
else
	System.out.println("No");
```
- Using ternary operator
```java
String s1 = "Hello";
String s2 = "Goodbye";
String answer = s1.equals(s2) ? "Yes" : "No";
System.out.println(answer);
```
# References
1. [[05 Scanner]]
2. [[Conditional Branches]]