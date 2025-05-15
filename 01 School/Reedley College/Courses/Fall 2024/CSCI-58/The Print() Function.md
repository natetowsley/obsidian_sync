---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - Python
  - ComputerScience/Basics
Date Created:
---
---
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

---
# References
1. 