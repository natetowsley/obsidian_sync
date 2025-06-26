---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-06-23
---
```table-of-contents
```
---
# Modifying Existing Programs
- When you are programming in real world scenarios, such as for a company, you will often maintain and modify existing programs
- In many cases, the business problems you solve will be tied to existing programs authored by other programmers
- Being able to modify an existing program is a valuable skill you will need to apply in most programming roles
## Pre-Written Code Scenario
- Imagine a banking application
- What should a banking application do?
	- Allow a user to: Create an account, deposit in the account, withdraw from the account, display the account balance, and calculate interest
- What are the components of a banking application?
	- Accounts
- What should each component do?
	- Create, deposit, and withdraw
### Examining Pre-Written Code
- When you receive a program (such as JavaBank) and you are unfamiliar with the code, it is important that you experiment with the application as well as examining the underlying code
- Using the application allows the identification of changes and additional functionality that can be added
- Examining the application as well as the underlying code allows you to become familiar with how the application works
### Considerations When Examining Code
- When examining code, keep the following in mind:
- Look for comments in the code
```java
// Single line comments are preceded bny a double forward slash
/* Comments spanning more than one line are enclosed by backslashes and asterisks */
```
- Task: Identify the classes
	1. Examine each class and read the comments to gain an understanding of the program structure
### Techniques When Examining Code
- Here are some other techniques to try when reading code:
	- Re-run the application
	- Learn the high-level structure of the code and then find the point of entry and how it branches from there
	- Understand the constructs
	- Perform some testing
	- If you still have trouble understanding the code, ask someone else for their thoughts
	- Reach out to other programmers in a programmer's forum
# The Account Class
## Constructors in Account Class
- The default constructor sets:
	- Account Name to NULL (Empty)
	- Account Number to 0
	- Balance to 0
`Account()`
- The overloaded constructor takes values as parameters and sets these values to the instance of Account being created
`Account(String name, int num, int amt)`
## Methods in Account Class

| **Method**                                | **Description**                                                                      |
| ----------------------------------------- | ------------------------------------------------------------------------------------ |
| `public void deposit(int amt)`            | Updates the balance with a deposit amount                                            |
| `public void withdraw(int amt)`           | Updates the balance with a withdrawal amount                                         |
| `public void setAccountName(String name)` | Sets the account name value                                                          |
| `public void setAccountNum(int num)`      | Sets the account number value                                                        |
| `public void setBalance(int num)`         | Sets the account balance value                                                       |
| `public String getAccountName()`          | Returns the account name value                                                       |
| `public int getAccountNum()`              | Returns the account number value                                                     |
| `public int getBalance()`                 | Returns the account balance value                                                    |
| `public void print()`                     | Prints the instance fields values, this is included to accommodate isolation testing |

## Testing Classes in Isolation
- When you create a class, it is good practice to test the class independently before testing it within the application to detect problems in that code
	- This is known as isolation testing or unit testing
	- The main purpose of unit testing is to verify that an individual unit (a class, in Java) is working correctly before it is combined with other components in the system
- After creating the class, test it in isolation by creating a small program that calls the constructors, modifiers, and accessors
### Testing Classes in Isolation Example
```java
public class TestBank {
	public static void main(String[] args) {
		// Using constructor with values
		Account a1 = new Account("Sanjay Gupta", 11556, 300);
		Account a2 = new Account(); // Using default constructor
		Account a3 = new Account(); // Using default constructor
		//Set values of Instances created using default constructor
		a2.setAccountName("He Xai");
		a2.setAccountNum(22338);
		a2.setBalance(500);
		
		a3.setAccountName("Ilya Mustafana");
		a3.setAccountNum(44559);
		a3.setBalance(1000);
		
		//Print accounts
		a1.print();
		a2.print();
		a3.print();
	} // End method main
} // End class TestBank
```
## The Deposit Method
- This is the code for the deposit method from the Account class
```java
public void deposit(int amt) {
	balance = balance + amt;
} // end method deposit
```
- When this method is called, the value from the edit box is passed in as amt and is added to the balance field of the current account instance
- Similar actions are performed by the withdraw, setAccountName, setAccountNum, and setBalance methods
## The getAccountName Method
- Below is the code for the getAccountName method
```java
public String getAccountName() {
	return accountName;
} // end method getAccountName
```
- When getAccountName() is called, the value of accountName for the current account instance is returned to the calling method
- Similar actions are performed by the getAccountNum and getBalance methods
# Inheritance
- Inheritance is when you have one class that is a parent class (called a superclass) and another class that is a child class (called a subclass)
- The child class is said to be derived from the parent class
- The reason to have a child class is to keep information separate
- The child can inherit all the methods and fields from its parent, but can then act independently
## Extending the Account Class
- Let's assume that you want to create a new account type that behaves differently from a standard account
- To create this type, you can extend the Account class
- Consider a credit account
- A subclass that handles information about the credit amount associated with an account can be created as a subclass
![[Pasted image 20250626102341.png|300]]
### Using the Extends Keyword
- Use the keyword extends when creating a subclass that extends an existing class
```java
public class CreditAccount extends Account {

} //end class CreditAccount
```
- This will extend the Account class as a Credit Account
- It will have the same behavior as a standard account but will add the ability to set the credit limit
- The CreditAccount class will inherit all of the methods from the Account class

# ArrayList or Array?
- In Java, an Array has a fixed length
- Once the array is created, the programmer needs to know the length of the Array because it cannot grow or shrink in size
- If you have a situation where you cannot predict the number of object that you will be storing, you could use an ArrayList instead of using a fixed length Array
## ArrayList Operations
- In an Array, you need to know the length and the current number of elements stored
- In an ArrayList you can use predefined behaviors to perform these operations
	- `isEmpty()`: Returns true if this list contains no elements
	- `size()`: Returns the number of elements in this list
### Other ArrayList Operations

| **ArrayList Operation** | **Description**                                                             |
| ----------------------- | --------------------------------------------------------------------------- |
| `add`                   | Appends to the end of the list                                              |
| `clear`                 | Removes all of the elements from the list                                   |
| `contains`              | Returns true if this list contains the specified element                    |
| `get`                   | Returns the element at the specified position in this list                  |
| `remove`                | Removes the element in this list                                            |
| `set`                   | Replaces the element at the specified position in the list                  |
| `trimToSize`            | Trims the capacity of this ArrayList instance to be the list's current size |

---
# References
1. ![[JavaBank.jar.zip]]
2. [[08 Arrays]]