---
tags:
  - ComputerScience
  - Git
Date Created:
---
```table-of-contents
```
---
# Cheatsheet
> This is a reference to the most commonly used Git commands
- Commands related to a remote repository
	- `git clone git@github.com:USER-Name/REPOSITORY-NAME.git`
	- `git push` or `git push origin main` (Both accomplish the same goal in this context)
- Commands related to the workflow
	- `git add .`
	- `git commit -m "A message describing what you have done to make this snapshot different`
- Commands related to checking status or log history
	- `git status`
	- `git log`
> The basic Git syntax is `program | action | destination`
- Example:
	- `git add .` is read as `git | add | .` where the period represents everything in the current repository
	- `git commit -m "message"` is read as `git | commit -m | "message"
	- `git status` is read as `git | status | (no destination)`

# Git Best Practices
- **Atomic Commits**
	- Atomic commits are commits that include changes related to only one feature or task of your program
	- Two main reasons to do this
		- If something you change turns out to cause some problems, it is easy to revert the specific change without losing other changes
		- It enables you to write better commit messages
---
# References
1. 