---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Python
Date Created:
---
---
# Collections

> [!important] 🫂Collections reference
> 
> > [!info] collections — Container datatypes  
> > Source code: Lib/collections/__init__.  
> > [https://docs.python.org/3/library/collections.html](https://docs.python.org/3/library/collections.html)  
A single “variable” used to store multiple values
- Each value inside a collection is known as an element
- Also known as sequence types
- It is best practice to make variable name plural when declaring a collection
```Python
fruits = ["apple", "orange", "banana", "coconut"]  # List made
print(fruits[2])  # Will print "banana"
print(fruits[0: 3]) # Will print "['apple', 'orange', 'banana']"
```
- For loops can be used with collections
    - Is common practice to use non-plural of collection name as counter name
```Python
fruits = ["apple", "orange", "banana", "coconut"]
for fruit in fruits:
	print(fruit, end=" ")  # Will print "apple orange banana coconut"
```
### Collection methods
- `print(dir(collectionName))` will print all methods that can be used by your collection
    - Works for lists, sets, and tuples
    - `print(help(collectionName))` prints a description of all available methods
|   |   |
|---|---|
|_**Method**_|_**Purpose**_|
|len(collection)|Returns the length of a collection|
|(“x” in collection)|Returns True if x is in collection, False if not|
## Lists `[]`
- Ordered and changeable. Duplicates OK
- Elements in a list must be seperated by comma and all enclosed with square brackets `[]`
- To access an element at specific value of list, use index operator with index of desired element
    - First value is at index 0
    - `[start: end: step]`
- Values in lists can be reassigned using index operator as well
- Items in list do not have to be same type but most commonly are
```Python
fruits = ["apple", "orange", "banana", "coconut"]
fruits[0] = "pineapple" # Replaces "apple" with "pineapple"
print(fruits[0])   # Will print "pineapple"
```
### List Methods

| _**Method**_            | _**Purpose**_                                  |
| ----------------------- | ---------------------------------------------- |
| list.append(”value”)    | Appends value to the end of the list           |
| list.remove(”value”)    | Removes value from the list                    |
| list.insert(x, “value”) | Inserts value at index x in list               |
| list.sort()             | Will sort a list in alphabetical order         |
| list.reverse()          | Reverses order of a list based on order placed |
| list.clear()            | Clears a list entirely                         |
| list.index(”value”)     | Returns the index of value                     |
| list.count(”value”)     | Counts how many times value appears in list    |
### Nested Lists
- A list can contain other lists
    - Can be used to arrange data into hierarchical structures
- Items in a nested list must use two indexes to access items of the sublist
```Python
nested_list = [[1, 2, 3], [4, 5], 6]
print(nested_list[0][2]) # prints 3
```
_**IMPORTANT**_
- The name of an ordinary variable is the **name of its content**
- The name of a list is the name of a **memory location where the list is stored**
```Python
list_1 = [1]
list_2 = list_1
list_1[0] = 2
print(list_2)
```
- The assignment: `list_2 = list_1` copies the name of the array, not its contents. In effect, the two names (list_1 and list_2) identify the same location in the computer memory. Modifying one of them affects the other, and vice versa.
### Concatenating
- Concatenate: join two things together
- The `+` operator can be used to concatenate two lists
    - Cannot concatenate a list with another data type, such as a number
- The `+=` augmented assignment operator can also be used to concatenate lists
### **Slicing**
- Slice: A span of items taken from a sequence
- `mylist[start:end]` can be used to get around this and create a new list
    - start index included in list
    - end index not included in list
```Python
my_list = [10, 8, 6, 4, 2]
new_list = my_list[1:3]
print(new_list) # Will print [8, 6]
```
- `my_list[:3]` is a more compact way to code `my_list[0:3]`
- Similarly, if you omit the `end` in your slice, it is assumed that you want the slice to end at the element with the index `len(my_list)`
    - `my_list[2:]`
- Omitting both `start` and `end` makes a **copy of the whole list**
    - `my_list[:]`
### `in` and `not in` Operators
- returns a boolean value after checking if a value is stored inside a list or not
```Python
my_list = [0, 3, 12, 8, 2]
print(5 in my_list)     # prints "False"
print(5 not in my_list) # prints "True"
print(12 in my_list)    # prints "True"
```
### List Comprehension
- List comprehension offers a more compact syntax when you want to create a new list based on the values of an existing list or another iterable (tuple, string, array, range, etc.)
    - Typically, list comprehensions are written in a single line of code
```Python
my_list = []
for i in range(5):
	my_list.append(i)
	
print(my_list) # This works but is very bulky
```
```Python
my_list = [i for i in range (5)] # List comprehension
print(my_list) 
```
- List comprehension can also be nested
```Python
string = '0123456789'
matrix = [[string[j] for j in range(10)] for i in range(10)]
for row in matrix:
    print(row) # prints ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
                      # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
	   				  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
					  # ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
```
## Sets `{}`
- Unordered and immutable (cannot alter values), but Add/Remove OK. NO duplicates
- Unable to use indexing on sets as they are unordered
- Work well when working with constants
### Set Methods

| _**Method**_        | _**Purpose**_                                   |
| ------------------- | ----------------------------------------------- |
| set.add(”value”)    | Will add value to set                           |
| set.remove(”value”) | Will remove value from set                      |
| set.pop()           | Removes and returns a random element from a set |
| set.clear()         | Will completely clear a set                     |
## Tuples `()`
- Ordered and unchangeable. Duplicates OK. FASTER
- Only methods are `tuple.index(”value”)` and `tuple.count(”value”)`
- It is also possible to create a tuple just from a set of values separated by commas
```Python
tuple_1 = (1, 2, 3, 4)
tuple_2 = 1., .5, .25, .125
empty_tuple = ()
one_element_tuple = 1.,
```
- A special situation is the construction of tuples containing 0 or 1 items
    - Empty tuples are constructed by an empty pair of parentheses
    - A tuple with one item is constructed by followin a value with a comma
```Python
empty_tuple = ()
one_item_tuple = ('item',)
```
  
## Dictionaries
A collection of {key: value} pairs
- Ordered and changeable. NO DUPLICATES
- Not a sequence type, but can be easily adapted to sequence processing
- Contents can be changed
### Dictionary Methods

| _**Method**_             | _**Purpose**_                                              |
| ------------------------ | ---------------------------------------------------------- |
| dic.get(key)             | Gets the value from the key “key”                          |
| dic.update({Key: Value}) | Adds a key value pair to the end of the dictionary         |
| dic.pop(Key)             | Will remove a key value pair from the dictionary           |
| dic.popitem()            | Will remove the latest key value pair from the dictionary  |
| dic.clear                | Will clear the dicitonary                                  |
| dic.keys()               | Returns the keys of a dictionary                           |
| dic.values()             | Returns the values of a dictionary                         |
| dic.items()              | Returns a dictionary object resembling a 2d list of tuples |
```Python
# Dictionary example
tel = {'jack': 4098, 'sape': 4139}
tel['guido'] = 4127
tel # {'jack': 4098, 'sape': 4139, 'guido': 4127}
print(tel['jack']) # prints "4098"
del tel['sape']
tel['irv'] = 4127
tel # {'jack': 4098, 'guido': 4127, 'irv': 4127}
list(tel) # ['jack', 'guido', 'irv']
sorted(tel) # ['guido', 'irv', 'jack']
'guido' in tel # True
'jack' not in tel # False
```
---
# References
1. 