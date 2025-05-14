---
Date Created: 2024-10-07T13:00
Favorite: false
tags:
  - Basics
  - ComputerScience
📕 Courses:
  - "[[!!Programming Concepts and Methodology I (C++)]]"
---
# Table of Contents
- [[#Table of Contents]]
- [[#7.1]]
    - [[#Arrays Hold Multiple Values]]
    - [[#Array - Memory Layout]]
    - [[#Array Terminology]]
    - [[#Size Declarators]]
- [[#7.2]]
    - [[#Accessing Array Elements]]
    - [[#Using a Loop to Step Through an Array]]
        - [[#Default Initialization]]
    - [[#Array Initialization]]
    - [[#Partial Array Initialization]]
- [[#Implicit Array Sizing]]
- [[#7.3]]
    - [[#No Bounds Checking in C++]]
    - [[#Off-By-One Errors]]
- [[#7.4]]
    - [[#The Range-Based for Loop]]
    - [[#Modifying an Array with a Range-Based for Loop]]
    - [[#The Range-Based for Loop versus the Regular for Loop]]
- [[#7.5]]
    - [[#Processing Array Contents]]
    - [[#Array Assignment]]
    - [[#Printing the Contents of an Array]]
    - [[#Summing and Averaging Array Elements]]
    - [[#Finding the Highest Value in an Array]]
    - [[#Finding the Lowest Value in an Array]]
    - [[#Partially Filled Arrays]]
    - [[#Comparing Arrays]]
- [[#7.6]]
    - [[#Using Parallel Arrays]]
- [[#7.7]]
    - [[#Arrays as Function Arguments]]
    - [[#Modifying Arrays in Functions]]
- [[#7.8]]
    - [[#Two-Dimensional Arrays]]
    - [[#2D Array Initialization]]
    - [[#Two-Dimensional Array as Parameter, Argument]]
- [[#7.9]]
    - [[#Arrays with Three or More Dimensions]]
- [[#7.10]]
    - [[#Introduction to the STL vector]]
    - [[#Declaring Vectors]]
    - [[#Adding Elements to a Vector]]
    - [[#Removing Vector Elements]]
---
# 7.1
## Arrays Hold Multiple Values
- Array: Variable that can store multiple values of the same type
- Values are stored in adjacent memory locations
- Declared using `[]` operator:
```C++
int tests[5];
```
## Array - Memory Layout
- The definition `int tests[5];` allocates the following memory
![[image 7.png|image 7.png]]
## Array Terminology
- In the definition `int tests[5];`
    - `int` is the data type of the array elements
    - `tests` is the name of the array
    - 5, in `[5]` , is the size declarator. It shows the number of elements in the array
    - The size of an array is (number of elements) * (size of each element)
- The size of an array is:
    - The total number of bytes allocated for it
    - (number of elements) * (number of bytes for each element)
- Ex:
    - `int tests[5]` is an array of 20 bytes, assuming 4 bytes per `int`
## Size Declarators
- Named constants are commonly used as size declarators
```C++
const int SIZE = 5;
int tests[SIZE];
```
- This eases program maintenance when the size of the array needs to be changed
  
# 7.2
## Accessing Array Elements
- Each element in an array is assigned a unique _subscript_
- Subscripts start at 0
![[image 1 4.png|image 1 4.png]]
- The last element’s subscript is n-1 where n is the number of elements in the array
- Array elements can be used as regular variables:
```C++
tests[0] = 79;
cout << tests[0];
cin >> tests[1];
tests[4] = tests[0] + tests[1];
```
- Arrays must be accessed via individual elements:
    - `cout << tests;` ←not legal
- Can access elements with a constant or literal subscript:
    - `cout << tests[3] << endl;`
- Can use integer expression as subscript:
    - `int i = 5;`
    - `cout << tests[i] << endl;`
## Using a Loop to Step Through an Array
### Default Initialization
- Global array → all elements initialized to 0 by default
- Local array → all elements _uninitialized_ by default
## Array Initialization
- Arrays can be initialized with an initialization list:
```C++
const int SIZE = 5;
int tests[SIZE] = {79, 82, 91, 77, 84}
```
- The values are stored in the array in the order in which they appear in the list
- The initialization list cannot exceed the array size
## Partial Array Initialization
- If array is initialized with fewer initial values than the size declarator, the remaining elements will be set to 0
![[image 2 4.png|image 2 4.png]]
# Implicit Array Sizing
- Can determine array size by the size of the initialization list:
    - `int quizzes[] = {12, 17, 15, 11};`
- Must use either array size declarator or initialization list at array definition
  
# 7.3
## No Bounds Checking in C++
- When you use a value as an array subscript, C++ does not check it to make sure it is a valid subscript
- In other words, you can use subscripts that are beyond the bounds of the array
    - Doing so could overwrite data previously stored in that data location
![[image 3 3.png|image 3 3.png]]
- Be careful not to use invalid subscripts
- Doing so can corrupt other memory locations, crash programs, or lock up computer, and cause elusive bugs
## Off-By-One Errors
- An off-by-one error happens when you use array subscripts that are off by one
- This can happen when you start subscripts at 1 rather than 0
![[image 4 3.png|image 4 3.png]]
  
# 7.4
## The Range-Based `for` Loop
- C++ 11 provides a specialized version of the `for` loop that, in many circumstances, simplifies array processing
- The range-based `for` loop is a loop that iterates once for each element in an array
- Each time the loop iterates, it copies an element from the array to a built-in variable, known as the range variable
- The range-based `for` loop automatically knows the number of elements in an array
    - You do not have to use a counter variable
    - You do not have to worry about stepping outside the bounds of the array
- General format of the range based `for` loop
```C++
for (dataType rangeVariable : array)
	statement;
```
- `dataType` is the data type of the range variable
- `rangeVariable` is the name of the range variable. This variable will receive the value of a different array element during each loop iteration
- `array` is the name of an array on which you wish the loop to operate
- `statement` is a statement that executes during a loop iteration. If you need to execute more than one statement in the loop, enclose the statements in a set of braces`{}`
## Modifying an Array with a Range-Based `for` Loop
- As the range-based `for` loop executes, its range variable contains only a copy of an array element
- You cannot use a range-based `for` loop to modify the contents of an array unless you declare the range variable as a reference
- To declare the range variable as a reference variable, simply write an ampersand(&) in front of its name in the loop header
## The Range-Based `for` Loop versus the Regular `for` Loop
- The range-based for loop can be used in any situation where you need to step through the elements of an array, and you do not need to use the element subscripts
- If you need the element subscript for some purpose, use the regular `for` loop
  
# 7.5
## Processing Array Contents
- Array elements can be treated as ordinary variables of the same type as the array
- When using `++`,`--` operators, don’t confuse the element with the subscript
```C++
tests[i]++; //add 1 to tests[i]
tests[i++]; //increment i, no effect on tests
```
## Array Assignment
- To copy one array to another
    - Don’t try to assign one array to the other
        - `newTests = tests; //Won't work`
    - Instead, assign element-by-element
```C++
for (i = 0; i < ARRAY_SIZE; i++0)
	newTests[i] = tests[i];
```
## Printing the Contents of an Array
- You can display the contents of a character array by sending its name to `cout`
```C++
char fName[] = "Henry";
cout << fName << endl;
```
- ONLY WORKS with character arrays^
- For other types of arrays, you must print element by element
```C++
for (i = 0; i < ARRAY_SIZE; i++)
	cout << tests[i] << endl;
```
- In C++ 11 you can use the range-based for loop to display an array’s contents, as shown here
```C++
for (int val: numbers)
	cout << val << endl;
```
## Summing and Averaging Array Elements
- Use a simple loop to add together array elements:
```C++
int tnum;
double average, sum = 0;
for(tum = 0; tnum < SIZE; tnum++)
	sum += tests[tnum];
```
- Once summed, can compute average
## Finding the Highest Value in an Array
```C++
int count
int highest;
highest = numbers[0];
for (count = 1; count < SIZE; count++)
{
	if (numbers[count] > highest)
	highest = numbers[count];
}
```
## Finding the Lowest Value in an Array
```C++
int count;
int lowest;
lowest = numbers[0];
for (count = 1; count < SIZE; count++)
{
	if (numbers[count] < lowest)
	lowest = numbers[count];
}
```
## Partially Filled Arrays
- If it is unknown how much data an array will be holding
    - Make the array large enough to hold the largest expected number of elements
    - Use a counter variable to keep track of the number of items stored in the array
## Comparing Arrays
- To compare two arrays, you must compare element by element
```C++
const int SIZE = 5;
int firstArray[SIZE] = { 5, 10, 15, 20, 25 };
int secondArray[SIZE] = { 5, 10, 15, 20, 25 };
bool arraysEqual = true; // Flag variable
int count = 0; // Loop counter variable
// Compare the two arrays.
while (arraysEqual && count < SIZE)
{
if (firstArray[count] != secondArray[count])
	arraysEqual = false;
	count++;
}
if (arraysEqual)
	cout << "The arrays are equal.\n";
else
	cout << "The arrays are not equal.\n";
```
  
# 7.6
## Using Parallel Arrays
- Parallel Arrays: Two or more arrays that contain related data
- A subscript is used to relate arrays: elements at same subscript are related
- Arrays may be of different types
![[image 5 3.png|image 5 3.png]]
# 7.7
## Arrays as Function Arguments
- To pass an array to a function, just use the array name
    - `showScores(tests);`
- To define a function that takes an array parameter, use empty `[]` for array argument
```C++
// function prototype
void showScores(int []);
// function header
void showScores(int tests[])
{
}
```
- When passing an array to a function, it is common to pass array size so that function knows how many elements to process
    - `showScores(tests, ARRAY_SIZE);`
- Array size must also be reflected in prototype, header
```C++
// function prototype
void showScores(int [], int);
// function header
void showScores(int tests[], int size)
{
}
```
## Modifying Arrays in Functions
- Array names in functions are like reference variables - changes made to array in a function are reflected in actual array in calling function
- Need to exercise caution that array is not inadvertently changed by a function
  
# 7.8
## Two-Dimensional Arrays
- Can define one array for multiple sets of data
- Like a table in a spreadsheet
- Use two size declarators in definition:
```C++
const int ROWS = 4, COLS = 3;
int exams[ROWS][COLS];
```
- First declarator is number of rows; second is number of columns
![[image 6 2.png|image 6 2.png]]
- Use two subscripts to access element
    - `exams[2][2] = 86;`
## 2D Array Initialization
- Two dimensional arrays are initialized row-by-row:
```C++
const int ROWS = 2, COLS = 2;
int exams[ROWS][COLS] = { {84, 78}, {92, 97} };
```
- Can omit inner `{ }`, some initial values in a row — array elements without initial values will be set to `0` or `NULL`
## Two-Dimensional Array as Parameter, Argument
- Use array name as argument in function call
    - `getExams(exams, 2);`
- Use empty `[]` for row, size declarator for column in prototype, header
```C++
const int COLS = 2;
// Prototype
void getExams(int [][COLS], int);
// Header
void getExams(int exams[][COLS], int rows)
```
  
# 7.9
## Arrays with Three or More Dimensions
- Can define arrays with any number of dimensions
```C++
short rectSolid[2][3][5];
double timeGrid[3][4][3][4];
```
- When used as parameter, specifically all but 1st dimension in prototype, heading
    - `void getRectSolid(short [][3][5]);`
  
# 7.10
## Introduction to the STL `vector`
- A data type defined in the Standard Template Library (covered more in Chapter 17)
- Can hold values of any type
    - `vector<int> scores;`
- Automatically adds space as more is needed — no need to determine size at definition
- Can use `[]` to access elements
## Declaring Vectors
- You must `#include<vector>`
- Declare a vector to hold `int` element
    - `vector<int> scores;`
- Declare a vector with initial size 30
    - `vector<int> scores(30);`
- Declare a vector and initialize all elements to 0
    - `vector<int> scores(30, 0);`
- Declare a vector initialized to size and contents of another vector:
    - `vector<int> finals(scores);`
## Adding Elements to a Vector
- If you are using C++ 11, you can initialize a vector with a list of values
    - `vector<int> numbers {10, 20, 30, 40};`
- Use `push_back` member function to add element to a full array or to an array that had no defined size
    - `scores.push_back(75);`
- Use `size` member function to determine size of a vector
    - `howbig = scores.size();`
## Removing Vector Elements
- Use `pop_back` member function to remove last element from vector
    - `scores.pop_back();`
- To remove all contents of vector, use `clear` member functions
    - `scores.clear();`
- To determine if vector is empty, use `empty` member function
    - `while (!scores.empty())`
![[image 7 2.png|image 7 2.png]]