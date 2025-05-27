---
📕 Courses:
  - "[[!!Programming in Python]]"
tags:
  - ComputerScience
  - ComputerScience/Python
Date Created:
---
---
# Format Specifiers (Flags)
`{value:flags}` format a value based on what flags are inserted
- A way to control the behavior of user segments in you application

| Flag            | Purpose                                         |
|-----------------|-------------------------------------------------|
| `:.<number>f`    | Round to that many decimal places (fixed point)|
| `:<number>`      | Allocate that many spaces                      |
| `:0<number>`     | Allocate and zero-pad that many spaces         |
| `:<`             | Left justify (align left)                      |
| `:>`             | Right justify (align right)                    |
| `:^`             | Center align                                   |
| `:+`             | Use a plus sign to indicate positive values    |
| `:=`             | Place sign in leftmost position                |
| `: `             | Insert a space before positive numbers         |
| `:,`             | Use comma as a thousands separator             |

```Python
	price1 = 3.14159
	price2 = -987.65
	price3 = 12.34
	
	print(f"Price 1 is ${price1:.3f}") \#Will print "Price 1 is $3.141"
	print(f"Price 2 is ${price1:.3f}") \#Will print "Price 1 is $-987.650"
	#^Notice zeros are concatinated when desired digits exceed numbers
	
	print(f"Price 1 is ${price1:10}") \#Will print "Price 1 is $   3.14159"
	                                      \#Uses 10 total spaces^        ^
	                                      
	print(f"Price 1 is ${price1:<10}") \#Will print "Price 1 is $3.14159   "
	                \#Aligns value to left side of desired spaces^        ^
```
  
---
# References
1. [[Variables]]
2. [[User Input]]