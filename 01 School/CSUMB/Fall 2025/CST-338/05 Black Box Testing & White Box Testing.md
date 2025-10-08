---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
Date Created:
---
```table-of-contents
```
---
# Test Case Design
- During the test plan step, you must design a set of test cases
- Two approaches
	- Functional (Black Box Testing)
	- Structural (White Box Testing)
- These strategies work well together
## Testing is Like Detective Work
- The tester must try to understand how programmers and designers think, to better find defects
- The tester must not leave anything uncovered and must be **suspicious of everything**

# Black Box Testing
- The tester treats software to be tested as a black box
	- Internal structure of code is not used for test case design
	- In other words, test cases are determined solely from design specifications
- Testers provide the system with inputs and observe the outputs
- Testers can not see:
	- Source code
	- Internal data
	- Any of the design documentation describing the system's internals
## Equivalence Class Partitioning (ECP)
- A specific flavor of Black Box Testing
- Divide possible inputs into groups of valid and invalid inputs
	- Such groups are called *equivalence classes*
	- Run one test case per equivalence class
- The tester must:
	- Understand the required input
	- Appreciate how the software may have been designed
## Boundary Value Analysis
- Programs often fail on special values
- These values often lie on boundary of equivalence classes
- A boundary value test case is a set of data that lies on the edge of an equivalence class of input and output
	- Boundary values are an extremely rich source of errors
![[Pasted image 20251007102855.png]]

## Intuition and Experience
- Examples:
	- Empty input
	- Blank or null characters
	- Repeated instances
	- Negative numbers
	- Non-numeric values in numeric fields or vice versa
	- Too big or too small values

# White Box Testing
- Also called "structural testing" or "glass-box testing"
- Testers can
	- Examine design documents
	- View source code
	- Observe at run time the steps taken by algorithms and their internal data
- White box testing focuses on implementation
- Various criteria exist for test case design
	- Control flow: all possible paths through code
	- Statement coverage: every statement tested
		- Each statement should be executed at least once during testing
	- Edge coverage: all branches of code
		- Each edge should be traversed at least once during testing
![[Pasted image 20251007103253.png|400]]

---
# References
1. 