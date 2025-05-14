---
Date Created: 2025-03-31T09:42
Favorite: false
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
Lecture 8: Inheritance & Abstract Classes
###### tags: #ComputerScience #DataStructuresAndAlgorithms 
# Table of Contents
- [[#Table of Contents]]
- [[#15.1]]
    - [[#What is Inheritance?]]
        - [[#The “is a“ Relationship]]
        - [[#Inheritance - Terminology and Notation]]
        - [[#Back to the “is a” Relationship]]
        - [[#What Does a Child Have?]]
- [[#15.2]]
    - [[#Protected Members and Class Access]]
        - [[#Class Access Specifiers]]
- [[#15.3]]
    - [[#Constructors and Destructors in Base and Derived Classes]]
        - [[#Passing Arguments to Base Class Constructor]]
        - [[#Constructor Inheritance]]
- [[#15.4]]
    - [[#Redefining Base Class Functions]]
        - [[#Problem with Redefining]]
- [[#15.5]]
    - [[#Class Hierarchies]]
- [[#15.6]]
    - [[#Polymorphism and Virtual Member Functions]]
        - [[#Virtual Functions]]
        - [[#Polymorphism Requires References or Pointers]]
        - [[#Base Class Pointers]]
        - [[#Redefining vs. Overriding]]
        - [[#Virtual Destructors]]
        - [[#C++ 11’s override and final Key Words]]
- [[#15.7]]
    - [[#Abstract Base Classes and Pure Virtual Functions]]
- [[#15.8]]
    - [[#Multiple Inheritance]]
---
# 15.1
## What is Inheritance?
- Provides a way to create a new class from an existing class
- The new class is a specialized version of the existing class
**Example: Insects**
![[image 41.png|image 41.png]]
### The “is a“ Relationship
- Inheritance establishes an “is a” relationship between classes
    - A poodle is a dog
    - A car is a vehicle
    - A flower is a plant
    - A football player is an athlete
### Inheritance - Terminology and Notation
- **Base** class (or parent) - inherited from
- **Derived** class (or child) - inherits from the base class
- Notation:
```C++
class Student                     //base class
{ 
	...
};
class UnderGrad : public student  //derived class
{
	...
};
```
### Back to the “is a” Relationship
- An object of a derived class ‘is a(n)’ object of the base class
- Example:
    - An `UnderGrad` is a `Student`
    - A `Mammal` is an `Animal`
- A derived object has all of the characteristics of the base class
### What Does a Child Have?
- An object of the derived class has:
    - All members defined in child class
    - All members declared in parent class
- An object of the derived class can use:
    - All `public` members defined in child class
    - All `public` members defined in parent class
**Example**
- GradedActivity class has general characteristics
- FinalExam class derived from GradedActivity and adds specific attributes
    - Number of questions on exam
    - Number of points for each question
    - Number of questions missed
  
# 15.2
## Protected Members and Class Access
- **protected** member access specification: like `private`, but accessible by objects of derived class
- **Class Access Specification:** determines how `private`, `protected`, and `public` members of base class are inherited by the derived class
### Class Access Specifiers
1. `public` - object of derived class can be treated as obect of base class (not vice-versa)
2. `protected` - more restrictive that `public`, but allows derived classes to know details of parents
3. `private` - prevents objects of derived class from being treated as objects of base class
**Inheritance vs. Access**
![[image 1 26.png|image 1 26.png]]
  
# 15.3
## Constructors and Destructors in Base and Derived Classes
- Derived classes can have their own constructors and destructors
- When an object of a derived class is created, the base class’s constructor is executed first, followed by the derived class’s constructor
- When an object of a derived class is destroyed, its destructor is called first, then that of the base class
### Passing Arguments to Base Class Constructor
- Allows selection between multiple base class constructors
- Specify arguments to base constructor on derived constructor heading:
    - `Square::Square (int side) : Rectangle (side, side)`
- Can also be done with inline constructors
- Must be done if base class has no default constructor
![[image 2 24.png|image 2 24.png]]
### Constructor Inheritance
- In a derived class, some constructors can be inherited from the base class
- The constructors that _**cannot**_ be inherited are:
    - The default constructor
    - The copy constructor
    - The move constructor
- Consider the following:
```C++
class MyBase
{
private:
	int ival;
	double dval;
public:
	MyBase(int i)
	{ ival = i; }
	MyBase (double d)
	{ dval = d; }
};
```
```C++
class MyDerived : MyBase
{
public:
	MyDerived(int i) : MyBase(i)
	{}
	MyDerived(double d) : MyBase(d)
	{}
};
```
- We can rewrite the MyDerived class as:
```C++
class MyDerived : MyBase
{
	using MyBase::MyBase;
};
```
  
# 15.4
## Redefining Base Class Functions
- **Redefining function:** function in a derived class that has the same name and parameter list as a function in the base class
- Typically used to replace a function in base class with different actions in derived class
- Not the same as overloading - with overloading, parameter lists must be different
- Objects of base class use base class version of function; objects of derived class use derived class version of function
### Problem with Redefining
- Consider this situation:
    - Class `BaseClass` defined functions `x()` and `y()`. `x()` calls `y()`
    - Class `DerivedClass` inherits from `BaseClass` and redefines function `y()`
    - An object `D` of class `DerivedClass` is created and function `x()` is called
    - When `x()` is called, which `y()` is used, the one defined in `BaseClass` or the redefined one in `DerivedClass`?
![[image 3 23.png|image 3 23.png]]
  
# 15.5
## Class Hierarchies
- A base class can be derived from another base class
![[image 4 21.png|image 4 21.png]]
- Consider the GradedActivity, FinalExam, PassFailActivity, PassFailExam hierarchy in Chapter 15
![[image 5 21.png|image 5 21.png]]
  
# 15.6
## Polymorphism and Virtual Member Functions
- **Virtual Member Function:** Function in base class that expects to be redefined in derived class
- Function defined with key word `virtual`:
    - `virtual void Y() {...}`
- Supports **dynamic binding**: Functions bound at run time to function that they call
- Without virtual member functions, C++ uses **static (compile time) binding**
### Virtual Functions
- A virtual function is dynamically bound to calls at runtime
- At runtime, C++ determines the type of object making the call, and binds the function to the appropriate version of the function
- To make a function virtual, place the virtual key word before the return type in the base class’s declaration:
    - `virtual char getLetterGrade() const;`
- The compiler will not bind the function to calls, instead the program binds them at runtime
### Polymorphism Requires References or Pointers
- Polymorphic behavior is only possible when an object is reference by a reference variable or a pointer
### Base Class Pointers
- Can define a pointer to a base class object
- Can assign it the address of a derived class object
```C++
GradedActivity *exam = new PassFailExam(100, 25, 70.0);
cout << exam->getScore() << endl;
cout << exam->getLetterGrade() << endl;
```
- Base class pointers and references only know about members of the base calss
    - So, you can’t use a base class pointer to call a derived class function
```C++
GradedActivity *exam = new PassFailExam(100, 25, 70, 0);
cout << exam->getScore() << endl;        //This works
cout << exam->getLetterGrade() << endl;  //This also works
cout << exam->getPointsEach() << endl;   //ERROR! WONT WORK!
```
- Redefined functions in derived class will be ignored unless base class declares the function virtual
### Redefining vs. Overriding
- In C++, redefined functions are statically bound and overridden functions are dynamically bound
- So, a virtual function is overridden, and a non-virtual function is redefined
### Virtual Destructors
- It’s a good idea to make detructors virtual if the class could ever become a base class
- Otherwise, the compiler will perform static binding on the destructor if the class ever is derived from
### C++ 11’s `override` and `final` Key Words
- The `override` key word tells the compiler that the function is supposed to override a function in the base class
- When a member function is declared with the `final` key word, it cannot be overridden in a derived class
  
# 15.7
## Abstract Base Classes and Pure Virtual Functions
- **Pure Virtual Function:** A virtual member function that must be overridden in a derived class that has objects
- Abstract base class contains at least one pure virtual function:
    - `virtual void Y() = 0;`
- The `= 0` indicates a pure virtual function
- Must have no function definition in the base class
- **Abstract base class:** class that can have no objects
    - Serves as a basis for derived classes that may/will have objects
- A class becomes an abstract base class when one or more of its member functions is a pure virtual function
  
# 15.8
## Multiple Inheritance
- A derived class can have more than one base class
- Each base class can have its own access specification in derived class’ definition
![[image 6 18.png|image 6 18.png]]
- Arguments can be passed to both base classes’ constructors:
```C++
cube::cube(int side); : square (side), rectSolid(side, side, side);
```
- Base class constructors are called in order given in class declaration, not in order used in class constructor
- Problem: what if the base classes have member variables/ functions with the same name?
- Solutions:
    - Derived class redefines the multiply-defined function
    - Derived class invokes member function in a particular base class using scope resolution operator `::`
- Compiler errors occur if derived class uses base class function without one of these solutions