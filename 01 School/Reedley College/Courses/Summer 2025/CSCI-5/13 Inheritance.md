---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-06-16
---
```table-of-contents
```
---
# What is Inheritance?
- Inheritance is a simple but powerful tool of object oriented languages that allows classes to inherit methods and fields from other classes
- Inherit means to receive or obtain something from your predecessor or parent
- In Java, the concept of inheritance is similar to genetics
	- Genes and genetic traits are passed down from parent to child
	- Children often look and act like their parents as a result

# Superclass Versus Subclass
- Classes can derive from or evolve out of parent classes, which means they contain the same methods and fields as their parents, but can be considered a more specialized form of their parent class
- The difference between a subclass and a superclass is as follows:

| **Superclass**                                                                | **Subclass**                                                                         |
| ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------------ |
| The more general class from which other classes derive their methods and data | The more specific class that derives or inherits from another class (the superclass) |
- Superclasses contain methods and fields that are passed down to all of their subclasses
- Subclasses:
	- Inherit methods and fields of their superclasses
	- May define additional methods or fields that the superclass does not have

# Inheritance Example
- Create a Shape class with a variable, color, and one method which returns the color
	- Create a Rectangle class which inherits the variable and method from Shape, and can have its own methods and variables
```
Shape (superclass)
	public String color
	public String getColor

Rectangle (subclass)
	public String color
	public String getColor() //FROM SUPERCLASS

	//Rectangle-only data
	public int length
	public int width
	public int getLength()
	public int getWidth()
```

# extends Keyword
- In Java, you have the choice of which classes you want to inherit from by using the keyword extend
- The keyword extend allows you to designate the superclass that has methods you want to inherit, or whose methods and data you want to extend
- For example, to inherit from the Shape class, use extends when the Rectangle class is created
```java
public class Rectangle extends Shape {
	// code
} // end class Rectangle
```
## extends Keyword Example
- We want the Crab class to extend the methods and data in Animal and inherit methods like move(), turn(), etc.
	- Because the Animal class is extended, you can call the move() and turn() methods even though they do not appear within the Crab class code
```java
public class Crab extends Animal {
	public void act() {
		move(1);
		turn(90);
	}//end method act
}// end class Crab
```

# The Rule of Single Inheritance
- Single inheritance means that you cannot declare or extend more than one superclass per class
- The following code will not compile:
```java
public class Crab extends Animal, Crustacean, ...
```
## Extending More than One Class
- Why can't we extend more than one class?
	- Since superclasses pass down their methods and data to all of their subclasses and the subclasses of their subclasses, it isn't really necessary to extend more than one class

# More About Inheritance
- Inheritance is a one way street
	- Subclasses inherit from superclasses, but superclasses cannot access or inherit methods and data from their subclasses
	- This is just like how parents don't inherit genetic traits like hair color or eye color from their children

# Object: The Highest Superclass
- Every superclass implicitly extends the class Object
- Object:
	- Is considered the highest and most general component of any hierarchy
	- It is the only class that does not have a superclass
	- Contains very general methods which every class inherits
## Object Example 1
- Object contains methods that can be used on every class (such as toString(), or equals())
- For example, after you create a class and construct an instance of it, can you call the method toString() on your object?
```java
A_Class class = new A_class();
class.toString();
```
- Yes
	- Even though you did not write the method toString(), it is still legal for you to call this method because it was inherited from Object
## Object Example 2
- Is class.toString() legal if A_Class explicitly extends Another_Class, a superclass?
- Yes
- This is also legal since the superclass of A_Class extends Object

# Why Use Inheritance?
- The central benefit to inheritance is code reuse
- Inheriting methods from a superclass gives your class access to the code and data of the superclass
- You will not have to write the code twice, which saves you time and optimizes your code
- Also, fewer bugs occur

