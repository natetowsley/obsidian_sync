---
Date Created: 2024-11-13T12:55
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
- [[#13.1]]
    - [[#Procedural and Object-Oriented Programming]]
    - [[#Limitations of Procedural Programming]]
    - [[#Object-Oriented Programming Terminology]]
        - [[#Classes and Objects]]
        - [[#More on Objects]]
- [[#13.2]]
    - [[#Introduction to Classes]]
        - [[#Access Specifiers]]
        - [[#Using const with Member Functions]]
        - [[#Defining a Member Function]]
    - [[#Accessors and Mutators]]
- [[#13.3]]
    - [[#Defining an Instance of a Class]]
        - [[#Avoiding Stale Data]]
        - [[#Pointer to an Object]]
        - [[#Dynamically Allocating an Object]]
- [[#13.4]]
    - [[#Why Have Private Members?]]
- [[#13.5]]
    - [[#Separating Specification from Implementation]]
        - [[#Include Guards]]
- [[#13.6]]
    - [[#Inline Member Functions]]
        - [[#Tradeoffs - Inline vs. Regular Member Functions]]
- [[#13.7]]
    - [[#Constructors]]
        - [[#In-Place Initialization]]
        - [[#Default Constructors]]
- [[#13.8]]
    - [[#Passing Arguments to Constructors]]
        - [[#More About Default Constructors]]
        - [[#Classes with No Default Constructor]]
- [[#13.10]]
    - [[#Overloading Constructors]]
        - [[#Constructor Delegation]]
    - [[#Destructors]]
        - [[#Only One Default Constructor and One Destructor]]
        - [[#Member Function Overloading]]
    - [[#Exceptions]]
        - [[#Terminology]]
        - [[#Flow of Control]]
        - [[#Exceptions - Notes]]
        - [[#Exception Not Caught?]]
        - [[#What Happens After catch Block?]]
        - [[#Nested try Blocks]]
        - [[#Exceptions and Objects]]
---
# 13.1
## Procedural and Object-Oriented Programming
- Procedural programming focuses on the process/actions that occur in a program
- Object-Oriented programming is based on the data and the functions that operate on it. Objects are instances of ADTs that represent the data and its functions
## Limitations of Procedural Programming
- If the data structures change, many functions must also be changed
- Programs that are based on complex function hierarchies are:
    - difficult to understand and maintain
    - difficult to modify and extend
    - easy to break
## Object-Oriented Programming Terminology
- **Class:** Allows bundling of related variables
- **Object**: An instance of a `class`
### Classes and Objects
- A Class is like a blueprint and objects are like houses built from the blueprint
- **Attributes:** Members of a class
- **methods** and **behaviors**: Member functions of a class
### More on Objects
- **data hiding:** Restricting access to certain members of an object
- **public interface:** members of an object that are available outside of the object. This allows the object to provide access to some data and functions without sharing its internal details and design, and provides some protection from data corruption
  
# 13.2
## Introduction to Classes
- Objects are created from a `class`
- Format
```C++
class ClassName
{
	declaration;
	declaration;
};
```
- Class example
```C++
class Rectangle
{
	private:
		double width;
		double length;
	public:
		void setWidth(double);
		void setLength(double);
		double getWidth() const;
		double getLength() const;
		double getArea() const;
};
```
### Access Specifiers
- Used to control access to members of the class
- `public`: can be accessed by functions outside of the class
- `private`: can only be called by or accessed by functions that are members of the class
- Can be listed in any order in a class
- Can appear multiple times in a class
- If not specified, the default is `private`
### Using `const` with Member Functions
- `const` appearing after the parentheses in a member function declaration specifies that the function will not change any data in the calling object
    - `double getWidth() const;`
### Defining a Member Function
- When defining a member function
    - Put prototype in class declaration
    - Define function using class name and scope resolution operator
```C++
int Rectangle::setWidth(double w)
{
	width = w;
}
```
## Accessors and Mutators
- **Mutator:** A member function that stores a value in a private member variable, or changes its value in some way
- **Accessor:** Function that retrieves a value from a private member variable. Accessors do not change an object’s data, so they should be marked `const`
  
# 13.3
## Defining an Instance of a Class
- An object is an instance of a class
- Defined like structure variables:
    - `Rectangle r;`
- Access members using dot operator:
    - `r.setWidth(5.2);`
    - `cout << r.getWidth();`
### Avoiding Stale Data
- Some data is the result of a calculation
- In the `Rectangle` class the area of a rectangle is calculated
    - length x width
- If we were to use an `area` variable here in the `Rectangle` class, its value would be dependent on the length and the width
- If we change `length` or `width` without updating `area`, then `area` would become stale
### Pointer to an Object
- Can define a pointer to an object:
    - `Rectangle *rPtr = nullptr;`
- Can access public members via pointer:
    - `rPtr = &otherRectangle;`
    - `rPtr->setLength(12.5);`
    - `cout << rPtr->getLength() << endl;`
### Dynamically Allocating an Object
- We can also use a pointer to dynamically allocate an object
  
# 13.4
## Why Have Private Members?
- Making data members `private` provides data protection
- Data can be accessed only through `public` functions
- Public functions define the class’s public interface
![[image 10.png|image 10.png]]
  
# 13.5
## Separating Specification from Implementation
- Place class declaration in a header file that serves as the class specification file. Name the file _`ClassName.h`_, for example, `Rectangle.h`
- Place member function definitions in _`ClassName.cpp`_, for example, `Rectangle.cpp` File should `#include` the class specification file
- Programs that use the class must `#include` the class specification file, and be compiled and linked with the member function definitions
### Include Guards
- Used to prevent a header file from being included twice
- Format:
```C++
\#indef symbol_name
\#define symbol_name
... (normal contents of header file)
\#endif
```
- _`symbol_name`_ is usually the name of the header file, in all capital letters
- Example:
    - `#indef RECTANGLE_H`
    - `#define RECTANGLE_H`
  
# 13.6
## Inline Member Functions
- Member functions can be defined
    - inline: in class declaration
    - after the class declaration
- Inline appropriate for short function bodies:
```C++
int getWidth() const
	{return width;}
```
### Tradeoffs - Inline vs. Regular Member Functions
- Regular Functions - when called, compiler stores return address of call, allocates memory for local variables, etc.
- Code for an inline function is copied into program in place of call - larger executable program, but no function call overhead, hence faster execution
  
# 13.7
## Constructors
- Member function that is automatically called when an object is created
- Purpose is to construct an object
- Constructor function name is class name
### In-Place Initialization
- If you are using C++ 11 or later, you can initialize a member variable in its declaration statement, just as you can with a regular variable
- This is known as in-place initialization
    - Example:
```C++
class Rectangle
{
	private:
		double width = 0.0;
		double length = 0.0;
	public:
		Public member functions appear here...
};
```
### Default Constructors
- A default constructor is a constructor that takes no arguments
- If you write a class with no constructor at all, C++ will write a default constructor for you, one that does nothing
- A simple instantiation of a class (with no arguments) calls the default constructor:
    - `Rectangle r;`
- Constructor ex:
```C++
Rectangle::Rectangle()
{
	width = 0.0;
	length = 0.0;
}
```
  
# 13.8
## Passing Arguments to Constructors
- To create a constructor that takes arguments:
    - Indicate parameters in prototype:
        - `Rectangle(double, double);`
    - Use parameters in the definition
        - `Rectangle::Rectangle(double w, double len)`
        - `{width = w;`
        - `length = len;}`
- You can pass arguments to the constructor when you create an object:
    - `Rectangle r(10, 5);`
### More About Default Constructors
- If all of a constructor’s parameters have default arguments, then it is a default constructor. For example:
    - `Rectangle(double = 0, double = 0);`
- Creating an object and passing no arguments will cause this constructor to execute:
    - `Rectangle r;`
### Classes with No Default Constructor
- When all of a class’s constructors require arguments, then the class has no default constructor
- When this is the case, you must pass the required arguments to the constructor when creating an object
  
# 13.10
## Overloading Constructors
- A class can have more than one constructor
- Overloaded constructors in a class must have different parameter lists:
```C++
Rectangle();
Rectangle(double);
Rectangle(double, double);
```
### Constructor Delegation
- Sometimes a class will have multiple constructors that perform a similar set of steps. For example, look at the following `Contact` class:
![[image 1 7.png|image 1 7.png]]
- Both constructors perform a similar operation: They assign values to the name, email, and phone member variables
- The default constructor assigns empty strings to the members, and the parameterized constructor assigns specified values to the members
- In C++ 11, it is possible for one constructor to call another constructor in the same class
- This is known as _constructor delegation_
## Destructors
- Member function automatically called when an object is destroyed
- Destructor name is `~classname`
    - ex `~Rectangle`
- Has no return type; takes no arguments
- Only one destructor per class, _i.e._, it cannot be overloaded
- If constructor allocates dynamic memory, destructor should release it
### Only One Default Constructor and One Destructor
- Do not provide more than one default constructor for a class: one that takes no arguments for all parameters
    - `Square();`
    - `Square(int = 0); //will not compile`
- Since a destructor takes no arguments, there can only be one destructor for a class
### Member Function Overloading
- Non-constructor member functions can also be overloaded:
    - `void setCost(double);`
    - `void setCost(char *);`
- Must have unique parameter lists as for constructors
## Exceptions
- Indicate that something unexpected has occurred or been detected
- Allow program to deal with the problem in a controlled manner
- Can be as simple or complex as program design requires
### Terminology
- Exception: Object or value that signals an error
- Throw an exception: Send a signal that an error has occurred
- Catch/Handle an expression:
- `throw` - followed by an argument, is used to throw
- `try` - followed by a block `{}` , is used to invoke code that throws an exception
- `catch` - followed by a block, is used to detect and process exceptions thrown in preceding try block. Takes a parameter that matches the type thrown
### Flow of Control
1. A function that throws an exception is called from within a try block
2. If function throws exception, function terminates and the try block is immediately exited. Catch block to process the exception is searched for in the source code immediately following the try block
3. If a catch block is found that matches the exception thrown, it is executed. If no catch block that matches the exception is found, the program terminates
![[image 2 6.png|image 2 6.png]]
- What if no exception is thrown
![[image 3 5.png|image 3 5.png]]
### Exceptions - Notes
- Predefined function such as `new` may throw exceptions
- The value that is thrown does not need to be used in `catch` block
    - In this case, no name is needed in catch parameter definition
    - `catch` block parameter definition does need the type of exception being caught
### Exception Not Caught?
- An exception will not be caught if
    - It is thrown from outside of a `try` block
    - There is no `catch` block that matches the data type of the thrown exception
- If an exception is not caught, the program will terminate
### What Happens After `catch` Block?
- Once an exception is thrown, the program cannot return to throw point. The function executing `throw` terminates (does not return), other calling functions in `try` block terminate, resulting in unwinding the stack
- If objects were created in the `try` block and an exception is thrown, they are destroyed
### Nested `try` Blocks
- `try/catch` blocks can occur within an enclosing `try` block
- Exceptions caught at an inner level can be passed up to a `catch` block at an outer level:
```C++
catch ()
{
	...
	throw; //pass exception up to next level
}
```
### Exceptions and Objects
- An exception class can be defined in a class and thrown as an exception by a member function
- An exception class may have:
    - no members: used only to signal an error
    - members: pass error data to `catch` block
- A class can have more than one exception class