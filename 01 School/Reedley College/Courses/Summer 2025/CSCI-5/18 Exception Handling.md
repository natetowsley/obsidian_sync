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
# Exceptions
- Exceptions, or run-time errors (errors that happen during the execution of the code), should be handled by the programmer prior to program execution
- Handling exceptions involves one of the following:
	- Try-catch statements
	- Throw statements
## Try-Catch Statements
- Try-catch statements are used to handle errors and exceptions in Java and follow these steps:
	- The program will run through the try code block first
	- If no exception occurs, the program will continue through the code without executing the catch block
	- If an exception is found, the program will search for a catch statement that catches the exception
	- If no catch statement is found, and the exception is not handled in any other way, your program will crash during run-time

# Adding Error Handling
1. Write a try statement that encloses the text field input except for the account name
```java
try {
	if (accountNumJTextField.getText() == "0") {
		accountNum = 0; }
	else {
		accountNum = Integer.parseInt(accountNumJTextField.getText());
	}//endif
	if (balanceJTextField.getText() == "0") {
		balance = 0; }
	else {
		balance = Integer.parseInt(balanceJTextField.getText());
	}//endif
}//end try
```
- If an exception is found, the program will search for a catch statement that catches the exception
2. Add a catch statement after the closing try bracket to catch any exception and display it to the console
```java
} // end try
catch (Exception e) {
	System.out.println(e);
}// end catch
```
- The catch statement is where the error is handled
## Searching for the Catch Statement
- If no catch statement is found, and the exception is not handled in any other way, your program will crash during run-time
	- You can choose how to want to deal with the error by supplying an appropriate error message or providing a default value for a variable
	- Whatever suits the error that has been dealt with
### Using Multiple Catch Statements
- There are different kinds of exceptions and multiple catches can be used for multiple exceptions
- This is especially useful if different exceptions need to be handled differently
- Only one exception can be caught when multiple catch statements are used, and will be caught in the order in which they are handled
- Using multiple catch statements may be effective in making catch statements more specific to the certain exception that occurs
#### When Multiple Catch Statements Are Effective
- Multiple catch statements can be used for one try statement in order to catch more specific exceptions
3. A NumberFormatException has already been identified by the current catch statement, add this new catch statement above the existing one:
```java
} // end try
catch (NumberFormatException e) {
	name=("");
	JOptionPane.showMessageDialog(null, "Incorrect numeric value entered.");
}// end catch
catch(Exception e) {
```
- The Exception e catch statement must come last as it will catch all errors
```java
try {
	if (accountNumJTextField.getText() == "0") {
		 accountNum = 0; }
	else {
		accountNum = Integer.parseInt(accountNumJTextField.getText());}//endif
	if (balanceJTextField.getText() == "0") {
		balance = 0; }
	else {
		balance = Integer.parseInt(balanceJTextField.getText());}//endif
	
}//endtry
catch(NumberFormatException e) {
	name=("");
	JOptionPane.showMessageDialog(null, "Incorrect numeric value entered." );
}//end catch
catch(Exception e) {
	System.out.println(e);
}//end catch
```
- NumberFormatException will occur if an incorrect type is entered
- Exception will occur is any exception other than a NumberFormatException error occurs
- Only one exception is caught when multiple catch statements are used, and will be caught in the order they are handled in

# Finally Clause
- Try-catch statements can optionally include a finally clause that will execute if an exception was found or not
- Finally clauses are optional, but they will always execute no matter if an exception is caught or not
- This is useful for including code that will execute every time the program is run - with or without an exception occurring
## Example
- The finally clause will execute if an exception was found or not
```java
} // end catch
finally {
	//clear the JTextFields for new data
	nameJTextField.setText(" ");
	accountNumJTextField.setText("0");
	balanceJTextField.setText("0");
	depositJTextField.setText("0");
	withdrawJTextField.setText("0");
}//end finally
```

# Auto-Closeable Resources
- There is a "try-with-resources" statement that will automatically close resources if the resources fail
	- The try-with-resources statement is a try statement that declares one or more resources
	- A resource is an object that must be closed after the program is finished with it
	- The try-with-resources statement ensures that each resource is closed at the end of the statement
- In the following example, "missingfile.txt" will close if the try statement completes normally, or if a catch statement is executed
```java
System.out.println("About to open a file");
try (InputStream in = new FileInputStream("missingfile.txt"))
{
	System.out.println("File open");
	int data = in.read();
} catch (FileNotFoundException e) {
	System.out.println(e.getMessage());
} catch (IOException e) {
	System.out.println(e.getMessage());
}//end try catch
```

