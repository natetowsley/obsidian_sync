---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Basics
  - Python
Date Created:
---
---
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
---
# References
1.  