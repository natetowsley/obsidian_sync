---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-07-07
---
```table-of-contents
```
---
# Enumerations
- Enumerations (or enums) are a specification for a class where all instances of the class are created within the class
	- Enums are a datatype that contains a fixed set of constants
	- Enums are good to use when you already know all possibilities of the values or instances of the class
	- If you use enums instead of strings or integers you increase the checks at compile time
- Can be declared on their own or within another class
## Enumerations BankExample
- Say we wish to store the type of bank account within our Account Class
- We could have Savings and Credit as possible options
- As long as we specify that the class is of type enum, we can create these account types inside the class itself as if each was created outside of the class
### Adding Enumerations to the JavaBank
1. Add the following enum class to the JavaBank project
```java
public enum AccountType {
	SAVINGS,
	CREDIT
} // end enum AccountType
```
2. In the Account class create a private instance variable that will hold an account type under the bonusValue field
```java
private AccountType type;
```
3. Update the Account constructor to take a fourth parameter of type AccountType named type
```java
Account(String name, int num, int amt, AccountType type) {}
```
4. Assign the value of the instance field "type" to that of the parameter "type". Must come after the super call
```java
Account(String name, int num, int amt, AccountType type) {
	super(name, num, (amt + calculateInitialBonusValue(amt)));
	bonusValue = calculateInitialBonusValue(amt);
	this.type = type;
}// end constructor value
```
5. Create a toString() method in the Account class that will display the account type before calling the super class' toString() method
```java
@Override
public String toString() {
	return "\nAccount Type  : " + this.type + super.toString();
}//end method toString
```
6. Update the constructor calls to include an enum value that sets the account type to savings
```java
// Using constructor with values
Account a1 = new Account("Sanjay Gupta", 11556, 300, AccountType.SAVINGS);
Account a2 = new Account("He Xai", 22338, 500, AccountType.SAVINGS);
Account a3 = new Account("Ilya Mustafana", 44559, 1000, AccountType.SAVINGS);
```

# Enumeration Objects
- Enums are like any other class and can have fields, constructors, and methods
- By default, enums don't require a constructor definition, their default values are always the string used in the declaration
- You can add additional attributes to the enum fields
- You can define your own constructors to initialize the state of enum types
- Objects can be instantiated from an enum class by going through its constructors

# Enumerations AccountType
- Our bank accounts could have an internal code that is used by the bank to identify the account types
```java
public enum AccountType {
	CURRENT("CU"),
	SAVINGS("SA"),
	DEPOSIT("DP"); //Enum fields with attributes (Each type has its own code)

	private String code;

	private AccountType(String code) { 
		this.code = code; //enum constructors must be private or default
	}//end method accountType

	public String getCode() {
		return code; //both abstract and concrete methods are allowed in enums
	}//end method getCode
}//end class AccountType
```
- We can have more than one field in the enum
- If we wanted a minimum percent rate we could have:
```java
public enum AccountType {
	CURRENT("CU", 1.0),
	SAVINGS("SA", 2.0),
	DEPOSIT("DP", 0.0);
	
	private String code;
	private double rate;
	
	private AccountType(String code, double rate){
		this.code = code;
		this.rate = rate;
}//end constructor method
```
- Another internal field was included with another parameter added to the constructor to set the value
- By adding additional getters the value of the fields can be returned
```java
public String getCode() {
	return code;
}//end method getCode

public double getRate() {
	return rate;
}// end method getRate
```
- We can now access the field values held by the enum
```java
AccountType account = AccountType.Deposit;
System.out.println("Type: " + account.name()
					+ "\nCode: " + account.getCode()
					+ "\nRate: " + account.getRate());
```

# Problems with Types
- Often in programming we want to write code which can be used by more than one type with the same underlying behavior
![[Pasted image 20250707112051.png|500]]

# Simple Class Example
- If we wanted a very simple class to get and set a string value we could define this as:
```java
public class Cell {
	private String data;

	public void setValue(String celldata) {
		data = celldata;
	}//end method setValue

	public String getValue() {
		return data;
	}//end method get
}//end class Cell
```

