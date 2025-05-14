---
Date Created: 2024-11-26T13:18
Favorite: false
tags:
  - ComputerScience/Basics
  - ComputerScience
📕 Courses:
  - "[[!!Programming Concepts and Methodology I (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#9.1]]
    - [[#Recursion]]
        - [[#What Happens When Called?]]
- [[#9.2]]
    - [[#Solving Problems with Recursion]]
        - [[#Recursive Functions - Purpose]]
        - [[#Stopping the Recursion]]
        - [[#What Happens When Called?]]
        - [[#Types of Recursion]]
        - [[#The Recursive Factorial Function]]
- [[#9.3]]
    - [[#The Recursive gcd Function]]
- [[#9.4]]
    - [[#Solving Recursively Defined Problems]]
- [[#9.6]]
    - [[#A Recursive Binary Search Function]]
- [[#9.7]]
    - [[#The Towers of Hanoi]]
- [[#9.10]]
    - [[#Recursion vs. Iteration]]
---
# 9.1
## Recursion
- A recursive function contains a call to itself:
```C++
void countDown(int num)
{
	if (num == 0)
		cout << "Blastoff!";
	else
	{
		cout << num << "...\n";
		countDown(num - 1); //recursive call
	}
}
```
### What Happens When Called?
- If a program contains a line like countDown(2);
    1. `countDown(2)` generates the output 2…, then it calls `countDown(1)`
    2. `countDown(1)` generates the output 1…, then it calls `countDown(0)`
    3. `countDown(0)` generates the output `Blastoff!`, then returns to `countDown(1)`
    4. `countDown(1)` returns to `countDown(2)`
    5. `countDown(2)` returns to the calling function
![[image 11.png|image 11.png]]
  
# 9.2
## Solving Problems with Recursion
### Recursive Functions - Purpose
- Recursive functions are used to reduce a complex problem to a simpler-to-solve problem
- The simpler-to-solve problem is knokwn as the base case
- Recursive calls stop when the base case is reached
### Stopping the Recursion
- A recursive function must always include a test to determine if another recursive call should be made, or if the recursion should stop with this call
- In the sample program, the test is:
    - `if (num == 0)`
- Recursion uses a process of breaking a problem down into smaller problems until the problem can be solved
- In the `countDown` funciton, a different value is passed to the function each time it is called
- Eventually, the parameter reaches the value in the test, and the recursion stops
### What Happens When Called?
- Each time a recursive function is called, a new copy of the function runs, with new instances of parameters and local variables created
- As each copy finishes executing, it returns to the copy of the function that called it
- When the initial copy finishes executing, it returns to the part of the program that made the initial call to the function
![[image 1 8.png|image 1 8.png]]
### Types of Recursion
- Direct
    - A function calls itself
- Indirect
    - Funciton A calls function B, and function B calls function A
    - Function A calls function B, which calls …, which calls function A
### The Recursive Factorial Function
- The factorial function:
    - `n! = n*(n - 1) * (n - 2) * ... * 3*2*1 if n > 0`
    - `n! = 1 if n = 0`
- Can compute factorial of `n` if the factorial of `(n - 1)` is known
    - `n! = n * (n - 1)`
- `n = 0` is the base case
![[image 2 7.png|image 2 7.png]]
  
# 9.3
## The Recursive gcd Function
- Greatest common divisor (gcd) is the largest factor that two integers have in common
- Computed using Euclid’s algorithm:
    - `gcd(x, y) = y` if `y` divides`x` evenly
    - `gcd(x, y) = gcd(y, x % y)` otherwise
    - `gcd(x, y) = y` is the base case
![[image 3 6.png|image 3 6.png]]
  
# 9.4
## Solving Recursively Defined Problems
- The natural definition of some problems leads to a recursive solution
- Ex: Fibonacci numbers:
    - 0, 1, 1, 2, 3, 5, 8, 13, 21
- After the starting 0, 1, each number is the sum of the preceding two numbers
- Recursive solution:
    - `fib(n) = fib(n-1) + fib(n - 2);`
- Base cases: `n <= 0`, `n == 1`
  
# 9.6
## A Recursive Binary Search Function
- Binary search algorithm can easily be written to use recursion
- Base cases: desired value is found, or no more array elements to search
- Algorithm (array in ascending order):
    - If middle element of array segment is desired value, then done
    - Else, if the middle element is too large, repeat binary search in first half of array segment
    - Else, if the middle element is too small, repeat binary search on the second half of array segment
![[image 4 5.png|image 4 5.png]]
  
# 9.7
## The Towers of Hanoi
- The Towers of Hanoi is a mathematical game that is often used to demonstrate the power of recursion
- The game uses three pegs and a set of discs, stacked on one of the pegs
![[image 5 5.png|image 5 5.png]]
- The object of the game is to move the discs from the first peg to the third peg. Here are the rules:
    - Only one disc may be moved at a time
    - A disc cannot be placed on top of a smaller disc
    - All discs must be stored on a peg except while being moved
![[image 6 3.png|image 6 3.png]]
- The following statement describes the overall solution to the problem
    - _Move n discs from peg 1 to peg 3 using peg 2 as a temporary peg_
- Algorithm
    - To move n discs from peg A to peg C, using peg B as a temporary peg:
```C++
if (n > 0) then
	Move n - 1 discs from peg A to peg B, using peg C as a temporary peg
	
	Move the remaining disc from the peg A to peg C
	
	Move n - 1 discs from peg B to peg C, using peg A as a temporary peg
	
End If
```
  
# 9.10
## Recursion vs. Iteration
- Benefits (+), disadvantages(-) for recursion:
    - + Models certain algorithms most accurately
    - + Results in shorter, simpler function
    - May not execute very efficiently
- Benefits(+), disadvantages(-) for iteration:
    - + Executes more efficiently than recursion
    - Ofter is harder to code or understand