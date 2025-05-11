---
Date Created: 2024-09-25T12:57
Favorite: false
tags:
  - Basics
📕 Courses:
  - "[[Programming Concepts and Methodology I (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#6.1]]
    - [[#Modular Programming]]
- [[#6.2]]
    - [[#Defining and Calling Functions]]
        - [[#Function Definition]]
        - [[#Function Return Type]]
        - [[#Calling a Function]]
- [[#6.3]]
    - [[#Function Prototypes]]
        - [[#Prototype Notes]]
- [[#6.4]]
    - [[#Sending data into a Function]]
    - [[#Other Parameter Terminology]]
    - [[#Parameters, Prototypes, and Function Headers]]
    - [[#Function Call Notes]]
    - [[#Passing Multiple Arguments]]
- [[#6.5]]
    - [[#Passing Data by Value]]
- [[#6.6]]
    - [[#Using Functions in Menu-Driven Programs]]
- [[#6.7]]
    - [[#The return Statement]]
- [[#6.8]]
    - [[#Returning a Value From a Function]]
- [[#6.9]]
    - [[#Returning a Boolean Value]]
- [[#6.10]]
    - [[#Local and Global Variables]]
    - [[#Local Variable Lifetime]]
    - [[#Global Variables and Global Constants]]
    - [[#Initializing Local and Global Variables]]
- [[#6.11]]
    - [[#Static Local Variables]]
- [[#6.12]]
    - [[#Default Arguments]]
- [[#6.13]]
    - [[#Using Reference Variables as Parameters]]
    - [[#Passing by Reference]]
        - [[#Reference Variable Notes]]
- [[#6.14]]
    - [[#Overloading Functions]]
- [[#6.15]]
    - [[#The exit() Function]]
- [[#6.16]]
    - [[#Stubs and Drivers]]
---
# 6.1
## Modular Programming
- **Modular Programming:** breaking a program up into smaller, manageable functions or modules
- **Function**: A collection of statements too perform a task
- Motivation for modular programming:
    
    - Improves maintainability of programs
    - Simplifies the process of writing programs
    
      
    
# 6.2
## Defining and Calling Functions
- **Function call:** statement causes a function to execute
- **Function definition:** statements that make up a function
### Function Definition
- Definition includes:
    - Return type: data type of the value that function returns to part of the program that called it
    - name: name of the function. Function names follow same rules as variables. Best as **verbs**
    - parameter list: variables containing the values passed to the function
    - body: statements that perform the function’s task, enclosed in `{}`
![[image 6.png|image 6.png]]
### Function Return Type
- If a function returns a value, the type of the value must be indicated:
    - `int main()`
- If a function does not return a value, its return value type is `void`:
```C++
void printHeading()
{
	cout << "Monthly Sales\n" << endl;
}
```
### Calling a Function
- To call a function, use the function name followed by `()` and `;`
    - `printHeading();`
- When called, program executes the body of the called function
- After the function terminates, execution resumes in the calling function at point of call
![[image 1 3.png|image 1 3.png]]
- `main` can call any number of functions
- Function can call other functions
- Compiler must know the following about a function before it is called:
    - name
    - return type
    - number of parameters
    - data type of each parameter
  
# 6.3
## Function Prototypes
- Ways to notify the compiler about a function before a call to the function
    - Place function definition before calling function’s definition
    - Use a function prototype (function declaration) - like the function definition without the body
        - Header: `void printHeading()`
        - Prototype: `void printHeading();`
```C++
void first();  //prototype of first
void second(); //prototype of second
int main()
{
	code;
	first();
	second();
}
void first() //definition of first
{
	code;
	return;
}
void second() //definition of second
{
	code;
	return;
}
```
### Prototype Notes
- Place prototypes near top of program
- Program must include either prototype or full function definition before any call to the function - compiler error otherwise
- When using prototypes, can place function definitions in any order in source file
- Also known as function declarations
  
# 6.4
## Sending data into a Function
- Can pass values into a function at time of call:
    - `c = pow(a, b);`
- Values passed to function are arguments
- Variables in a function that hold the values passed as arguments are parameters
![[image 2 3.png|image 2 3.png]]
## Other Parameter Terminology
- A parameter can also be called a formal parameter or a formal argument
- An argument can also be called an actual parameter or an actual argument
## Parameters, Prototypes, and Function Headers
- For each function argument…
    - the prototype must include the data type of each parameter inside its parentheses
    - the header must include a declaration for each parameter in its `()`
```C++
void evenOrOdd(int);     //prototype
void evenOrOdd(int num)  //header
evenOrOdd(val);          //call
```
## Function Call Notes
- Value of argument is copied into parameter when the function is called
- A parameter’s scope is the function which uses it
- Function can have multiple parameters
- There must be a data type listed in the prototype `()` and an argument declaration in the function header `()` for each parameter
- Arguments will be promoted/demoted as necessary to match parameters
## Passing Multiple Arguments
- When calling a function and passing multiple arguments…
    - the number of arguments in the call must match the prototype and definition
    - the first argument will be used to initialize the first parameter, the second argument to initialize the second parameter, etc.
![[image 3 2.png|image 3 2.png]]
  
# 6.5
## Passing Data by Value
- Pass by value: when an argument is passed to a function, its value is copied into the parameter
- Changes to the parameter in the function do not affect the value of the argument
```C++
int val = 5;
evenOrOdd(val);
```
![[image 4 2.png|image 4 2.png]]
- `evenOrOdd` can change variable `num`, but it will have no effect on variable `val`
  
# 6.6
## Using Functions in Menu-Driven Programs
- Functions can be used…
    - to implement user choices from menu
    - to implement general-purpose tasks:
        - Higher-level functions can call general-purpose functions, minimizing the total number of functions and speeding program development time
  
# 6.7
## The `return` Statement
- Used to end execution of a function
- Can be placed anywhere in a function
    - Statements that follow the `return` statement will not be executed
- Can be used to prevent abnormal termination of program
- In a `void` function without a `return` statement, the function ends at its last `}`
  
# 6.8
## Returning a Value From a Function
- A function can return a value back to the statement that called the function
- `pow()` function returns a value
```C++
double x;
x = pow(2.0, 10.0); //pow() returns a double
```
- In a value-returning function, the `return` statement can be used to return a value from function to the point of call.
```C++
int sum(int num1, int num2)
{
	double result;
	result = num1 + num2;
	return result;
}
```
- The prototype and the definition must indicate the data type of return value(not `void`)
- Calling function should use return value
    - assign it to a variable
    - send it to `cout`
    - use it in an expression
  
# 6.9
## Returning a Boolean Value
- Function can return `true` or `false`
- Declare return type in function prototype and heading as `bool`
- Function body must contain `return` statement(s) that return `true` or `false`
- Calling function can use return value in a relational expression
  
# 6.10
## Local and Global Variables
- Variables defined inside a function are _local_ to that function. They are hidden from the statements in other functions, which normally cannot access them
- Because the variables defined in a function are hidden, other functions may have separate, distinct variables with the same name
## Local Variable Lifetime
- A function’s local variables exist only while the function is executing. This is known as the _lifetime_ of a local variable
- When the function begins, its local variables and its parameter variables are created in memory, and when the function ends, the local variables and parameter variables are destroyed
- This means that any value stored in a local variable is lost between calls to the function in which the variable is declared
## Global Variables and Global Constants
- A global variable is any variable defined outside all the functions in a program
- The scope of a global variable is the portion of the program from the variable definition to the end
- This means that a global variable can be accessed by _all_ functions that are defined after the global variable is defined
- You should avoid using global variables because they make programs difficult to debug
- Any global that you create should be _global constants_
## Initializing Local and Global Variables
- Local variables are not automatically initialized. They must be initialized by programmer
- Global variables (not constants) are automatically initialized to `0` (numeric) or `NULL` (character) when the variable is defined
  
# 6.11
## Static Local Variables
- Local variables only exist while the function is executing. When the function terminates, the contents of local variables are lost
- `static` local variables retain their contents between function calls
- `static` local variables are defined and initialized only the first time the function is executed. `0` is the default initialization value
  
# 6.12
## Default Arguments
- A Default argument is an argument that is passed automatically to a parameter ==**if the argument is missing on the function call**==
- Must be a constant declared in prototype
    - `void evenOrOdd(int = 0);`
- Can be declared in header if no prototype
- Multi-parameter functions may have default arguments for some or all of them
    - `int getSum(int, int = 0, int = 0);`
- If not all parameters to a function have default values, the defaultless ones are declared first in the parameter list
    - `int getSum(int, int = 0, int = 0); //OK`
    - `int getSum(int, int = 0, int); //NOT OK`
- When an argument is omitted from a function call, all arguments after it must also be omitted
    - `sum = getSum(num1, num2); //OK`
    - `sum = getSum(num1, , num3); //NOT OK`
  
# 6.13
## Using Reference Variables as Parameters
- A mechanism that allows a function to work with the original argument from the function call, not a copy of the argument
- Allows the function to modify values stored in the calling environment
- Provides a way for the function to ‘return’ more than one value
## Passing by Reference
- A reference variable is an alias for another variable
- Defined with an ampersand (&)
    - `void getDimensions(int&, int&);`
- Changes to a reference variable are made to the variable it refers to
- Use reference variables to implement passing parameters by _reference_
### Reference Variable Notes
- Each reference parameter must contain `&`
- Space between type and `&` is unimportant
- Must use `&` in both prototype and header
- Argument passed to reference parameter must be a variable - cannot be an expression or constant
- Use when appropriate - don’t use when argument should not be changed by function, or if function needs to return only 1 value
  
# 6.14
## Overloading Functions
- Overloaded functions have the same name but different parameter lists
- Can be used to create functions that perform the same task but take different parameter types or different number of parameters
- Compiler will determine which version of function to call by argument and parameter lists
![[image 5 2.png|image 5 2.png]]
  
# 6.15
## The `exit()` Function
- Terminates the execution of a program
- Can be called from any function
- Can pass an `int` value to operating system to indicate status of program termination
- Usually used for abnormal termination of program
- Requires `cstdlib` header file
    - defines two constants that are commonly passed, to indicate success or failure
        - `exit(EXIT_SUCCESS)`
        - `exit(EXIT_FAILURE)`
  
# 6.16
## Stubs and Drivers
- Useful for testing and debugging program and function logic and design
- Stub: A dummy function used in place of an actual function
    - Usually displays a message indicating it was called. May also display parameters
- Driver: A function that tests another function by calling it
    - Various arguments are passed and return values are tested