---
Date Created: 2024-09-09T10:32
Favorite: false
tags:
  - Basics
📕 Courses:
  - "[[!!Programming Concepts and Methodology I (C++)]]"
---
> [!important] C++ Reference
> 
> > [!info] cplusplus.com  
> >  
> > [https://cplusplus.com/](https://cplusplus.com/)  
# Table of contents
- [[#Table of contents]]
- [[#4.1]]
    - [[#Relational Operators]]
    - [[#Relational Expressions]]
- [[#4.2]]
    - [[#The if Statement]]
    - [[#if Statement Notes]]
- [[#4.3]]
    - [[#Expanding the if Statement]]
- [[#4.4]]
    - [[#The if/else Statement]]
- [[#4.5]]
    - [[#Nested if Statements]]
- [[#4.6]]
    - [[#The if/else if Statement]]
- [[#4.7]]
    - [[#Flags]]
- [[#4.8]]
    - [[#Logical Operators]]
    - [[#Logical Operator Notes]]
- [[#4.9]]
    - [[#Checking Numeric Ranges with Logical Operators]]
- [[#4.10]]
    - [[#Menus]]
    - [[#Menu-Driven Program Organization]]
- [[#4.11]]
    - [[#Validating User Input]]
- [[#4.12]]
    - [[#Comparing Characters and Strings]]
        - [[#Comparing Characters]]
        - [[#Comparing string Objects]]
- [[#4.13]]
    - [[#The Conditional Operator]]
- [[#4.14]]
    - [[#The switch Statement]]
    - [[#switch Statement Requirements]]
    - [[#switch Statement-How it Works]]
    - [[#break Statements]]
    - [[#Using switch in Menu Systems]]
- [[#4.15]]
    - [[#More About Blocks and Scope]]
    - [[#Variables with the Same Name]]
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
  
---
# 4.1
## Relational Operators
- Used to compare numbers to determine relative order
- Opertaors
|   |   |
|---|---|
|>|Greater than|
|<|Less than|
|>=|Greater than or equal to|
|<=|Less than or equal to|
|==|Equal to|
|!=|Not equal to|
## Relational Expressions
- Boolean expressions - `true` or `false`
- ex:
    - 12 > 5 is `true`
    - 7 <= 5 is `false`
- Can be assigned to a variable
```C++
bool result = x <= y; 
//Assigns 0 for false, 1 for true
```
- Do not confuse `=` and `==`
  
# 4.2
## The `if` Statement
- Allows statements to be conditionally executed or skipped over
- Models the way we mentally evaluate situations
    
    - “If it’s raining, take an umbrella.”
    - “If it’s cold outside, wear a coat.”
    
    ![[image.png]]
    
- General Format:
```C++
if (expression)
	statement;
```
- If the `expression` is `true`, then `statement` is executed
- If the `expression` is `false`, then `statement` is skipped
## `if` Statement Notes
- Do not place `;` after `(expression)`
- Place `statement;` on a separate line after `(expression)`, indented:
```C++
if (score > 90)
	grade = 'A';
```
- Be careful testing `float`s and `double`s for equality
- 0 is `false`; any other value if `true`
  
# 4.3
## Expanding the `if` Statement
- To execute more than one statement as part of an `if` statement, must be enclosed in `{}`:
```C++
if (score > 90)
{
	grade = 'A';
	cout << "Good Job!\n";
}
```
- `{}` creates a _**block**_ of code
  
# 4.4
## The `if/else` Statement
- Provides two possible paths of execution
- Performs one statement or block if `expression` is true, otherwise performs another statement or block
- General Format:
```C++
if (expression)
	statement1; // or block
else
	statement2; // or block
```
- If the `expression` is `true`, then `statement1` is executed and `statement2` is skipped.
- If the `expression` is `false`, then `statement1` is skipped and `statement2` is executed.
![[image 1.png]]
  
# 4.5
## Nested `if` Statements
- An `if` statement that is nested inside another `if` statement
- Nested `if` statements can be used to test more than one condition
![[image 2.png]]
```C++
// Determine the user's loan qualifications/
if (employed == 'Y')
{
	if (recentGrad == 'Y') //Nested if
	{
		cout << "You qualify for the special ";
		cout << "interest rate.\n";
	}
}
```
# 4.6
## The `if/else if` Statement
- Tests a series of conditions until one is found to be true
- Often simpler than using nested `if/else` statements
- Can be used to model though processes such as:
    - “If it is raining, take an umbrella, else if it is windy, take a hat, else, take sunglasses”
- `if/else if` Format
```C++
if (expression)
	statement1; // or block
else if (expression)
	statement2; // or block
	.
	. // other else ifs
	.
else if (expression)
	statementn; // or block
```
- Order of expressions matters, because program will execute until first `true`
  
# 4.7
## Flags
- Variable that signals a condition
- Usually implemented as a `bool` variable
- Can also be and integer
    - The value `0` is considered `false`
    - Any nonzero value is considered `true`
- As with other variables in functions, must be assigned an initial value before it is used
  
# 4.8
## Logical Operators
- Used to create relational expressions from other relational expressions
|   |   |   |
|---|---|---|
|Operators|Meaning|Explanation|
|&&|AND|New relational expressions is true if both expressions are true|
|\||OR|New relational expression is true if either expression is true|
|!|NOT|Reverses the value of an expression - true expressions becomes false, and false becomes true|
## Logical Operator Notes
- `!` has highest precedence, followed by `&&`, then `||`
- If the value of an expression can be determined by evaluating just the sub-expression on left side of a logical operator, then the sub-expression on the right side will not be evaluated (short circuit evaluation)
  
# 4.9
## Checking Numeric Ranges with Logical Operators
- Used to test to see if a value falls **inside** a range
```C++
if (grade >= 0 && grade <= 100)
	cout << "Valid grade";
```
- Can also test to see if value falls **outside** of range
```C++
if (grade <= 0 || grade >= 100)
	cout << "Invalid grade";
```
- Cannot use mathematical notation
```C++
if (0 <= grade <= 100) //INVALID --- DOESN'T WORK
```
  
# 4.10
## Menus
- Menu-driven program: program execution controlled by user selecting from a list of actions
- Menu: list of choices on the screen
- Menus can be implemented using `if/else if` statements
## Menu-Driven Program Organization
- Display list of numbered or lettered choices for actions
- Prompt user to make selection
- Test user selection in `expression`
    - If a match, then execute code for action
    - If not, then go on to the next `expression`
  
# 4.11
## Validating User Input
- Input validation: inspecting input data to determine whether it is acceptable
- Bad output will be produced from bad input
- Can perform various tests:
    - Range
    - Reasonableness
    - Valid menu choice
    - Divide by zero
  
# 4.12
## Comparing Characters and Strings
### Comparing Characters
- Characters are compared using their ASCII values
- ‘A’ < ‘B’
    - The ASCII value of ‘A’ (65) is less than the ASCII value of ‘B’ (66)
- ‘1’ < ‘2’
    - The ASCII value of ‘1’ (49) is less than the ASCII value of ‘2’ (50)
- Lowecase letter have higher ASCII codes than uppercase letters, so ‘a’ > ‘Z’
### Comparing `string` Objects
- Like characters, strings are compared using their ASCII values
    
    ```C++
    string name1 = "Mary";
    string name2 = "Mark";
    
    name1 > name2  // true
    name1 <= name2 // false
    name1 != name2 // true
    
    name1 < "Mary Jane" // true
    ```
    
  
# 4.13
## The Conditional Operator
- Can use to create short `if/else` statements
- Format: `expr ? expr : expr;`
![[image 3.png]]
- The value of a conditional expression is
    - The value of the second expression if the first expression is `true`
    - The value of the third expression if the first expression is `false`
- Parentheses `()` may be needed in an expression due to precedence of conditional operator
  
# 4.14
## The `switch` Statement
- Used to select among statements from several alternatives
- In some cases, can be used instead of `if/else if` statements
```C++
switch (expression) //integer
{
	case exp1: statement1;
	case exp2: statement2;
	...
	case expn: statementn;
	defaault: statementn+1;
}
```
- Example:
```C++
    char choice;
    cout << "Enter A, B, or C: ";
    cin >> choice;
    switch (choice)
    {
    case 'A': cout << "You entered A.\n";
        break;
    case 'B': cout << "You entered B.\n";
        break;
    case 'C': cout << "You entered C.\n";
        break;
    default:  cout << "You did not enter A, B, or C!\n";
    }
```
```C++
switch(grade)
	case 'A':
	case 'B':
	case 'C':
	case 'D': cout << "You passed!" << endl;
						break;
```
## `switch` Statement Requirements
1. `expression` must be an integer variable or an expression that evaluates to an integer value
2. `exp1` through `exp`_`**n**`_ must be constant integer expressions or literals, and must be unique in the `switch` statement
3. `default` is optional but recommended
## `switch` Statement-How it Works
1. `expression` is evaluated
2. The value of `expression` is compared against `exp1` through `exp`_`**n**`_
3. If `expression` matches value `exp`_`**i**`_, the program branches to the statement following `exp`_`**i**`_ and continues to the end of the `switch`
4. If no matching value is found, the program branches to the statement after `default`:
## `break` Statements
- Used to exit a `switch` statement
- If it is left out, the program “falls through” and executes the remaining statements in the `switch` statement
## Using `switch` in Menu Systems
- `switch` statement is a natural choice for menu-driven program:
    - display the menu
    - then, get the user’s menu selection
    - use user input as `expression` in `switch` statement
    - use menu choices as `expr` in `case` statements
  
# 4.15
## More About Blocks and Scope
- Scope of a variable is the block in which it is defined, from the point of definition to the end of the block
- Usually defined at beginning of function
- May be defined close to first use
![[image 4.png]]
## Variables with the Same Name
- Variables defined inside `{}` have local or block scope
- When outside of a block, the variables defined inside said block are unavailable