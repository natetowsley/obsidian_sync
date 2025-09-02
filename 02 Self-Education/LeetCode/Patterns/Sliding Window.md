---
tags:
  - ComputerScience
  - ComputerScience/LeetCode
Date Created: 2025-09-02
---
```table-of-contents
```
---
# What is the Sliding Window?
- Used when you need to process a series of data elements
	- List or String
- You find specific things in a list by looking at a smaller part of the list at a time
	- This smaller portion of the list is known as the **"Window"**
- This window slides one step at a time until the entire list is scanned
![[Pasted image 20250902135805.png|450]]
## When Do We Use the Sliding Window?
- If a problem asks you to find a subset of elements that satisfies a given condition
- Input could be:
	- Linear Data Structure
		- Array
		- String
		- Linked List
## Types of Sliding Windows
### Fixed Sliding Window
- Maintains a constant length as is slides across the data structure
- Commonly used if required window size is known
- Often used to find substrings of a fixed length
#### General Fixed Sliding Window Pseudocode
```python
initialize window_sum = 0
initialize max_result # (or other required value)

# Set up the initial window
for i from 0 to k-1:
	window_sum += arr[i]
	
max_result = window_sum # Initialize result

# Slide the window across the array
for i from k to arr.length - 1:
	window_sum += arr[i] - arr[i - k] # Add new element, remove old element
	update max_result # (or other computation)
	
return max_result # (or other required value)
```

>[Fixed Sliding Window Easy Problem](https://leetcode.com/problems/maximum-average-subarray-i/description/)
### Dynamic Sliding Window
-  Expands in length based on conditions
- Commonly applied to problems where the window size is not fixed
- Used often to find the longest or shortest subarray/substring that satisfies a condition
#### General Dynamic Sliding Window Pseudocode
```python
initialize left = 0
initialize window_state # (sum, count, frequency map, etc.)
initialize min_or_max_result

for right from 0 to arr.length - 1:
	update window_state to include arr[right] # Expand the window
	
while window_state violates the condition:
	update min_or_max_result # (if needed)
	update window_state to exclude arr[left] # Shrink the window
	move left pointer forward
	
return min_or_max_result
```

>[Dynamic Sliding Window Easy Problem](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
# [CONTINUE AT 4:04](https://www.youtube.com/watch?v=y2d0VHdvfdc)
---
# References
1. 