---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-07-09
---
```table-of-contents
```
---
# Sorting Arrays
- There are many different algorithms for sorting arrays, some are easier to code, and some have a faster computation time
	- An algorithm is a logical computational procedure that if correctly applied, ensures the solution to a problem
- When searching  for elements in an array, it is beneficial to sort your array in lexicographical order to reduce time spent searching through the array
- ASCII values can be used to sort
## Main Sorting Algorithms for Arrays
- There are many sorting algorithms for arrays
- Some of the common algorithms are:
	- Selection sort
	- Bubble sort
	- Insertion sort
	- Merge sort
	- Quick sort
- We will look at the pros and cons of these in the remaining slides
- These algorithms are transferable between languages

# Selection Sort
- Selection sort is a simple sorting algorithm that works as follows:
	- Find the minimum value in the list
	- Swap it with the value in the starting position
	- Repeat the steps above for the remainder of the list, starting at the second position and advancing each time
- This algorithm:
	- Is inefficient on large arrays because it has to iterate through the entire array each time to find the next smallest element
	- Is preferred for smaller arrays because of its simplicity
## Steps to the Selection Sort Algorithm
- To sort the following array:
	- `{5, 7, 2, 15, 3}`
1. Find the smallest value, which is 2
2. Swap the value with the starting position:
	- `{2, 7, 5, 15, 3}`
3. Repeat steps 1 and 2 starting with the next position in the list. The next smallest number is 3
	- When swapped for the next position, the array is:
		- `{2, 3, 5, 15, 7}`
- These steps are repeated until the array is sorted, or to be more specific, when array.length - 1 is reached
- At that point, if the second last element was bigger than the last, it would swap and the array would be sorted
- Otherwise, the array is sorted
	- `{2, 3, 5, 7, 15}`
## Selection Sort Example
```java
static void selectionSort(int[] numbers) {
	int indexMin = 0; //the index of the smallest number
	for(int i = 0; i < numbers.length; i++) {
		indexMin = i;
		for(int j = i + 1; j < numbers.length; j++) {
			if(numbers[j] < numbers[indexMin]) {//if we find a smaller int
				indexMin = j;
			}//end if
		}//end for
		//we have the index of the smalles int and can swap the values
		int temp = numbers[i]; //use temp to store the value
		numbers[i] = numbers[indexMin];
		numbers[indexMin] = temp;
	}//end for
}//end method selectionSort
```

# Bubble Sort
- Bubble sort, also known as exchange sort, is another sorting algorithm that is simple but inefficient on large lists
- The algorithm works as follows:
	- Compare 2 adjacent values (those at indexes 0 and 1)
	- If they are in the wrong order, swap them
	- Continue this with the next two adjacent values(those at indexes 1 and 2) and on through the rest of the list
	- Repeat steps 1 through 3 until array is sorted
## Steps to the Bubble Sort Algorithm
- To sort the following array:
	- `{40, 7, 59, 4, 1}`
- First, compare and swap the first two values:
	- `{7, 40, 59, 4, 1}`
- Second, compare and swap the next two values
	- Swap does not occur because already in order (40 and 59)
- Repeat until array is sorted
	- `{1, 4, 7, 40, 59}`
## Bubble Sort Example
```java
static void bubbleSort(int[] numbers) {
	for(int = 0; i < number.length; i++) {
		for(int j = 0; j < numbers.length - 1; j++) {
			//if the numbers are not in order
			if(numbers[j] > numbers[j + 1]) {
				//swap the numbers
				int temp = numbers[j];
				numbers[j] = numbers[j + 1];
				numbers[j + 1] = temp;
			}//end if
		}//end for
	}//end for
}//end method bubbleSort
```
### Optimized Bubble Sort
- It can be modified so that it breaks out of the for loops if there is no swap detected
```java
static void bubbleSort(int[] numbers) {
	for(int i=0; i<numbers.length; i++)
	{
		boolean flag = false;
		for(int j=0; j<numbers.length-1; j++)
		{
			if(numbers[j]>numbers[j+1])
			{
				flag = true;
				int temp = numbers[j+1];
				numbers[j+1] = numbers[j];
				numbers[j] = temp;
			}//endif
		}//endfor
		if(!flag){//No Swapping happened, array is sorted. Exit.
		return;
		}//endif
	}//endfor
}//end method bubbleSort
```

# Merge Sort
- Merge Sort:
	- Is more complex than the previous two sorting algorithms
	- Can be more efficient because it takes advantage of parallel processing
	- Takes on a "divide and conquer" technique, which allows it to sort arrays with optimal speed
