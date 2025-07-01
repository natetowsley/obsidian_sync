---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-07-01
---
```table-of-contents
```
---
# Abstract Classes
- An abstract class provides a base class from which other classes extend
- Abstract classes can provide:
	- Implemented methods: Those that are fully implemented, and their child classes may use them
	- Abstract methods: Those that have no implementation and require child classes to implement them
- Abstract classes do not allow construction directly, but you can create subclasses or static nested classes to instantiate them
- An Abstract Class:
	- Must be defined by using the abstract keyword
	- Cannot be instantiated into objects
	- Can have local declared variables
	- Can have method definitions and implementations
	- Must be subclassed (extends) rather than implemented (implements)
## More Information about Abstract Classes
- If a concrete class uses an abstract class, it must inherit it, inheritance precludes inheriting from another class
- Abstract classes are important when all derived classes should share certain methods
- The alternative is to use an interface, then define at least one concrete class that implements the interface
- This means you can use the concrete class as an object type for a variable in any number of programs which provides much greater flexibility

# Abstract Class or Interface
- There is no golden rule on whether to use interfaces, abstract classes, or both
- An abstract class usually has a stronger relationship between itself and the classes that will be derived from it than interfaces
- Classes and interfaces can implement multiple interfaces whereas a class can only be a subclass of one abstract class
- Abstract classes allow methods to be defined
- Abstract classes often have an "Is-A" relationship
	- A Student is a Person, so Person may be better as an Abstract Class
![[Pasted image 20250701102709.png]]
- Interfaces often have a "Has-A" relationship
	- A Vehicle has an Engine, so Engine may be better as an Interface
![[Pasted image 20250701102755.png]]

# Bank Account as Abstract
- Previously an interface for the Account class had been implemented
```java
public interface InterfaceBankAccount {
	public final String BANK = "JavaBank";

	public void deposit(int amt);
	public void withdraw(int amt);
	public int getBalance();
	public String getBankName();
}//end interface InterfaceBankAccount
```
- An abstract class could have been used instead...
- Abstract Class
```java
abstract public class AbstractBankAccount {
	public final String BANK = "JavaBank";

	abstract public void deposit(int amt);
	abstract public void withdraw(int amt);
	abstract public int getBalance();
	abstract public String getBankName();
}//end class AbstractBankAccount
```
- An interface would be better if all bank accounts had to implement only those defined methods
- The interface approach would allow the use of other interfaces in the class design
- If some base functionality was required to be defined, then an abstract class would be used
## Updating the Account/AbstractBankAccount Classes
1. Move the instance fields from the Account class to the AbstractBankAccount class
```java
abstract public class AbstractBankAccount {
	//Instance fields
	public final String BANK= "JavaBank";
	protected String accountName;
	protected int accountNum;
	protected int balance;

	abstract public void deposit(int amt);
	abstract public void withdraw(int amt);
	abstract public int getBalance();
	abstract public String getBankName();
}//end class AbstractBankAccount
```
2. Move the relevant getter/setter methods from the Account class to the AbstractBankAccount class
3. Move the withdraw method as this executes the same for both Account and CreditAccount classes
```java
	//in class
	protected int balance;
	
	abstract public void deposit(int amt);
	
	public String getBankName(){/*code*/}
	public String getAccountName(){/*code*/}
	public void setAccountName(String name){/*code*/}
	public int getAccountNum(){/*code*/}
	public void setAccountNum(int num){/*code*/}
	public int getBalance(){/*code*/}
	public void setBalance(int num){/*code*/}
	public void withdraw(int amt ){/*code*/}
}//end class AbstractBankAccount
```
4. Delete the default constructor in the Account class so that you cannot create an empty Account object
```java
public class Account extends AbstractBankAccount{
	//Instance Fields removed for space on the slide

	//constructor for Account
	public Account(String name, int num, int amt) {
		accountName = name;
		accountNum = num;
		balance = amt;
	}//end constructor
}
```
5. Copy the remaining constructor from the Account class into the AbstractBankAccount class Update the constructor name to match the class
```java
abstract public class AbstractBankAccount {
	//constructor for AbstractBankAccount
	public AbstractBankAccount(String name, int num, int amt)
	{
		accountName = name;
		accountNum = num;
		balance = amt;
	}//end constructor method
	abstract public void deposit(int amt);
}
```
6. Add a private instance field named bonusValue that can store an integer value in the Account class
```java
public class Account extends AbstractBankAccount {
	//Instance Fields
	private int bonusValue;
}
```
7. Your completed method should look like:
```java
private static int calculateInitialBonusValue(int amt) {
	if(amt >= 1 && amt <= 100)
		return 10;
	else if(amt <= 300)
		return 20;
	else
		return 30;
	//end if
} // end method calculateInitialBonusValue
```
8. Update the Account constructor to call the super constructor in AbstractBankAccount
	- Use the `name`, `num` and the result of `amt` + `calculateInitialBonusValue`
