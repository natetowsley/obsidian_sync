---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - Python
Date Created:
---
---
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

---
# References
1. [[Variables]]
2. [[obsidian_sync/01 School/Reedley College/Courses/Fall 2024/CSCI-58/Functions|Functions]]