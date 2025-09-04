---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
Date Created: 2025-09-04
---
```table-of-contents
```
---
# Using Google's Style Guide
>[Google's Java Style Guide](https://google.github.io/styleguide/javaguide.html)

1. Class names must be capitalized
	1. What does this say about the file names?
2. EVERY STATEMENT GET BRACES {}
	1. Even empty statements, even one-line statements
3. **Braces are placed on the same line as the statement**
	1. ```java
	   statement { <- HERE
	   }
	   
	   statement
	   {    <-------- NOT HERE
	   }
	   ```

# Comments
- `/** */` <- This is a javadoc comment
- Each method you create (not autogenerate) MUST have a Javadoc comment
## Example
```java
/**
* Returns a Random action
* @return A String representing a generic action
*/
priate static String getRandomAction() {
	List<String> actions = new ArrayList<>(){};
	actions.add("Drink coffee");
	actions.add("Sleep");
	actions.add("Grade");
	Random random = new Random();
	return actions.get(random.nextInt(actions.size()));
}
```
---
# References
1. [Google's Java Style Guide](https://google.github.io/styleguide/javaguide.html)