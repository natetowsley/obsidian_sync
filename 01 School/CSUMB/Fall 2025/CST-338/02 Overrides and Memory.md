---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/Java
Date Created:
---
```table-of-contents
```
---
# Don't Use == to Compare Objects
- == compares memory
- Often times we actually want to compare content
## Why Doesn't == Work with Objects?
- Objects posses several methods that all objects inherit
	- toString
	- Equals
	- hashCode
	- clone
	- and more

# Equals Method
```java
@Override
public boolean equals(Object o) {
	if (this == 0) {
		return true;
	}
	if (o == nul || getClass() != o.getClass()) {
		return false;
	}
	
	Answer answer = (Answer) o;
	
	return value == answer.value;
}
```

```java
public class Answer {
	int value;
	public Answer() {
		value = 42;
	}
	
	public static void main(String[] args) {
		Answer answer = new Answer();
		Answer answer2 = new Answer();
		System.out.println(answer.equals(answer2));
	}
	
	@Override
	public boolean equals(Object o) {...}
	
	@Override
	public int hashCode() {return value;}
}
```

## What Happens when we Print an Object?
- When an object is printed out, the name followed by the memory address of the object is printed
	- It is actually a hashcode that is used in a lookup table, so it approximates a memory address

# Comparing Objects
- When an object is directly assigned to a previously instantiated object, they will have equal memory addresses, and == will return true
```java
MyObject o1 = new MyObject();
MyObjecet o2 = o1;
// o1 == o2 -> true
```

# @Override
- @Override is an **annotation**
	- like @Test
- It is telling the interpreter that we are implementing out own version of an inherited method
- Inheritance refers to two things
	- Extending a class
	- Implementing an interface

# New UML
- Arrows in UML diagrams point to parent classes of some class
	- Solid means extends
	- Dotted means implements
	- MyObject is a subclass of Parent
![[Pasted image 20250909112242.png|400]]

# What does Inheritance Mean?
- Inheritance is a method by which one class can access all the **public** or **protected** methods and fields of a parent object
- Additionally, all objects can be grouped by their parent
- Bottom Line:
	- Inheritance lets use re-use code in a meaningful way
- 
---
# References
1. 