# Simple Driver Class
- Using a simple driver class we could set and retrieve a string value
```java
public class CellDriver {
	public static void main(String[] args) {
		Cell cell = new Cell();
		cell.setValue("One");
		System.out.println(cell.getValue());
	}//end method main
}//end class CellDriver
```
- This example would only ever work with Strings
- Although this is a very simple class without much coding, if it had been more complex we may wish to reuse the algorithms with other data types
## Flexible Class
- We could change the String primitive type to Object
```java
public class Cell {
	private void setValue(Object celldata) {
		data = celldata;
	}//end method setValue

	public Object getValue() {
		return data;
	}//end method get
}//end class Cell
```
- Changing all occurrences of String to Object would give us the flexibility to use other datatypes
## Flexible Driver Class
- Now our driver class can set the type of data we wish to store
```java
public class CellDriver {
	public static void main(String[] args) {
		Cell cell = new Cell();
		cell.setValue(1);
		int num = (int)cell.getValue();
		System.out.println(num);
	}//end method main
}//end class CellDriver
```
- Our cell cast can be used on different types, but only one type at a time. If we cast to the wrong type then we will most likely produce a casting exception
- The problem with this is if we pass a String in the set method and try to cast as int then we will receive a casting error at runtime
```java
public class CellDriver {
	public static void main(String[] args) {
		Cell cell = new Cell();
		cell.setValue("One");
		int num = (int)cell.getValue();
		System.out.println(num);
	}//end method main
}//end class CellDriver
```
![[Pasted image 20250707113417.png|450]]

# Generic Classes
- A generic class is a special type of class that associates one or more non-specified Java types upon instantiation
- This removes the risk of the runtime exception "ClassCastException" when casting between different types
- Generic types are declared by using angled brackets - <> around a holder return type. E.g. `<E>`
	- `<E>` is simply an example. We could have written `<T>`, `<Type1>`, or `<Element1>`
## Generic Cell Class
- We can modify our cell class to make it generic
```java
public class Cell<T> {
	private T data;

	public void setValue(T celldata) {
		data = celldata;
	}//end method setValue

	public T getValue() {
		return data;
	}//end method get
}//end class Cell
```
- We have not had to make many changes to make our class generic
- We remove specific data type references and change them to the generic type T
## Generic Cell Driver Class
- We can now set the type at creation
```java
public class CellDriver {
	public static void main(String[] args) {
		Cell<Integer> integerCell = new Cell<Integer>();
		Cell<String> stringCell = new Cell<String>();
		integerCell.setValue(1);
		stringCell.setValue("One");
		int num = integerCell.getValue();
		String num = integerCell.getValue();
		System.out.println("Integer Value: " + num);
		System.out.println("String Value: " + str);
	}//end method main
}//end class CellDriver
```

# Initializing a Generic Object
- Initializing a Generic object with one type, Example:
```java
public class Cell<T> {
	private T data;

	public void setValue(T celldata) {
		data = celldata;
	}//end method setValue

	public T getValue() {
		return data;
	}//end method get
}//end class Cell
```

```java
Cell<Integer> integerCell = new Cell<Integer>();
```
- You define the generic class name followed by the type in the diamond brackets and then give the object a name
```java
ClassName<Data Type> ObjectName = new ClassName<Data Type>();
```
- The data type on the left of the new operator is optional
```java
ClassName<Data Type> ObjectName = new ClassName();
```
- To initialize a Generic object with two types:
```java
ClassName<Data Type, Data Type> ObjectName = new ClassName();
```
- Example
```java
Example<String, Integer> showMe = new Example<>();
```
- The only difference between creating an object from a regular class versus a generics class is the diamond brackets<String, Integer>
## Updated Cell Class with Two Types
```java
public class Cell<T, T2> {
	private T t;
	private T2 k;

	public void setValue(T celldata, T2 i) {
		t = celldata;
		k = i;
	}//end method setValue
	public T getT1Value() {
		return t;
	}//end method getT1Value()
	public T2 getT2Value() {
		return k;
	}//end method getT2Value()
	public String toString() {
		return("cell type is: Type1: " + t.getClass() + " and Type2: " 
		+ k.getClass());
	}//end method toString
}//end class Cell
```
## Updated CellDriver Class Using Two Types
```java
public class CellDriver {
	public static void main(String[] args) {
		Cell<Integer, String> mixCell = new Cell<Integer, String>();
		Cell<Integer, Integer> integerCell = new Cell();
		
		mixCell.setValue(1, "4");
		integerCell.setValue(45, 60);
		
		int mcType1 = mixCell.getT1Value();
		String mcType2 = mixCell.getT2Value();
		int icType1 = integerCell.getT1Value();
		int icType2 = integerCell.getT2Value();
		
		System.out.println(mixCell);
		System.out.println(integerCell);
		System.out.println("The numerical value is: " +
						mcType1 + ". The text value is: " + mcType2);
		System.out.println("The first numerical value is: " + icType1 +
						" and the second is : " + icType2);

	}//end main
}//end class CellDriver
```

