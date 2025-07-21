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

# Matcher
- A matcher is a class in the java.util.regex package that stores a possible match between a Pattern and a String
```java
import java.util.regex.Matcher;
```
- A Matcher is initialized as follows:
```java
Matcher match = patternName.matcher(StringName);
```
- The matcher method returns a Matcher object
- This code returns true if the regular expression given in the Pattern patternName declaration matches the String StringName
```java
return match.matches();
```
## Benefits to Using Pattern and Matcher
- This seems like a very complex way of completing the same task as the String method matches
- Although that may be true, there are benefits to using a Pattern and Matcher such as:
	- Capturing groups of Strings and pulling them out, allowing to keep specific formats for dates or other specific formats without having to create special classes for them
	- Matches has a find() method that allows for detection of multiple instances of a pattern within the same String

# Regular Expressions and Groups
- Segments of regular expressions can be grouped using parentheses, opening groups with `(` and closing it with `)`
- These groups can later be accessed with the Matcher method group (groupNumber)
- For example:
	- consider reading in a sequence of dates, Strings in the format "DD/MM/YYYY", and printing out each date date in the format
	- Using groups would make this task quite simple

## Matcher.find()
- Matcher's find method will return true if the defined Pattern exists as a Substring of the String of the Matcher
- For example, if we had a pattern defined by the regular expression `"[0,9]"`, as long as we give the Matcher a String that contains at least one digit somewhere in the String, calling find() on this, Matcher will return true
![[Pasted image 20250721125440.png|400]]
## Parsing a String with Regular Expressions
- Recall the String method split() introduced earlier in the lesson, which splits a String by spaces and returns the split Strings in an array of Strings
	- The split method has an optional parameter, a regular expression that describes where the operator wishes to split the String
	- For example, to split the String at any sequence of one or more digits, the code we could write would look something like this:
```java
String[] tokens = str.split("[0-9]+");
```

## Replacing with Regular Expressions
- Other methods that could be used are replaceFirst() and split() that can be both be researched through the Java API
	- String replaceFirst(String regex, String replacement) Replaces the first substring of this string that matches the given regular expression with the given replacement
	- String[] split(String regex) Splits this string around matches of the given regular expression
	- String[] split(String regex, int limit) Splits this string around matches of the given regular expression
## Replacing Using a Matcher
- `ReplaceAll` - For use with a matcher
- This method works the same if called by a Matcher rather than a String
- However, it does not require the regular expression
	- It will simply replace any matches of the Pattern you gave it when you initialized that Matcher
	- The method example shown below results in a replacement of all matches identified by Matcher with the String "abc"
```java
MatcherName.replaceAll("abc");
```
---
# References
1. 