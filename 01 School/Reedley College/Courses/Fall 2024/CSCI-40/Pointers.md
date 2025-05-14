---
Date Created: 2024-11-04T13:09
Favorite: false
tags:
  - ComputerScience/Basics
  - ComputerScience
📕 Courses:
  - "[[!!Programming Concepts and Methodology I (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#9.1]]
    - [[#Getting the Address of a Variable]]
- [[#9.2]]
    - [[#Pointer Variables]]
    - [[#Something Like Pointers: Arrays]]
    - [[#Something Like Pointers: Reference Variables]]
    - [[#The Indirection Operator]]
    - [[#READING A POINTER🚨🚨🚨]]
- [[#9.3]]
    - [[#The Relationship Between Arrays and Pointers]]
    - [[#Pointers in Expressions]]
    - [[#Array Access]]
- [[#9.4]]
    - [[#Pointer Arithmetic]]
- [[#9.5]]
    - [[#Initializing Pointers]]
- [[#9.6]]
    - [[#Comparing Pointers]]
- [[#9.7]]
    - [[#Pointers as Function Parameters]]
        - [[#Example]]
    - [[#Pointers to Constants]]
    - [[#Constant Pointers]]
    - [[#Constant Pointers to Constants]]
- [[#9.8]]
    - [[#Dynamic Memory Allocation]]
    - [[#Releasing Dynamic Memory]]
- [[#9.9]]
    - [[#Returning Pointers from Functions]]
- [[#9.10]]
    - [[#Using Smart Pointers to Avoid Memory Leaks]]
---
# 9.1
## Getting the Address of a Variable
- Each variable in program is stored at a unique address
- Use address operator `&` to get address of a variable
    - `int num = -99;`
    - `cout << &num; //prints address in hexadecimal`
  
# 9.2
## Pointer Variables
- Pointer variable: Often just called a pointer, it’s a variable that holds an address
- Because a pointer variable holds the address of another piece of data, it “points” to the data
## Something Like Pointers: Arrays
- We have already worked with something similar to pointers, when we learned to pass arrays as arguments to functions
- For example, suppose we use this statement to pass the array `numbers` to the `showValues` function:
```C++
showValues(numbers, SIZE);
```
![[image 9.png|image 9.png]]
## Something Like Pointers: Reference Variables
- We have also worked with something like pointers when we learned to use reference variables.
- Suppose we have this function:
```C++
void getOrder(int &donuts)
{
	cout << "How many doughnuts do you want? ";
	cin >> donuts;
}
```
- And we call it with this code:
    - `int jellyDonuts;`
    - `getOrder(jellyDonuts);`
![[image 1 6.png|image 1 6.png]]
- Pointer variables are yet another way using a memory address to work with a piece of data
- Pointers are more “low-level” than arrays and reference variables
- This means you are responsible for finding the address you want to store in the pointer and correctly using it
- Definition
    - `int *intptr;`
- Read as:
    - “`intptr` can hold the address of an int”
- Spacing in definition does not matter:
    - `int * intptr; //same as above`
    - `int* intptr; //same as above`
- Assigning an address to a pointer variable:
    - `int* intptr;`
    - `intptr = &num;`
- Memory layout
![[image 2 5.png|image 2 5.png]]
- Initialize pointer variables with the special value `nullptr`
- In C++ 11, the `nullptr` key word was introduced to represent the address `0`
- Here is an example of how you define a pointer variable and initialize it with the value `nullptr`:
    - `int* ptr = nullptr;`
## The Indirection Operator
- The indirection operator (*) dereferences a pointer
- It allows you to access the item that the pointer points to
```C++
int x = 25;
int* intptr = &x;
cout << *intptr << endl; //prints 25
```
## READING A POINTER🚨🚨🚨
```C++
int * pbalance = &balance;
```
- Read: ==Integer== ==pointer== named pbalance ==is set to== ==the address== of balance
# 9.3
## The Relationship Between Arrays and Pointers
- Array name is starting address of array
    - `int vals[] = {4, 7, 11};`
- Starting address of vals: 0x4a00
    - `cout << vals; //displays 0x4a00`
    - `cout << vals[0]; //displays 4`
- Array name can be used as a pointer constant:
    - `int vals[] = {4, 7, 11};`
    - `cout << *vals; //displays 4`
- Pointer can be used as an array name:
    - `int *valptr = vals;`
    - `cout << valptr[1] //displays 7`
## Pointers in Expressions
- Given:
```C++
int vals[]= {4,7,11}, *valptr;
valptr = vals;
```
- What is `valptr + 1`
    - It means (address in `valptr`) + (1 * size of an int)
    - `cout << * (valptr+1); //displays 7`
    - `cout << * (valptr+2); //displays 11`
- **Must use ( ) as shown in the expressions^^**
## Array Access
- Array elements can be accessed in many ways:
![[image 3 4.png|image 3 4.png]]
- Conversion: `vals[i]` is equivalent to `* (vals + i)`
- No bounds checking performed on array access, whether using array name or a pointer
  
# 9.4
## Pointer Arithmetic
- Operations on pointer variables:
![[image 4 4.png|image 4 4.png]]
  
# 9.5
## Initializing Pointers
- Can initialize at definition time:
    - `int num, *numptr = &num;`
    - `int val[3], *valptr = val;`
- Cannot mix data types:
    - `double cost;`
    - `int *ptr = &cost; //won't work`
- Can test for an invalid address for `ptr` with:
    - `if (!ptr) ...`
  
# 9.6
## Comparing Pointers
- Relational operators (<, >=, etc.) can be used to compare addresses in pointers
- Comparing addresses in pointers is not the same as comparing contents pointed at by pointers:
    - `if (ptr1 == ptr2) //compares addresses`
    - `if (*ptr1 == *ptr2) //compares contents`
  
# 9.7
## Pointers as Function Parameters
- A pointer can be a parameter
- Works like reference variable to allow change to argument from within function
- Requires:
    
    1. asterisk * on parameter in prototype and heading
    
    `void getNum(int *ptr); // ptr is pointer to an int`
    
    1. asterisk * in body to dereference the pointer
    
    `cin >> *ptr;`
    
    1. address as an argument to the function
    
    `getNum(&num); //pass address of num to getNum`
    
### Example
```C++
void swap(int *x, int *y)
{ 
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}
int num1 = 2, num2 = -3;
swap(&num1, &num2);
```
## Pointers to Constants
- If we want to store the address of a constant in a pointer, then we need to store it in a pointer-to-const
- Example: Suppose we have the following definitions:
```C++
const int SIZE = 6;
const double payRates[SIZE] =
	{ 18.55, 17.45, 12.85,
		14.97, 10.35, 18.89 };
```
- In this code, `payRates` is an array of constant doubles
- Suppose we wish to pass the `payRates` array to a function? Here’s an example of how we can do it
```C++
void displayPayRates(const double *rates, int size)
{
	for (int count = 0; count < size; count++)
	{
		cout << "Pay rate for employee " << (count + 1)
				 << " is $" << *(rates + count) << endl;
	}
}
//The parameter, rates, is a pointer to const double.
```
## Constant Pointers
- A constant pointer is a pointer that is initialized with an address, and cannot point to anything else
- Example
    - `int value = 22;`
    - `int* const ptr = &value;`
## Constant Pointers to Constants
- A constant pointer to a constant is:
    - a pointer that points to a constant
    - a pointer that cannot point to anything except what it is pointing to
- Example
    - `int value = 22;`
    - `const int* const ptr = &value;`
  
# 9.8
## Dynamic Memory Allocation
- Can allocate storage for a variable while program is running
- Computer returns address of newly allocated variable
- Uses `new` operator to allocate memory:
    - `double* dptr = nullptr;`
    - `dptr = new double;`
- `new` returns address of memory location
- Can also use `new` to allocate array:
```C++
const int SIZE = 25;
arrayPtr = new double[SIZE];
```
- Can then use `[]` or pointer arithmetic to access array:
```C++
for (i = 0; i < SIZE; i++)
	*arrayptr[i] = i * i;
//or
for(i = 0; i < SIZE; i++)
	*(arrayptr + i) = i * i;
```
- Program will terminate if not enough memory available to allocate
## Releasing Dynamic Memory
- Use `delete` to free dynamic memory:
    - `delete fptr;`
- Use `[]` to free dynamic array:
    - `delete [] arrayptr;`
- **Only use** `**delete**` **with dynamic memory!**
  
# 9.9
## Returning Pointers from Functions
- Pointer can be the return type of a function:
    - `int* newNum();`
- The function must not return a pointer to a local variable in the function
- A function should only return a pointer:
    - to data that was passed to the function as an argument
    - to dynamically allocated memory
  
# 9.10
## Using Smart Pointers to Avoid Memory Leaks
- In C++ 11, you can use _smart pointers_ to dynamically allocate memory and not worry about deleting the memory when you are finished using it
- Three types of smart pointer:
    - `unique_ptr`
    - `shared_ptr`
    - `weak_ptr`
- Must `#include` the memory header file:
    - `#include <memory>`
- Intro to `unique_ptr`:
    - `unique_ptr<int> ptr( new int );`
![[image 5 4.png|image 5 4.png]]
- The notation `<int>` indicates that the pointer can point to an `int`
- The name of the pointer is `ptr`
- The expression `new int` allocates a chunk of memory to hold an `int`
- The address of the chunk of memory will be assigned to `ptr`