---
📕 Courses:
  - "!!Operating Systems"
tags:
  - ComputerScience/OS
Date Created: 2026-08-26
---
```table-of-contents
```
---
# C
- Low-level
	- Close to hardware
- Linux & many other OS's are implemented in C
- `C standards`: Set the laws (syntax, semantics, standard library) to ensure consistent behavior across compilers
	- Any rules left out of the standard are up to the compiler to decide the behavior of
## C-Family Languages
- C++
- Java
- Rust
- JS
- Go
- C#
- Perl
- PHP
- Swift
- etc.

# What's the Biggest Difference?
- C is not object oriented
	- Has 'objects' as pieces of memory with definable fields
	- C++/Java add object specific functions
- C is pass-by-value
	- So to modify an object in a function, you need to say where it is in memory
```C
// passed by value
int add_one(int a) {
	a++;
}

// passed by reference (with '*')
int add_one(int* a) {
	(*a)++; //<--- dereference memory location with '*'
}
```

# Why Do We Use C?
- All major OS's are written primarily in C
	- There is a push to use Rust
- C because allows for low-level access
	- Direct memory manipulation
	- Low-level hardware access
- As a precursor to many languages it helps us think about those languages as well

# C vs Java
```java
int main() {
	for (int i = 0; i < 5; i++) {
		System.out.println("Java Loop: " + i);
	}
}
```

```c
#include <stdio.h> // header file (contains usable functions) i.e. printf()

int main() {
	for (int i = 0; i < 5; i++) {
		printf("C Loop: %d\n", i); // %d <-- decimal 'i' (not float)
	}
}
```

# Pre Processing Statement
- `#include <stdio.h>`
	- these statements happen before the compilation of the program
- `#define FIVE 7`
	- any case of `FIVE` would result in `7`

# Structs vs Objects
- No objects in C
- C does have structs
- Defines that a chunk of memory should look like x
	- 50 characters, 1 int in this case
```c
#include <stdio.h>

struct PersonC {
	char name[50];
	int age;
};

int main() {
	struct PersonC person;
	strcpy(person.name, "John");
	person.age = 30;
}
```

# C Data Types

| **integer type** | **size***         |
| ---------------- | ----------------- |
| char             | 1 byte            |
| int              | 2 or 4 bytes      |
| long             | 8 bytes (usually) |

| **floating point type** | **size*** |
| ----------------------- | --------- |
| float                   | 4 bytes   |
| double                  | 8 bytes   |
- There are also `signed char` and `unsinged char`
- Derived Types:
	- `pointers`
	- `arrays`
	- `structures`
	- `functions`

# C Functions
- Functions in C are similar to many other languages you know!
	- Strongly typed and often end with a return statement (especially if they have a non-void return type)
- Functions, like data, are just locations in memory
	- So we can have pointers to them
- Can return any of the base data types/derived types or void

# C Pointers
- Pointers are **locations in memory**
	- They are important for passing objects to C functions when we want those objects to change
- C is **pass-by-value**
	- Functions get a *copy* of the original data
	- When we pass an **object** inside the function we don't know about the original object
	- When we pass a **pointer** we get access to the original object
```c
#include <stdio.h>

// Function that takes an int pointer as an argument
void modifyValue(int *ptr) {
	*ptr += 10; // dereferences address
}

int main() {
	int number = 5;
	
	printf("Before function call: %d\n", num);
	
	modifyValue(&number); // passes address
	
	printf("After function call: %d\n", num);
}
```

# C: Arrays
- Arrays are **contiguous locations in memory of the same data type**
	- So a pointer to the first entry in the array is the same as a pointer to the array
		- Because they are the same memory location
- We can use index notation and pointer notation interchangeably for arrays
```c
#include <stdio.h>

int main() {
	int nums[] =
		{10,20,30,40,50);
	// Using array index
	for (int i = 0; i < 5; i++) {
		printf("nums[%d] = %d\n",
			i, nums[i]
		);
	}
	
	// Using pointer arithmetic
	int* ptr = numbers;
	for (int i = 0; i < 5; i++) {
		printf(
			"*(ptr + %d) = %d\n",
			i,
			*(ptr + i)
		);
	}
}
```

# C: data
## bools
- Booleans are not inherent in C
	- Instead, we can use 1 or 0, where 0 is "false" and anything not 0 is "true"
- We can also include `stdbool.h`
	- Makes life easier and more similar to other languages
```c
#include <stdio.h>
#include <stdbool.h>

// C has no boolean type
int main() {
	printf("Comparison of 1 and 2: %d\n", 1==2);
	
	if (0) {
		printf("0 means 'true'\n");
	}
	if (5) {
		printf("5 means 'true'\n");
	}
	
	// stdbool.h defines true and false
	if (true) {
		printf("Thanks, stdbool!\n");
	}
	return 0;
}
```
## Strings
- Strings in C are just `arrays` of characters
	- Importantly they are `null-terminated`
- "hi" == `{'h', 'i', '\0'}`
	- Note: `"` != `'`
- You also must include `string.h` to use many helper functions such as `strlen(...)`
```c
#include <stdio.h>
#include <string.h>

// Experiments with strings
int main(void) {
    char *s = "doozy";
    printf("%s has length %ld\n", s, strlen(s));
    printf("s[0]: %c, s[5]: %c\n", s[0], s[5]);

    char s1[] = "woozy";
    s1[3] = 't';
    printf("new string: %s\n", s1);

    if (strcmp(s, "wooty") == 0) { // This will not be true
        printf("s is wooty\n");
    }

    if (strcmp(s, "doozy") == 0) {
        printf("s is doozy\n");
    }

    printf("compare abc and xyz: %d\n", strcmp("abc", "xyz"));
    printf("compare xyz and abc: %d\n", strcmp("xyz", "abc"));
    return 0;
}

```
---
# References
1. 