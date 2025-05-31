---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience/Java
  - ComputerScience
Date Created:
---
---
# Java JRE and Java JDK
- Differences between Java JRE and Java JDK:
	- Java Runtime Environment (JRE) contains only the necessary functionality to start Java programs, such as Internet applications
	- Java Development Kit (JDK) contains functionality to start Java programs as well as develop them
	- At a minimum, the Java JRE is required to execute Java applications

# Steps to Launch Eclipse
- The steps shown in the following slides are for using the Eclipse Java IDE
	- Different IDEs may have different steps
- Open Eclipse
- When prompted, enter the pathname for the workspace into which you will store your Java projects and click the OK button
	- This can be you c:\ drive, or possibly a network drive
- Eclipse will start and display that Welcome page
- Close the Welcome page by clicking the X next to the Welcome tab name
## Eclipse Welcome Page
- There are valuable resources available from the Welcome page
- You can return to the Welcome page by choosing Welcome from the Help menu

# Eclipse Edit Area and Views
- Eclipse provides an edit area and several views
- An editor is where you type in your Java source code
- Views are sub-windows that provide information about your project
![[Pasted image 20250527103712.png|500]]

# Eclipse Edit Area Tabs
- The edit area uses tabs when more than one file is open
![[Pasted image 20250527103834.png|500]]

# Eclipse Edit Area Windows
- The edit area can have multiple windows occupy the space
![[Pasted image 20250527103932.png|500]]
## Additional Details on Edit Areas and Views
- A combination of views and editors are referred to as a perspective
- You can choose Open Perspective from the Window menu

# The Workspace
- All projects are developed and modified in a workspace
- A workspace is a collection of Projects
- In this course, you may use the same workspace for all practice projects and packages
- A project is a way from programmers to organize Java files
- A package is how Java and Eclipse organize Java files that are related
- Using packages will ensure that related files can find each other
## Switching Workspaces
- You can Switch Workspaces
	- From the File menu change to a different physical location for you files
![[Pasted image 20250527104506.png|400]]
# High-Level Steps to Create a Program in Eclipse
- Create a project
- Create a Package (inside the src folder of the project)
- Create Class(es) inside the package
	- At least one of the classes must contain a main method
		- This class is called the Driver class
- Compile the Java code
- This creates a .class file
- Run the Java code from the Driver class

# Projects in Eclipse
- In Eclipse:
	- All programs must reside inside a project for proper compilation
	- You may have one or multiple class files in one project
	- One of the classes must contain a main method
## Create a Project in a Java IDE
- Create your first project in your Java IDE
	- The reference materials for this lesson show the steps to do this for both Eclipse and NetBeans
		- Different IDEs will have varying steps
### Project Display
- The project is created and displayed as a folder
- It displays in the package view to the left of the edit area
![[Pasted image 20250527110537.png|300]]
### Naming Packages
- For this course, package names should be the same as the project name using lower camel case
![[Pasted image 20250527110628.png|500]]

# A Java Class
- A class in Java is a construct that is used as a blueprint to create objects
- A class is also a construct in which objects are created

# The Main Method
- A main method in Java is the method inside a class that runs when the class is compiled and executed
- The class containing the main method is also referred to as the Driver Class

# Syntax Errors
- You may have to correct some syntax errors that are a result of typing errors
- Your IDE will highlight syntax errors in your code
- See if you can correct them without asking for assistance
- Pay particular attention to the ";" at the end of each line, and that you "{"
 has a matching "{"

# Java Class Comments
- Add comments to your code to describe what the lines of code do
	- Comments are ignored by the Java compiler
	- To add a comment, type // in front of the comment for a single line comment
	- To add a block comment (for multiple lines) use `/*` to begin the comment, and `*/` to end

# Terminology
- Key terms used in this lesson included:
	- Camel case
	- Java IDE:
		- edit and view areas, perspective, workspace
	- Java JRE vs. Java JDK
	- Java classes
	- Java packages
	- Java main methods
---
# References
1. 