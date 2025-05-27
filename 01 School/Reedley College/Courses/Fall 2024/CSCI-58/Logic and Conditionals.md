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
## Conditional Expressions
A one-line shortcut for the if-else statement (ternary operator). Print or assign one of two values based on a condition(X if condition else Y)
```Python
num = 5
print("Positive" if num > 0 else "Negative") # In both lines the condition is included in the expression
result = "EVEN" if num % 2 == 0 else "ODD"
print(result) # Console will print "Positive" "ODD"
```
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
## Bitwise Operators
Operators that allow you to manipulate single bits of data
- `&` (ampersand) - bitwise conjunction
    - requires exactly two 1s to provide 1 as the result
- `|` (bar) - bitwise disjunction
    - requires at least one 1 to provide 1 as the result
- `~` (tilde) - bitwise negation
- `^` (caret) - bitwise exclusive or (xor - exclusive or)
    - requires exactly one 1 to provide 1 as the result
---
# References
1. 