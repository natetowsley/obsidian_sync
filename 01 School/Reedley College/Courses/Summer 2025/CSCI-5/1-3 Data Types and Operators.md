---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
Date Created:
---
---
# Java Programming Types
- In Java, data types:
	- Are used to define the kind of data that can be stored inside a variable
	- Ensure that only correct data is stored
	- Are either declared or inferred
	- Can be created by the programmer
## Variables Must Have Data Types
- All variables must have a data type for security reasons
- The program will not compile if the user attempts to store data that is not the correct type
- Programs must adhere to type constraints to execute
	- Incorrect types in expressions or data are flagged as errors at compile time
## Primitive Data Types
- Java has eight primitive data types that are used to store data during a program's operation
- Primitive data types are a special group of data types that do not use the keyword new when initialized
- Java creates them as automatic variables that are not references, which are stored in memory with the name of the variable
- The most common primitive types used in this course are int (integers) and double (decimals)
**Primitive Data Types**

| **Data Type** | **Size**        | **Example**   | **Data Description**                                                            |
| ------------- | --------------- | ------------- | ------------------------------------------------------------------------------- |
| boolean       | 1 bit           | true, false   | Stores true and false flags                                                     |
| byte          | 1 byte (8 bits) | 12, 128       | Stores integers from -128 to 127                                                |
| char          | 2 bytes         | 'A', '5', '#' | Stores a 16-but Unicode character from 0 to 65,535                              |
| short         | 2 bytes         | 6, -14, 2345  | Stores integers from -32,768 to 32,767                                          |
| int           | 4 bytes         | 6, -14, 2345  | Stores integers from -2,147,483,648 to 2,147,483,647                            |
| long          | 8 bytes         | 3459111, 2    | Stores integers from: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807   |
| float         | 4 bytes         | 3.145, .077   | Stores a positive or negative decimal number from: 1.4023x10-45 to 3.4028x10+38 |
| double        | 8 bytes         | .0000456, 3.7 | Stores a positive or negative decimal number from 4.9406x10-324 to 1.7977x10308 |
## Declaring Variables and Using Literals
- The keyword new is not used when initializing a variable of a primitive type
- Instead, a literal value should be assigned to each variable upon initialization
- A literal can be any number, text, or other information that represents a value
EX:
![[Pasted image 20250528204903.png|500]]
- In the image below:
	- The initialization of d2 shows how scientific notation can be used to set the value
	- The initialization of ss_num shows that underscores can be used to separate numbers for readability
![[Pasted image 20250528205109.png|500]]
### Numeric Literal Examples
- 0x and 0b are used to denote a literal hexadecimal value or a literal binary value
- Literals will improve processing performance
![[Pasted image 20250528205219.png|500]]
### Binary Literals
- Binary literals can be expressed using the binary system by adding the prefixes 0b or 0B to the number
- Binary literals are Java int values
- Java byte and short values require a cast to prevent a precision loss error from the compiler
#### Purpose of Java Binary Literals
- Binary Literals are used for:
	- Calculations
	- Comparisons
	- Low-level programming, such as:
		- Writing device drivers
		- Low-level graphics
		- Communications protocol packet assembly
		- Decoding
#### Why Use Binary Literals?
- Using Binary Literals represent values for comparisons and calculations is substantially faster that using values of the actual data type
- Modern high-performance processors usually perform calculations on integers as fast as using binary literals, so why use literals?
- It is still optimal to use literals for overall power and performance because they use less resources
## Casting Example
![[Pasted image 20250528205659.png|600]]

# Variable Scope
- Scope is used to describe the block of code where a variable exists in a program
- It is possible for multiple variables with the same name to exist in a Java program
	- In most cases, the innermost variable has precedence
- A variable only exists inside the code block in which it is declared
- Once the final brace of the block '}' is reched:
	- The variable goes out of scope
	- It is no longer recognized as a declared variable
EX:
- In the example below, name will not print out because it stops existing once the brace marked point B is reached
![[Pasted image 20250528210715.png|550]]
# Boolean Operators
- Boolean operators are a set of operators that can be used to compare expressions to either true or false

| **Operator** | **Operator**             | **Description**                                      | **Example** |
| ------------ | ------------------------ | ---------------------------------------------------- | ----------- |
| &&           | AND                      | If both are true, returns true                       | (A&&B)      |
| \|\|         | OR                       | If any are true, returns true                        | (A\|\|B)    |
| !            | NOT                      | Reverses the logical state (T to F, F to T)          | !(A&&B)     |
| ==           | equal to                 | If both are equal, returns true                      | (A==B)      |
| !=           | NOT equal to             | If both are not equal, returns true                  | (A!=B)      |
| >            | greater than             | If left is greater than right, return true           | (A>B)       |
| >=           | greater than or equal to | If left is greater than or equals right, return true | (A>=B)      |
| <            | less than                | If left is less than right, returns true             | (A<B)       |
| <=           | less than or equal to    | If left is less than or equals right, return true    | (A<=B)      |

# Arithmetic Operators
- Java has several arithmetic operators to perform math operations

| **Symbol** | **Operator Description**                                  |
| ---------- | --------------------------------------------------------- |
| +          | Addition operator                                         |
| -          | Subtraction operator                                      |
| *          | Multiplication operator                                   |
| /          | Division operator (finds the quotient)                    |
| %          | Modular operator (finds the remainder)                    |
| ++         | Increment operator (adds one)<br>Is a unary operator      |
| --         | Decrement operator (subtracts one)<br>Is a unary operator |
## Arithmetic Operator Precedence
- All math expressions are evaluated following the order of precedence:
	- Expressions in parenthesis are handled first
	- All multiplication, division, and modular operations are handled next, working from left to right
	- Finally, all addition and subtraction operations are handled, working from left to right
## Increments and Decrements
- Increments and decrements are handled first for pre-increment notation and last from post-increment notation
- Increment in Java means to add one to the variable value
- Decrement in Java means to subtract one from the variable
- Pre-increment notation:
	- `++x;`
- Post-increment notation:
	- `x++;`

# Assignment Operator (SLIDE 30)
---
# References
1. 