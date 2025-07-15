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

# Square Brackets (SLIDE 8)
---
# References
1. 