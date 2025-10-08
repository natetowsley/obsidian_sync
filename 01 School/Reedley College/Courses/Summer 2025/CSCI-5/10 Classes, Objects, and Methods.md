---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
  - ComputerScience/OOP
Date Created: 2025-06-09
---
```table-of-contents
```
---
# Creating a Class Template
- Programmers can create their own classes
- Classes are essentially a template or blueprint for all instances of the class
- The class code also communicates to the compiler how to define, create, and interact with objects of the class
## Class Template Example
```java
public class Vehicle {
	// The vehicle class has two fields
	private String make;
	private int milesPerGallon;
	// constructor
	public Vehicle() {
	} // end constructor
	//mutator/setter methods
	public void setMake(String m) {
		make = m;
	} // end method make
	public int getMilesPerGallon() {
		return milesPerGallon;
	} // end method milesPerGallon
} // end class Vehicle
```

# Creating an Instance of a Class
- Once you have created a class, you can create instances of the class (objects) in a Driver Class or inside other Object Classes
- Instances:
	- Inherit all attributes and methods defined in the class template
	- Interact independently of one another
	- Are reference objects
	- Are created using the new operator
## Instantiate an Instance
- To instantiate an instance of Vehicle called myCar, write:
```java
public class VehicleTester{
	public static void main(String[] args) {
		Vehicle myCar = new Vehicle();
	} // end method main
} // end class VehicleTester
```

# Constructors
- Constructors are methods that allow the user to create instances of (instantiate) a class
- Good programming practice dictates that classes should have a default constructor
- Constructors which contain parameters typically initialize the private variables of the class to values passed in by the user
- Constructors do not have a return type (void)
- Java has garbage collection, and therefor has no destructors
## Default Constructor
- Good programming practice dictates that classes should have a default constructor
- A default constructor:
	- Takes no parameters
	- Typically initializes all private variables to base values
```java
public Vehicle() {
	make = "";
	milesPerGallon = 0;
} // end constructor
```
## Constructor with Parameters
- A constructor with parameters is used when you want to initialize the private variables to values other than the default values
```java
public Vehicle(String m, int mpg) { // <-- parameters
	make = m;
	milesPerGallon = mpg;
} // end constructor
```
## Instantiate Vehicle Instance
- To instantiate a Vehicle instance using the constructor with parameters, use arguments:
```java
Vehicle myCar = new Vehicle("Toyota", 30);
```
- To instantiate a Vehicle Instance using the default constructor, write:
```java
Vehicle myCar = new Vehicle();
```

# Defining Methods
- A method is a block of code which is referred to by name and can be called at any point in a program simply by utilizing the method's name
- There are four main parts to defining your own method:
	- Access modifier (public, private, protected, default)
	- Return type
	- Method name
	- Parameter(s)
```java
public returnType methodName(Parameter p, ...) {
	/*code that will execute with each call to the method goes here*/
}
```
## Components of a Method
- Method components include:
	- Return type:
		- This identifies what type of object, if any, will be returned when the method is invoked (called)
		- If nothing will be returned, the return type is declared as void
	- Method name:
		- Used to make a call to the method
	- Parameter(s):
		- The programmer may choose to include parameters depending on the purpose and function of the method
		- Parameters can be of any primitive or type of object, but the parameter type used when calling the method must match the parameter type specified in the method definition
### Method Components Example
```java
public String getName(String firstName, String lastName){
//return type^.  ^name of method     ^^^^parameters
	return (firstName + " " + lastName);
} //end method getName
```

# Class Methods
- Every class will have a set of methods associated with it which allow functionality for the class
- Accessor method
	- "getter"
	- Returns the value of a specific private variable
- Mutator method
	- "setter"
	- Changes or sets the value of a specific private variable
- Functional method
	- Returns or performs some sort of functionality for the class
## Accessor Methods
- Accessor methods access and return the value of a specific private variable of the class
- Non-void return type corresponds to the data type of the variable you are accessing
- Include a return statement
- Usually have no parameters
```java
public String getMake() {
	return make;
} //end method getMake

public int getMilesPerGallon() {
	return milesPerGallon;
} //end method getMilesPerGallon
```
## Mutator Methods
- Mutator methods set or modify the value of a specified private variable of the class
- Void return type
- Parameter with a type that corresponds to the type of the variable being set
```java
public void setMake(String m) {
	make = m;
} //end method setMake

public void setMilesPerGallon(int mpg) {
	milesPerGallon = mpg;
} //end method setMilesPerGallon
```
## Functional Methods
- Functional methods perform a functionality for the class
- Void or non-void return type
- Parameters are optional and used depending on what is needed for the method's function
- Below is a functional method for the class Vehicle that compares two vehicles and returns an int value for the comparison
```java
/* Compares the miles per gallon of each vehicle passed in, returns 0 if they are the same, 1 if the first vehicle is larger than the second and -1 if the second vehicle is larger than the first*/

public int compareTo(Vehicle v1, Vehicle v2) {
	if (v1.getMilesPerGallon() == v2.getMilesPerGallon())
		return 0;
	else if (v1.getMilesPerGallon() > v2.getMilesPerGallon())
		return 1;
	else 
		return -1;
} //end method compareTo
```

## Using Constructors and Methods in a Driver Class main Method Example
```java
public class VehicleTester{
	public static void main(String[] args) {
		Vehicle v;
		v = new Vehicle();
		v.setMake("Ford");
		v.setMilesPerGallon(35);
		
		System.out.print("My "+v.getMake()
						 + " gets " + v.getMilesPerGallon()
						 + " mpg.");
	} // end method main
} //end class VehicleTester
```

# this Reference
- Within an instance method or a constructor, `this` is a reference to the current object
- The reference to the object whose method or constructor is being called
- Refer to any member of the current object by using this
- Most commonly used when a field is shadowed by a method or constructor parameter of the same name
## Example
- When a method argument "shadows" a field of the object, the `this` reference is used to differentiate the local scope from the class scope
```java
public class Point {
	private int x;
	private int y;

	//constructor
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	} //end constructor
} //end class Point
```

# Card Class Example
- Consider a standard deck of playing cards
- To represent each card as an instance of a Card class, what attributes would the class need to have?
	- Suit
	- Name
	- Points
```java
public class Card {
	private String suit;
	private String name;
	private int points;
}//end class Card
```
## Reference Object Representation
- When creating a new instance of an object, a reference is made to the object in memory
- The reference points to the object
- All attribute variables are created and initialized based on the constructor used
```java
Card c = new Card(); //suit = null | name = null | points = 0
```

# Understanding Garbage Collection
- Consider the following code
```java
Card c = new Card("Diamonds", "Four", 4);
Card c2 = new Card("Spades", "Ace", 1);
c2 = c;
```
- When executed, c2 = c; takes the reference c2 and makes it reference the same object as c
- This effectively renders the original object c2 useless, and garbage collection takes care of it by removing it from memory
# Finalizers
- A finalizer is code called by the garbage collector when it determines no more references to the object exist
- All objects inherit a finalize() method from java.lang.Object
- This method takes no parameters and is written to perform no action when called
- Overriding the finalize() method in classes allows you to modify what happens before garbage collection, such as:
	- Notify the user about the garbage collection that is about to occur
	- Cleaning up non-Java resources, such as closing a file
## Finalize Method Example
- This example closes all associated files and notifies the user that the finalization occurs:
```java
protected void finalize() {
	try{
		close(); // close all files
	} //end try
	finally {
		System.out.println("Finalization has occured");
	} //end finally
} // end method finalize
```
---
# References
1. [[02 Object and Driver Classes]]