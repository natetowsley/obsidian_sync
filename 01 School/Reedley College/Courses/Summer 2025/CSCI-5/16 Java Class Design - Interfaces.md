---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created:
---
```table-of-contents
```
---
# Classes
- A java class is a template/ blueprint that defines the features of an object
- A class can be though of as a category used to define groups of things
- Classes:
	- Declare fields
	- Define implement methods
	- Implement methods from implemented interfaces
```java
public class Dog {
	// instance field declarations
	private String name;
	private String breed;
	private String barkNoise = "Woof";
	private double weight;
} // end class Dog
```

# Objects
- An object is an instance of a class
- A program may have many objects
- An object stores data in the fields to give it state
- This state will differentiate it from other objects of the same class

| **Name**       | Bailey   |
| -------------- | -------- |
| **Breed**      | Boerboel |
| **Bark Noise** | arf-arf  |
| **Weight**     | 80.2     |

```java
public Dog(String name, String breed, String noise, double weight, String color) {
	super(breed, color);
	this.name = name;
	barkNoise = noise;
	this.weight = weight;
} //end constructor method
```

# What Classes Can and Cannot Do
- Classes can be instantiated by:
	- A public or protected constructor
	- A public or protected static method or nested class
- Classes cannot:
	- Override inherited methods when the method is final

# Immutable Objects
- Immutable objects have a number of advantages in certain circumstances
	- As they are immutable then we know their state cannot be changed which means they are always consistent
	- Making a class final does not on its own make it immutable, but it does stop it being subclassed and its methods overridden
	- Eliminating any methods that change instance variables would be required to make an object truly immutable
## When Classes Can be Subclassed or Made Immutable
- A class can be subclassed when:
	- The class is not declared final
	- The methods are public or protected
- Strategy for making a class immutable:
	- Make it final
	- Limit instantiation to the class constructors
	- Eliminate any methods that change instance fields
	- Make all fields final and private
## Immutable Using Final
- Declaring a class as final means that it cannot be extended
- Example: You may have a class that has a method to allow users to login by using some secure call
	- You would not want someone to later extend it and remove the security
```java
public final class ImmutableClass {
	public static boolean logOn(String username, String password) {
		//call to private boolean method
		return someSecureAuthentication(username, password);
	}//end method logOn
	.
	.
}//end class ImmutableClass
```
## Immutable by Limiting Instantiation to the Class Constructor
- By removing any method that changes instance fields and limiting their setting to the constructor, the class fields will automatically be made immutable
- Example: When instance of the ImmutableClass is created, the `immutableInt` field cannot be changed
```java
public final class ImmutableClass{
	private final int immutableInt;
	public ImmutableClass (int mutableIntIn) {
		immutableInt = mutableIntIn;
	}//end constructor method
	private int getImutableInt() {
		return immutableInt;
	}//end method getImutableInt
}//end class ImmutableClass
```

# Interface
- An interface is a Java construct that helps define the roles that an object must assume
- You create an interface using the interface keyword instead of that class keyword
- An interface looks like a class with abstract methods (no implementation code for the method), but we cannot create an instance of it
- An interface does not have a constructor method
- It is implemented by a class (using the keyword `implements`) or extended by another interface
- Interfaces define collections of related methods without providing the implementation
- All methods in a Java interface are abstract
## Why Use Interfaces
- When implementing a class from an interface we force it to implement all the abstract methods
	- The interface forces separation of what a class can do, to how it actually does it
	- A programmer can change how something is done at any point, without changing the function of the class
	- This facilitates the idea of polymorphism as the methods described in the interface will be implemented by all classes that implement the interface
- An interface:
	- Can declare public constants
	- Define methods without implementation
	- Can only refer to its constants and defined methods
	- Can be used with the instance of operator
- While a class can only inherit from a single superclass
```java
public class ClassName extends Superclass {
	//class implementation
} //end class ClassName
```
- A class can implement from one interface
```java
public class ClassName implements InterfaceName {
	//class implementation
}//end class ClassName
```
- A class can implement from more than one interface
```java
public class ClassName implements InterfaceName, InterfaceName2 {
	//class implementation
}//end class ClassName
```
## Interface Method
- An inheritance method:
- Each method is public even when you forget to declare it as public
```java
void getName();

public void getName(); //Both equivalent in an interface
```
- Is implicitly abstract but you can also use the abstract keyword
## Declaring an Interface Example
1. To declare a class as an interface you must replace the keyword class with the keyword interface
2. This will declare your interface and forces all methods to be abstract and make the default access modifier public
```java
abstract interface InterfaceBankAccount {
	public final String BANK = "JavaBank";

	public void deposit(int amt);
	public void withdraw(int amt);
	public int getBalance();
	public String getBankName();
}//end interface InterfaceBankAccount
```
## Implementing an Interface Example
```java
public class Account implements InterfaceBankAccount {
	public Account() {
	}//end constructor method
	public void deposit(int amt)
	{/* deposit code */}
	public void withdraw(int amt)
	{/* withdraw code */}
	public int getBalance()
	{/* getBalance code */}
	public String getBankName() {
		return InterfaceBankAccount.BANK;
	}//end method getBankName
}//end class Account
```
## Bank Example
- The keyword final means that the field BANK is a constant in the interface
- Only constants and method stubs can be defined in the interface
```java
public final String BANK = "JavaBank";
```
- Accessing a constant from an interface uses the same dot notation syntax as accessing a static field:
	- InterfaceName.fieldName
```java
public String getBankName() {
	return InterfaceBankAccount.BANK;
}//end method getBankName
```

```java
public void print() {
	System.out.println(getBankName()
						+ " " + accountName
						+ " " + accountNum
						+ " " + balance);
}//end method print
```

# A Store Example
- A store owner wants to create a website that displays all items in the store
- We know:
	- Each item has a name
	- Each item has a price
	- Each item is organized by department
- It would be in the store owner's best interest to create an interface for what defines an item
- This will serve as the blueprints for all items in the store, requiring all items to at least have the above defined qualities
## Adding a New Item to the Store Example
- The owner adds a new item to his store named cookie:
	- Each cookie costs between 1 and 3 US dollars
	- Cookies can be found in the Bakery department
	- Each cookie is identified by a type
- The owner may create a Cookie class that implements the Item interface such as shown on the next slide, adding methods or fields that are specific to cookies
## Item Interface
- Possible Item interface
```java
public interface Item {
	public String getItemName();
	public double getPrice();
	public void setPrice(double price);
	public String getDepartment();
}//end interface Item
```

---
# References
1. 