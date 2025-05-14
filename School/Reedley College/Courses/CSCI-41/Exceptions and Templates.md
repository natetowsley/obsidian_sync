---
Date Created: 2025-01-20T09:43
Favorite: false
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#16.2]]
    - [[#Function Templates]]
    - [[#Function Template Notes]]
- [[#16.3]]
    - [[#Where to Start when Defining Function Templates]]
- [[#16.4]]
    - [[#Class Templates]]
        - [[#Class Template Example]]
    - [[#Class Templates and Inheritance]]
---
# 16.2
## Function Templates
- **Function Template:** A pattern for a function that can work with many data types
- When written, parameters are substituted for the data types
- When called, compiler generates code for specific data types in function call
```C++
template <class T> //template prefix
			    //^^^generic data type
T times10(T num) //T is type parameter
{
	return 10 * num;
}
```
![[image 22.png|image 22.png]]
- Can define a template to use multiple data types:
    - `template<class T1, class T2>`
- Ex:
```C++
template<class T1, class T2>       //T1 and T2 will be replaced
double mpg(T1 miles, T2 gallons)   //in the called function with
{                                  //the data types of the arguments
	return miles / gallons;
}
```
- Function templates can be overloaded
    - Each template must have a unique parameter list
```C++
template <class T>
T sumAll (T num) ...
template <class T1, class T2>
T1 sumAll (T1 num1, T2 num2) ...
```
## Function Template Notes
- All data types specified in template prefix must be used in template definition
- Function calls must pass parameters for all data types specified in the template prefix
- Like regular functions, sunction templates must be defined before being called
- A function template is a pattern
- No actual code is generated until the function named in the template is called
- A function template uses no memory
- When passing a class object to a function template, ensure that all operators in the templat eare defined or overloaded in the class definition
# 16.3
## Where to Start when Defining Function Templates
- Templates are often appropriate for multiple functions that perform the same task with different parameter data types
- Develop function using usual data types first, then convert to a template
    - add template prefix
    - convert data type names in the function to a type parameter (i.e., a T type) in the template
  
# 16.4
## Class Templates
- Classes can also be represented by templates. When a class object is created, type information is supplied to define the data members of the class
- Unlike functions, classes are insantiated by supplying the type name (int, double, string, etc.) at object definition
### Class Template Example
```C++
template <class T>
class grade
{
	private:
		T score;
	public:
		grade(T);
		void setGrade(T);
		T getGrade()
};
```
- Pass type information to class template when defining objects:
    - `grade<int> testList[20];`
    - `grade<double> quizList[20];`
- Use as ordinary objects once defined
## Class Templates and Inheritance
- Class templates can inherit from other class templates:
```C++
template <class T>
class Rectangle
	{...};
template <class T>
class Square : public Rectangle<T>
	{...};
```
- Must use type parameter `T` everywhere base class name is used in derived class