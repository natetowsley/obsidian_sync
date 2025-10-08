---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/OOP
Date Created: 2025-08-28
---
```table-of-contents
```
---
- Java is statically typed
	- Once a variable of a certain type is defined, it cannot be changed
![[Pasted image 20250904103307.png|400]]

# Primitive and Reference Types

| primitive types | reference types |
| --------------- | --------------- |
| byte            | Byte            |
| short           | Short           |
| int             | Integer         |
| long            | Long            |
| float           | Float           |
| double          | Double          |
| boolean         | Boolean         |
| char            | Character       |

## Reference vs Primitive
- Reference types can be:
	- first class citizens objects
	- composite types (rare)
- Have methods and data
- These data are the state of the object

# methods
- A *function* is a collection of code that we can call by name
- A **method** is a function that belongs to an object
- We access these methods with **dot notation**
	- `myObject.addition();`

# What is an Object?
- An object is a collection of data and methods to operate on those data
	- Specifically an *instance* of a class
- An object is responsible for maintaining it's **STATE**

# Encapsulation
- A language mechanism for restricting direct access to some of the object's components
- A language construct that facilitates the bundling of data with the methods (or other functions) operating on those data
- Objects have data and are responsible for the **state** of those data
- We must be able to TRUST those data
# Java Access Modifiers
>Access modifiers control who and what can modify our code
## What are the Access Modifiers?
- private
- public
- package-private
- protected
![[Pasted image 20250904103935.png|500]]
- We control what data is held in our objects by controlling who has access
- A mechanism for this are **Setters** and **Getters**

# UML Diagrams
>The creation of UML (Unified Modeling Language) was originally motivated by the desire to standardize the disparate notational systems and approaches to software design. It was developed by Grady Booch, Ivar Jacobson, and James Rumbaugh at Rational Software in 1994-1995, with further development led by them through 1996

![[Pasted image 20250904104246.png|400]]
## Creating UML
- [Draw.io](https://app.diagrams.net/) is easy to access and fairly clear
- IntelliJ Idea Ultimate will generate UML once the code is written
- Other technologies for creating UNL include:
	- Pencil & Paper
	- Whiteboard
	- Tablet
	- PowerPoint/ Google Slides
- There is no excuse to not have UML diagram if you didn't get IntelliJ Ultimate
---
# References
1. 