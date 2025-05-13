---
Date Created: 2024-10-16T12:56
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology I (C++)]]"
---
###### tags: #DataStructuresAndAlgorithms #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#Tools we have learned so far…]]
- [[#8.1]]
    - [[#Introduction to Search Algorithms]]
        - [[#Linear Search]]
        - [[#Linear Search - Example]]
        - [[#A linear search function]]
        - [[#Linear Search - Tradeoffs]]
        - [[#Binary Search]]
        - [[#Binary Search - Example]]
        - [[#Binary Search - Tradeoffs]]
- [[#8.2]]
    - [[#Introduction to Sorting Algorithms]]
        - [[#Bubble Sort]]
        - [[#A Bubble Sort Function]]
        - [[#Bubble Sort - Tradeoffs]]
        - [[#Selection Sort]]
        - [[#A Selection Sort Function]]
        - [[#Selection Sort - Tradeoffs]]
- [[#8.3]]
    - [[#Sorting and Searching Vectors]]
---
# Tools we have learned so far…
- Variables
- Calculations
- Conditions
- Loops
- Functions
- Arrays
Where can we go now…
# Algorithms
A process or set of rules to be followed in calculations or other problem-solving operations, especially by a computer.
- Some common tasks
    - Navigation problems
    - Database problems
    - ==Searching==
    - ==Sorting==
  
# 8.1
## Introduction to Search Algorithms
- Search: locate an item in a list of information
- Two algorithms we will examine
    - Linear search
    - Binary search
### Linear Search
- Also called the sequential search
- Starting at the first element, this algorithm sequentially steps through an array examining each element until it locates the value it is searching for
### Linear Search - Example
- Array `numlist` contains
![[image 8.png|image 8.png]]
- Searching for the value `11`, linear search examines `17`, `23`, `5`, and `11`
- Searching for the value `7`, linear search examines `17`, `23`, `5`, `11`, `2`, `29`, and `3`
- Algorithm
    
    set found to false; set position to –1; set index to 0
    
    while index < number of elements and found is false
    
    if list[index] is equal to search value
    
    found = true
    
    position = index
    
    end if
    
    add 1 to index
    
    end while
    
    return position
    
### A linear search function
```C++
int linearSearch(int arr[], int size, int value)
{
	int index = 0; // Used as a subscript to search the array
	int position = -1; // To record the position of search value
	bool found = false; // Flag to indicate if value was found
	while (index < size && !found)
	{
		if (arr[index] == value) // If the value is found
		{
			found = true; // Set the flag
			position = index; // Record the value's subscript
		}
		index++; // Go to the next element
	}
	return position; // Return the position, or -1
}
```
### Linear Search - Tradeoffs
- Benefits
    - Easy algorithm to understand
    - Array can be in any order
- Disadvantages
    - Inefficient (slow): for array of N elements, examines N/2 elements on average for value in array, N elements for value not in array
### Binary Search
Requires array elements to be in order
1. Divides the array into three sections
    1. middle element ((highest index + lowest index) / 2)
    2. elements on one side of the middle element
    3. elements on the other side of the middle element
2. If the middle element is the correct value, done. Otherwise, go to step 1 using only the half of the array that may contain the correct value
3. Continue steps 1 and 2 until either the value is found or there are no more elements to examine
### Binary Search - Example
- Array `numlist2` contains
![[image 1 5.png|image 1 5.png]]
- Searching for the value `11`, binary search examines `11` and stops
- Searching for the value `7`, binary search examines `11`, `3`, `5`, and stops
- Algorithm
    
    Set first to 0
    
    Set last to the last subscript in the array
    
    Set found to false
    
    Set position to -1
    
    While found is not true and first is less than or equal to last
    
    Set middle to the subscript half-way between array[first] and array[last].
    
    If array[middle] equals the desired value
    
    Set found to true
    
    Set position to middle
    
    Else If array[middle] is greater than the desired value
    
    Set last to middle - 1
    
    Else
    
    Set first to middle + 1
    
    End If.
    
    End While.
    
    Return position.
    
    ### A Binary Search Function
    
    ```C++
    int binarySearch(int array[], int size, int value)
    {
    	int first = 0, // First array element
    	last = size - 1, // Last array element
    	middle, // Mid point of search
    	position = -1; // Position of search value
    	bool found = false; // Flag
    	while (!found && first <= last)
    	{
    		middle = (first + last) / 2; // Calculate mid point
    		if (array[middle] == value) // If value is found at mid
    		{
    			found = true;
    			position = middle;
    		}
    		else if (array[middle] > value) // If value is in lower half
    			last = middle - 1;
    		else
    			first = middle + 1; // If value is in upper half
    	}
    	return position;
    }
    ```
    
### Binary Search - Tradeoffs
- Benefits
    - Much more efficient that linear search. For array of N elements, performs at most $log_2N$ comparisons
- Disadvantages
    - Requires that array elements be sorted
  
# 8.2
## Introduction to Sorting Algorithms
- Sort: Arrange values into an order
    - Alphabetical
    - Ascending numeric
    - Descending numeric
- Two algorithms considered here
    - Bubble sort
    - Selection sort
### Bubble Sort
- Concept
    - Compare 1st two elements
        - If out of order, exchange them to put in order
    - Move down one element, compare 2nd and 3rd elements, exchange if necessary. Continue until end of array
    - Pass through array again, exchanging as necessary
    - Repeat until pass made with no exchanges
### A Bubble Sort Function
```C++
void bubbleSort(int array[], int size)
{
	int maxElement;
	int index;
	
	for (maxElement = size - 1; maxElement > 0; maxElement--)
	{
		for (index = 0; index < maxElement; index++)
		{
			if (array[index] > array[index + 1])
			{
				swap(array[index], array[index + 1];
			}
		}
	}
}
void swap(int &a, int &b)
{
	int temp = a;
	a = b;
	b = temp;
}
```
### Bubble Sort - Tradeoffs
- Benefit
    - Easy to understand and implement
- Disadvantage
    - Inefficient: slow for large arrays
### Selection Sort
- Concept for sort in ascending order
    - Locate smallest element in array. Exchange it with element in position 0
    - Locate next smallest element in array. Exchange it with element in position 1
    - Continue until all elements are arranged in order
### A Selection Sort Function
```C++
void selectionSort(int array[], int size)
{
	int minIndex, minValue;
	
	for (int start = 0; start < (size - 1); start++)
	{
		minIndex = start;
		minValue = array[start];
		for (int index = start + 1; index < size; index++)
		{
			if (array[index] < minValue)
			{
				minValue = array[index];
				minIndex = index;
				}
			}
			swap(array[minIndex], array[start]);
		}
	}
```
### Selection Sort - Tradeoffs
- Benefit
    - More efficient that Bubble Sort, since fewer exchanges
- Disadvantage
    - May not be as easy as Bubble Sort to understand
  
# 8.3
## Sorting and Searching Vectors
- Sorting and searching algorithms can be applied to vectors as well as arrays
- Need slight modifications to functions to use vector arguments
    - `vector <type> &` used in prototype
    - No need to indicate vector size - functions can use `size` member function to calculate