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
# Prompting the User for Input: Scanner
- Keyboard input using a Scanner requires the following import statement
```java
import java.util.Scanner;
```
- Prompting the user can be done with simple code that will appear in the console screen where the user can then enter their input
```java
System.out.println("Write instructions for user here.");
```

# Scanner
- To read in the input that the user has entered, use the Java object Scanner
- To initialize a Scaner, write:
```java
Scanner in = new Scanner(System.in);
```
- `Scanner` is commonly named "in" which is short for "input"
- `System.in` is used for the scanner to read the users' input from the console screen
## Why Scanner?
- Scanner makes it easy to read in the user's input because it already has methods that do this very task
- The Scanner method next() reads in the user's input as a String and returns that String
- This line of code:
	- Creates a new string called input
	- Scans in the string that the user has entered into the output console using the scanner called in
	- Sets input equal to the string that was read in by the scanner
```java
String input = in.next();
```
## Scanner's nextInt() Method
- The Scanner method nextInt() reads in the user's input as an integer and returns that integer
- This line of code creates a new int, called answer
```java
import java.util.Scanner;
public class InputExample {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = in.next(); //reads in text until a space
		System.out.println("Enter a number");
		int answer = in.nextInt(); //reads an integer value
		System.out.println(name + ", the number you entered is: " + answer);
	} //end method main
} //end class InputExample
```
## More Useful Scanner Methods

| **Method** | **What it Does**                                                                          | **When to Use**                                                                                                                                                                                                                                    |
| ---------- | ----------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| nextInt()  | Similar to next(), this function reads in the user's input and returns it's integer value | When you prompt the user for an integer value and wish to read in the user's input as an integer rather than as a string                                                                                                                           |
| hasNext()  | Returns true if the scanner has another input, and false otherwise                        | When you wish to know if there is any more input for the scanner to read in                                                                                                                                                                        |
| close()    | Closes the scanner                                                                        | When you are done reading in input, it is good practice to close the scanner, especially when reading input from the console screen<br>This keeps the program from running continuously<br>The scanner may expect more input if it is never closed |
- hasNext() and close() are used for reading files
---
# References
1. [[04 Strings]]