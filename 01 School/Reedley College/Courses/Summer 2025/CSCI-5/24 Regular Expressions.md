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
# Regular Expressions
- A regular expression is a character or a sequence of characters that represent a String or multiple Strings
- Regular expressions:
	- Are part of the java.util.regex package, this package has classes to help form and use regular expressions
	- Syntax is different than what you are used to but allows for quicker, easier searching, parsing, and replacing of characters in a String

# String.matches (String regex)
- The String class contains a method named matches(String regex) that returns true if a String matches the given regular expression
- This is similar to the String method equals(String str)
- The difference is that comparing the String to a regular expression allows variability
	- For example, how would you write code that returns true if the String animal is "cat" or "dog" and returns false otherwise?
## Equals Versus Matches
- A standard answer may look something like this
```java
if (animal.equals("cat"))
	return true;
else if (animal.equals("dog"))
	return false;
return false;
```
- An answer using regular expression would look something like this:
```java
return animal.matches("cat|dog");
```
- The second solution is much shorter!
1. The regular expression symbol `|` allows for the method matches to check if animal is equal to "cat" or "dog" and return true accordingly
```java
package regularexpressionexample;
public class RegularExpressionExample {
	public static void main(String[] args) {
		if(getAnimal("cat"))
			System.out.prinln("This is a valid animal");
		else
			System.out.println("This is not a Valid Animal");
		//endif
	}//end of method main
	public static boolean getAnimal(String animal) {
		return animal.matches("cat|dog");
	}//end method getAnimal
}//end of class
```
## Square Brackets
- Square brackets are used in regular expression to allow for character variability
- If you wanted to return true if animal is equal to "dog" or "Dog", but not "dOg", using equalsIgnoreCase would not work and using equals would take multiple lines
2. If you use regular expression, this task can be done in one line as follows
- This code tests if animal matches "Cat" or "cat" or "Dog" or "dog" and returns true if it does
```java
public static boolean getAnimal(String animal) {
	return animal.matches("[Cc]at|[Dd]og");
}//end method getAnimal
```
## Include Any Range of Characters
- Square brackets aren't restricted to two-character options
- They can be combined with a hyphen to include any range of characters
- For example, you are writing code to create a rhyming game
	- You want to see if a String word rhymes with cat
	- The definition of a rhyming word is a word that contains all the same letters except the first letter which may be any letter of the alphabet
- Your first attempt at coding may look like this:
```java
if(word.length()==3) {
	if(word.substring(1,3).equals("at")) {
		return true;
	}//end if
}
return false;
```
## Using Square Brackets and a Hyphen
- A shorter, more generic way to complete the same task is to use square brackets and a hyphen (regular expression) as shown below
```java
return word.matches("[a-z]at");
```
- This code returns true if word begins with any lower case letter and ends in "ouse"
- To include upper case characters write:
```java
return word.matches("[a-zA-Z](at|AT)");
```
- This code allows the first character to be:
	- a space (note the space before 0)
	- any number
	- a lower or upper case character
- The rest of the word must be bcde and is case sensitive
```java
return word.matches("[ 0-9a-zA-Z]bcde");
```

# The Dot
- The dot (.) is a representation for any character in regular expressions
- For example,
	- you are writing a decoder for a top-secret company and you think that you have cracked the code
	- You need to see if a String element consists of a number followed by any other single character
- This task is done easily with use of the dot as shown below
- This code returns true if element consists of a number followed by any character
- The dot matches any character
```java
return element.matches("[0-9].");
```

# Repetition Operators
- A repetition operator is any symbol in regular expressions that indicates the number of times a specified character appears in a matching String

| **Repetition Operator** | **Definition**        | **Sample Code**             | **Code Meaning**                                                         |
| ----------------------- | --------------------- | --------------------------- | ------------------------------------------------------------------------ |
| `*`                     | 0 or more occurrences | `return str.matches("A*");` | Returns true if str consists of **zero or more** A's but no other letter |
| `?`                     | 0 of 1 occurrence     | `return str.matches("A?");` | Returns true if str is "" or "A".                                        |
| `+`                     | 1 or more occurrences | `return str.matches("A+");` | Returns true if str is **1 or more** A's in a sequence.                  |
## More Repetition Operators
- A repetition operator is any symbol in regular expressions that indicates the number of times a specified character appears in a matching String

| **Repetition Operator** | **Definition**            | **Sample Code**                  | **Code Meaning**                                        |
| ----------------------- | ------------------------- | -------------------------------- | ------------------------------------------------------- |
| `{x}`                   | x occurrences             | `return str.matches("A{7}");`    | Returns true if str is a **sequence of 7** A's          |
| `{x,y}`                 | Between x & y occurrences | `return str.matches("A{7, 9}");` | Returns true if str is a **sequence of 7, 8, or 9** A's |
| `{x, }`                 | x or more occurrences     | `return str.matches("A{5,}");`   | Returns true if str is a **sequence of 5** or more A's  |
## Combining Repetition Operators
- In the code below:
	- The dot represents any character
	- The asterisk represents any number of occurrences of the character preceding it
	- The `".*"` means any number of any character in a sequence will return true
```java
return str.matches(".*");
```
- For the code below to return true, str must be a sequence of 10 digits (between 0 and 5) and may have 0 or 1 characters preceding the sequence
- Remember, all symbols of regular expressions may be combined with each other, as shown below, and with standard characters
```java
return str.matches(".?[0-5]{10}");
```
- Valid code: K1234512345
- Invalid code: K1234567890
- Invalid code: KL1234512345

# Pattern
- A Pattern is a class in the java.util.regex package that stores the format of the regular expression
```java
import java.util.regex.Pattern;
```
- For example, to initialize a Pattern of characters as defined by the regular expression `"[A-F]{5,}.*"` you would write the following code:
```java
Pattern p = Pattern.compile("[A-F]{5,}.*");
```
- The compile method returns a Pattern as defined by the regular expression given in the parameter

# Matcher (SLIDE 30)
---
# References
1. 