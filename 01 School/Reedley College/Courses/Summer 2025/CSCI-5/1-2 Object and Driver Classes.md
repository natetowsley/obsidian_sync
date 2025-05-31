---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
  - ComputerScience
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
- The following is example syntax to create a programmer-created object class
- The Java keywords are:
	- package (optional)
	- import (optional)
	- public class
![[Pasted image 20250528162755.png|500]]
- In the example below, a Student class and a Teacher class could be found in a folder under the domain name for each developer
- If a company called Acme has developers named Smith and Jones, the packages would be:
	- package com.acme.smith
	- package com.acme.jones
- The path for Jones' file is shown below
![[Pasted image 20250528180917.png|400]]![[Pasted image 20250528180942.png|400]]
# Key Terms

| **Term**                                                      | **Definition**                                                                                                                                                                                                                                         |
| ------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| package keyword                                               | - Defines where this class lives relative to other classes, and provides a level of access control<br>- Use access modifiers (such as public and private) to control access                                                                            |
| import keyword                                                | - Defines other classes or groups of classes that you are using in you class<br>- The import statement provides the compiler information that identifies outside clases used within the current class                                                  |
| class keyword                                                 | - Precedes the name of the class<br>- The name of the class and the file name must match when the class is declared public (which is a good practice)<br>- However, the keyword public in front of the class keyword is a modifier and is not required |
| class variables or instance fields(often shortened to fields) | - Variables, or the data associated with programs (such as integers, strings, arrays, and references to other objects)                                                                                                                                 |
| Constructors                                                  | - Methods called during the creation (instantiation) of an object (a representation in memory of a Java class)                                                                                                                                         |
| Methods                                                       | - Methods that can be performed on an object<br>- They are also referred to as instance methods<br>- Methods may return an object's variable values (sometimes called functions) or the may change an object's variable values                         |
# Java Keywords
- All Java programs use Java keywords
- Examples include the following
	- class
	- public
	- String
	- int
	- for
	- while
	- double
- The font color for Keywords will change in your Java IDE
- List of Java keywords:
	- https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html

# Java Program Naming Conventions
- Naming Conventions for a Java program:
	- The optional package name is defined before an import statement in lower camel case
	- The optional import statements are defined below the package name
	- The class name is a noun labeled using upper camel case
## Additional Naming Conventions for a Java Program
- Variable names are short but meaningful in lower camel case
- Constant names are declared in uppercase letters with the final modifier
- Constructors are named the same as the class name
- Methods and verbs named in lower camel case
EX:
![[Pasted image 20250528163943.png|500]]

# Import Keyword
- An import statement is not required, and by default, your class always imports java.lang from the API
- You do not need to import classes that are in the same package as the import statement
## Import Statement Examples
![[Pasted image 20250528181327.png|700]]

# Variables for Student Class
- In addition to the package statement and import statements, the Student class will contain variables for student ID, name, social security number, grade point average, and school code
- This will require defining a class with variables and a constructor
- In addition, methods will be added that can access and change the variables

# The Student Class
![[Pasted image 20250528181600.png]]
## Conventions for the Class Declaration
- Class declaration conventions:
	- The name must begin with a character, and may contain numbers, `_` or `$`
	- Use upper camel case if the name is more than one word
	- For a simple programmer-created object class, the access modifier should be public (all access modifiers are either public, private, or protected)
## Conventions for the Class Variables
- Class variable conventions:
	- Class variables should be declared with the private access modifier to protect the data
	- Class variables are named using lower camel case
	- An exception is a constant (a value that does not change) that should be names using upper case, and declared as public to allow driver programs to access the value
### Class Variable Declaration Examples
- Examples of declaring class variables:
```java
private int length;
private int width;
private double area;
public final double SCALE = 0.25;
private String name;
```
## Constructor Methods
- A constructor method is unique in Java because:
	- The method creates an instance of the class
	- Constructors always have the same name as the class and do not declare a return type
- Constructors are invoked using the new keyword
- Example of code that could be used in a Driver Class to create an object from the Student constructor
```java
Student stu = new Student();
```
- With constructor methods:
	- You can declare more than one constructor in a class declaration
	- You do not have to declare a constructor, in fact, Java will provide a default (blank) constructor for you
	- If you declare one or more constructors, Java will not provide a default constructor
```java
public Student() {
// all code for this method must be enclosed in a set of curly brackets {}
}
```
### Constructors Without Parameters
- If you create a constructor without parameters, you can leave the contents of the constructor blank (seen above)
- This is called a default constructor, and is the same as the Java-provided constructor if you do not declare one
- This constructor initializes the numeric class variables to zero, and object variables (such as Strings) to null
- You can also initialize the variables between the { and } (seen below)
![[Pasted image 20250528182917.png|500]]
### Constructors With Parameters
- If you create a constructor with parameters, you will also initialize the variables between the { and }
- This constructor will initialize the class variables with the values that are sent in from the main driver class
![[Pasted image 20250528183102.png|500]]
### Default Constructor Example
- The constructor method in this example is a default constructor that creates an instance of Student
![[Pasted image 20250528183227.png|600]]
- The Student example illustrates a simple no-argument constructor
- The value returned from the constructor is a reference to a Java object of the type created

# Main Method
- To run a Java program you must define a main method in a driver class
- The main method is automatically called when the class is called
- Remember to name the file that same as the class
## A Simple Programmer-Created Driver Class: StudentTester
- Below is an example of a simple Java driver class named StudentTester with a main method
```java
public class StudentTester {
	public static void main(String args[]) {
	} // end method main
} // end class StudentTester
```

# Accessor and Mutator Methods
- It is common to create a set of methods that manipulate and retrieve class data values:
	- Accessors (getters):
		- Methods that return (get) the value of each class variable
	- Mutators (setters):
		- Methods that change (set) the value of each class variable
## Examples in Student Object Class
- Accessor methods:
	- getStudentID()
	- getName()
	- getSSN()
	- getGPA()
- Mutator methods:
	- setStudentID()
	- setName()
	- setSSN()
	- setGPA()
---
# References
1. 