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
- When using arithmetic to increment a variable, an equals sign after the operator will suffice
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

---
# References
1. 