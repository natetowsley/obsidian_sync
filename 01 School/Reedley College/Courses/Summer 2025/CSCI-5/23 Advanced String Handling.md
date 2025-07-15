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
### Steps to Parsing a String with a For Loop
- First a String is required that can be parsed
```java
String str = "Parse this String";
```
- A data structure must be created to store the individual sections of the parsed String, as the number of substrings is unknown an ArrayList is ideal
```java
ArrayList<String> words = new ArrayList<String>();
```
- A while loop is used to work through that String until all the substrings have been removed
```java
while(str.length() > 0) {
	//parsing code goes here
}//end while
```
- Within the while loop, a nested for loop is required that will search through the String until the parse character or the end of the String is found
```java
while(str.length() > 0) {
	for(int i = 0; i < str.length(); i++) {
		if(i == str.length()-1) {
			words.add(str.substring(0));
			str = "";
			break;
		}
		else if(str.charAt(i) == ' ') {
			words.add(str.substring(0, i));
			str = str.substring(i + 1);
			break;
		}//endif
	}//endfor
}//endwhile
```
- The contents of the ArrayList can then be displayed to screen using an enhanced for loop
```java
for(String s : words)
	System.out.print(s + ' ');
//end for
```
- You could then use the ArrayList methods to:
	- Count the number of elements created in the parse
	- Sort the elements into their natural order
	- Display them in any order you choose
- The collection methods that you should use are:
```java
System.out.println("\nThere are " + words.size()
					+ " words in the original String");
Collections.sort(words);
System.out.println(words);
```
- Output should be as follows
![[Screenshot 2025-07-14 at 8.31.30 AM.png|450]]
## Parsing a String: Split
- Split is a method inside the String class that parses a String at specified characters, or if unspecified, spaces
- It returns an array of Strings that contains the Substrings (words) that parsing the String gives
- How to call split on a String:
```java
String sentence = "This is my sentence";
String[] words = sentence.split(" ");
//words will look like {This,is,my,sentence}
String[] tokens = sentence.split("i");
//tokens will look like this {Th,s my sentence}
for(String token : tokens)
	System.out.print(token + ", ");
```
### Parsing a String: Split (Using Multiple Characters)
- It is also possible to split a String by more than one specified character if you use brackets around the characters
- Here is an example:
```java
String sentence = "This is my sentence";

String[] tokens = sentence.split("[ie]");
//tokens will look like this {Th,s ,s my s,nt,nc}
/*each token will be separated by an occurence of an i or any 
occurrence of an e*/
```

# Calling Methods on a String
- These methods are beneficial when working with problems that involve the manipulation of Strings

| **String Method**          | **Description**                                                                                                                                 |
| -------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `contains(CharSequence s)` | Returns true if the String contains s                                                                                                           |
| `indexOf(char ch)`         | Returns the index within this String of the furst occurrence of the specified character and -1 if the character is not in the String            |
| `indexOf(String str)`      | Returns the index within this String of the first occurrence of the specified Substring and -1 if the String does not contain the Substring str |

# StringBuilder vs String
- StringBuilder is a class that represents a String-like object
- It is made of a sequence of characters, like a String
- The difference between String and StringBuilder objects is that:
	- StringBuilder includes methods that can modify the StringBuilder object once it has been created by appending, removing, replacing, or inserting characters
	- Once created, a String is immutable (cannot be changed) it is replaced by a new String instead
	- It is not possible to make modifications to a String
	- Methods used to "modify" a String actually create a new String in memory with the specified changes, they do not modify the old one
	- This is why StringBuilders are much faster to work with: they can be modified and do not require you to create a new String with each modification
- These are some of the important differences between a StringBuilder and a String object

| **StringBuilder**                                                      | **String**                                                              |
| ---------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| Changeable                                                             | Immutable                                                               |
| Easier insertion                                                       | Easier concatenation                                                    |
| Can be more difficult to use, especially when using regular expression | Visually simpler to use, similar to primitive types rather than objects |
| Use when memory needs to be conserved                                  | Use with simpler programs where memory is not a concern                 |
## StringBuilder and String Shared Methods
- StringBuilder shares many of the same methods with String, including but not limited to:

| **String Method**               | **Description**                                                                                                                      |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| `length()`                      | Returns the number of characters in the String                                                                                       |
| `charAt(int i)`                 | Returns the character at index i                                                                                                     |
| `substring(int start)`          | Returns part of the String from index start to the end of the String                                                                 |
| `substring(int start, int end)` | Returns part of the String from index start to index end, not including the character at index end                                   |
| `indexOf(char ch)`              | Returns the index within this String of the first occurrence of the specified character and -1 if the character is not in the String |
# StringBuilder Methods (SLIDE 38)
## Example
- 
---
# References
1. 