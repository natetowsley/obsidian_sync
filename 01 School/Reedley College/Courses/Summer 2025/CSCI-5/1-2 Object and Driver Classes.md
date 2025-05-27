---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
Date Created:
---
---
# General Java Program Form
- There are two general forms of Java classes:
	- Driver classes
	- Object classes
## Driver Classes
- Driver classes:
	- Contain a main method
		- A main method is necessary to run a Java program
		- The main method may include:
			- Instances of objects from an object class
			- Variables
			- Loops, conditional statements (if/else)
			- Other programming logic
	- Can also contain other static methods
## Object Classes
- Object classes:
	- Are classes that define objects to be used in a driver class
	- Can be found in the Java API, or created by you
		- The Java API is a library of packages and object classes that are already written and are available for use in your programs
	- Examples: String, BankAccount, Student, Rectangle

# The Java API
- The Java API documentation is located here:
>https://docs.oracle.com/en/java/javase/18/docs/api/allclasses-index.html
## The Java API: String Class
- The constructor that is most common for this class is:
	- String(String original)
- Common Methods include:

| **Method**                | **Description**                                         |
| ------------------------- | ------------------------------------------------------- |
| charAt(int index)         | Returns the char value at the specified index           |
| length()                  | Returns the length of this string                       |
| substring(int beginIndex) | Returns a new string that is a substring of this string |
# A Simple Programmer-Created Object Class: Student
- A Java class is used to store or represent data for the object that the class represents
- There are many classes already available from the Java API, but you will want to create many more
- For example, we can create a model, or programmatic representation, of a Student
	- Information that we might need for a student includes Student ID, Name, and GPA
- All Java classes are created in a text file with the same name as the class
	- These files also have a .java extension
# CONTINUE ON SLIDE 13
---
# References
1. 