# Type Parameter Names
- The most commonly used type parameter names are
	- E - Element (used extensively by the Java Collections Framework)
	- K - Key
	- N - Number
	- T - Type
	- V - Value
	- S, U, V etc. - 2nd, 3rd, 4th types

# Working with Generic Types
- When working with generic types, remember the following:
	- The types must be identified at the instantiation of the class
	- Your class should contain methods that set the types inside the class to the types passed into the class upon creating an object of the class
	- One way to look at generic classes is by understanding what is happening behind the code

# Generic Methods
- So far we have created Generic classes, but we can also create generic methods outside of a generic class
- Just like type declarations, method declarations can be generic - that is, parameterized by one or more type parameters
- A type interface diamond is used to create a generic method
## Type Interface Diamond
- A type interface diamond enables you to create a generic method as you would an ordinary method, without specifying a type between angle brackets
- Why a diamond
	- The angle brackets are often referred to as the diamond<>
	- Typically if there is only one type inside the diamond, we use `<T>` where T stands for Type
	- For two types we would have `<K,T>`
- You can use any non reserved word as the type holder instead of using `<T>`. We could have used `<T1>`
- By convention, type parameter names are single, uppercase letters
- This stands in sharp contrast to the variable naming conventions that you already know about, and with good reason: Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name
## Example
```java
public class GenericMethodClass {
	public <T> void printArray(T[] array) {
		for(T arrayitem : array) {
			System.out.println( arrayitem );
		}//end for
	}//end method printArray
}//end class GenericMethodClass
```

```java
public class GenericMethodDriver {
	public void main(String[] args) {
		GenericMethodClass gmc = new GenericMethodClass();
		
		Integer[] integerArray = {1, 2, 3};
		String[] stringArray = {"This","is","fun"};
		
		gmc.printArray(integerArray);
		gmc.printArray(stringArray);
	}//end method main
}//end class GenericMethodDriver
```

# Generic Wildcards
- Wildcards with generics allows us greater control of the types we use
- They fall into two categories:
	- Unbounded
		- `<?>`
	- Bounded
		- `<? extends type>`
		- `<? super type>`
## Unbounded Wildcards
- `<?>` denotes an unbounded wildcard, it can be used to represent any type
- Example - `arrayList<?>` represents an arrayList of unknown type
```java
ArrayList<?> array1 = new ArrayList<Integer>();
array1 = new ArrayList<Double>();
```
- `public void printList(List<?> list)`
	- This declares a list of unknown type as the parameter
- You could have written a generic method to achieve the same result using the Type assigned in the generic class
- `public <T> void printList(List<T> list)`
## Upper Bounded Wildcard
- `<? extends Type>` denotes an Upper Bounded Wildcard
- Sometimes we want to relax restrictions on a variable
- Lets say we wished to create a method that works only on ArrayLists of numbers
	- `ArrayList<Integer>`
	- `ArrayList<Double>`
	- `ArrayList<Float>
- We could use an upper bounded wildcard
- The upper bound wildcard sets the type by extending subtypes of a specific supertype, in this case Number
- `public double sumOfList(ArrayList<? extends Number> arrayList) {`
- This only allows numeric arrayLists to be processed
```java
		ArrayList<String> sArray = new ArrayList<String>();
		System.out.println(gmc.sumOfList(sArray));
	}//end method main
}//end class GenericMethodDriver
```
- Accessing the method with a String List would produce:
![[Pasted image 20250707134538.png|650]]
## Lower Bounded Wildcard
- `<?super Type>` denotes a Lower Bounded Wildcard
	- A lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type
- Say a method is required that puts Integer objects into ArrayList
	- To maximize flexibility, you would like the method to work on `ArrayList<Integer>`, `Array<Number>`, and `ArrayList<Object>` - anything that can hold Integer values
- When the generic method addNumbers was created it extended number. It would not accept an arrayList of Strings
- The addNumbers only accepts Integer types (and its superclasses) so if the following code was tried:
```java
		ArrayList<Double> doubleArray = new ArrayList<Double>();
		gmc.addNumbers(doubleArray);
	}//end method main
}//end class GenericMethodDriver
```
- As it's a Double it would produce the following error:
![[Pasted image 20250707135632.png|600]]
---
# References
1. 