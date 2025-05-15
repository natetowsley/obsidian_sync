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
  
---
# References
1. [[Logic and Conditionals]]
2. [[Variables]]