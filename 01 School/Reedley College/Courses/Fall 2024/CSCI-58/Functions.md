---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Basics
  - ComputerScience/Python
Date Created:
---
---
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
- Functions can be called in various ways
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
---
# References
1. 