# Inheritance Hierarchies
- In many situations, it's common to classify concepts as hierarchies
	- A hierarchy is a way of categorizing the relationship among ideas, concepts or things with the most general or all-encompassing component at the top and the more specific, or the component with the narrowest scope, at the bottom
	- Hierarchies are a useful concept when it comes to inheritance and can be used to model an organize the relationship among superclass and subclass
## Tree Diagrams
- Hierarchies can be organized into tree diagrams
	- Computer scientists will often refer to trees having leaves and branches, or will refer to the "leaves" as nodes
	- For example, shapes can be categorized by different properties, such as their number of sides
![[Pasted image 20250616100345.png|550]]
- Notice that Circle, Triangle, and Rectangle all have a different number of sides, so they are different branches in the tree
- Only nodes with the same properties will occupy the same branch
### Type of Parent Nodes
- Anything below a node on the tree is a type of parent node
- We know that Square is a type of Rectangle
- Triangle, Rectangle, and Circle are all types of shapes
## "Is-a"
- With class hierarchies, you can use the phrase "is-a" to describe a hierarchical relationship
- A node on a branch can be thought of as the same type as the node on the root
- Example: A Rectangle "is-a" Shape, since it has all of the properties of a shape
- To model relationships among classes, we use UML
# Unified Modeling Language: UML
- Computer scientists model inheritance hierarchies using a modeling language called Unified Modeling Language, or UML
- UML is a ways of describing the relationships among classes in a system, or graphical representation of a system
- UML was developed by Grady Booch, James Rumbaugh, and Ivar Jacobson, and is standardized so it can be understood across languages
## Basic Components of UML
- Inheritance hierarchies can be modeled simply with UML
- A few simple components are required to start:
	- Class diagram:
		- Shows the name of the class, and any important data or methods within the class
	- Arrows and lines:
		- Show one class's relationship to other classes
## Class Diagram in UML
- A class can be drawn as a box that contains the class name, instance variables, and methods
- Classes can also be drawn as simple boxes with just the class name, although including methods is helpful
- It is not necessary to include every attribute or those that represent collections of data (such as arrays) Include only the most helpful attributes
![[Pasted image 20250616101146.png|450]]
## More Details About UML
- UML is a helpful tool for you to plan out how to organize multilevel class hierarchies
- You are encouraged to use UML for coding projects
- [More on UML](http://www.oracle.com/technetwork/developer-tools/jdev/gettingstartedwithumlclassmodeling-130316.pdf)
## Showing Inheritance in UML
- Class diagrams are connected using lines with arrows
- Connecting lines vary depending on the relationship among classes
- For inheritance, a solid line and a triangular arrow are used to represent the "is-a" relationship
![[Pasted image 20250616101433.png|500]]
![[Pasted image 20250616101458.png|400]]

# Encapsulation
- Encapsulation is a fundamental concept in object oriented programming
## How Encapsulation Works
- In object-oriented programming, encapsulation encloses, or wraps, the internal working of a Java instance/ object
- Data variables, or fields, are hidden from the user of the object
- Methods can provide access to the private  data or work with the data, but methods hide the implementation
- Encapsulating you data prevents it from being modified by the user or other classes so that the data is not corrupted
## How Encapsulation is Used
- Encapsulation can be used to protect sensitive data, such as personal information, by preventing the data from being changed, except within the scope of the class itself
- Data is protected and implementation is hidden by declaring access modifiers on variables and methods
- Access modifiers (public, private, protected, "default") are keywords that determine whether or not other classes can access the data or methods of the class

# Access Modifiers
- Programmers can customize the visibility of their data and methods with several levels of access modifiers

| **Access Modifier** | **Accessed by:**                                                                                  |
| ------------------- | ------------------------------------------------------------------------------------------------- |
| `public`            | Any class in any package                                                                          |
| `private`           | Only to other methods within the class itself                                                     |
| `protected`         | All subclasses and all classes in the same package                                                |
| "default"           | Any class in the package<br>Actually when no keyword is specified<br>The word default is NOT used |
## Declaring Access Modifiers (SLIDE 36)
---
# References
1. 