---
Date Created: 2025-01-27T09:36
Favorite: false
tags:
  - Data-Structures-&-Algorithms
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#11.1]]
    - [[#Abstract Data Types]]
- [[#11.2]]
    - [[#Combining Data into Structures]]
    - [[#struct Declaration Notes]]
    - [[#Defining Variables]]
- [[#11.3]]
    - [[#Accessing Structure Members]]
    - [[#Displaying a struct Variable]]
    - [[#Comparing struct Variables]]
- [[#11.4]]
    - [[#Initializing a Structure]]
- [[#11.5]]
    - [[#Arrays of Structures]]
- [[#11.6]]
    - [[#Nested Structures]]
    - [[#Members of Nested Structures]]
- [[#11.7]]
    - [[#Structures as Function Arguments]]
- [[#11.8]]
    - [[#Returning a Structure from a Function]]
- [[#11.9]]
    - [[#Pointers to Structures]]
    - [[#Accessing Structure Members via Pointer Variables]]
---
# 11.1
## Abstract Data Types
- A data type that specifies
    - values that can be stored
    - operations that can be done on the values
- User of an abstract data type does not need to know the implementation of the data type, e.g., how the data is stored
- ADTs are created by programmers
- **Abstraction:** A definition that captures general characteristics without details
    - Ex: An abstract triangle is a 3-sided polygon. A specific triangle may be scalene, isosceles, or equilateral
- **Data Type:** Defines the values that can be stored in a variable and the operations that can be performed on it
  
# 11.2
## Combining Data into Structures
- **Structure:** C++ construct that allows multiple variables to be grouped together
- General Format:
```C++
struct structName //structure tag
{
	type1 field1; //structure members
	type2 field2;
	...
};
```
## `struct` Declaration Notes
- Must have `;` after closing `}`
- `struct` names commonly begin with uppercase letter
- Multiple fields of same type can be in comma-separated list:
    - ex: `string name, address;`
## Defining Variables
- `struct` declaration does not allocate memory or create variables
- To define variables, use structure tag as type name
    - `Student bill;`
![[image 24.png|image 24.png]]
  
# 11.3
## Accessing Structure Members
- Use the dot (`.`) operator to refer to members of `struct` variables:
```C++
cin >> stu1.studentID;
getline(cin, stu1.name);
stu1.gpa = 3.75;
```
- Member variables can be used in any manner appropriate for their data type’
## Displaying a `struct` Variable
- To display the contents of a `struct` variable, **must display each field separately**, using the dot operator:
```C++
cout << bill; //won't work
cout << bill.studentID << endl;
cout << bill.name << endl;
cout << bill.yearInSchool;
cout << " " << bill.gpa;
```
## Comparing `struct` Variables
- Cannot compare `struct` variables directly:
    - `if (bill == william)` won’t work
- Instead, must compare on a field basis:
    - `if (bill.studentID == william.studentID)...`
  
# 11.4
## Initializing a Structure
- `struct` variable can be initialized when defined:
    - `Student s = {11465, "Joan", 2, 3.75};`
- Can also be initialized member-by-member after definition:
    - `s.name = "Joan";`
    - `s.gpa = 3.75;`
- May initialize only some members:
    - `Student bill = {11465};`
- Cannot skip over members:
    - `Student s = {1234, "John", , 2.83};`<-illegal
- Cannot initialize in the structure declaration, since this does not allocate memory
  
# 11.5
## Arrays of Structures
- Structures can be defined in arrays
- Can be used in place of parallel arrays
```C++
const int NUM_STUDENTS = 20;
Student stuList[NUM_STUDENTS];
```
- Individual structures accessible using subscript notation
- Fields within structures accessible using dot notation:
    - `cout << stuList[5].studentID;`
  
# 11.6
## Nested Structures
- A structure can contain another structure as a member:
```C++
struct PersonInfo
{
	string name, address, city;
};
struct Student
{
	int studentID;
	PersonInfo pData;
	short yearInSchool;
	double gpa;
};
```
## Members of Nested Structures
- Use the dot operator multiple times to refer to fields of nested structures:
```C++
Student S;
s.pData.name = "Joanne";
s.pData.city = "Tulsa";
```
  
# 11.7
## Structures as Function Arguments
- May pass members of `struct` variables to functions:
    - `computeGPA(stu.gpa);`
- May pass entire `struct` variables to functions:
    - `showData(stu);`
- Can use reference parameter if function needs to modify contents of structure variable
  
# 11.8
## Returning a Structure from a Function
- Function can return a `struct`:
    - `Student getStudentData();` ←prototype
    - `stu1 = getStudentData();` ← call
- Function must define a local structure
    - for internal use
    - for use with `return` statement
  
# 11.9
## Pointers to Structures
- A structure variable has an address
- Pointers to structures are variables that can hold the address of a structure:
    - `Student *stuPtr;`
- Can use & operator to assign address:
    - `stuPtr = & stu1;`
- Structure pointer can be a function parameter
## Accessing Structure Members via Pointer Variables
- Must use `()` to dereference pointer variable, not field within structure:
    - `cout << (*stuPtr).studentID;`
- Can use structure pointer operator to eliminate `()` and use clearer notation
    - `cout << stuPtr->studentID;`