## Steps to Merge Sort
- The algorithm works as follows:
	- Divide the unsorted list into sub-lists, each containing one element (a list of one element is considered sorted)
	- Repeatedly merge sub-lists to produce new sub-lists until there is only one sub-list remaining
	- This will be the sorted list
## Visual Representation of Merge Sort
![[Pasted image 20250710092359.png|600]]

# Searching Through Arrays
- Sorting an array makes searching faster and easier
- There are two basic searching methods:
	- Sequential/Linear searches
	- Binary searches
- For exmaple, in a sorted array of student names, you want to know if Juan is in your class
- You could search the array, or find out exactly where his name is in alphabetical order with the other students
## Sequential Search
- A sequential search is an iteration through the array that stops at the index where the desired element is found
- If the element is not found, the search stops after all elements of the list have been iterated through
- This method works for sorted or unsorted arrays, but is not efficient on larger arrays
- However, a sequential search is not more efficient if the list is sorted
- A sequential search starts at the first element, then the second and so on
- If the value being searched for is near the start, then it will be found quicker than if it was at the end
![[Pasted image 20250710093148.png|600]]
### Sequential Sort Example
```java
static void sequentialSearch(int[] numbers, int value) {
	for(int i = 0; i < numbers.length; i++) {
		if(numbers[i] == value) {
			System.out.println("The number "+ value + " is at position "
			
			+ i + " in the list");
			
			return;
		}//endif
	}//endfor
	System.out.println("The number "+ value + " is not in the list");
}//end method sequentialSearch
```
## Binary Search
- Binary searches can only be performed on sorted data
- To see how a binary search works:
	- Search for the target value 76 in the array
	- Step 1: Identify the low, middle, and high elements in the array
		- Low is 0, high is array.length = 11, middle is (high - low)/2 = 5
	- Step 2: Compare the target value with the middle value
		- 76 is greater than 56
![[Pasted image 20250710093448.png|600]]
- To see how a binary search works:
	- Step 3: Since the target value is greater than the middle value, it is to the right of the middle. Set the low index to middle + 1, then calculate the new middle index
		- Middle is ((5 + 1) + 10) / 2 = 8
	- Step 4: Compare the target value with the middle value
		- 76 is less than 81
![[Pasted image 20250710093722.png|600]]
- To see how a binary search works:
	- Step 5: Since the target value is less than the middle value, it is to the left of the middle value, it is to the left of the middle. Set the high index to middle - 1 then calculate the new middle index
		- Middle is ((8 - 1) + 6) / 2 = 7
	- Step 6: Compare the target value with the middle value
		- 76 is equal to 76
	- Step 7: The target value has been found at index 7
![[Pasted image 20250710094130.png|600]]
### Decide What to Return in a Binary Search Method
- When writing a binary search method you will have to decide what to return
	- Index
	- Boolean
	- Value
		- Entire object
		- One field of the object
### Binary Search Example
```java
static public void binarySearch(int[] numbers, int value){
	int low = 0;
	int high = numbers.length - 1;
	while(high >= low){
		int middle = (low + high)/2; // Middle index
		if(numbers[middle] == value){
			System.out.println("The number "+ value + " is at position "
			
			+ middle + " in the list");
			
			return; //Target value was found
		}//endif
		if(numbers[middle] < value){
			low = middle + 1;
		}//endif
		if(numbers[middle] > value){
			high = middle - 1;
		}//endif
	}//endwhile 
	//The value was not found
	System.out.println("The number "+ value + " is not in the list");
}//end method binarySearch
```

# Comparison of Sorting Algorithms
![[Pasted image 20250710094452.png|600]]

# Big-O Notation
- Big-O Notation is used in Computer Science to describe the performance of Sorts and Searches on arrays
- The Big-O is a proportion of speed or memory usage to the size of the array
- In the previous slide, Big-O examples are:
	- $n$
	- $n log n$
	- $n^2$
- Compare the values of these sorts
	- Which sort(s) is/are quickest when n is 100?
	- Which sort(s) is/are quickest when n is 1 billion?
- O(n) represents linear time
	- That the size of n affects the growth of the algorithm proportionally
	- So for a for loop that iterates n times, then as n grows the number of iterations grows proportionally
- $n^2$ would be the same as having a nested loop where both iterate n times
	- So for every iteration of the first loop, the nested loop would run n times
- $O(Log n)$ - means that you don't have to look at all the inputs
	- This is when we don't always have to iterate through a whole data structure
	- Think of a phone book and you want to look up someone with a name starting with N
	- You would start roughly at the middle and see if you are before or after N
	- Then repeats this step again, depending on where you are (binary search idea)
	- You have not had to search through all of the elements
	- So on average its performance is better than a linear search
---
# References
1. 