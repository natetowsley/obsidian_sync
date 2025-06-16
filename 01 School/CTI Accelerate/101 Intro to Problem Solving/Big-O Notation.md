---
tags:
  - CTI
  - ComputerScience
  - ComputerScience/DataStructuresAndAlgorithms
Date Created: 2025-06-16
---
```table-of-contents
```
---
# What is it?
- Simplified analysis of algorithm's efficiency
	1. Complexity in terms of input size, N
	2. Machine-independent
	3. Basic computer steps
	4. Time & Space
# Types of Measurement
- Worst-case
	- Most commonly looked at
- Best-case
- Average-case

# General Rules
1. Ignore constants
	- 5n -> O(n)
2. Certain terms "dominate" others
	- i.e. ignore low-order terms
$$O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(2^n) < O(n!)$$
![[Pasted image 20250616154524.png|600]]
## Constant Time
- Independent of input size, N
- O(1)
```python
x = 5 + (15 * 20);
```

# Linear Time
- Very simply dependent of input size, N
- O(N)
- Consider the following code
```python
for x in range (0, n):
	print x; # O(1)
```
$$N * O(1) = O(N)$$
# Quadratic Time
- Nested loop
- $O(N^2)$
```python
for x in range (0, n):
	for y in range (0, n):
		print x * y; # O(1)
```
---
# References
1. [[!!Programming Concepts and Methodology II (C++)]]