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
- We have seen previously that we can use ArrayLists and HashSets to store multiple data
- Java has a rich library of collections that will handle a varied list of requirements

# Maps
- A map is a collection that links a key to a value
- Similar to how an array links an index to a value, a map links a key (one object) to a value (another object)
- Maps, like sets, cannot contain duplicates
- This means each key can only exist once and can only link to a single value
- Since Map is an interface, you must use on of the classes that implement Map such as HashMap to instantiate a map
## HashMaps
- HashMaps are maps that link a Key to a Value
- The Key and Value can be of any type, but their types must be consistent for every element in the HashMap
- The KeyType and ValueType can be the same or different types
- HashMaps, like sets contain no order
- They do allow one null for the key, and multiple nulls for the value
### HashMap Methods

| **Method**                            | **Method Description**                                                                                      |
| ------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `boolean containsKey(Object Key)`     | Returns true if the HashMap contains the specified Key                                                      |
| `boolean containsValue(Object Value)` | Returns true if this map maps one or more keys to the specified value                                       |
| `V get(Object kay)`                   | Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key |
| `Set<K> keySet()`                     | Returns a set of the keys contained in the HashMap                                                          |
| `Collection<V> values()`              | Returns a collection of the values contained in the HashMap                                                 |
| `V remove(Object Key)`                | Removes the mapping for the specified key from this map if present                                          |
| `int size()`                          | Returns the number of key-value mappings in the HashMap                                                     |
### HashMap Example
- This is a generic breakdown of how to initialize a HashMap
```java
HashMap<KeyType, ValueType> mapName = new HashMap<KeyType, ValueType>();
```
- If a program is required to group together and store many different fruits as well as their colors then a HashMap is an ideal Collection to implement
```java
import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String, String> fruitBowl = new HashMap<String, String>():
	
		addElements(fruitBowl);

		displayElemnts(fruitBowl);
	}//end method main

	static void addElements(HashMap<String, String> fruitBowl) {
		fruitBowl.put("Apple", "Green");
		fruitBowl.put("Cherry", "Red");
		fruitBowl.put("Orange", "Orange");
		fruitBowl.put("Banana", "Yellow");
	}//end method addElements

	static void displayElements(HashMap<String, String> fruitBowl) {
		for (HashMap.Entry<String, String> fruit : fruitBowl.entrySet()) {
			System.out.println("Fruit: " + fruit.getKey()
								+ " - Color: " + fruit.getValue())
		}//end for
	}//end method displayElements
}
```
- This `displayElements()` function will display
![[Pasted image 20250709101721.png|500]]


- HashMap is just one of many Map collections:
	- Hashtable
	- EnumMap
	- IdentityHashMap
	- LinkedHashMap
	- Properties
	- TreeMap
	- WeakHashMap

# LinkedList Methods
- A Queue is a LinkedList that operates a **First In First Out** system known as **FIFO**
- Stacks are a LinkedList that operates a **Last In First Out** system known as **LIFO**

| **FIFO LinkedList Methods**                                                            | **LIFO LinkedList Methods**                                          |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `add(E e)` Appends the given element to the end of the list                            | `push(E e)` Pushes an element onto the stack represented by the list |
| `removeFirst()` Removes the first element from the list and returns it                 | `pop()` Pops an element from the stack represented by this list      |
| `set(int index, E element)` Replaces the element at the specified position in the list | `size()` Returns the number of elements in this list                 |
## LinkedList: Queues
- A Queue is a list of elements with a first in first out ordering (First In First Out, also known as FIFO)
- When you enqueue (Add) an element, it adds it to the end of the list
- When you dequeue (Remove) an element, it returns the element at the front of the list and removes that element from the list
- Queues are commonly used when the order of adding an object is important, with the first one added being the first one removed
- For example, picture a line at the movie theater
	- The first person there is the first to get their ticket
