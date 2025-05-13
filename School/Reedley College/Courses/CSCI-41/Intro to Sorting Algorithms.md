---
Date Created: 2025-02-10T10:03
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #DataStructuresAndAlgorithms #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#4.1]]
    - [[#Introduction to Sorting Algorithms]]
    - [[#Bubble Sort]]
        - [[#Tradeoffs]]
- [[#4.2]]
    - [[#Selection Sort]]
        - [[#Tradeoffs]]
- [[#4.3]]
    - [[#The QuickSort Algorithm]]
- [[#4.4]]
    - [[#Mergesort Algorithm]]
        - [[#Mergesort example]]
---
# 4.1
## Introduction to Sorting Algorithms
- **Sort:** Arrange values into an order:
    - Alphabetical
    - Ascending numeric
    - Descending numeric
- Two algorithms considered here:
    - Bubble Sort
    - Selection Sort
## Bubble Sort
Concept:
- Compare 1st two elements
    - If out of order, exchange them to put in order
- Move down one element, compare 2nd and 3rd elements, exchange if necessary. Continue until end of array
- Pass through array again, echanging as necessary
- Repeat until pass made with no exchanges
### Tradeoffs
- Benefit
    - Easy to understand/ implement
- Desadvantage
    - Inefficient: Slow for large arrays
  
# 4.2
## Selection Sort
- $O(n^2)$
- Concept for sort in ascending order:
    - Locate smallest element in array. Exhange it with emelent in position 0
    - Locate next smallest element in array. Exchange it with element in position 1.
    - Continue until all elements are arranged in order
### Tradeoffs
- Benefit
    - More efficient than bubble sort, since fewer exchanges
- Disadvantage
    - May not be as easy as bubble sort to understand
  
# 4.3
## The QuickSort Algorithm
- $O(nlog_2n)$ average case; $O(n^2)$ worst case
- Recursive algorithm that can sort an array or a linear linked list
- Determines an element/ node to use as pivot value:
![[image 28.png|image 28.png]]
- Once pivot value is determined, values are shifted so that elements in sublist1 are < pivot and elements in sublist2 are > pivot
- Algorithm then sorts sublist1 and sublist2
- Base case: sublist has size 1
  
# 4.4
## Mergesort Algorithm
- $O(nlog_2n)$
- Uses the divide-and-conquer technique
    - Partitions the array into two subarrays
    - Sorts the subarrays
    - Combines the subarrays into one sorted array
- Differs from quick sort in how array is partitioned
    - Divides array into two subarrays of nearly equal size
![[image 1 15.png|image 1 15.png]]
- Suppose the L is a list of n elements with n > 0
- Suppose that n is a power of 2; that is, n = $2^m$ for some integer m > 0, so that we can divide the list into two sublists, each of size:
![[image 2 13.png|image 2 13.png]]
- m will be the number of recursion levels
- To merge two sorted lists of size s and t, the maximum number of comparisons is s + t - 1
- Function mergeList merges two sorted lists into a sorted list
    - This is where the acutal comparisons and assignments are done
- Max # of comparisons ata level k of recursion:
![[image 3 12.png|image 3 12.png]]
- The maximum number of comparisons at each level of the recursion is O(n)
    - Maximum number of comparisons is O(nm), where m = number of levels of recursion
    - Thus, $O(nm) = O(nlog_2n)$
    - W(n): # of key comparisons in worst case
        - $W(n) = O(nlog_2n)$
    - A(n): # of key comparisons in average case
        - $A(n) = nlog_2n - 1.25n = O(nlog_2n)$
### Mergesort example
```C++
void Merge(int* numbers, int leftFirst, int leftLast,
   int rightLast) {
   int mergedSize = rightLast - leftFirst + 1;
   int* mergedNumbers = new int[mergedSize];
   int mergePos = 0;
   int leftPos = leftFirst;
   int rightPos = leftLast + 1;
  
   while (leftPos <= leftLast && rightPos <= rightLast) {
      if (numbers[leftPos] <= numbers[rightPos]) {
         mergedNumbers[mergePos] = numbers[leftPos];
         leftPos++;
      }
      else {
         mergedNumbers[mergePos] = numbers[rightPos];
         rightPos++;
      }
      mergePos++;
   }
  
   while (leftPos <= leftLast) {
      mergedNumbers[mergePos] = numbers[leftPos];
      leftPos++;
      mergePos++;
   }
   while (rightPos <= rightLast) {
      mergedNumbers[mergePos] = numbers[rightPos];
      rightPos++;
      mergePos++;
   }
   for (mergePos = 0; mergePos < mergedSize; mergePos++) {
      numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
   }
   delete[] mergedNumbers;
}
```