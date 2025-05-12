---
Date Created: 2024-09-05T11:26
Favorite: false
tags:
  - Basics
  - Data-Structures-&-Algorithms
📕 Courses:
  - "[[!!Program in Python]]"
---
# Table of Contents
- [[#Table of Contents]]
- [[#Variables]]
    - [[#Swapping Variables]]
- [[#The print() Function]]
    - [[#print(f)]]
- [[#Typecasting]]
- [[#User Input]]
    - [[#The input() Function]]
- [[#Arithmetic & Math]]
    - [[#Arithmetic Operators]]
    - [[#Relational Operators]]
    - [[#Built in Math Functions]]
    - [[#Math Library]]
- [[#If Statements]]
- [[#Logical Operators]]
    - [[#Conditional Expressions]]
    - [[#Bitwise Operators]]
- [[#Strings]]
    - [[#String Methods]]
    - [[#F-Strings]]
    - [[#String Indexing]]
    - [[#String Formatting]]
    - [[#In Operator]]
    - [[#Character Escaping]]
    - [[#Basic String Operations]]
    - [[#Accessing the Individual Characters in a String]]
    - [[#String Concatenation]]
    - [[#Strings Are Immutable]]
    - [[#String Slicing]]
    - [[#Testing, Searching, and Manipulating Strings]]
    - [[#More String Methods]]
    - [[#The Repetition Operator]]
    - [[#Splitting a String]]
- [[#Format Specifiers (Flags)]]
- [[#While Loops]]
- [[#For Loops]]
    - [[#Range]]
    - [[#Break and Continue]]
        - [[#The interaction of i in while and for loops]]
- [[#Nested Loops]]
- [[#Collections]]
    - [[#Collection methods]]
    - [[#Lists [] ]]
        - [[#List Methods]]
        - [[#Nested Lists]]
        - [[#Concatenating]]
        - [[#Slicing]]
        - [[#in and not in Operators]]
        - [[#List Comprehension]]
    - [[#Sets {}]]
        - [[#Set Methods]]
    - [[#Tuples ()]]
    - [[#Dictionaries]]
        - [[#Dictionary Methods]]
- [[#2D Lists]]
- [[#Sorting Algorithms]]
    - [[#Bubble Sort]]
- [[#Functions]]
    - [[#Defining and Calling a Function]]
    - [[#Return]]
    - [[#Default Parameters]]
        - [[#*args and **kwargs]]
        - [[#Docstrings]]
        - [[#Various Function Calls]]
- [[#Scope]]
    - [[#Global Variables]]
- [[#Standard Library Functions and the import Statement]]
    - [[#Generating Random Numbers]]
    - [[#Random Number Seeds]]
    - [[#The math Module]]
    - [[#Storing Functions in Modules]]
    - [[#Conditionally Executing main Function in a Module]]
    - [[#Python Package Index (PyPI)]]
- [[#Procedural Programming]]
- [[#Object Oriented Programming]]
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
---

> [!important] Python Reference
> 
> > [!info] The Python Language Reference  
> > This reference manual describes the syntax and “core semantics” of the language.  
> > [https://docs.python.org/3/reference/index.html](https://docs.python.org/3/reference/index.html)  
  
# Variables
Variables are abstract storage locations paired with an associated symbolic name, which contains some known or unknown quantity of data or object referred to as a value.
- Variable names may only contain Latin letters, digits, and/or the underscore character
    - Cannot start with a digit
    - Cannot be a python keyword
- Variable types
    - int: integers(whole numbers)
        - 1, 0, -1
        - Can be used in arithmetic expression, unlike strings
    - float: decimal numbers
        - 5.5, 0.018, 3.14
    - string: words and phrases
        - “Hello World”
    - bool: True/False value represented by a 1 or a 0
        - Often used with logical operation (if, while, and, or)
## Swapping Variables
- When variable values need to be swapped, it is common practice to use a `temp` variable as to not lose a variable’s value in the process
```Python
x = 6
y = 0
temp = y \#temp = 0
y = x    \#y = 6
x = temp \#Now x = 0 and y = 6
```
- In python however, this can be done in a single line
```Python
x = 6
y = 0
x, y = y, x \#Will swap the values of these two variables
```
# The print() Function
`**print()**` can be used to print the desired message on a device’s screen. The Print is always in a string format. If the print message is in other objects, it is first converted into a string before being printed. You can input single or multiple objects of any type.
- Can print strings on their own
```Python
print("Hello, World)
# Will print "Hello, World" to the screen
```
- Can also print variables
```Python
userNum = 11
print(userNum)
# Will print "11" to the screen
# While variable is an integer, the string "11" is what is printed
```
- A blank print function (`print()`) will result in a blank line being outputted to the screen
- `“\n”` is used as a newline character, can be placed directly in a string to indicate a new line is to begin
```Python
print("The itsy bitsy spider\nclimbed up the waterspout.")
# Will print "The itsy bitsy spider
#            climbed up the waterspout."
```
- The `end` and `sep` parameters can be used for formatting the output of the `print()` function
    - `sep` parameter specifies the separator between the outputted arguments, e.g., `print("H", "E", "L", "L", "O", sep="-")`
    - `end` parameter specifies what to print at the end of the print statement
        - `print(x, end=””)` will print output values on same line, no space between
## print(f)
- **print(f)** can be used to format a variable within a string that is desired to be printed
```Python
firstName = "Guy"
age = 21
print(f"You're called {firstName} and you are {age} years old.")
# Will print "You're called Guy and you are 21 years old."
```
  
# Typecasting
Casting, also known as type conversion, is **a process that converts a variable's data type into another data type**. These conversions can be implicit (automatically interpreted) or explicit (using built-in functions).
- `str()`, `int()`, `float()`, `bool()`
- `print(type())` will print the class that your variable is
    - Helpful when debugging code using lots of variables and typecasting, as it can get confusing to follow
```Python
name = "Guy"      # string
age = 21          # int
gpa = 3.5         # float
is_student = True # bool
print(type(age))  # Will print <class 'int'> to screen
age = float(age)  # Will change value from 21 to 21.0
```
- Converting a string into a boolean will return True unless no string is present
    - Helpful for determining if user inputted anything when prompted
```Python
name = "Guy"
otherName = ""
name = bool(name)
otherName = bool(otherName)
print(name) # name will return True
print(otherName) # otherName will return False
```
  
# User Input
## The ==`input()`== Function
- `input(prompt)`
    
    - If the _prompt_ argument is present, it is written to standard output without a trailing newline. The function then reads a line from input, converts it to a string (stripping a trailing newline), and returns that. When EOF is read, `[EOFError](https://docs.python.org/3/library/exceptions.html#EOFError)` is raised.
    
    ```Python
    s = input('--> ')  
    --> Monty Python's Flying Circus
    s  
    "Monty Python's Flying Circus"
    ```
    
- In python, user wil be prompted next to prompt, not on a new line, as seen above
- Since all user input is interpreted as a string, type casting must be done to perform arithmetic expression
```Python
age = input("How old are you?: ") # ex: 20
age = age + 1 # Will result in error/ Attempting to add int to string
age = int(age)
age = age + 1 # Will result in the value of age being the int 21
```
- Type casting can also be dont while promting user for input, assuming we know what variable type we desire
```Python
age = int(input("How old are you?: ") # ex: 20 (will now be an int, not string)
```
  
# Arithmetic & Math
## Arithmetic Operators

| **Operator** | **Meaning**    | **Produces**          |
| ------------ | -------------- | --------------------- |
| +            | Addition       | Sum                   |
| -            | Subtraction    | Difference            |
| *            | Multiplication | Product               |
| /            | Division       | Quotient              |
| %            | Modulus        | Remainder of division |
| **           | Exponetial     | Power                 |
- When using arithmetic to incriment a variable, an equals sign after the operator will suffice
```Python
num = 1
num = num + 3 
num += 3      # Both will result in num = 4
```
## Relational Operators

| **Operator** | **Meaning**              |
| ------------ | ------------------------ |
| >            | Greater than             |
| <            | Less than                |
| >=           | Greater than or equal to |
| <=           | Less than or equal to    |
| ==           | Equal to                 |
| !=           | Not equal to             |
## Built in Math Functions

| **Function** | **Purpose**                                                      |
| ------------ | ---------------------------------------------------------------- |
| round(x, y)  | Takes float x and rounds it to y digits                          |
| abs(x)       | Returns the absolute value of x                                  |
| pow(x, y)    | An alternative exponential function, raising x to the power of y |
| max(x, y, z) | Returns the greatest value                                       |
| min(x, y, z) | Returns the lowest value                                         |
## Math Library
- Library of common math functions
- ==`import`== ==`math`== ==must be included prior to function usage==
    - All functions return float values
- Commonly used functions in math library

| Function        | Purpose                             |
| --------------- | ----------------------------------- |
| `math.pi`       | Value of pi                         |
| `math.e`        | Value of e                          |
| `math.sqrt(x)`  | Returns the square root of x        |
| `math.ceil(x)`  | Rounds a floating point number up   |
| `math.floor(x)` | Rounds a floating point number down |

> [!important] 🔢 Math Library
> 
> > [!info] math — Mathematical functions  
> > This module provides access to the mathematical functions defined by the C standard.  
> > [https://docs.python.org/3/library/math.html#module-math](https://docs.python.org/3/library/math.html#module-math)  
  
# If Statements
A condition statement used to check a condition, and then execute it if the condition holds true.
- Programming’s most basic form of decision making
```Python
age = int(input("Enter your age: "))
if age >= 18:
	print("You are now signed up!") # Will run only if user inputted age 18 or greater
elif age < 0: # Elif is keyword for "else if" (for a new condition to be checked)
	print("Enter a valid age")
else:
	print("You must be 18+ to sign up") # Will run if age is less than 18
```
- Indentation matters when using these statements, other languages may vary
- Some languages do not use `elif`, rather use `else if`
# Logical Operators
Logical operators are used to combine multiple conditions together and evaluate them as a single boolean expression.

| Operator       | Purpose                                   | Notes                                 |
|----------------|-------------------------------------------|----------------------------------------|
| `x or y`       | Returns `x` if `x` is truthy, else `y`    | _At least one condition must be true_ |
| `x and y`      | Returns `y` if `x` is truthy, else `x`    | _Both conditions must be true_        |
| `not x`        | Returns `false` if `x` is truthy, else `true` | _Inverts the condition_          |


The `or` operator:
```Python
temp = 25
is_raining = False
if temp > 95 or temp < 0 or is_raining: # if only one of these conditions is true, the if condition is ran
	print("The outdoor event is cancelled")
else:
	print("The outdoor event is still scheduled") # if all conditions are false, else is ran
```
The `and` operator:
```Python
temp = 25
is_sunny = True
if temp >= 85 and is_sunny:     # Both conditions must be true in order for print statements to execute
	print("It is HOT outside🥵")
	print("It is SUNNY☀️")
```
## Conditional Expressions
A one-line shortcut for the if-else statement (ternary operator). Print or assign one of two values based on a condition(X if condition else Y)
```Python
num = 5
print("Positive" if num > 0 else "Negative") # In both lines the condition is included in the expression
result = "EVEN" if num % 2 == 0 else "ODD"
print(result) # Console will print "Positive" "ODD"
```
## Bitwise Operators
Operators that allow you to manipulate single bits of data
- `&` (ampersand) - bitwise conjunction
    - requires exactly two 1s to provide 1 as the result
- `|` (bar) - bitwise disjunction
    - requires at least one 1 to provide 1 as the result
- `~` (tilde) - bitwise negation
- `^` (caret) - bitwise exclusive or (xor - exclusive or)
    - requires exactly one 1 to provide 1 as the result
# Strings

> [!important] 🧵str()
> 
> > [!info] Built-in Types  
> > The following sections describe the standard types that are built into the interpreter.  
> > [https://docs.python.org/3/library/stdtypes.html#str](https://docs.python.org/3/library/stdtypes.html#str)  
## String Methods
- The string class includes many different operations that can come in handy when dealing with strings
- Using print(help(str)) will print a list of string methods to the console

| Method                      | Purpose                                                                 |
|----------------------------|-------------------------------------------------------------------------|
| `len(string)`              | Returns the length of the string                                        |
| `string.find("x")`         | Returns the position of the **first** occurrence of "x"                 |
| `string.rfind("x")`        | Returns the position of the **last** occurrence of "x" (reverse find)   |
| `string.capitalize()`      | Capitalizes the first letter in the string                              |
| `string.upper()`           | Converts all alphabetical characters to uppercase                       |
| `string.lower()`           | Converts all alphabetical characters to lowercase                       |
| `string.isdigit()`         | Returns `True` if the string is composed only of digits                 |
| `string.isalpha()`         | Returns `True` if the string is composed only of letters                |
| `string.count("x")`        | Counts how many times "x" appears in the string                         |
| `string.replace("x", "y")` | Replaces all occurrences of "x" with "y"                                |
| `string.join(iterable)`    | Joins elements of `iterable` using the string as a separator            |

## F-Strings
- A formatted string literal, or an f-string, is a string literal that is prefixed ‘f’ or ‘F’
    - These strings may contain replacement fields, which are expressions delimited by curly braces `{}`
```Python
name = "Fred"
print(f"He said his name is {name}") # Prints "He said his name is Fred"
print(f"{name.lower()} is funny.") # Prints "fred is funny."
```
## String Indexing
- Accessing elements of a sequence using `[]` (indexing operator)
    
    - `[start : end : step]`
    - Starting position is inclusive, end is exclusive
    - If all characters until end of string are needed, a specified end is not needed
        - `[start:]`
    - Using negative indexes will begin the search from the end and work backwards
    - The `step` property will skip by x amount of indexes
    
    ```Python
    credit_number = "1234-5678-9012-3456"
    
    print(credit_number[3]) # Will print "4"
    
    print(credit_number[0:4] # Will print "1234" 4 exclusive doesn't use "-"
    
    print(credit_number[5]) # Will print "5678-9012-3456"
    
    print(credit_number[::2]) # Will print "13-6891-46"
    ```
    
    - To reverse a string, set `step` to -1
## String Formatting
- The `%` operator after a string is used to combine the string with variables
    - Will replace %s in a string with the string variable that comes after it
    - The %d special symbol is used as a placeholder for numeric or decimal values
```Python
name = "John"
# Note: %s is inside the string, % is after the string.
print("Hello, PyCharm! My name is %s!" % name) # Replaces %s with "John"
print("I'm %d years old" % 21) # Prints "I'm 21 years old"
```
## In Operator
- If you want to check whether a string contains a specific letter or a substring, you can use the `in` keyword
```Python
ice_cream = "ice cream"
print("cream" in ice_cream) # Prints True
```
## Character Escaping
- Backslash used to escape special symbols, such as quotation marks
```Python
print("It\'s me") # Prints "It's me"
```

| Type   | Purpose                  |
|--------|--------------------------|
| `\'`   | Single Quotation Mark    |
| `\"`   | Double Quotation Marks   |
| `\n`   | New Line                 |
| `\t`   | Tabulation               |
| `\\`   | Backslash                |

## Basic String Operations
- Many types of programs perform operations on strings
- In Python, many tools for examining and manipulating strings
    - Strings are sequences, so many of the tools that work sequences work with strings
## Accessing the Individual Characters in a String
- To access an individual character in a string
    
    - Use a `for` loop
        - Format: `for` _`character`_ `in` _`string`_:
        - Useful when need to iterate over the whole string, such as to count the occurrences of a specific character
    
    - Use indexing
        - Each character has an index specifying its position in the string, starting at 0
        - Format: _`character`_ `=` _`my_string`_`[`_`i`_`]`
![[image 1 35.png|image 1 35.png]]
- `IndexError` exeception will occur if:
    - You try to use an index that is out of range for the string
        - Likely to happen when loop iterates beyond the end of the string
    - `len(`_`string`_`)` function can be used to obtain the length of a string
        - Useful to prevent loops from iterating beyond the end of a string
## String Concatenation
- Concatenation: Appending one string to the end of another string
    - Use the + operator to produce a string that is a combination of its operands
    - The augmented assignment operator += can also be used to concatenate strings
        - The operand on the left side of the += operator must be an existing variable; oherwise, an exception is raised
## Strings Are Immutable
- Strings are immutable
    - Once they are created, they cannot be changed
        - Concatenation doesn’t actually change the existing string, but rather creates a new string and assigns the new string to the previously used variable
    - Cannot use an axpression of the form
    - `string[`_`index`_`] =` _`new_character`_
        - Statement of this type will raise an exception
## String Slicing
- Slice: Span of items taken from a sequence, known as _substring_
    - Slicing format: _`string`_`[`_`start`_ `:` _`end`_`]`
        - Expression will return a string containing a copy of the characters from _`start`_ up to, but not including, _`end`_
        - If _`start`_ not specified, `0` is used for start index
        - If _`end`_ not specified, `len(string)` is used for end index
    - Slicing expressions can include a step value and negative indexes relative to end of string
## Testing, Searching, and Manipulating Strings
- You can use the `in` operator to determine whether one string is contained in another string
    - General format: _`string1`_ `in` _`string2`_
        - _`string1`_ and _`string2`_ can be string literals or variables referencing strings
- Similarly you can use the `not in` operator to determine whether one string is not contained in another string
  
## More String Methods
- Strings in Python have many types of methods, divided into different types of operations
    - General format:
        - _`mystring.method(arguments)`_
- Some methods test a string for specific characteristics
    - Generally Boolean methods, that return `True` if a condition exists, and `False` otherwise
![[image 2 33.png|image 2 33.png]]
- Some methods return a copy of the string, to which modifications have been made
    - Simulate strings as mutable objects
- String comparisons are case-sensitive
    - Uppercase characters are distinguished from lowercase characters
    - `lower` and `upper` methods can be used for making case-insensitive string comparisons
![[image 3 32.png|image 3 32.png]]
- Programs commonly need to search for substrings
- Several methods to accomplish this:
    - `endswith(`_`substring`_`)` : checks if the string ends with _`substring`_
        - Returns `True` or `False`
    - `startswith(`_`substring`_`)` : checks if the string starts with _`substring`_
        - Returns `True` or `False`
    - `find(`_`substring`_`)`: searches for _`substring`_ within the string
        - Returns lowest index of the substring, or if the substring is not contained in the string, returns -1
    - `replace(`_`substring, new_string`_`)`:
        - Returns a copy of the string where every occurrence of _`substring`_ is replaced with _`new_string`_
![[image 4 30.png|image 4 30.png]]
  
## The Repetition Operator
- **Repitition operator:** makes multiple copies of a string and joins them together
    - The * symbol is a reprtition operator when applied to a string and an integer
        - String is left operand; number is right
    - General format: _`string_to_copy * n`_
    - Variable reference a new string which contains multiple copies of the original string
  
## Splitting a String
- `split` method: returns a list containing the words in the string
    - By default, uses space as separator
    - Can specify a different separator by passing it as an argument to the `split` method
# Format Specifiers (Flags)
`{value:flags}` format a value based on what flags are inserted
- A way to control the behavior of user segments in you application

| Flag            | Purpose                                         |
|-----------------|-------------------------------------------------|
| `:.<number>f`    | Round to that many decimal places (fixed point)|
| `:<number>`      | Allocate that many spaces                      |
| `:0<number>`     | Allocate and zero-pad that many spaces         |
| `:<`             | Left justify (align left)                      |
| `:>`             | Right justify (align right)                    |
| `:^`             | Center align                                   |
| `:+`             | Use a plus sign to indicate positive values    |
| `:=`             | Place sign in leftmost position                |
| `: `             | Insert a space before positive numbers         |
| `:,`             | Use comma as a thousands separator             |

```Python
	price1 = 3.14159
	price2 = -987.65
	price3 = 12.34
	
	print(f"Price 1 is ${price1:.3f}") \#Will print "Price 1 is $3.141"
	print(f"Price 2 is ${price1:.3f}") \#Will print "Price 1 is $-987.650"
	#^Notice zeros are concatinated when desired digits exceed numbers
	
	print(f"Price 1 is ${price1:10}") \#Will print "Price 1 is $   3.14159"
	                                      \#Uses 10 total spaces^        ^
	                                      
	print(f"Price 1 is ${price1:<10}") \#Will print "Price 1 is $3.14159   "
	                \#Aligns value to left side of desired spaces^        ^
```
  
# While Loops
Will execute some code WHILE some condition remains true
- Best used to keep user in infinite loop ==**until some condition is met**==
- Can be used in combination with logical operators
- General Format:
```Python
while conditional_expression:
	instruction1
	instruction2
	.
	.
	instruction_n
```
- Example
```Python
age = input("Enter your age: ")
while age < 0:
	print("Age can't be negative.")  \#Until user inputs a number > 0 they will be reprompted to enter age
	age = input("Enter your age: ")
	
print(f"You are {age} years old.")
```
- While not
    - The keyword `while not` is also a valid way of using while loops
```Python
age = input("Enter your age: ")
while not age >= 0:
	print("Age can't be negative.")  \#This code works the same as the example above, but uses while not
	age = input("Enter your age: ")
	
print(f"You are {age} years old.")
```
- Infinite loop
    - Loop that will continue forever
    - To get out of indinite loop in python console window use _Ctrl-C_
```Python
while True:
	print("I'm stuck inside a loop.") \#Will repeatedly print forever
```
- Infinite loop can be used alongside `if/else` statements where else involves `break`
    - `break` will cause the infinite while loop to be broken out of
```Python
while True:
	age = int(input("Enter your age: ")   \#User will be prompted infinitely until a valid input is entered
	if age <= 0:
		print("Age cannot be less than or equal to zero")
	else:
		break
print(f"You are {age} years old") \#Will only be executed after break command has run
```
# For Loops
Will execute a block of code a ==**fixed number of times**==
- Can be used to iterate over a range, string, sequence, etc.
## Range
- `range(start, stop[,step])`
    - `range(10)` will start at 0 and end at 9
    - `range(1, 11)` will start at 1 and end at 10
    - `range(0, 30, 5)` will start at 0, and count up by 5s until before 30 (0, 5, 10, 15, 20, 25)
    - When using a range, the beginning of the range is inclusive, while the end of the range is exclusive
```Python
for x in range(1, 11):
	print(x)             \#Will print "1, 2, 3, 4... 10" each on their own line
	
for x in reversed(range(1, 11): \#Will do the same counting down from the end of the range
	print(x)                      \#Range must be inside reversed function to do so
```
## Break and Continue
- `continue` behaves as if the program has suddenly reached the end of the body; the next turn is started and the condition expression is tested immediately
```Python
for x in range(1, 21):
	if x == 13:
		continue
	else:
		print(x) # Will print 1, 2, 3, 4... 20, 21 BUT WILL SKIP 13
```
- `break`  exits the loop immediately, and unconditionally ends the loop's operation; the program begins to execute the nearest instruction after the loop's body
```Python
for x in range(1, 21):
	if x == 13:
		break
	else:
		print(x) # Will print 1, 2, 3... 11, 12 AND WILL END (or break) BEFORE 13
```
  
### The interaction of `i` in while and for loops
- In a while loop, `i` must be defined before the loop, and will retain its value when being used in the loop
```Python
i = 5
while i < 5:
	print(i)
	i += 1
else:
	print("else:", i)  # Will immediately print "else: 5" as it is not less than 5
```
- However, in a for loop `i` , even if defined before the loop, will be redefined for the loop itself, and will retain said value at the end of the loop
```Python
i = 111
for i in range(5):  # i is redefined to be 0, and then incrimented by one as the loop iterates
    print(i)
else:
    print("else:", i)
print(i) # i will maintain its last value (4) and print here "4"
```
  
# Nested Loops
A loop within another loop (outer, inner)
- Can come in a variety of ways
```Python
while x > 0: # WHILE loop inside a WHILE loop
	while y > 0:
		print("do something")
		
for x in range(3):  \#FOR loop inside a FOR loop
	for y in range(9):
		print("do something")
		
while x > 0:   # FOR loop inside a WHILE loop
	for x in range(9):
		print("do something")
		
for x in range(3):   # WHILE loop inside a FOR loop
	while x > 0:
		print("do something")
```
- The contents in the inner loop executes before the outer loop can reiterate
- When using nested loops, make sure your counters are different names (x and y)
```Python
for x in range(3):   
	for y in range(1, 10):
		print(x, end="")
	print()            # Will print 123456789 3 times on 3 different lines
```
  
# Collections

> [!important] 🫂Collections reference
> 
> > [!info] collections — Container datatypes  
> > Source code: Lib/collections/__init__.  
> > [https://docs.python.org/3/library/collections.html](https://docs.python.org/3/library/collections.html)  
A single “variable” used to store multiple values
- Each value inside a collection is known as an element
- Also known as sequence types
- It is best practice to make variable name plural when declaring a collection
```Python
fruits = ["apple", "orange", "banana", "coconut"]  # List made
print(fruits[2])  # Will print "banana"
print(fruits[0: 3]) # Will print "['apple', 'orange', 'banana']"
```
- For loops can be used with collections
    - Is common practice to use non-plural of collection name as counter name
```Python
fruits = ["apple", "orange", "banana", "coconut"]
for fruit in fruits:
	print(fruit, end=" ")  # Will print "apple orange banana coconut"
```
### Collection methods
- `print(dir(collectionName))` will print all methods that can be used by your collection
    - Works for lists, sets, and tuples
    - `print(help(collectionName))` prints a description of all available methods
|   |   |
|---|---|
|_**Method**_|_**Purpose**_|
|len(collection)|Returns the length of a collection|
|(“x” in collection)|Returns True if x is in collection, False if not|
## Lists `[]`
- Ordered and changeable. Duplicates OK
- Elements in a list must be seperated by comma and all enclosed with square brackets `[]`
- To access an element at specific value of list, use index operator with index of desired element
    - First value is at index 0
    - `[start: end: step]`
- Values in lists can be reassigned using index operator as well
- Items in list do not have to be same type but most commonly are
```Python
fruits = ["apple", "orange", "banana", "coconut"]
fruits[0] = "pineapple" # Replaces "apple" with "pineapple"
print(fruits[0])   # Will print "pineapple"
```
### List Methods

| _**Method**_            | _**Purpose**_                                  |
| ----------------------- | ---------------------------------------------- |
| list.append(”value”)    | Appends value to the end of the list           |
| list.remove(”value”)    | Removes value from the list                    |
| list.insert(x, “value”) | Inserts value at index x in list               |
| list.sort()             | Will sort a list in alphabetical order         |
| list.reverse()          | Reverses order of a list based on order placed |
| list.clear()            | Clears a list entirely                         |
| list.index(”value”)     | Returns the index of value                     |
| list.count(”value”)     | Counts how many times value appears in list    |
### Nested Lists
- A list can contain other lists
    - Can be used to arrange data into hierarchical structures
- Items in a nested list must use two indexes to access items of the sublist
```Python
nested_list = [[1, 2, 3], [4, 5], 6]
print(nested_list[0][2]) # prints 3
```
_**IMPORTANT**_
- The name of an ordinary variable is the **name of its content**
- The name of a list is the name of a **memory location where the list is stored**
```Python
list_1 = [1]
list_2 = list_1
list_1[0] = 2
print(list_2)
```
- The assignment: `list_2 = list_1` copies the name of the array, not its contents. In effect, the two names (list_1 and list_2) identify the same location in the computer memory. Modifying one of them affects the other, and vice versa.
### Concatenating
- Concatenate: join two things together
- The `+` operator can be used to concatenate two lists
    - Cannot concatenate a list with another data type, such as a number
- The `+=` augmented assignment operator can also be used to concatenate lists
### **Slicing**
- Slice: A span of items taken from a sequence
- `mylist[start:end]` can be used to get around this and create a new list
    - start index included in list
    - end index not included in list
```Python
my_list = [10, 8, 6, 4, 2]
new_list = my_list[1:3]
print(new_list) # Will print [8, 6]
```
- `my_list[:3]` is a more compact way to code `my_list[0:3]`
- Similarly, if you omit the `end` in your slice, it is assumed that you want the slice to end at the element with the index `len(my_list)`
    - `my_list[2:]`
- Omitting both `start` and `end` makes a **copy of the whole list**
    - `my_list[:]`
### `in` and `not in` Operators
- returns a boolean value after checking if a value is stored inside a list or not
```Python
my_list = [0, 3, 12, 8, 2]
print(5 in my_list)     # prints "False"
print(5 not in my_list) # prints "True"
print(12 in my_list)    # prints "True"
```
### List Comprehension
- List comprehension offers a more compact syntax when you want to create a new list based on the values of an existing list or another iterable (tuple, string, array, range, etc.)
    - Typically, list comprehensions are written in a single line of code
```Python
my_list = []
for i in range(5):
	my_list.append(i)
	
print(my_list) # This works but is very bulky
```
```Python
my_list = [i for i in range (5)] # List comprehension
print(my_list) 
```
- List comprehension can also be nested
```Python
string = '0123456789'
matrix = [[string[j] for j in range(10)] for i in range(10)]
for row in matrix:
    print(row) # prints ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
                      # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
	   				  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
```
## Sets `{}`
- Unordered and immutable (cannot alter values), but Add/Remove OK. NO duplicates
- Unable to use indexing on sets as they are unordered
- Work well when working with constants
### Set Methods

| _**Method**_        | _**Purpose**_                                   |
| ------------------- | ----------------------------------------------- |
| set.add(”value”)    | Will add value to set                           |
| set.remove(”value”) | Will remove value from set                      |
| set.pop()           | Removes and returns a random element from a set |
| set.clear()         | Will completely clear a set                     |
## Tuples `()`
- Ordered and unchangeable. Duplicates OK. FASTER
- Only methods are `tuple.index(”value”)` and `tuple.count(”value”)`
- It is also possible to create a tuple just from a set of values separated by commas
```Python
tuple_1 = (1, 2, 3, 4)
tuple_2 = 1., .5, .25, .125
empty_tuple = ()
one_element_tuple = 1.,
```
- A special situation is the construction of tuples containing 0 or 1 items
    - Empty tuples are constructed by an empty pair of parentheses
    - A tuple with one item is constructed by followin a value with a comma
```Python
empty_tuple = ()
one_item_tuple = ('item',)
```
  
## Dictionaries
A collection of {key: value} pairs
- Ordered and changeable. NO DUPLICATES
- Not a sequence type, but can be easily adapted to sequence processing
- Contents can be changed
### Dictionary Methods

| _**Method**_             | _**Purpose**_                                              |
| ------------------------ | ---------------------------------------------------------- |
| dic.get(key)             | Gets the value from the key “key”                          |
| dic.update({Key: Value}) | Adds a key value pair to the end of the dictionary         |
| dic.pop(Key)             | Will remove a key value pair from the dictionary           |
| dic.popitem()            | Will remove the latest key value pair from the dictionary  |
| dic.clear                | Will clear the dicitonary                                  |
| dic.keys()               | Returns the keys of a dictionary                           |
| dic.values()             | Returns the values of a dictionary                         |
| dic.items()              | Returns a dictionary object resembling a 2d list of tuples |
```Python
# Dictionary example
tel = {'jack': 4098, 'sape': 4139}
tel['guido'] = 4127
tel # {'jack': 4098, 'sape': 4139, 'guido': 4127}
print(tel['jack']) # prints "4098"
del tel['sape']
tel['irv'] = 4127
tel # {'jack': 4098, 'guido': 4127, 'irv': 4127}
list(tel) # ['jack', 'guido', 'irv']
sorted(tel) # ['guido', 'irv', 'jack']
'guido' in tel # True
'jack' not in tel # False
```
# 2D Lists
- Two-dimensional list: a list that contains other lists as its elements
    
    - Also known as a nested list
    - Common to think of two-dimensional lists as having rows and columns
    
    ![[image 5 30.png|image 5 30.png]]
    
    - Useful for working with multiple sets of data
- Tot process data in a two-dimensional list, list need to use two indexes
    
    - `list[0][1]`
    
    ![[image 6 27.png|image 6 27.png]]
    
# Sorting Algorithms
An algorithm that puts elements of a list into an order
## Bubble Sort
- Very simple/ easy to understand
- Not very fast or efficient compared to others
- Works by repeatedly swapping the adjacent elements if they are in the wrong order
- While loop bubble sort:
```Python
my_list = [8, 10, 6, 2, 4]  # list to sort
swapped = True  # Set to true in order to enter while loop
while swapped:
    swapped = False  # no swaps so far
    for i in range(len(my_list) - 1):
        if my_list[i] > my_list[i + 1]:
            swapped = True  # a swap occurred!
            my_list[i], my_list[i + 1] = my_list[i + 1], my_list[i]
print(my_list)
```
[![](https://www.computersciencebytes.com/wp-content/uploads/2016/10/bubble_sort.png)](https://www.computersciencebytes.com/wp-content/uploads/2016/10/bubble_sort.png)
- Python contains the `sort()` method that can be used to sort a list as fast as possible
```Python
my_list = [8, 10, 6, 2, 4]
my_list.sort()
print(my_list) # Will print [2, 4, 6, 8, 10]
```
  
# Functions
Function: A group of statements within a program that perform a specific task
- Usually on task of a large program
- Modularized program: Program wherein each task within the program is in its own function
- Often to prevent coding the same blocks of code over and over
- Void functions
    - Simply executes the statements it contains and then terminates
- Value returning function
    - Executes the statements it contains, and then it returns a value back to the statement that called it
## Defining and Calling a Function
- Functions are given names
    - Cannot use keywords as a function name
    - Cannot contain spaces
    - First character must be a letter or underscore
    - All other characters must be a letter, number or underscore
    - Uppercase and lowercase characters are distinct
- Function name should be descriptive of the task carried out by the function
    - Often includes a verb
- Function definition: specifies what function does
- When defining a function `def` must come before the name of the function, followed by parenthesis and a colon
    - code that belongs in the function should be indented following the name of the function
```Python
def function_name():
	statement
	statement
```
- Data can be passed through to functions using **parameters** and **arguments**
    - Parameters: variables that are defined in a function's definition and receive values passed to the function as arguments
    - Arguments: the values that are passed to a function when it is called
```Python
def function_name(name, age): \#name and age are parameters
	print (f"{name} is {age} years old.")
function_name("Nate", 21) #"Nate" and 21 are arguments
```
## Return
Statement used to end a function and send a result back to the caller
```Python
def add(x, y):
	z = x + y
	return z
	
print(add(5, 10)) \#Will print 15, as z = 15 and z is what is returned
```
## Default Parameters
- A default value for a certain parameter to be used when no argument is given for said parameter
    - If an argument is given, it takes priority and is used in function
- Makes functions more flexible, causes less errors
```Python
\#NO DEFAULT ARGUMENTS
def NetPrice(list_price, discount, tax):
	return list_price * (1 - discount) * (1 + tax)
	
print(NetPrice(500)) \#Will result in error as arguments for discount and tax are mandatory
```
```Python
\#WITH DEFAULT ARGUMENTS
def NetPrice(list_price, discount = 0, tax = 0.05):
	return list_price * (1 - discount) * (1 + tax)
	
print(NetPrice(500)) \#Function will run with default parameters
										 \#Prints 525.0
```
- Non-default arguments should follow default arguments
    - `def count(start = 0, end)` causes an error if `count(10)`
    - `def count(end, start = 0)` works with `count(10)`
### *args and **kwargs
- ***args:** Allow you to pass multiple non-key arguments to a function
    - Places arguments into a tuple that can be used within function
- ****kwargs:** allows you to pass multiple keywork-arguments
    - 4:34 bro code……….
- The ‘*’ is the unpacking operator
### Docstrings
- Docstrings are documentation generally written for module, class, and method definitions
- One-line docstrings are for really obvious cases
- Multi-line docstrings consist of a summary line just like one-line docstrings, followed by a blank line, followed by a more elaborate description
- A docstring for a function or method should summarize its behavior and document its arguments, return value(s), side effects, exceptions raised, and restrictions on when it can be called (all if applicable)
```Python
def increment_list(mylist):
    """This function adds 1 to each element of the list.""" # <---DOCSTRING
    for i in range(len(mylist)):
        mylist[i] += 1
    return mylist

print(increment_list.__doc__)
print(increment_list([1, 2, 3]))
```
### Various Function Calls
- Functions can be caled in various ways
- Consider the following code:
```Python
def cat(food, state='still hungry', action='meow', breed='Siamese'):
    print(f"-- This cat wouldn't {action}", end=' ')
    print(f"if you gave it {food}")
    print(f"-- Lovely fur, the {breed}")
    print(f"-- It's {state}!")

cat(???)
```
- cat() can be called with:
    - 1 positional argument
        - `cat('chicken')`
    - 1 keyword argument
        - `cat(food='chicken')`
    - 2 keyword arguments
        - `cat(food='fish', action='bite')`
        - `cat(action='bite', food='fish')`
    - 3 positional arguments
        - `cat('beef', 'happy', 'hiss')`
    - 1 positional, 1 keyword
        - `cat('a hug', state='purrring')`
# Scope
Scope is the area of the code in which a variable is accessible
- Variables created inside of a function have a scope of said function
    - Are not recognized outside of the function
```Python
def function():
	x = 1
	
	
function()
print(x)   \#Will result in an error
```
- Variables declared before function call can be used in a function
```Python
def my_function():
    print("Do I know that variable?", var)

var = 1
my_function() \#Will print "Do I know that variable? 1
print(var) \#Will print 1
```
- Changing the parameter's value doesn't propagate outside the function
```Python
def my_function(n):
    print("I got", n)
    n += 1
    print("I have", n)

var = 1
my_function(var)
print(var)       \#Var still = 1
```
## Global Variables
- Variable that ignore scope and are accessible at all parts of the code are global
    - Declared using keyword `global` before variable name
  
# Standard Library Functions and the `import` Statement
- **Modules:** files that store functions of the standard library
    - Help organize library functions not built into the interpreter
    - Copied to computer when you install Python
- To call a function stored in a module, need to write an `import` statement
    - Written at the top of the program
    - Format: `import module_name`
- Can import specific function using `from`
    - `from math import pi`
- `dir(module)` can be used to display all entities in a module
    - `dir(math)`
## Generating Random Numbers
- Random numbers are useful in a lot of programming tasks
- `**random**` **module:** includes library functions for working with random numbers
- **Dot notation:** notation for calling a function belonging to a module
    - Format: `module_name.function_name()`
- `**randint**` **function**: generates a random number in the range provided by the arguments
    
    - Returns the random number to part of the program that called the function
    - Returned integer can be used anywhere that an integer would be used
    - You can experiment with the function in interactive mode
    
    ![[image 7 24.png|image 7 24.png]]
    
- `**randrange**` **function:** similar to `range` function, but returns randomly selected integer from the resulting sequence
    - Same arguments as for the `range` function
- `**random**` **function:** returns a random float in the range of 0.0 and 1.0
    - Does not receive arguments
- `**uniform**` **function:** returns a random float but allows user to specify range
## Random Number Seeds
- Random number created by functions in random module are actually pseudo-random numbers
- Seed value: initializes the formula that generates random numbers
    - Need to use different seeds in order to get different series of random numbers
        - By default uses system time for seed
        - Can use `random.seed()` function to specify desired seed value
## The `math` Module
- `**math**` **module:** part of standard library that contains functions that are useful for performing mathematical calculations
    - Typically accept one or more values as arguments, perform mathematical operation, and return the result
    - Use of module requires an `import math` statement
![[image 8 22.png|image 8 22.png]]
- The `math` module defines variables `pi` and `e`, which are assigned the mathematical values for pi and e
    - Can be used in equations that require these values, to get more accurate results
- Variables must also be called using the dot notation
    - Example: `circle_area = math.pi * radius**2`
## Storing Functions in Modules
- In large, complex programs, it is important to keep code organized
- **Modularization:** grouping related function in modules
    - Makes program easier to understand, test, and maintain
    - Make it easier to reuse code for multiple different programs
        - Import the module containing the required function to each program that needs it
- Module is a file that contains Python code
    - Contains function definition but does not contain calls to the functions
        - Importing programs will call the functions
- Rules for module names
    - File name should end in .py
    - Cannot be the same as a Python keyword
- Import module using the `import` statement
## Conditionally Executing main Function in a Module
- Importing module results in executing its statements
```Python
import math
def area(radius):
	return math.pi * radius**2
	
def circumference(radius):
	return 2 * math.pi * radius
```
- Modules are not typically standalone programs
- Module can be standalone program or imported into other programs
- **__name**__ variable
    - set to the name of module when file imported as a module
    - set to ‘__main__’ when used as a standalone program
## Python Package Index (PyPI)
- Large collection of third-party modules
- Package: collection of related modules
- pip utility
    - Part of the standard Python installation
    - Accessed via pip utility in Windows command prompt
        - pip install _package_name_
    - Accessed via pip3 in Mac or Linux
        - sudo pip3 install _package_name_
- Thonny
    - Tools → manage packages
    - Search for a package (e.g. ‘camelcase’)
    - Click “Search on PyPI”
    - Select link and install
    - Close
- import camelcase
- to uninstall: Manage packages, uninstall
# Procedural Programming
- Procedural Programming: Writing programs made of functions tht perform specific tasks
    - Procedures typically operate on data items that are separate from the procedures
    - Data items commonly passed from one procedure to another
    - Focus: To create procedures that operate on the program’s data
# Object Oriented Programming
- Object-Oriented programming: focusessd on creating objects
- Object: entity that contains data and procedures
    - Data is known as data attributes and procedures are known as methods
        - Methods perform operations on the data attributes
- Encapsulation: combining data and code into a single object
    
    ![[image 9 21.png|image 9 21.png]]
    
- Data hiding: Object’s data attributes are hidden from code outside the object
    - Access restricted to the object’s methods
        - Protects from accidental corruption
        - Outside code does not need to know internal structure of the object
- Object reusability: The same object can be used in defferent programs
    - Example: 3D image object can be used for architecture and game progrmming
![[image 10 20.png|image 10 20.png]]