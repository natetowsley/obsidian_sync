---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
  - ComputerScience
Date Created:
---
```table-of-contents
```
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

# Assignment Operator
- Java uses the = (equal sign) as the assignment operator
![[Pasted image 20250529145701.png|450]]

# Truncation and Integer Division
- Division of two integers will ALWAYS produce an integer
- Integer Division Examples:
	- 16 / 3 = 5 (Truncation)
	- 10 / 3 = 3 (Truncation)
	- 16 % 3 = 1
	- 12 % 3 = 0
	- 11 % 3 = 2
- To calculate a quotient without truncation (decimal results), convert either the dividend or the divisor to a decimal
- For example:
	- 11 / 5.0 = 2.2 and likewise, 11.0 / 5 = 2.2

# Understanding Types and Conversion
- There are a few ways to force a formula to not truncate a value:
	- Move the fraction to the end so that Java will always use a double and an integer and will implicitly convert the answer to a double, not truncate
	- ![[Pasted image 20250529150227.png|450]]
	- Make one literal integers into a literal double so that Java will always use a double and an integer and will implicitly convert the answer to a double, not truncate
	- ![[Pasted image 20250529150334.png|450]]
## Implicit Type Conversions
- In the previous example, Java did implicit type conversion
- This happens whenever a smaller data type (int) is placed into a larger type (double)
- Java realizes that the types are different and converts to the larger size automatically for you
- However, Java will not convert from a larger (double) to a smaller (int) size automatically
## Using Type Casting
- Using the random method from the Math library, we can generate a random number from 1 to 10
- The random method generates a double between 0 and (not including) 1
- Values such as 0, 0.4567, or 0.901306 might be generated
![[Pasted image 20250529151341.png|400]]
- Multiplying these values by 10 and then truncating the extra would yield values 0, 4, or 9
- However, Java will not let this program compile in its current state
- Data is lost by going from a larger value (double) to a smaller value (int)
- Thus, type casting is required for this type conversion
## Type Casting Operator
- To cast a double value to an int, use (int) in front of the value
- To get the double result from our formula to go into the integer container, use the type casting operator (int) in front of the value
- Casting to the int data type will truncate the value
- Thus, casting the double literal 4.567 to an int will result in 4, and 9.01306 will result in 9
![[Pasted image 20250529151636.png|500]]
## Converting Data Types
- You can convert a data type (primitive or reference) to another data type by simply placing the name of the data type in parenthesis in front of the value or variable, as shown in the example below
![[Pasted image 20250529151746.png|600]]
### Converting String Data Types
- Note that casting will not work in all situations
- For example:
	- Casting a char to a String results in a compiler error
	- In situations such as this, you would need to resort to making the type conversion in another way
	- There are methods in the java.lang library to convert characters to strings

# Using Type Conversions
- Using type conversions is another option to fixing the truncation issue with the volume formula shown previously
- Use type casting to make one of the literal integers a double
![[Pasted image 20250529152023.png|550]]
## Understanding Types and Conversions
- When Java is converting from a smaller primitive type to a larger primitive type, the conversion is implicit
![[Pasted image 20250529152145.png|450]]
- However, when Java converts from a larger primitive type to a smaller primitive type, the conversion muse be explicit via type casting
- Java will not implicitly cast a larger type to a smaller type because of loss of precision
![[Pasted image 20250529152302.png|600]]

# Searching Through the Java API
- Examples and exercises in this course will require the use of the methods in the Java Math and String classes
	- A description of all Java methods can be found in the online Java API
- Understanding how to navigate this vast library of standard methods and classes will aid you in writing Java programs and reusing code blocks that have already been created by others
## Why Use the Java API?
- One major benefit to having access to the Java API is a common concept programmers call code reuse
- Rather than coding excess items, you may use the API to find how to access existing code that does exactly what you want
- This will reduce spending time on reproducing already existing code and making your programming much more efficient
---
# References
1. 