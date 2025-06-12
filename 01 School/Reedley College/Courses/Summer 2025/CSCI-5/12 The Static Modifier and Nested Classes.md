---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-06-11
---
```table-of-contents
```
---
# Static Modifier
- Using instance variables, each instance of a class created with the keyword new creates a copy of all instance variables in that class
- For example, in the Employee class below, a unique copy of lastname and firstname is created for each new Employee object that is created in a Driver Class
```java
public class Employee {
	private String lastname;
	private String firstname;
		... // more code
} // end class Employee
//create two Employees in a main method
Employee e1 = new Employee("Smith", "Mary");
Employee e2 = new Employee("Jones", "Sally");
```
## Static Keyword
- Static is a keyword in Java that modifies the association of an item to a class
- Contents of a class that are identified as static are shared across all instances of the class
- This means all the instances of the class share one copy of the static items, and each have their own unique copies of instance items, or non-static items
## Static Example
- Consider initializing a static String with the value "Oracle" called myCompany that represents the employer's company
- Each instance of Employee would still have their unique instance variables, but would share the static variable
![[Pasted image 20250611220613.png|600]]
## Static Variables
- Static Variables:
	- Are also known as class variables
	- Are declared with the static keyword
	- Have only one copy in memory, as opposed to instance variables, which hold one copy per instance
	- Are shared by object instances
	- Hold the same value for all class instance
	- Public access for static variables:
		- If public, they can be modified directly by other classes
		- Consider making the variable a constant by using the keyword final to prevent modification
```java
public static final int MODEL_NUM = 883;
```
### Programming Practices & Static Variables
- Good programming practice initializes static variables with values, rather than relying on the default null and 0 values
- The values initially assigned can be changed as long as the class is active in JVM memory
- Garbage collection removes it from memory and the initial values assigned will return the next time you use it
### Declaring a Static Variable
- To declare a static variable, include the keyword static as shown below
	- Can be public, protected, or private
	- Should have assigned values, but automatically are assigned null values for class instances: an empty string or 0 for primitive numbers
	- Should act as constants with the final keyword when they use a public, protected, or default access
```java
public class Nesting {
	//declare public static variable
	public static final int MODEL_NUM = 883;
		...
} // end class nothing
```
### Changes to a Static Variable
- Static variables that are not final can be read or assigned new values by using the optional keyword this in instance methods
	- Changes by instance methods are changed for all instances
	- A change to a static variable may indicate that the class should be limited to only one object
	- This is known as the Singleton pattern
```java
private static String myCompany = "Oracle";
public void setMyCompany(String s) {
	this.myCompany = s;
} //end method myCompany
```
### Static Variable Example (SLIDE 12)
---
# References
1. 