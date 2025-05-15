---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/DataStructuresAndAlgorithms
  - Python
Date Created:
---
---
# Sorting Algorithms
An algorithm that puts elements of a list into an order
## Bubble Sort
- Very simple/ easy to understand
- Not very fast or efficient compared to others
- Works by repeatedly swapping the adjacent elements if they are in the wrong order
- While loop bubble sort:
```Python
my_list = [8, 10, 6, 2, 4]  # list to sort
swapped = True  # Set to true in order to enter while loop
while swapped:
    swapped = False  # no swaps so far
    for i in range(len(my_list) - 1):
        if my_list[i] > my_list[i + 1]:
            swapped = True  # a swap occurred!
            my_list[i], my_list[i + 1] = my_list[i + 1], my_list[i]
print(my_list)
```
[![](https://www.computersciencebytes.com/wp-content/uploads/2016/10/bubble_sort.png)](https://www.computersciencebytes.com/wp-content/uploads/2016/10/bubble_sort.png)
- Python contains the `sort()` method that can be used to sort a list as fast as possible
```Python
my_list = [8, 10, 6, 2, 4]
my_list.sort()
print(my_list) # Will print [2, 4, 6, 8, 10]
```

---
# References
1. [[Collections]]