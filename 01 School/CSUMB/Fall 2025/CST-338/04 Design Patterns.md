---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/Java
  - ComputerScience/OOP
Date Created:
---
```table-of-contents
```
---
# Resources
- By the so called "Gang of Four" this is *the* book on design patterns
	- It is dry, terse, and not fun to read
	- It has LOTS of great info
	- There are PDFs available
- Game Programming Patterns by Robert Nystrom
	- Discusses the why of design patterns with computer games as a context
	- All in C++
	- Available for free online
- [Sourcemaking.com](https://sourcemaking.com) 
	- GREAT site
	- Has LOTS of code examples
	- Will be used in this course a lot

# What are Design Patterns?
- Design Patterns are like kata
	- Good practice, not something to blindly repeat
- They are like data structures
	- A tool to use depending on the problem
- Nystrom says:
	- "A simple structure used cleverly is better than a clever structure used simply"

# Three Flavors
1. **Creational**
	1. Singleton
	2. Factory Method
	3. Builder
2. Structural
	1. Flyweight
	2. Decorator
3. Behavioral
	1. Command
	2. Memento
	3. Observer
	4. State
	5. Strategy

# Commonalities
- Most of these rely on some form of **inheritance**
- It is better to think of these as *ideas* rather than out of the box solutions

> A design pattern is a codified mental model

# Command Pattern
- The command pattern **Turns a method into an object**
- **The method can then be dynamically changed and shared**
- Or to put it another way [SourceMaking](https://sourcemaking.com) 
	- Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations
	- Promote "invocation of a method on an object" to full object status
	- An object-oriented callback
```java
public interface ICommand {
	void execute();
}
```

```java
public class JumpCommand implements ICommand {
	private final Player player;
	
	public JumpCommand(Player player) {
		this.player = player;
	}
	@Override
	public void execute() {
		player.jump();
	}
}
```
## What this allows
- We can store, repeat, and/or undo them
	- Repeating them leads to instant replays
- Commands can be sent over a network
	- This is how remote desktop tends to work
	- Also multiplayer games work this way
- It lets us dynamically change controls
	- GTA walking vs flying vs driving
## How do we do it?
![[Pasted image 20250923104058.png|600]]
### Checklist on Implementing Command
- Define a Command interface with a method signature like execute(), Do(), Activate(), etc
- Create one or more derived classes that encapsulates some subset of the following
	- A "receiver" object, the method to invoke, the argument to pass
- Instantiate a Command object for each deferred execution request
- Pass the command object from the creator (aka sender) to the invoker (aka receiver)
- The invoker decides when to execute()
### Tools we will need
- Interfaces
- Inheritance
- That's it!

# Interfaces
- Interfaces are declared similarly to a class
```java
public interace Istone {
}
```
- To use an interface, we `implement` it
```java
public class PowerStone implements Istone {
}
```
## RULES
- Interface dos
	- An interface may contain any number of **abstract** methods
	- Interfaces look like a normal java file, meaning:
		- Interfaces have a `.java` extension, with the name of the interface matching the name of the file
		- Interfaces compile to `.class` file
- Interface dont's
	- Interfaces can't be instantiated
	- An interface does not contain constructors
	- An interface cannot contain instance fields
		- The only fields that can appear in an interface must be declared both static and final
	- An interface is not *extended* by a class, it is **implemented** by a class
	- An interface extends other interfaces

# Abstract Keyword
- Methods or classes can be abstract
- Abstract methods have no definition
- Abstract methods must be declared in either interfaces or abstract classes
- Abstract methods can have parameters and return types
```java
public abstract class Thanos {
	abstract String armour();
}
```
- Abstract classes cannot be instantiated
	- `new` will fail
- They may only be **extended**
- The may have fields, methods, and abstract methods

# Abstract vs Interface
- Use an abstract class if:
	- Code will be shared among several closely related classes
	- Classes that extend the abstract class have many common methods or fields or require access modifiers other than public
	- A need to declare non-static or non-final fields
- Use an interface if
	- Unrelated classes will implement the interface
		- EX: The interfaces Comparable and Cloneable are implemented by many unrelated classes
	- Need to specify the behavior of a particular data type but are not concerned about who implements its behavior
	- Need to take advantage of multiple inheritance of type
## One Major Difference
- Classes can not extend multiple classes
```java
Main extends AbstractOne, AbstractTwo //DOESN't WORK
```
- But we can implement multiple interfaces
```java
static class Main extends AbstractOne implements Ione, ITwo {}
```
- An interface can extend multiple interfaces
```java
public interface IThree extends IOne, ITwo {}
```

# One `final` note
- A final class can't be extended
```java
public final class NoMore {
}
```

```java
public static Main extends NoMore//DOESN'T WORK {
}
```
---
# References
1. 