---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-07-13
---
```table-of-contents
```
---
# Strings
- The String object can be interpreted as a group of characters in a single memory location
- Strings, like arrays, begin their index at 0 and end their index at `StringName.length()-1`
- There are many different ways of approaching String manipulation

# Print String to Console
- Java provides an easy way of printing the contents of the String to the console
- `System.out.print(str)` will print the contents of the String to the console and leave the cursor on the same line
```java
System.out.print(str);
```
- `System.out.println(str)` will print the contents of the String to the console and place the cursor on the next line
```java
System.out.println(str);
```

# Common String Methods

| **String Method**               | **Description**                                                                                           |
| ------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `length()`                      | Returns the number of characters in the String                                                            |
| `charAt(int i)`                 | Returns the character at index i                                                                          |
| `substring(int start)`          | Returns part of the String from index start to the end of the String                                      |
| `substring(int start, int end)` | Returns part of the String from index start to index end, but does not include the character at index end |
| `replace(char oldC, char newC)` | Returns a String where all occurrences of character oldC                                                  |
# Using a For Loop
- One way to manipulate Strings is to use a FOR loop
- This code segment initializes a String and increments through its characters, printing each one to the console on a separate line
```java
String str = "Sample String";

for (int index = 0; index < str.length(); index++) {
	System.out.println(str.charAt(index));
} //end for
```
## Benefits of Using a For Loop
- Using a for loop method of incrementing through a String is beneficial if you want to:
	- Read the String backwards(from last element to first element)
	- Search for a specific character or String inside of the String
	- Parse the String
# Reading Strings Backwards
- Typically a String is read from left to right
- To read a String backwards, simply change the starting index and ending index of the for loop that increments through the String
- A for loop makes it easy to go backwards as well as forward
```java
String str = "Read this backwards";
String strBackwards = "";

for(int i = str.length()-1; i >= 0; i--) {
	strBackwards+= str.substring(i, i+1);
}//end for
```
# Searching and Strings
- There are a few different ways to search for a specific character of String inside of an existing String
- The first is a for loop, which can be altered to search, count, or replace characters or Substrings contained in Strings

# Parsing a String
- Parsing means dividing a String into a set of Substrings
- Typically, a sentence (stored as a String) is parsed by spaces to separate the words of the sentence rather than the whole sentence
- This makes it easier to rearrange the words than if they were all together in one String
- You may parse a String by any character or Substring
- Below are two techniques for parsing a String:
	- For loop
	- Split
## Parsing a String with a For Loop
- Increment through the for loop until you find the character or Substring where you wish to parse it
- Store the parsed components
- Update the String 
- Manipulate the parsed components as desired
### Steps to Parsing a String with a For Loop (SLIDE 20)
---
# References
1. 