### Using LinkedList as a Queue
- LinkedList is initialized in the same way as an ArrayList
```java
import java.util.LinkedList;

public class LettersQueue {
	public static void main(Stringp[] args) {
		//This will be implemented as a queue
		LinkedList<String> lettersQ = new LinkedList<String>();

		//Adding elements to the end of the queue
		lettersQ.add("A");
		lettersQ.add("B");
		lettersQ.add("C");
		lettersQ.add("D");

		//display the contents of the linked list
		System.out.println("Linked list : " + lettersQ);
		//display the size of the linked list
		System.out.println("Queue Size: " + lettersQ.size());

		//while the Queue is not empty remove each element
		while(!lettersQ.isEmpty()) {
			System.out.println(lettersQ.removeFirst());
		}//end while
		//display the contents of the linked list
		System.out.println("Linked list : " + lettersQ);
	}
}
```
- Output will be as follows
![[Pasted image 20250709102852.png|450]]
## LinkedList: Stacks
- Stacks are Queues that have reverse ordering to the standard Queue
- Instead of FIFO ordering (like a queue or line at the theater), the ordering of a stack is last in first out
- This can be represented by the acronym **LIFO** (**Last In First Out**)
### Stack of Pancakes Example
- If there was a pile of pancakes it would typically be called a "stack" of pancakes because the pancakes are added on top of the previous leaving the most recently added pancake at the top of the stack
- To remove a pancake, you would have to take off the one that was most recently added: The pancake on the top of the stack
- If you tried to remove the pancake that was added first, you would most likely make a very large mess
## Implementing a Stack: Deque
- One way to implement a Stack is by using a Double-Ended Queue (or deque, pronounced "deck", for short)
- These allow us to insert and remove elements from either end of the queue using methods inside the Deque class
- Deques like building blocks, allow you to put pieces on the bottom of your structure or on the top, and likewise pull pieces off from the bottom or top
- Deques can be implemented by LinkedLists

# LinkedLists
- A LinkedList is a list of dynamically-stored elements
- Like an ArrayList, it changes size and has an explicit ordering, but it doesn't use an array to store information
- It uses an object known as a Node
- Nodes are like roadmaps: they tell you where you are (the element you are looking at), and where you can go (the previous element and the next element)
![[Pasted image 20250709103605.png]]
## Adding Nodes to LinkedLists
- Ultimately, we have a list of Nodes, which point to other Nodes and have an element attached to them
- To add a Node, set its left Node to the one on its list, and its right Node to the one on its right
- Do not forget to change the Nodes around it as well
- A fourth node was added to the end of this linked list:
![[Pasted image 20250709103728.png]]
## Using a LinkedList as a Stack
- LinkedList is initialized in the same way as ArrayList
```java
import java.util.LinkedList;

public class LettersStack {
	public static void main(String[] args) {
		//This will be implemented as a stack
		LinkedList<String> letterS = new LinkedList<String>();
		
		//Adding elements to the top of the stack
		letterS.push("A");
		letterS.push("B");
		letterS.push("C");
		letterS.push("D");
	
		//display the contents of the linked list
		System.out.println("Linked list : " + letterS);
	
		//display the size of the linked list
		System.out.println("Stack size: " + letterS.size());
	
		//while the stack is not empty remove each element
		while(!letterStack.isEmpty()) {
			System.out.println(letterS.pop());
		}//end while
		//display the contents of the linked list
		System.out.println("Linked list : " + letterS);
	}
}
```
- Output will look like this:
![[Pasted image 20250709104210.png|400]]

# Sorting a Collection
- Using the sort method of the Collections class has already been discussed in this course in regards to sorting using simple elements
- In the classlist exmaple the ArrayList of student names were sorted using the Collections.sort() method as they were stored as Strings
```java
Collections.sort(studentNames);
```
- This sorted the ArrayList in its natural alphabetic order
- Sort is a static method within the class Collections, so doesn't have to be initialized
- This is fine with simple elements but what if the students' details had been stored in a class instead of being represented by a String?
- What if there were additional fields, which field should the students be sorted on?
```java
public class Student {
	private String firstName;
	private String lastName;
	private int mark;
}//end class Student
```

# The Comparable Interface
- For the classes to have a natural order the interface java.lang.Comparable can be implemented
```java
public interface Comparable<T> {
	int compareTo(T o);
}//end method main
```
- If the Comparable interface was implemented then the code for compareTo must be included in the class
- Eclipse will prompt you to add unimplemented methods to help you with this
## compareTo()
- The compareTo() method will return an integer based on the following:
	- Return a negative value if this object is smaller than the other object
	- Return 0 (zero) if this object is equal to the other object
	- Return a positive value if this object is larger than the other object
- The compareTo() method implementation could have used any or multiple fields from our class
- In this exmaple, the String field lastName was used to sort the students based on their last name
```java
@Override
public int compareTo(Student stud2) {
	if(lastName.compareTo(stud2.getLastName()) < 0)
		return -1;
	if(lastName.compareTo(stud2.getLastName()) == 0)
		return 0;
	return 1;
}//end method compareTo
```
- compareTo() expects an integer value to be returned which can be used to determine the ordering of the objects
---
# References
1. 