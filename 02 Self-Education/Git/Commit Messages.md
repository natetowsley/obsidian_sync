---
tags:
  - ComputerScience
  - Git
Date Created: 2025-06-07
---
```table-of-contents
```
---
# Bad vs Good Commits
- When it comes to writing commits, it is crucial to write them effectively
- EX: Bad Commit message
```
fix a bug
```
- This message is much too vague
- A good commit message will explain the **why** behind your changes
	- Commit messages describe the problem you changes solve and how it solves them
- Effective commits consist of two separate parts: a subject, and a body:
	- Subject
		- A brief summary of the change you made to the project
		- `This is a change I made to the codebase`
	- Body
		- A concise yet clear description of what you did
		- `Describe the problem your commit solves and how`
- Good commit example
```
Addmissing link and alt text to the company's logo

Screen readers won't read the images to users with disabilities without this information
```

# How to commit with a Subject and Body in the Message
- Up until now, you've been told to commit with `git commit -m <message>`
- To make a commit with subject and body in message, the simplest way is to type `git commit` without the `-m` flag and message argument
- Doing so will open a new Visual Studio Code tab if you had set Visual Studio Code as the Git editor
- You can remove any comments and enter your multi-line messages
	- When you save and close the tab, your commit will be creates
## When to Commit
- A good way to view a commit is like a "snapshot" of your code at the moment that it was made
- That version of your code up to that point will be saved for you to revert back to or look back at
- It is considered best practice to commit every time you have a meaningful change in the code
	- This will create a timeline of your progress and show that your finished code didn't appear out of nowhere

# The Seven Rules of a Great Git Commit Message
## 1. Separate Subject from Body with a Blank Line
- Though not required, it is a good idea to begin the commit message with a single short line summarizing the change, followed by a blank line in a commit message is treated as the commit title, and that title is used throughout Git
- Not every commit requires both a subject and a body
	- Sometimes a single line is fine, especially when the change is so simple that no further context is necessary
	- EX: `fix typo in introduction to user guide`
	- `-m` often used when a simple commit message can be written
---
# References
1. 