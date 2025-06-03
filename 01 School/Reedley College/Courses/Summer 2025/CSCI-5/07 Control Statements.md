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
# What is a Loop?
- Many everyday tasks involve doing an action, and then repeating the same procedure or action on a different object
- When folding clean clothes, there are three basic steps:
	- Pick up the piece of clothing
	- Fold it
	- Put it away
- For each piece of clothing, the actions are repeated
- Each time you execute the action, only your input (the specific piece of clothing) is different

# Loops
- In programming, there are times when you want to work with multiple inputs, but you want to execute the same logic for each input item
- A loop allows you to have a series of inputs with the same code
- Loops will start at the beginning of a piece of code, execute the logic you wish, and then return to the beginning of the loop with new input, ready to execute the code once more
## Why are Loops Useful?
- Suppose you have a list of ten numbers and you want to find the sum of those numbers
- You could create a statement like this
`sum = num1 + num2 + num3 + num4 + ... + num10;`
- While this is fairly simple code, using a loop will simplify the code further
```java
loop (loop condition) {
	input currentNumber
	sum = sum + currentNumber;
} //end loop
```
## Loop Control: Stopping the Loop
- For code to enter a loop and execute the code inside, the loop condition must be true
- To end the loop, the loop condition must be false
- When creating loops in Java, a condition must change from true to false in order for code to exit the loop
### Stopping Conditions
- A loop needs a stopping condition, which could be specified as:
	- A set number of times to run the code
	- A boolean condition that is changed in the code to make the loop stop executing
## Types of Loops
- Java has three basic types of loops that work with these two types of stopping conditions:
	- Pre-test loops:
		- while loops
		- for loops
	- Post-test loops:
		- do-while loop
### The while Loop
- The while loop is designed to loop while something remains true
- Example condition:
	- While there are more numbers to enter
- Think of the example as a true/false condition, or boolean condition:
	- If the condition "There are more numbers to enter" is true, continue to accept input
	- When the condition "There are more numbers to enter" is false, stop accepting input
#### Infinite Loops
- If you do not allow for a change in the condition, the loop will run forever as an infinite loop
#### Java Syntax for while Loops
- With a while loop, Java uses the syntax:
```java
while(condition is true) {
	//logic
} //end while
```
- Similar to if statements, the while loop parameters can be boolean types, or can produce a boolean value
- Conditional statements using(`<, >, <=, >=, !=, ==`)
	- Examples
```java
while (num1 < num2)
while (isTrue)
while (n != 0)
```
#### While Loop Example
```java
import java.util.Scanner;
public class LoopPractice{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numInputs = 0;
		int sum = 0;
		while (numInputs < 10) {
			input = in.nextInt();
			sum += input;
			numInputs++;
		}
		System.out.println("The sum of those ten numbers is: " + sum);
	}
}
```
#### Using a While Loop with String Methods
- A palindrome is a word spelled the same forward or backward
### The do-while Loop
- The do-while loop:
	- Is a post-test loop
	- Is a modified while loop that allows the program to run through the loop once before testing the boolean condition
	- Continues until the condition becomes false
- If you do not allow for a change in the condition, the loop will run forever as an infinite loop
#### Java Syntax for do-while Loops
- The do-while loop uses the same boolean logic that is used for a regular while loop
- The do code block is run once, and the while condition is tested at the end of each run of the code
	- First, the do code block is executed
	- Next, the condition is tested
	- This repeats until the condition becomes false
- do-while loop syntax:
```java
do{
	//statements to repeat go here
} while (condition);
```
#### do-while Loop Example
```java
import java.util.Scanner;
public class LoopPractice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numInputs = 0;
		int sum = 0, input = 0;
		do {
			System.out.print("Enter a number: ");
			input = in.nextInt();
			sum += input;
			numInputs++;
		}while (numInputs < 10);
		System.out.println("The sum of those ten numbers is: " + sum);
	} //end method main
} //end class
```
### The for Loop
- Recall the folding clothes example
	- If we know how many pieces of clothing we have, we know exactly when the condition "There are more clothes" will be false
	- for loops tell the loop when to stop by explicitly saying "Stop when the loop has run once for every piece of clothing"
	- For example, if we have ten pieces of clothing, we can tell the loop, "Run 10 times" since we know that after the tenth execution, there will not be any more clothes
#### for Loop Java Syntax
- for loop syntax contains three parts:
	- Initializing the lcv (loop control variable)
	- Conditional statement, or stopping condition
	- Updating the counter (going to the next value)
		- Think of i as a counter, starting at 0 and incrementing until i=timesToRun
- for loop syntax:
```java
for (int i = 0; i < timesToRun; i++) {
	//logic
} //end for
```
#### for Loop Example
```java
for (int i = 0; i < numFolded; i++) {
	fold();
} //end for
System.out.println("All Done!");
```
## Which Loop Do I use?

| **Loop Type** | **Definition**                                                                                                                               | **When to Use**                                                                                                                                                                                       |
| ------------- | -------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| while         | Pre-test loop that repeats until a specified condition is false                                                                              | Use when you are not certain the number of times the loop should be executed or even if it should at all                                                                                              |
| do-while      | Post-test loop that executes the loop before testing the condition, then repeats until the condition is false                                | Use when you know that the code must be executed at least once and possibly more times depending on the condition                                                                                     |
| for           | Loop that contains an initialized counter, and increments the counter with each run through the loop<br>Repeats until the condition is false | Use when you need to execute a loop a specific number of times, or when you need to increment through a set of data<br>The counter can also be used as an index for accessing data one item at a time |

# Using break and continue
- break and continue are both keywords in Java that aid in controlling the flow of your program
- The keyword break is useful for instances where you wish to exit a loop at a specified point that is different than the condition statement
	- Using break in a loop will cause code to exit the loop
- The keyword continue is useful for special cases where you want to exclude code for a particular element in a list
	- Using continue will cause the code to skip the rest of the code in the loop and evaluate the condition statement (in a for loop, the lcv will also increment)
---
# References
1. 