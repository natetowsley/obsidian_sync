---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/OOP
Date Created:
---
```table-of-contents
```
---
# Inheritance Concepts
- Extending an existing class to make a new one
	- The new class "inherits" the fields (instance variables) and methods of the existing class
- Existing class is called the *super class*, *parent class*, or *base class*
- New class is called *sub class*, *child class*, or *derived class*
- Better code reuse, not copy paste, only one copy of code to debug/ maintain
- Allows us to **override** and change some of the methods
- Allows us to **extend** the class with new methods and instance variables
- This customizes the class for a new application
## Why?
- Effective reuse of code
- Extensibility
- Security
- Maintainability
- Flexibility

# Like Methods
- Methods reuse code
- Inheritance reuses, and allow modification of collections of methods
- **Extending** a class uses all the predefined methods of a class
- **Implementing** gives a template
- Example:
	- Have automated deli, have many sandwiches, wish to expand into offering Burgers
- Deli Sandwich class
```java
public class DeliSandwich {  
	//Integer rather than int because of containers.  
	private Integer slicesOfBread;  
	private String filling;  
	public DeliSandwich(Integer slicesOfBread, String filling) {  
		this.slicesOfBread = slicesOfBread;  
		this.filling = filling;  
	}  
	/**  
	* Using a StringBuilder because we will use a loop later...  
	* @return a String about sandwiches  
	*/  
	@Override  
	public String toString() {  
		StringBuilder sb = new StringBuilder();  
		sb.append("This sandwhich has ");  
		sb.append(filling);  
		sb.append(" between ");  
		sb.append(slicesOfBread);  
		sb.append(" slices of bread.");  
		return sb.toString();  
	}
}
```
- Burger subclass
```java
public class Burger extends DeliSandwich {
	public Burger() {
		this("Beef Patty");
	}
	public Burger(String filling) {
		super(2, filling);
	}
}
```
## What is `this` Doing?
-  The `this` Constructor
	- Within the definition of a constructor, `this` can be used to invoke another constructor in the same class
![[Pasted image 20250916103311.png|400]]
## What is `super` doing?
- The `super` keyword
	- The keyword `super` references members of the super class

# Rules
- To extend a class, we use the **extends** keyword
- All **public** and **protected** members and methods are inherited and directly accessible
	- Use getters and setters for private members
- Constructors are **NOT** inherited
- In constructors
	- `super` must be called before `this`
		- Except not in the latest version of Java
```java
public class Burger extends DeliSandwich {
	public Burger() {
		this("Beef Patty");
	}
	public Bruger(String filling) {
		super(2, filling);
	}
}
```
## Sample
- This is good, but can become better
```java
public class Restaurant {  
	public static void main(String[] args) {  
		List<DeliSandwich> menu = new ArrayList<>();  
		DeliSandwich sandwich = new DeliSandwich(2, "Ham and Cheese");  
		Burger burger = new Burger();  
		menu.add(sandwich);  
		menu.add(burger);  
		for(DeliSandwich s : menu){  
			System.out.println(s);  
		}  
	}  
}
```
- Would print 
	- This sandwich has Ham and Cheese between 2 slices of bread.  
	- This sandwich has Beef Patty between 2 slices of bread.
- We need to show that the burger is a burger, not a sandwich as printed above
- Below is better, but we can do more
```java
@Override  
public String toString() {  
	StringBuilder sb = new StringBuilder();  
	sb.append("This ").append(this.getClass().getName());  
	sb.append(" has ").append(filling);  
	sb.append(" between ");  
	sb.append(slicesOfBread);  
	sb.append(" slices of bread.");  
	return
}
```

# HashMap
- A HashMap<> is a generic container
	- Like an ArrayList<>
- A HashMap takes two types
	- a **Key** and a **Value**
```java
public class DeliSandwich {  
	//Integer rather than int because of containers.  
	private Integer slicesOfBread;  
	private HashMap<String, Integer> filling = new HashMap<>();  
	public DeliSandwich(Integer slicesOfBread, String filling) {  
		this.slicesOfBread = slicesOfBread;  
		this.filling.put(filling, 1);
	}
```
## Facts About HashMaps
- HashMaps can't use a primitive type as a key
	- `HashMap<int, Burger> hashmap = new HashMap<>();` <- INVALID
- HashMap has useful methods including:
	- KeySet
	- containsKey
	- containsValue
- If you put the same value twice, it gets overwritten
## New and Improved DeliSandwich
```java
private Integer slicesOfBread;  
private HashMap<String, Integer> fillings;  
public DeliSandwich(Integer slicesOfBread, HashMap<String,Integer>  
fillings) {  
	this.slicesOfBread = slicesOfBread;  
	this.fillings = fillings;  
}  
@Override  
public String toString() {  
	StringBuilder sb = new StringBuilder();  
	sb.append("This ").append(this.getClass().getName());  
	sb.append(" is ");  
	sb.append(slicesOfBread > 1 ? "Bread":"");  
	for (String key : fillings.keySet()){  
		sb.append(key).append("\n");  
	}  
	sb.append(" bread.");  
	return sb.toString();  
}
```

# (ASIDE) Don't Break Things
- When changing DeliSandwich to use a HashMap, you need to add a constructor to the parent
- If you ever change something, make sure you don't break existing functionality
- Unit testing helps with this

---
# References
1. 