# Declaring Exceptions
- Another way to handle an exception is to declare that a method throws an exception
- Methods can be declared to throw exceptions if they contain try statements and fail to execute correctly
	- A try statement will go in the method declaration
	- If the try fails, the method will throw the declared exception
```java
public static int readByteFromFile() throws IOException {
	try (InputStream in = new FileInputStream("a.txt")) {
		System.out.println("File open");
		return in.read();
	}//end try
}//end method readByteFromFile
```
## Handling Declared Exceptions
- Method-declared exceptions must still be handled, but can be handled inside the method declaration or from where the method was called
- Here is an example of handling the exception when the method from the previous slide is called
```java
public static void main(String[] args) {
	try {
		int data = readByteFromFile();
	}//endtry
	catch(IOException e) {
		System.out.println(e.getMessage());
	}//end catch
}//end method main
```

# Creating Custom Exceptions
- If you find that no existing exception adequately describes the exception, you can create your own
- Custom exceptions are created by extending the Exception class or one of its subclasses
```java
public class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}//end constructor method

	//MyException specific code here...
}// end class MyException
```
## Calling Custom Exceptions
- A custom exception is called from within an existing Exception statements catch block
- To work with your own custom exception you must create a new object of that exception class as part of a throw statement
- A throw statement passes the error back to the calling statement
- A throws statement must be added to the end of the method signature identifying the type of Exception that will be returned
- The myException example on a previous slide requires a message to be passed into its constructor, you need to pass the error string to the object when you create it
```java
private void actionMethod() throws myException {
	//method code
	try {
		//method code
	}
	catch(Exception e) {
		throw new MyException("An unhandled error occurred!!");
	}//end catch
}
```
- The calling function must also be wrapped in a try catch statement so that the custom Exception can be processed
```java
try {
	actionMethod();
} catch(MyException e) {
	System.out.println(e);
}//end try catch
```
- The error message can then be displayed
```java
try {
	actionMethod();
} catch(MyException e) {
	JOptionPane.showMessageDialog(null, e);
}//end try catch
```

# Assertions
- Assertions are a form of testing that allow you to check for correct assumptions throughout your code
	- For example, if you assume that you method will calculate a negative value, you can use an assertion
- An assert statement is used to declare an expected boolean condition in a program
- If the program is running with assertions enabled, then the condition is checked at runtime
- Assertions can be used to check internal logic of a single method:
	- Internal invariants
		- Internal invariants allow you to check that your code deals with values correctly
	- Control flow invariants
		- Control flow invariants usually allow you to check if something in your code that should have been executed hasn't been
	- Class invariants
		- A class invariant can specify the relationships among multiple attributes and should be true before and after any method completes
## Disabling Assertions at Run-Time
- Assertions can easily be disabled at run time so that you can disable all of your test features when you run the code
- Therefore:
	- Do not use assertions to check parameters
	- Do not use methods that can cause side effects in an assertion check
## Assertion Syntax
- There are two different assertion statements
	- If the <boolean_expression> evaluates to false, then an AssertionError is thrown
	- A second argument is optional, but can be declared and will be converted to a string to serve as a description to the AssertionError message displayed
```java
assert <boolean_expression>;
assert <boolean_expression> : <detail_expression>;
```
## Internal Invariants
- Internal invariants are testing values and evaluations in your methods
- Internal invariants are to test values of variables after they've been updated or evaluated
- They are usually used to test internal values to see if they are set or updated correctly
```java
if (x > 0) {
	//do this
}
else {
	assert (x == 0);
	//do that
	//what if x is negative?
} //end if
```
## Control Flow Invariants
- Control flow invariants are assertions that can be made inside control flow statements
- They allow you to check if code that should have been executed has not been executed
- They also allow you to evaluate what happened if values you do not think are possible were to be processed by your code
### Example
```java
public static void main(String[] args) {
	String suit = "Card";
	switch (suit) {
	case "Clubs" : System.out.println("Clubs");
		break;
	case "Diamonds" : System.out.println("Diamonds");
		break;
	case "Hearts" : System.out.println("Hearts");
		break;
	case "Spades" : System.out.println("Spades");
		break;
	default : assert false : "Unknown playing card suit";
		break;

	}//end switch
}//end method main
```
## Class Invariants
- A class invariant is an invariant used to evaluate the assumptions of the class instances, which is an Object in the following example:
```java
public Object pop() {
	int size = this.getElementCount();
	if (size == 0) {
		throw new RuntimeException("Attempt to pop from empty stack");
	}//endif
	Object result = /* code to retrieve the popped element */ ;
	// test the postcondition
	assert (this.getElementCount() == size - 1);
	return result;
}//end Object pop
```
---
# References
1. 