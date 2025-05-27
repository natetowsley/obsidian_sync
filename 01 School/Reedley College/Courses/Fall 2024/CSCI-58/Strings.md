---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Basics
  - ComputerScience/Python
Date Created:
---
---
> [!important] 🧵str()
> 
> > [!info] Built-in Types  
> > The following sections describe the standard types that are built into the interpreter.  
> > [https://docs.python.org/3/library/stdtypes.html#str](https://docs.python.org/3/library/stdtypes.html#str)  
## String Methods
- The string class includes many different operations that can come in handy when dealing with strings
- Using print(help(str)) will print a list of string methods to the console

| Method                      | Purpose                                                                 |
|----------------------------|-------------------------------------------------------------------------|
| `len(string)`              | Returns the length of the string                                        |
| `string.find("x")`         | Returns the position of the **first** occurrence of "x"                 |
| `string.rfind("x")`        | Returns the position of the **last** occurrence of "x" (reverse find)   |
| `string.capitalize()`      | Capitalizes the first letter in the string                              |
| `string.upper()`           | Converts all alphabetical characters to uppercase                       |
| `string.lower()`           | Converts all alphabetical characters to lowercase                       |
| `string.isdigit()`         | Returns `True` if the string is composed only of digits                 |
| `string.isalpha()`         | Returns `True` if the string is composed only of letters                |
| `string.count("x")`        | Counts how many times "x" appears in the string                         |
| `string.replace("x", "y")` | Replaces all occurrences of "x" with "y"                                |
| `string.join(iterable)`    | Joins elements of `iterable` using the string as a separator            |

## F-Strings
- A formatted string literal, or an f-string, is a string literal that is prefixed ‘f’ or ‘F’
    - These strings may contain replacement fields, which are expressions delimited by curly braces `{}`
```Python
name = "Fred"
print(f"He said his name is {name}") # Prints "He said his name is Fred"
print(f"{name.lower()} is funny.") # Prints "fred is funny."
```
## String Indexing
- Accessing elements of a sequence using `[]` (indexing operator)
    
    - `[start : end : step]`
    - Starting position is inclusive, end is exclusive
    - If all characters until end of string are needed, a specified end is not needed
        - `[start:]`
    - Using negative indexes will begin the search from the end and work backwards
    - The `step` property will skip by x amount of indexes
    
    ```Python
    credit_number = "1234-5678-9012-3456"
    
    print(credit_number[3]) # Will print "4"
    
    print(credit_number[0:4] # Will print "1234" 4 exclusive doesn't use "-"
    
    print(credit_number[5]) # Will print "5678-9012-3456"
    
    print(credit_number[::2]) # Will print "13-6891-46"
    ```
    
    - To reverse a string, set `step` to -1
## String Formatting
- The `%` operator after a string is used to combine the string with variables
    - Will replace %s in a string with the string variable that comes after it
    - The %d special symbol is used as a placeholder for numeric or decimal values
```Python
name = "John"
# Note: %s is inside the string, % is after the string.
print("Hello, PyCharm! My name is %s!" % name) # Replaces %s with "John"
print("I'm %d years old" % 21) # Prints "I'm 21 years old"
```
## In Operator
- If you want to check whether a string contains a specific letter or a substring, you can use the `in` keyword
```Python
ice_cream = "ice cream"
print("cream" in ice_cream) # Prints True
```
## Character Escaping
- Backslash used to escape special symbols, such as quotation marks
```Python
print("It\'s me") # Prints "It's me"
```

| Type   | Purpose                  |
|--------|--------------------------|
| `\'`   | Single Quotation Mark    |
| `\"`   | Double Quotation Marks   |
| `\n`   | New Line                 |
| `\t`   | Tabulation               |
| `\\`   | Backslash                |

## Basic String Operations
- Many types of programs perform operations on strings
- In Python, many tools for examining and manipulating strings
    - Strings are sequences, so many of the tools that work sequences work with strings
## Accessing the Individual Characters in a String
- To access an individual character in a string
    
    - Use a `for` loop
        - Format: `for` _`character`_ `in` _`string`_:
        - Useful when need to iterate over the whole string, such as to count the occurrences of a specific character
    
    - Use indexing
        - Each character has an index specifying its position in the string, starting at 0
        - Format: _`character`_ `=` _`my_string`_`[`_`i`_`]`
![[image 1 35.png|image 1 35.png]]
- `IndexError` exeception will occur if:
    - You try to use an index that is out of range for the string
        - Likely to happen when loop iterates beyond the end of the string
    - `len(`_`string`_`)` function can be used to obtain the length of a string
        - Useful to prevent loops from iterating beyond the end of a string
## String Concatenation
- Concatenation: Appending one string to the end of another string
    - Use the + operator to produce a string that is a combination of its operands
    - The augmented assignment operator += can also be used to concatenate strings
        - The operand on the left side of the += operator must be an existing variable; oherwise, an exception is raised
## Strings Are Immutable
- Strings are immutable
    - Once they are created, they cannot be changed
        - Concatenation doesn’t actually change the existing string, but rather creates a new string and assigns the new string to the previously used variable
    - Cannot use an axpression of the form
    - `string[`_`index`_`] =` _`new_character`_
        - Statement of this type will raise an exception
## String Slicing
- Slice: Span of items taken from a sequence, known as _substring_
    - Slicing format: _`string`_`[`_`start`_ `:` _`end`_`]`
        - Expression will return a string containing a copy of the characters from _`start`_ up to, but not including, _`end`_
        - If _`start`_ not specified, `0` is used for start index
        - If _`end`_ not specified, `len(string)` is used for end index
    - Slicing expressions can include a step value and negative indexes relative to end of string
## Testing, Searching, and Manipulating Strings
- You can use the `in` operator to determine whether one string is contained in another string
    - General format: _`string1`_ `in` _`string2`_
        - _`string1`_ and _`string2`_ can be string literals or variables referencing strings
- Similarly you can use the `not in` operator to determine whether one string is not contained in another string
  
## More String Methods
- Strings in Python have many types of methods, divided into different types of operations
    - General format:
        - _`mystring.method(arguments)`_
- Some methods test a string for specific characteristics
    - Generally Boolean methods, that return `True` if a condition exists, and `False` otherwise
![[image 2 33.png|image 2 33.png]]
- Some methods return a copy of the string, to which modifications have been made
    - Simulate strings as mutable objects
- String comparisons are case-sensitive
    - Uppercase characters are distinguished from lowercase characters
    - `lower` and `upper` methods can be used for making case-insensitive string comparisons
![[image 3 32.png|image 3 32.png]]
- Programs commonly need to search for substrings
- Several methods to accomplish this:
    - `endswith(`_`substring`_`)` : checks if the string ends with _`substring`_
        - Returns `True` or `False`
    - `startswith(`_`substring`_`)` : checks if the string starts with _`substring`_
        - Returns `True` or `False`
    - `find(`_`substring`_`)`: searches for _`substring`_ within the string
        - Returns lowest index of the substring, or if the substring is not contained in the string, returns -1
    - `replace(`_`substring, new_string`_`)`:
        - Returns a copy of the string where every occurrence of _`substring`_ is replaced with _`new_string`_
![[image 4 30.png|image 4 30.png]]
  
## The Repetition Operator
- **Repetition operator:** makes multiple copies of a string and joins them together
    - The * symbol is a repartition operator when applied to a string and an integer
        - String is left operand; number is right
    - General format: _`string_to_copy * n`_
    - Variable reference a new string which contains multiple copies of the original string
  
## Splitting a String
- `split` method: returns a list containing the words in the string
    - By default, uses space as separator
    - Can specify a different separator by passing it as an argument to the `split` method
---
# References
1. [[User Input]]
2. [[Variables]]