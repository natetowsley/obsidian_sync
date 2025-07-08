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
# Collections
- We have seen previously that we can use arrays to store items of the same type
- The main issue with arrays is that they have to be manually sized before use
- Arrays are often used to store primitive data up to a pre-set quantity
## Collections Without Generics Example
1. Create a project named cells
2. Create Cell class:
```java
public class Cell {
	private String data;

	public void setValue(String celldata) {
		data = celldata;
	}//end method setValue

	public String getValue() {
		return data;
	}//end method get

	public String toString() {
		return data;
	}//end method toString
}//end class Cell
```
- This is a non-generic Cell class
3. Create a class that will act as your own simple data structure (collection) to store multiple Cell occurrences
```java
public class CellCollection {
	Cell[] cells;
	int index = 0;

	public CellCollection(int size) {
		cells = new Cell[size];
	}//end constructor

	public void add(Cell c) {
		cells[index] = c;
		index++;
	}//end method add

	public Cell get(int i) {
		return cells[i];
	}//end method get
	//more methods...
}//end class CellCollection
```
- In its current state this is not that useful
- We would have to create more methods, such as insert, sort and delete
### Implementing your Collection
4. Create the following driver class to test the collection:
```java
public class CellCollectionDriver {
	public static void main(String[] args) {
		CellCollection cells = new CellCollection(5);
		
		cells.add(new Cell());
		cells.add(new Cell());
		
		System.out.println(cells.get(0));
		System.out.println(cells.get(1));
		
		cells.get(0).setValue("First Cell");
		cells.get(1).setValue("Second Cell");
		
		System.out.println(cells.get(0));
		System.out.println(cells.get(1));
	}//end method main
}//end class
```

## Collections With Generics Example
- We could try to create a generic collection similar to our non generic example
```java
public class CellGenericCollection<T> {
	T[] cells;
	int index = 0;

	public CellGenericCollection(int size) {
		cells = new T[size];
	}//end constructor

	public void add(T c) {
		cells[index] = c;
		index++;
	}//end method add

	public T get(int i) {
		return cells[i];
	}//end method get
}//end class CellCollection
```
- The problem is we should not create generic arrays in java and this would produce an error:
```java
public CellGenericCollection(int size) {
	cells = new T[size];
}//end constructor
```
- The constructor could be modified but this would produce a non type safe solution, therefore removing one of the advantages of generics
```java
public CellGenericCollection(int size) {
	cells = (T[]) new Object[size];
}//end constructor
```

# Collections - Introduction
- Data structures are used a lot in programming and as such Java comes with pre-built collection classes for you to utilize
- These save you and every other developer the task of having to create similar storage structures
- They come in a few guises, each with its own pros and cons
- Collection is an interface in the `java.util` package that is used to define a group, or collection of objects
- It includes sets and lists and is important in data storage
- Because it is in the `java.util` package, it will be necessary to import the `java.util` package into any programs you write using a collection
- This can be done by typing the following class declaration at the top of the program:
```java
import java.util.*;
```
## Collections Class Hierarchy
- Java defines three main interface collections
- This forces any classes that use the collection interface to define its methods such as add()
![[Pasted image 20250708104040.png|650]]

# Lists
- A list, in Java, is an ordered collection that may contain duplicate elements
- In other words, List extends Collections
- Important qualities of Lists are:
	- They grow and shrink as you add and remove objects
	- They maintain a specific order
	- They allow duplicate elements
# ArrayLists
- Until now we have been using arrays inside a collections class to create a collections interface
- With arrays, you are restricted to the size of the array that you initiate inside the constructor
- ArrayLists are very similar to arrays, except that you do not need to know the size of the ArrayList when you initialize it, like you would with an array
## Code to Initialize an ArrayList
- You may alter the size of the ArrayList by adding or removing elements
- The only information you need when initializing an ArrayList is the object type that it stores
- The following code initializes an ArrayList of Accounts
```java
ArrayList<Account> account = new ArrayList<Account>();
```
## ArrayList Methods
- The ArrayList class already exists in Java
- It contains many methods, including the following:

| **Method**                       | **Method Description**                                                                 |
| -------------------------------- | -------------------------------------------------------------------------------------- |
| `boolean add(E e)`               | Appends the specified element to the end of the list                                   |
| `void add(int index, E element)` | Inserts the specified element at the specified position                                |
| `E get(int index)`               | Returns the element at the specified position                                          |
| `E set(int index, E element)`    | Replaces the element at the specified position in the list with the specified element  |
| `E remove(int index)`            | Removes the element at the specified position in the list                              |
| `boolean remove(Object o)`       | Removes the first occurrence of the specified element from this list, if it is present |
# Sets
- A set is a collection of elements that does not contain duplicates
- For example, a set of integers 1, 2, 2, 3, 5, 3, 7 would be:
	- `{1, 2, 3, 5, 7}`
- All elements of a set must be of the same type
- For example, you can not have a set that includes integers and Strings, but you could have a set of integers and a separate set of Strings
- The Set interface contains only methods inherited from the Collection interface
## Implementing Sets with a HashSet
- Lists, which are a collection that may contain duplicates, are implemented through ArrayLists
- Similarly, Sets are commonly implemented with a HashSet
- A HashSet:
	- Is similar to an ArrayList, but does not have any specific ordering
	- Is good to use when order is not important
### Some HashSet Methods

| **Method**                   | **Method Description**                                              |
| ---------------------------- | ------------------------------------------------------------------- |
| `booelan add(Object o)`      | Adds the specified element to this set if it is not already present |
| `boolean remove(Object o)`   | Removes the specified element from the list if present              |
| `int size()`                 | Returns the number of elements in the set                           |
| `void clear()`               | Removes all of the elements from this set                           |
| `boolean contains(Object o)` | Returns true if this set contains the specified element             |
| `boolean isEmpty()`          | Returns true if this set contains no elements                       |
### HashSets Coin Example
- Imagine there are 35 coins in a bag
- There is no special order to these coins, but the bag can be searched to see if it contains a certain coin
- Coins can be either added or removed from the bag, and the amount of coins is always known
- Think of the bag as the HashSet
- There is no ordering and therefore no indexes of the coins, so we cannot increment through or sort HashSets
- Even if we incremented through or sorted the coins, with one little shake of the bag, the order is lost
- HashSets have no guarantee that the order will be the same throughout time
- HashSets are often used when you require to tell if an instance that you are trying to add to the collection already exists
### Searching Through HashSets
- Although HashSets do not have ordering, we can search through them, just like we could search through the bag to see if the coin we are looking for is in the bag
- For example, to search for a coin in the HashSet bagOfCoins, use HashSet's contains(element) as demonstrated below:
```java
bagOfCoins.contains(coin5);
//returns true if bagOfCoins contains the coin
```
---
# References
1. 