```java
public class Account extends AbstractBankAccount {
	//Instance fields
	private int bonusValue;

	//constructor for Account
	Account(String name, int num, int amt) {
		super(name, num, (amt + calculateInitialBonusValue(ame)));
	}//end constructor method

	private static int calculateInitialBonusValue(int amt) {}
}
```
9. Use the `calculateInitialBonusValue` method to assign the initial value to the private bonusValue field
```java
public class Account extends AbstractBankAccount{
	// Instance Fields
	private int bonusValue;
	
	//constructor for Account
	Account(String name, int num, int amt)
	{
		super(name, num, (amt + calculateInitialBonusValue(amt)));
		bonusValue = calculateInitialBonusValue(amt);
	}//end constructor method
	
	private static int calculateInitialBonusValue(int amt) {
```
10. If you have an Account that is not a credit account, you will receive an additional 10% of your initial bonus value added to each deposit over $100
```java
} //end method calculateInitialBonusValue

//make a deposit to the balance
public void deposit(int amt) {
	if(amt>100)
		balance = balance + (amt + (int)(bonusValue * 0.1));
	else
		balance = balance + amt;
	//end if
}//end method deposit
```
11. Have the CreditAccount class inherit from AbstractBankAccount instead of Account
```java
public class CreditAccount extends AbstractBankAccount {
	private int creditLimit;

	//default constructor for CreditAccount
	CreditAccount()
}
```
- When you extend the abstract class you are required to add the unimplemented methods
12. For the AbstractBankAccount class this means that you have to implement a deposit method that accepts an integer parameter and adds it to the current value of the balance
```java
	@Override
	public void deposit(int amt) {
		balance = balance + amt;
	}//end method deposit
}//end class CreditAccount
```
13. Update the default constructor to accept parameters for the name, number and initial amount for the credit account
	- This allows the creation of a credit account with the default $100 credit limit
14. A constructor for a basic credit account already exists where a $100 dollar credit limit is assigned
	- JavaBank wants to implement a new scheme to make the processing of credit accounts easier
15. Your completed code should look like this:
```java
}//end constructor method
	private static int calculateCreditLimit(int amt) {
	if(amt>1 && amt<=2000)
		return 100;
	else if(amt<=4000)
		return 200;
	else
		return 300;
	//endif
}//end method calculateCreditLimit
```
16. Update the default constructor to call calculateCreditLimit() to assign a value for the creditLimit instance field
```java
public class CreditAccount extends AbstractBankAccount{

// Instance Fields
private int creditLimit;
//default constructor for CreditAccount
CreditAccount(String name, int num, int amt)
{
	super(name,num,amt);
	this.creditLimit=calculateCreditLimit(amt);
}//end constructor method
```
17. Update the print method in the CreditAccount class so that the output resembles that of the Account class but also displays the credit limit
```java
//print method
public void print()
{
	System.out.println("\nBank Name : " + getBankName() +
	"\nAccount Holder : " + accountName +
	"\nAccount Number : " + accountNum +
	"\nAccount balance: " + balance +
	"\nCredit Limit : " + creditLimit);
}//end method print
```

# Virtual Method Invocation
- Virtual method invocation is the process where Java identifies the type of subclass and calls that class's implementation of a method
- When the Java virtual machine invokes a class method, it selects the method to invoke based on the type of the object reference, which is always known at compile time
- On the other hand, when the virtual machine invokes an instance method, it selects the method to invoke based on the actual class of the object, which may only be known at runtime
## Example
- The toString() method uses virtual method invocation by calling the toString() method of the different subclasses
- The decision is made by the JVM to call the toString method implemented in the subclasses rather than the toString method in the superclass or the Object class

# The instanceof Operator
- The instanceof operator allows you to determine the type of an object
- It takes an object on the left side of the operator and a type on the right side of the operator and returns a boolean value indicating whether the object belongs to that type or not

# Upcasting and Downcasting
- Casting is the principal of changing the object type during assignment
- Upcasting loses access to specialized methods in the subclassed object instance
- Downcasting gains access to specialized methods of the subclass
- Casting object works somewhat like casting primitives
## Upcasting
- **Upcasting** does not risk the loss of precision nor require you to specify the new data type
- This is when going from a smaller to a larger data type so there is no risk of losing information
- Java will implicitly carry out the conversion for you
```java
double complexNumber = 45.75L;
int simpleNumber = 34;

complexNumber = simpleNumber;
```
## Downcasting
- **Downcasting** a double to an int means the values to the right of the decimal point are lost
	- This is a loss of precision
- For that reason, you must explicitly specify the downcast type, Java will not allow this implicitly
```java
double complexNumber = 45.75L;
int simpleNumber = 34;

simpleNumber = (int)complexNumber;
```
---
# References
1. [[]]