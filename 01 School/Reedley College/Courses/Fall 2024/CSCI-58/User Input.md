---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Python
Date Created:
---
---
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
    
- In python, user will be prompted next to prompt, not on a new line, as seen above
- Since all user input is interpreted as a string, type casting must be done to perform arithmetic expression
```Python
age = input("How old are you?: ") # ex: 20
age = age + 1 # Will result in error/ Attempting to add int to string
age = int(age)
age = age + 1 # Will result in the value of age being the int 21
```
- Type casting can also be don't while prompting user for input, assuming we know what variable type we desire
```Python
age = int(input("How old are you?: ") # ex: 20 (will now be an int, not string)
```
---
# References
1. [[Variables]]