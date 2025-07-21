---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-07-21
---
```table-of-contents
```
---
# Understanding Recursion
- A recursive program is one that calls itself one or more times with each execution until it satisfies the base case arguments, then discontinues calling itself
- It contains:
	- A base case: Segment of code that tells the program when to stop calling itself and return a value or void
	- A recursive case: A call out to another copy of itself
	- A pattern of convergence: The process working backward through a problem's data set
- The types of recursion are:
	- Linear: Only one call to itself in the recursive case
		- Useful and frequently used
	- Non-Linear: Two or more calls to itself in the recursive case
		- Used less frequently because of its impact on the system, specifically JVM memory
- The base case means the method does not need to recursively call itself any more
	- It returns the default value (or does nothing) at the bottom most activity
	- The recursive case occurs when the method cannot resolve the problem without a recursive call to itself
	- Convergence means that you recursively call the method until you reach the base case, then you return values or go up the chain to the original program unit

# Recursion Process
- Recursion looks backward through a chain of events, while traditional loops look forward through events
- Recursion works backward through convergence on a base case, where the base case occurs when you are back to the beginning
![[Pasted image 20250721131055.png||550]]
- If the base case if poorly chosen or the algorithm does not converge on the base case the Java process running on the computer will quickly run out of memory (stack overflow)
## Forward and Recursive Sequences
- The forward thinking (loop) method is the more traditional method of solving problems
- Creating a method that does all of the processing and then returns the value back to the calling method
- This method is called once and completes all of the processing within that one method call
```java
public static double forward(double limit) {
	//declare local variables
	double num1 = 5, result = 0;

	//add n to r, d times
	for (double i = 0; i < limit; i++) {
		result += num1;
	}//end for
	return result
}//end method forward
``` 
- Forward Sequence Explained
	- This explains the code on the previous slide
	- The variable "result" in the forward thinking program is the result variable
	- It is defined initially and incremented with each iteration through the loop
	- This type of variable is essential when we navigate forward without recursion
## Backward Thinking (Recursion)
- The recursive method being shown here demonstrates how recursion works with the backward method continually calling itself until the base case has been reached
```java
public static double backward(double limit) {
	//declare local variables
	double num = 5;
	if (limit <= 1) //base case
		return num;
	else
		return backward(limit - 1) + num;
	//end if
}//end method backward
```
- Recursive Sequence Explained
	- There is no variable "result" in the recursive example because it is not required
	- The return result from each recursive method call passes back the solution, the version of the method that called it increments and returns the result to the prior level
	- This continues until you reach the top most method call
	- In a sense, the return value of the method call in conjunction with the recursive calling statement manages "result" (the result) value without explicitly declaration or management

# The Fibonacci Sequence
- The Fibonacci Sequence is a series of numbers where the next number is found by adding up the two numbers before it
	- 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
- The 2 is found by adding the two numbers before it (1 + 1)
- Similarly, the 3 is found by adding the two numbers before it (1 + 2) and so on
- The next number in the sequence above is 34 + 55 = 89
## Non-Linear Recursion Fibonacci Problem
- The following Fibonacci problem:
	- Calls two or more copies of itself
	- Calls first copy until the base case, then second copy
	- Returns values from the lowest recursive call to original call for each series of calls
```java
public static double fibonacci(double d) {
	//sort elements by title case
	if (d < 2) {
		return d:
	}
	else {
		return fibonacci(d - 1) + fibonacci(d - 2);
	}//end if
}//end method fibonacci
```
## Tracing Through Non-Linear Recursion
- Tracing through a non-linear recursive method is slightly more complex than linear recursive methods
- Although the concept of backward thinking is the same, it may be difficult to use a chart for keeping track of your calls
- Using a tree diagram is more practical for tracing this type of recursion
## Trace a Call to fibonacci(4)
- Trace a call to fibonacci(4) to find out what the returned value is
- When you make a call where d = 4, you get this result:
	- fibonacci(4) = fibonacci(3) + fibonacci(2)
```java
public static double fibonacci(double d) {
	//sort elements by title case
	if (d < 2) {
		return d;
	}
	else {
		return fibonacci(d - 1) + fibonacci(d - 2);
	}//end if
}//end method fibonacci
```
- Continuing to trace through until you reach the base case for all branches, which will give you a tree that looks like this:
![[Pasted image 20250721140654.png|600]]
- The new tree will look like this:
![[Pasted image 20250721140717.png|600]]
- Since fibonacci(2) = 1+1 = 2, change it in the tree:
![[Pasted image 20250721140746.png||550]]
- Next, replace fibonacci(3) with it's value (2 + 1 = 3)
![[Pasted image 20250721140814.png||400]]
- Finally, replace fibonacci(4) with its return value (3 + 2 = 5)
- The conclusion is that fibonacci(4) = 5

# Recursion Pros and Cons
- Pros:
	- Once understood, often more intuitive
	- Simpler, more elegant code
- Cons:
	- Uses more method calls
	- Can cause performance issues
	- Uses more memory
- When programming with either tree or sorted lists then recursion is generally the best method of interacting with these data structures
- The UNIX operating system allows recursion when executing directory structure commands
- Even if you do not use recursion in your programs, you still need to understand it since other programmers' code may use recursion
---
# References
1. [[Recursion]]
2. [[Week 08- Induction & Recursion]]
3. [[Week 09- Algorithms Using Induction & Recursion]]