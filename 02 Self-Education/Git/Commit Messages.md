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
```
$ git commit -m "Fix typo in introduction to user guide"
```
- The separation of subject from body pays off when browsing the log
- Example:
```
$ git log
commit 42e769bdf4894310333942ffc5a15151222a87be
Author: Kevin Flynn <kevin@flynnsarcade.com>
Date:   Fri Jan 01 00:00:00 1982 -0200

 Derezz the master control program

 MCP turned out to be evil and had become intent on world domination.
 This commit throws Tron's disc into MCP (causing its deresolution)
 and turns it back into a chess game.
```
- And now `git log --oneline`, which prints out just the subject line:
```
$ git log --oneline
42e769 Derezz the master control program
```
- Or, `git shortlong`, which groups commits by user, again showing just the subject line for concision:
```
$ git shortlog
Kevin Flynn (1):
      Derezz the master control program

Alan Bradley (1):
      Introduce security program "Tron"

Ed Dillinger (3):
      Rename chess program to "MCP"
      Modify chess program
      Upgrade chess program

Walter Gibbs (1):
      Introduce protoype chess program
```
## 2. Limit the Subject Line to 50 Characters
- 50 characters isn't a hard limit, just a rule of thumb
- This ensures readability, and forces the author to keep it brief, only including important information
- GitHub will truncate any subject line longer than 72 characters with an ellipsis
	- Go for 50 characters, consider 72 the hard limit
## 3. Capitalize the Subject Line
- Easy as it sounds, always be sure to capitalize the first letter of the subject
- Example:
```
Accelerate to 88 miles per hour
```
## 4. Do not End the Subject Line with a Period
- Trailing punctuation is unnecessary in subject lines
	- This is also not good to remain under 50 characters
## 5. Use the Imperative Mood in the Subject Line
- _Imperative mood_ just mean "spoken or written as if giving a command or instruction"
- Examples:
	- Clean your room
	- Close the door
	- Take out the trash
- A properly formed Git commit subject line should always be able to complete the following sentence:
	- If applied, this commit will ___your subject line here___
- Examples:
	- If applied, this commit will ___refactor subsystem X for readability___
	- If applied, this commit will ___update getting started documentation___
	- If applied, this commit will ___remove deprecated methods___
## 6. Wrap the Body at 72 Characters
- Git never wraps text automatically
- When you write the body of a commit message, you must mind its right margin, and wrap text manually
- The recommendation is 72 characters so Git has plenty of room to indent text while still keeping everything under 80 characters overall
## 7. Use the Body to Explain What and Why vs. How
- This commit from Bitcoin Core is a great example of explaining what changed and why:
```
commit eb0b56b19017ab5c16c745e6da39c53126924ed6
Author: Pieter Wuille <pieter.wuille@gmail.com>
Date:   Fri Aug 1 22:57:55 2014 +0200

   Simplify serialize.h's exception handling

   Remove the 'state' and 'exceptmask' from serialize.h's stream
   implementations, as well as related methods.

   As exceptmask always included 'failbit', and setstate was always
   called with bits = failbit, all it did was immediately raise an
   exception. Get rid of those variables, and replace the setstate
   with direct exception throwing (which also removes some dead
   code).

   As a result, good() is never reached after a failure (there are
   only 2 calls, one of which is in tests), and can just be replaced
   by !eof().

   fail(), clear(n) and exceptions() are just never called. Delete
   them.
```
---
# References
1. 