---
Date Created: 2024-09-18T12:57
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
- [[#5.1]]
    - [[#The increment and Decrement Operators]]
        - [[#++]]
        - [[#--]]
    - [[#Prefix vs. Postfix]]
        - [[#Prefix/Postfix Examples]]
    - [[#Notes on Increment and Decrement]]
- [[#5.2]]
    - [[#Introduction to Loops: The while Loop]]
    - [[#The while Loop - How it Works]]
    - [[#The Logic of a while Loop]]
    - [[#Watch Out for Infinite Loops]]
- [[#5.3]]
    - [[#Using the while Loop for Input Validation]]
- [[#5.4]]
    - [[#Counters]]
- [[#5.5]]
    - [[#The do-while Loop]]
    - [[#The Logic of a do-while Loop]]
        - [[#do-while Loop Notes]]
- [[#5.6]]
    - [[#The for Loop]]
    - [[#for Loop - Mechanics]]
    - [[#When to Use the for Loop]]
        - [[#The for loop is a Pretest Loop]]
        - [[#for Loop - Modifications]]
- [[#5.7]]
    - [[#Keeping a Running Total]]
- [[#5.8]]
    - [[#Sentinels]]
- [[#5.9]]
    - [[#Deciding Which Loop to Use]]
- [[#5.10]]
    - [[#Nested Loops]]
    - [[#Nested Loops - Notes]]
- [[#5.11]]
    - [[#Using Files for Data Storage]]
    - [[#Files: What is Needed]]
    - [[#Opening Files]]
    - [[#Testing for File Open Errors]]
    - [[#Using Files]]
    - [[#Using Loops to Process Files]]
    - [[#Closing Files]]
    - [[#Letting the User Specify a Filename]]
    - [[#Using the c_str Member Function in Older Versions of C++]]
- [[#5.12]]
    - [[#Breaking and Continuing a Loop]]
    - [[#The continue Statement]]
---
# 5.1
## The increment and Decrement Operators
### `++`
- `++` is the increment operator
    - adds one to a variable
    - `val++;` is the same as `val = val + 1;`
- `++` can be used before (prefix) or after (postfix) a variable:
    - `++val;` or `val++;`
### `--`
- `--` is the decrement operator
    - subtracts one from a variable
    - `val--;` is the same as `val = val - 1;`
- `--` can be used before (prefix) or after (postfix) a variable:
    - `--val;` or `val--;`
## Prefix vs. Postfix
- `++` and `--` operators can be used in complex statements and expressions
- In prefix mode (`++val`, `—val`) the operator increments or decrements, _then_ returns the value of the variable
- In postfix mode (`val++`, `val--`) the operator returns the value of the variable, _then_ increments or decrements
### Prefix/Postfix Examples
```C++
int num, val = 12
cout << val++; //displays 12... then val becomes 13
cout << ++val; //val becomes 14... then is displayed
```
## Notes on Increment and Decrement
- Can be used in expressions
```C++
result = num1++ + --num2;
```
- Must be applied to something that has a location in memory. Cannot have:
```C++
result = (num1 + num2)++;
```
- Can be used in relational expressions
```C++
if (++num > limit)
```
- pre- and post-operators will cause different comparisons
  
# 5.2
## Introduction to Loops: The `while` Loop
- **Loop**: a control structure that causes a statement or statements to repeat
- General format of the `while` loop
```C++
while (expression)
	statement
```
- `statement`; can also be a block of statements enclosed in `{ }`
## The `while` Loop - How it Works
- `expression` is evaluated
    - If `true`, then `statement` is executed, and `expression` is evaluated again
    - If `false`, then the loop is finished and the program statements following `statement` execute
## The Logic of a `while` Loop
![[image 5.png|image 5.png]]
- The `while` Loop is a pretest loop
    
    - `expression` is evaluated _before_ the loop executes. The following loop will never execute:
    
    ```C++
    int number = 6;
    while (number <= 5) //number == 6, which makes the condition false
    {
    	cout << "Hello\n";
    	number++
    }
    ```
    
## Watch Out for Infinite Loops
- The loop must contain code to make `expression` become `false`
- Otherwise, the loop will have no way of stopping
- Such a loop is called an _infinite loop_, because it will repeat an infinite number of times
```C++
int number = 1;
while (number <= 5)
{
	cout << "Hello\n"; //nothing happens to number, so is always 1
}                    //makes while loop always true
```
  
# 5.3
## Using the `while` Loop for Input Validation
- Input validation is the process of inspecting data that is given to the program as input and determining whether it is valid
- The while loop can be used to create input routines that reject invalid data, and repeat until valid data is entered
- Here’s the general approach, in pseudocode
```C++
Read an item of input.
While the input is invalid
	Display an error message.
	Read the input again.
End While
```
- Input validation example
```C++
cout << "Enter a number less than 10: ";
cin >> number;
while (number >= 10)
{
	cout << "Invalid Entry!" << "Enter a number less than 10: ";
	cin >> number;
}
```
  
# 5.4
## Counters
- **Counter**: a variable that is incremented or decremented each time a loop repeats
- Can be used to control execution of the loop
    - Also known as the _loop control variable_
- Must be initialized before entering loop
  
# 5.5
## The `do-while` Loop
- `do-while`: a posttest loop - execute the loop, _then_ test the `expression`
- General format:
```C++
do 
{
	statement; // or block in {}
} while (expression);
```
- Note that semicolon is required after `expression`
## The Logic of a `do-while` Loop
![[image 1 2.png|image 1 2.png]]
```C++
int x = 1;
do
{
	cout << x << endl;
} while(x < 0);
```
- Although the test expression is false, this loop will execute one time because `do-while` is a posttest loop
### `do-while` Loop Notes
- Loop always executes at least once
- Execution continues as long as `expression` is `true`, stops repetition when `expression` becomes `false`
- Useful in menu-driven programs to bring user back to menu to make another choice
  
# 5.6
## The `for` Loop
- Useful for counter-controlled loops
- General format:
```C++
for(initialization; test; update)
{
	statement; //or block in {}
}
```
- No semicolon after the `update` expression or after the `)`
## `for` Loop - Mechanics
1. Perform `initialization`
2. Evaluate `test` expression
    1. If `true`, execute `statement`
    2. If `false`, terminate loop execution
3. Execute `update`, then re-evaluate `test` expression
- Example
```C++
int count;
for (count = 1; count <= 5; count++)
{
	cout << "Hello" << endl; //Will print "Hello" 5 times each on new line
}
```
## When to Use the `for` Loop
- In any situation that clearly requires
    - an initialization
    - a false condition to stop the loop
    - an update to occur at the end of each iteration
### The `for` loop is a Pretest Loop
- The `for` loop tests its test expression before each iteration, so it is a pretest loop
- The following loop will never iterate
```C++
for (count = 11; count <= 10; count ++)
{
	cout << "Hello" << endl; //Will never execute because 11 > 10 tested before execution
}
```
### `for` Loop - Modifications
- You can have multiple statements in the `initialization` expression
    - Separate the statements with a comma
```C++
int x, y;
for (x=1, y=1; x <= 5; x++)
{
	cout << x << " plus " << y << " equals " << (x+y) << endl;
	}
```
- You can also have multiple statements in the `test` expression
    - Separate the statements with a comma
```C++
int x, y;
for (x=1, y=1; x <= 5; x++, y++) //x and y both incriment
{ 
	cout << x << " plus " << y << " equals " << (x+y) << endl;
}
```
- You can omit the `initialization` expression if it has already been done
```C++
int sum = 0, num = 1;
for (; num <= 10; num++)
{
	sum += num;
}
```
- You can declare variables in the `initialization` expression
    - The scope of declared variable is the `for` loop
```C++
int sum = 0;
for (int num = 0; num <= 10; num++)
{
	sum += num;
}
```
  
# 5.7
## Keeping a Running Total
- running total: accumulated sum of numbers from each repetition of loop
- accumulator: variable that holds running total
```C++
int sum = 0, num = 1; //sum is the accumulator
while (num <= 10)
{
	sum += num;
	num++
}
cout << "Sum of numbers 1 - 10 is " << sum << endl;
```
  
# 5.8
## Sentinels
- sentinel: value in a list of values that indicates end of data
- Special value that cannot be confused with a valid value, e.g. -999 for a test score
- Used to terminate input when user may not know how many values will be entered
  
# 5.9
## Deciding Which Loop to Use
- The `while` loop is a conditional pretest loop
    - Iterates as long as a certain condition exits
    - Validating input
    - Reading lists of data terminated by a sentinel
- The `do-while` loop is a conditional posttest loop
    - Always iterates at least once
    - Repeating a menu
- The `for` loop is a pretest loop
    - Built-in expressions for initializing, testing, and updating
    - Situations where the exact number of iterations is known
  
# 5.10
## Nested Loops
- A nested loop is a loop inside the body of another loop
- Inner(inside), outer (outside) loops
```C++
for (row = 1; row <= 3; row++) //outer
{	
	for (col = 1; col <= 3; col++) //inner
	{	
		cout << row * col << endl;
	}
}
```
![[image 2 2.png|image 2 2.png]]
## Nested Loops - Notes
- Inner loop goes through all repetitions for each repetition of outer loop
- Inner loop repetitions complete sooner than outer loop
- Total number of repetitions for inner loop is product of number of repetitions of the two loops
  
# 5.11
## Using Files for Data Storage
- Can use files instead of keyboard, monitor screen for program input, output
- Allows data to be retained between program runs
- Steps:
    - _Open_ the file
    - _Use_ the file (read from, write to, or both)
    - _Close_ the file
## Files: What is Needed
- Use `fstream` header file for file access
- File stream types:
    - `ifstream` for input from a file
    - `ofstream` for output to a file
    - `fstream` for input from or output to a file
- Define file stream objects:
    - `ifstream infile;`
    - `ofstream outfile;`
## Opening Files
- Create a link between file name (outside the program) and file stream object (inside the program)
- Use the `open` member function:
```C++
\#include <fstream>
infile.open("inventoryl.dat");
outfile.open("report.txt");
```
- Filename may include drive, path info.
- Output file will be created if necessary; existing file will be erased first
- Input file must exist for `open` to work
## Testing for File Open Errors
- Can test a file stream object to detect if an open operation failed:
```C++
\#include <fstream>
infile.open("test.txt");
if (!infile)
{
	cout << "File open failure!";
}
```
- Can also use the `fail` member function
## Using Files
- Can use output file object and `<<` to send data to a file:
```C++
outfile << "Inventory report";
```
- Can use input file object and `>>` to copy data from file to variables:
```C++
infile >> partNum;
infile >> qtyInStock >> qtyOnOrder;
```
## Using Loops to Process Files
- The stream extraction operator `>>` returns `true` when a value was successfully read, `false` otherwise
- Can be tested in a while loop to continue execution as long as values are read from the file:
```C++
while (inputFile >> number)
{
	stuff;
}
```
## Closing Files
- Use the `close` member function:
```C++
\#include <fstream>
infile.close();
outfile.close();
```
- Don’t wait for operating system to close files at program end
    - May be limit on number of open files
    - May be buffered output data waiting to send to file
## Letting the User Specify a Filename
- In many cases, you will want the user to specify the name of a file for the program to open
- In C++ 11, you can pass a `string` object as an argument to a file stream object’s `open` member function
![[4993aa3c-842e-4502-a0bf-9ce1bd3312e5.png]]
## Using the `c_str` Member Function in Older Versions of C++
- Prior to C++ 11, the `open` member function requires that you pass the name of the file as a null-terminated string, which is also known as a C-string
- _String literals_ are stored in memory as null-terminated C-strings, but _string objects_ are **not**.
- `string` objects have a member function named `c_str`
    - It returns the contents of the object formatted as a null-terminating C-string
    - Here is the general format of how you call the `c_str` function
```C++
stringObject.c_str()
```
  
# 5.12
## Breaking and Continuing a Loop
- Can use `break` to terminate execution of a loop
- Use sparingly if at all - makes code harder to understand and debug
- When used in an inner loop, terminates that loop only and goes back to outer loop
## The `continue` Statement
- Can use `continue` to go to end of loop and prepare for next repetition
    - `while`, `do-while` loops: go to test, repeat loop if test passes
    - `for` loop: perform update step, then test, then repeat loop if test passes
- Use sparingly - like `break`, can make program logic hard to follow