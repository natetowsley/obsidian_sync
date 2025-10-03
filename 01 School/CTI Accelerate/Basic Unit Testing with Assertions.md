---
tags:
  - ComputerScience
  - ComputerScience/Design
Date Created:
---
```table-of-contents
```
---
# Unit Testing
- A systematic way of testing and verifying code as you develop it
- There are two halves to the term "Unit Testing"
## "Unit"
- Code is organized in a way that code segments can be run in isolation
- Functions are the cornerstone of unit testing
	- They naturally segment code with clear input and output
```python
def test_me(test, my_answers):
	score = 0
	for question in range(test):
		score += 1 if test[question] == my_answers[question] else 0
	return score
```
## "Testing"
- Code is written to test these segments of code
- Once a test is written, you can run it whenever you make changes to the code to verify that the code segment still works
```python
assert test_me([1, 2, 3], [1, 2, 3]) == 3 # This statement evalueates to True
assert test_me([1, 2, 3], [4, 5, 6]) == 3 # This evaluates to False, and then stops the program
```

# Assert Keyword
- In Python, we can use the `assert` keyword to implement basic tests to verify that our code works
- The `assert` keyword checks if a given statement or series of statements is True or False
	- If True, the program continues as normal
	- If False, the program stops and outputs an error
- The `assert` keyword determines if a test passes or fails
```python
def right_triangle_area(b, h):
	return b * h * 0.5
	
# It's a common practice to set up functions for each test (We'll see why in a little bit)
def simple_triangle():
	assert right_triangle_area(3, 4) == 6.0 # PASS
	
def null_triangle():
	assert right_triangle_area(0, 0) == 0.0 # PASS

def incorrect_triangle():
	assert right_triangle_area(-1, -1) == 0.0 # FAIL
	
# Run each of the tests
simple_triangle()
null_triangle()
incorrect_triangle()
```
- As the name implies, assert statements ensure that a given value meets the assertion criteria
- In general, you should only write assertions that will be True
	- Remember that the goal is to catch errors during development, not after the code or project has been publicly released
- When moving a Python project from development use (used by the development team) to production use (used by the public), assert statements are often disabled
	- You wouldn't want to run unit tests in a deployed project
	- You should not use assert statements to build program logic
---
# References
1. 