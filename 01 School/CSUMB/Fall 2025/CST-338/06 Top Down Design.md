---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/OOP
Date Created: 2025-10-09
---
```table-of-contents
```
---
# Step One: Read the Problem FIRST
- Read the instructions completely before taking any action
	1. Read the prompt all the way through
	2. Read it again
	3. Read it one more time to make sure nothing was missed
	4. Keep it open as a reference

# Step Two: Objects
- How many objects do we need?
- Think about the tools we have
	- Arrays, ArrayLists, HashMaps, and Classes
- What objects are we going to need to create?
## Object Oriented Philosophy
- If something has a state, it's an object
	- By this I mean if I can set its name, date, age, temperature, bank balance, etc.
- If something operates on, manipulates, or returns data: It's a method
	- Which belongs to an OBJECT

# Step Three: Methods
- Designing code, especially object oriented code, focuses on 'black boxes'
```java
void toString_test() {
	System.out.println("TESTING To Strings!");
	for (Monster m : monsters) {
		System.out.println(m);
	}
	
	electricRat.setType(Monster.ElementalType.GRASS);
	System.out.println(electricRat);
	
	while (!flowerDino.isFainted()) {
		fireLizard.attack(flowerDino);
	}
	System.out.println(flowerDino);
}
```
![[Pasted image 20251009103715.png|400]]
- When debating on whether or not to make a new method, if in doubt, make a new method
	- Does processing that data make sense where you are?
	- Break things into methods whenever it makes sense
		- It always makes sense
		- If you copy and pasted the same code more than once, make a method

# How Dr. C Stopped Worrying and Learned to Love the TODO
- BEFORE:
```java
System.out.println(machine1);
System.out.println("");
machine1.displayMenu(); //".displayMenu() will be red (intellij)
```

```java
//TODO: implement displayMenu
public void displayMenu() {
	System.out.println("Display not implemented yet");
}
```

- AFTER:
```java
System.out.println(machine1);
System.out.println(""); 
machine1.displayMenu(); //No more error on this line after TODO comment made
```
- Intellij will identify TODO comments and remind you where they are
![[Pasted image 20251009104356.png|400]]

---
# References
1. 