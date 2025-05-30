---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
Date Created:
---
---
# What is a String?
- A String is an object that contains a sequence of characters
- Declaring and instantiating a String is much like any other object variable
- However, there are differences:
	- They can be instantiated (created) without using the new keyword
	- They are immutable
		- Once instantiated, they are final and cannot be changed
# Modifying a String
- Attempting to modify a String does not modify it, it creates a new string object
- As a new programmer, you will not notice this difference
- However, it becomes important in real systems where processing time is a key element in program design
## String Operations Example
![[Pasted image 20250529165421.png|500]]
# Class Template
- Use the following class to insert examples from this section
![[Pasted image 20250529165456.png|600]]

# Instantiating a String
- Strings are object reference types
- They can be instantiated in two ways:
	- The new operator
	- String literals
	- There is no difference between the strings below
	- Both methods of instantiation create identical objects
![[Pasted image 20250529165631.png|600]]

# String References
- When you create a reference to an Object or String, the object does not necessarily exist yet
- In the code below, since name is not initialized, the program will not compile
- The variable name is a null pointer
![[Pasted image 20250529165745.png|600]]
- In the code below, one String object exists, and name is referencing it
	- The reference name2 is null
	- How will line change memory?
![[Pasted image 20250529165847.png|600]]
- Executing `name2 = name` changes the name2 reference
- The reference name2 will now refer to the same object as name
![[Pasted image 20250529170022.png|550]]
- If we run a very similar program but ask the user to enter Strings, we get a different result
```java
Scanner in = new Scanner(System.in);
String name, name2;
name = in.next();
name2 = in.next();
```
- If the user types Mya for both strings, the compiler actually creates two different String Objects
![[Pasted image 20250529170223.png|600]]

# String Concatenation
- Concatenate two strings together with the + and += operators
- Symbol + is used to concatenate two strings together
- Symbol += is used to concatenate two strings together and assign it to itself all in one operation
```java
String s1 = "This is a ";
String s2 = "string";
String s3 = s1 + s2;
String s4 = "This is a " + s2;
String s1 += s2;
```

# Manipulation of Strings 
 - Each time a String is changed, a new String is created in a new memory location and the reference is moved to the new location
 - Some string will point to the same reference object in memory
 - Making a modification to one String that is pointing to the shared reference will not make a modification to the others
 - The one that you modify points to the new memory address that holds the new/ modified string and the other still point to the original one

# Escape Sequences \
- Escape sequences in string literals allow the user to add characters that would be misinterpreted by the compiler
- For example, to include a double-quote in your String, the compiler would interpret the double-quote as the beginning or end of your String rather than including it
- Use the escape sequence `\"` to include a double-quote
![[Pasted image 20250529170800.png|550]]
## Common Escape Sequences in Java

| **Escape Sequence** | **Representation** | **Alternate Octal Escape Representation** |
| ------------------- | ------------------ | ----------------------------------------- |
| `\"`                | Double quote       | \u0022                                    |
| `\'`                | Single quote       | \u0027                                    |
| `\\`                | Backslash          | \u005c                                    |
| `\t`                | Horizontal tab     | \u0009                                    |
| `\n`                | Line feed          | \u000a                                    |
| `\b`                | Backspace          | \u0008                                    |
| `\r`                | Carriage return    | \u000d                                    |
| `\f`                | Form feed          | \u000c                                    |
| Octal Escape        | Octal value        | \u0000 to \u00ff                          |

# Methods to Compare Strings
## compareTo() Method
- Method: s1.compareTo(s2)
- Should be used when trying to find the lexicographical order of two strings
- Returns an integer
- If s1 is less that s2, an int < 0 is returned
- If s1 is equal to s2, 0 is returned
- If s1 is larger than s2, an int > 0 is returned
## equals() Method
- Methods to use when comparing Strings
	- Method: s1.equals(s2)
	- Should be used when you only wish to find if the two strings are equal
	- Returns a boolean value
	- If true is returned, s1 is equal to s2
	- If false is returned, s1 is not equal to s2

## Comparing Strings with ==
- Primitive variables can be compared with ==
- This method of comparison does not always work with Strings and should be avoided unless trying to compare the memory address locations of the two String objects
- == compares reference values, not values
- Will only be true if the two String objects are pointing to the same reference objects
![[Pasted image 20250529171917.png|600]]

# Useful String Method: length()
- Method: s1.length()
- Returns the length, or the number of characters, in s1 as an int
- String length is an accessor method called on a String object will return the length variable of the String
```java
String s1 = "This is a string.";
int n = s1.length();
// n is 17 because s1 has 17 characters
```

# Useful String Method: substring()
- s2.substring(int beginIndex)
	- Returns part of the string s2 from the beginIndex to the end of the String
- s2.substring(int beginIndex, int endIndex)
	- Returns part of the string s2 from the beginIndex to the endIndex but does not include the character at endIndex
	- What is displayed as a result of this code segment?
```java
String s1 = "I eat apples";
String s2 = "Bananas are my favorite fruit";
System.out.println(s1.substring(6)) + " " + s2.substring(8, 23);
```

# Useful String Methods: indexOf and charAt
- Method: s3.indexOf(char c);
	- Returns the index value of the first occurrence of c in String s3
- Parameter does not need to be a character, it can also be a String, for example: s3.indexOf("the");
- Method: s4.charAt(int index);
	- Returns the character of the String located at the index passed as the parameter
	- Index can be an integer from 0 to s4.length() - 1
---
# References
1. 