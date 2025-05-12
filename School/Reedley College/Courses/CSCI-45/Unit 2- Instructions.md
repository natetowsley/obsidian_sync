---
Date Created: 2025-02-09T20:30
Favorite: false
📕 Courses:
  - "[[!!Computer Architecture and Organization]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#2.1]]
    - [[#Introduction]]
- [[#2.2]]
    - [[#Operations of the Computer Hardware]]
        - [[#LEG v8 Operands Revealed in this Chapter]]
        - [[#LEGv8 Assembly Language Revealed in this Chapter]]
- [[#2.3]]
    - [[#Operands of the Computer Hardware]]
        - [[#Memory Operands]]
- [[#2.4]]
    - [[#Signed and Unsigned Numbers]]
        - [[#Negation Shortcut]]
- [[#2.5]]
    - [[#Representing Instructions in the Computer]]
        - [[#LEGv8 Fields]]
        - [[#LEGv8 Architecture]]
        - [[#The Stored Program Concept]]
- [[#2.6]]
    - [[#Logical Operations]]
        - [[#C and Java Logical Operators and their Corresponding LEGv8 Instructions]]
- [[#2.7]]
    - [[#Instructions for Making Decisions]]
        - [[#Loops]]
- [[#2.8]]
    - [[#Supporting Procedures in Computer Hardware]]
        - [[#Procedure Basics]]
        - [[#Using More Registers]]
        - [[#What is and What is not Preserved Across a Procedure Call]]
        - [[#Allocating Space for New Data on the Stack]]
        - [[#Allocating Space for New Data on the Heap]]
        - [[#LEGv8 Register Conventions]]
- [[#2.9]]
    - [[#Communicating with People]]
- [[#2.10]]
    - [[#LEGv8 Addressing for Wide Immediates and Addresses]]
        - [[#Wide Immediate Operands]]
- [[#2.11]]
    - [[#Parallelism and Instructions: Synchronization]]
- [[#2.12]]
    - [[#Translating and Starting a Program]]
        - [[#Compiler]]
        - [[#Assembler]]
        - [[#Linker]]
        - [[#Loader]]
    - [[#Dynamically Linked Libraries]]
    - [[#Starting a Java Program]]
- [[#2.13]]
    - [[#A C Sort Example to put it all Together]]
    - [[#The Procedure swap]]
        - [[#Register Allocation for swap]]
        - [[#Code for the Body of the Procedure swap]]
        - [[#The Full swap Procedure]]
    - [[#The Procedure sort]]
        - [[#Register Allocation for sort]]
        - [[#Code for the Body of the Procedure sort]]
        - [[#The Procedure call in sort]]
        - [[#Passing Parameters in sort]]
        - [[#Preserving Registers in sort]]
        - [[#The Full Procedure sort]]
---
# 2.1
## Introduction
- **Instruction Set:** The vocabulary of commands understood by a given architecture
- **Stored-Program Concept:** The idea that instructions and data of many types can be stored in memory as numbers and thus be easy to change, leading to the stored-program computer
  
# 2.2
## Operations of the Computer Hardware
- Every computer must be able to perform arithmetic. The LEGv8 assembly language notation `ADD a, b, c` instructs a computer to add the two variables `b` and `c` and store the result in `a`
- `t0` , `t1`, etc. are “temp” variables used to store temporary values such as when operations are performed in parenthesis in a larger equation
- `f = (g + h) - (i + j);`
    - `t0` contains `(g + h)`
    - `t1` contains `(i + j)`
### LEG v8 Operands Revealed in this Chapter
![[image 29.png|image 29.png]]
### LEGv8 Assembly Language Revealed in this Chapter
![[image 1 16.png|image 1 16.png]]
![[image 2 14.png|image 2 14.png]]
  
# 2.3
## Operands of the Computer Hardware
- **Word:** A natural unit of access in a computer, usually a group of 32 bits
- **Doubleword:** Another natural unit of access in a computer, usually a group of 64 bits; corresponds to the size of a register in the LEGv8 architecture
### Memory Operands
- **Data transfer instruction:** A command that moves data between memory and registers
- **Address:** A value used to delineate the location of a specific data element within a memory array
  
# 2.4
## Signed and Unsigned Numbers
- **Binary Digit:** Also called _binary bit_. One of the two numbers in base 2, 0 or 1, that are the components of information
- **Least Significant Bit:** The rightmost bit in an LEGv8 doubleword
- **Most Significant Bit:** The leftmost bit in an LEGv8 doubleword
- **Sign and magnitude representation:** A single bit used to represent the sign, and the remaining bits represent the magnitude
    - 0 being positive, 1 being negative
![[image 3 13.png|image 3 13.png]]
- **Two’s Compolement:** A signed number representation where a 0 indicates a positive number and a leading 1 indicates a negative number
    - The complement of a value obtained by complementing each bit (0 → 1 or 1 → 0), and then adding one to the result
### Negation Shortcut
![[image 4 11.png|image 4 11.png]]
  
# 2.5
## Representing Instructions in the Computer
- Where we explain the difference in how humans instruct computers and the way computers see instructions
- **Instruction Format:** A form of representation of an instruction composed of fields of binary numbers
![[image 5 11.png|image 5 11.png]]
- **Machine Language:** Binary representation used for communication within a computer system
- **Hexadecimal:** Numbers in base 16
**Hexadecimal-Binary Conversion Table**
![[image 6 8.png|image 6 8.png]]
![[image 7 6.png|image 7 6.png]]
### LEGv8 Fields
- LEGv8 fields are given names to make them easier to discuss
![[image 8 4.png|image 8 4.png]]
- **opcode :** Basic operation of the instruction, and this abbreviation is its traditional name
- **Rm:** The second register source operand
- **shamt:** Shift amount. (COD Section 2.6 (Logical operations) explains shift instructions and this term; it will not be used until then, and hence the field contains zero in this section)
- **Rn:** The first register source operand
- **Rd:** The register destination operand. It gets the result of the operation
![[image 9 3.png|image 9 3.png]]
### LEGv8 Architecture
![[image 10 3.png|image 10 3.png]]
- Today’s computers are built on two key principles
    - Instructions are represented as numbers
    - Programs are stored in memory to be read or written, just like data
### The Stored Program Concept
![[image 11 3.png|image 11 3.png]]
  
# 2.6
## Logical Operations
### C and Java Logical Operators and their Corresponding LEGv8 Instructions
![[image 12 3.png|image 12 3.png]]
- The first class of such operations is called **shifts**
    - A _shift_ moves all the bits in a doubleword to the left or right, filling the emptied bits with 0s
![[image 13 3.png|image 13 3.png]]
- **AND:** A logical bit-by-bit operation with two operands that calculates a 1 only if there is a 1 in both operands
![[image 14 2.png|image 14 2.png]]
- **OR:** A logical bit-by-bit operation with two operands that calculates a 1 if there is a 1 in either operand
- **NOT**: A logical bit-by-bit operation with one operand that inverts the bits; that is, it replaces every 1 with a 0, and every 0 with a 1
- **EOR**: A logical bit-by-bit operation with two operands that calculates the exclusive OR of the two operands. That is, it calculates a 1 only if the values are different in the two operands
  
# 2.7
## Instructions for Making Decisions
- **Conditional Branch:** An instruction that tests a value and that allows for a subsequent transfer of control to a new address in the program based on the outcome of the test
- `CBZ register, L1`
    - This instruction means go to the statement labeled `L1` if the value in `register` equals 0
    - `CBZ` stands for **compare and branch if zero**
- `CBNZ register, L1`
    - This instruction means go to the statement labeled `L1` if the value in `register` does not equal 0
    - `CBNZ` stands for **compare and branch if not zero**
![[image 15 2.png|image 15 2.png]]
### Loops
![[image 16 2.png|image 16 2.png]]
- **Basic Block:** A sequence of instructions without branches (except possibly at the end) and without branch targets or brach labels (except possibly at the beginning)
**How to do all comparisons if the instruction that set the condition codes was a subtract**
![[image 17 2.png|image 17 2.png]]
  
# 2.8
## Supporting Procedures in Computer Hardware
- **Procedure:** A stored subroutine that performs a specific task based on the parameters with which it is provided
- **Branch-and-Link Instruction:** An instruction that branches to an address and simultaneously saves the address of the following instruction in a register (LR or X30 in LEGv8)
- **Return Address:** A link to the calling site that allows a procedure to return to the proper address; in LEGv8 it is stored in register LR (X30)
- **Caller:** The program that instigates and provides the necessary parameter values
- **Callee:** A procedure that executes a series of stored instructions based on parameters provided by the caller and then returns control to the caller
- **Program Counter** _**(PC)**_**:** The register containing the address of the instruction in the program being executed
### Procedure Basics
![[image 18 2.png|image 18 2.png]]
### Using More Registers
- **Stack:** A data structure for spilling registers organized as a last-in-first-out queue
- **Stack Pointer:** A value denoting the most recently allocated address in a stack that shows where registrers should be spilled or hwere old register values can be found
    - In LEGv8, it is register SP
- **Push:** Add element to stack
- **Pop:** Remove element from stack
- **Global Pointer:** The register that is reserved to point to the static area
### What is and What is not Preserved Across a Procedure Call
![[image 19 2.png|image 19 2.png]]
### Allocating Space for New Data on the Stack
- **Procedure Frame:** Also called **activation record**. The segment of the stack containing a procedure’s saved registers and local variables
![[image 20 2.png|image 20 2.png]]
- **Frame Pointer:** A value denoting the location of the saved registers and local variables for a given procedure
### Allocating Space for New Data on the Heap
- **Text Segment:** The segment of a UNIX object file that contains the machine language code for the routines in the source file
![[image 21 2.png|image 21 2.png]]
### LEGv8 Register Conventions
![[image 22 2.png|image 22 2.png]]
  
# 2.9
## Communicating with People
**American Standard Code for Information Interchange(ASCII):** 8 bytes used to represent characters that nearly everyone follows
![[image 23 2.png|image 23 2.png]]
  
# 2.10
## LEGv8 Addressing for Wide Immediates and Addresses
### Wide Immediate Operands
![[image 24 2.png|image 24 2.png]]
  
# 2.11
## Parallelism and Instructions: Synchronization
- **Parallel Execution** is easier when tasks are independent, but often they need to cooperate
    - Means some tasks are writing new values that others must read
    - Tasks must synchronize to know when one is finished writing for another to be able to read
    - If out of sync, there is danger of a data race
- **Data race:** Two memory accesses form a data race if they are from different threads to same location, at least one is a write, and they occur one after another
  
# 2.12
## Translating and Starting a Program
**A Translation Heirarchy for C**
![[image 25 2.png|image 25 2.png]]
### Compiler
- Transforms the C program into an _assembly language_ program, a symbolic for of what the machine understands
- **Assembly Language:** A symbolic language that can be translated into binary machine language
### Assembler
- Since assemby language is an interface to higher-level software, the assembler can also treat common variations of machine language instructions as if they were intructions in their own right called _pseudoinstructions_
- **Pseudoinstruction:** A common variation of assembly language instructions often treated as if it were an instruction in its own right
- **Symbol Table:** A table that matches names of labels to the addresses of the memory words that instructions occupy
### Linker
- **Linker:** Also called **link editor**. A systems program that combines independently assebled machine language programs and resolves all undefined labels into an executable file
- Three steps for linker
    - Place code and data modules symbolically in memory
    - Determine the addresses of data and instruction labels
    - Patch both the internal and external references
- **Executable File:** A functional program in the format of an object file that contains no unresolved references
    - Can contain symbol tables and debugging information
    - A “stripped executable” does not contain that information
    - Relocation information may be included for the loader
### Loader
- **Loader:** A system’s program that places an object program in main memory so that it is ready to execute
## Dynamically Linked Libraries
- **Dynamically Linked Libraries (DLLs):** Library routines that are linked to a program during execution
**Dynamically Linked Library via Lazy Procedure Linkage**
![[image 26 2.png|image 26 2.png]]
## Starting a Java Program
- **Java Bytecode:** Instruction from an instruction set designed to interpret Java programs
**A Translation Hierarchy for Java**
![[image 27 2.png|image 27 2.png]]
- **Java Virtual Machine (JVM):** The program that interprets Java bytecodes
- **Just In Time Compiler (JIT):** The commonly given to a compiler that operates at runtime, translating the interpreted code segments into the native code of the compiler
  
# 2.13
## A C Sort Example to put it all Together
**A C Procedure that Swaps Two Locations in Memory**
![[image 28 2.png|image 28 2.png]]
## The Procedure `swap`
- When translating from C to assembly language by hand, we follow these general steps
    - Allocate registers to program variables
    - Produce code for the body of the procedure
    - Preserve registers across the procedure invocation
### Register Allocation for `swap`
- The LEGv8 covention on parameter passing is to use registers X0 to X7
- Since swap has just two parameters, `v` and `k`, they will be found in registers X0 and X1
    - Only other variable is `temp`, which we associate with register X9 since swap is a leaf procedure
### Code for the Body of the Procedure `swap`
- The reamining lines of C code in swap are
    - `temp = v[k];`
    - `v[k] = v[k + 1];`
    - `v[k + 1] = temp;`
- Recall that the memory address for LEGv8 refers to the byte address, and so doublewords are really 8 bytes apart
    - We need to multiply the index k by 8 before adding it to the address
    - First step is to get the address of `v[k]` by multiplying k by 8 via a shift left by 3
```Plain
LSL X10, X1, #3  // reg X10 = k * 8
ADD X10, X0, X10 // reg X10 = v + (k * 8)
                 // reg X10 has the address of v[k]
```
- Now we load `v[k]` using X10, and then `v[k + 1]`
```Plain
LDUR X9, [X10, #0]  // reg X9 (temp) = v[k]
LDUR X11, [X10, #8] // reg X11 = v[k + 1]
                    // refers to next element of v
```
- Next we store X9 and X11 to the swapped addresses:
```Plain
STUR X11, [X10, #0]  // v[k] = reg X11
STUR X9, [X10, #8]   // v{k + 1] = regX9 (temp)
```
- Now what is missing is the code for preserving the saved registers used within `swap`
    - Since we are not useing saved registers in this leaf procedure, there is nothing to preserve
### The Full `swap` Procedure
![[image 29 2.png|image 29 2.png]]
## The Procedure `sort`
**A C Procedure that Performs a Sort on the Array v**
![[image 30.png]]
### Register Allocation for `sort`
- The two parameters of the procedure `sort`, `v` and `n`, are in the parameter registers X0 and X1, and we assign register X19 to i and register X20 to j
### Code for the Body of the Procedure `sort`
- The procedure body consists of two nested for loops and a call to `swap` that includes parameters
- The first translation step is the first for loop
    - `for (i = 0; i < n; i += 1) {`
- Recall that the C for statement has three parts: initialization, loop test, and iteration increment
- It takes just one instruction to initialize i to 0, the first part of the for statement
```Plain
MOV X19, XZR  // i = 0
```
- Remember that MOV is a pseudoinstruction provided by the assembler for the convenience of the assembly language programmer
- It also takes just one instruction to increment i, the last part of the for statement
```Plain
ADDI X19, X19, #1  //i += 1
```
- The loop should be exited if i < n is not true or, said another way, should be exited if i ≥ n
    - This test takes two instructions:
```Plain
for1tst: CMP X19, X1  //compare X19 to X1 (i to n)
         B.GE exit1   // go to exit1 if X19 >= X1 (i >= n)
```
- The bottom of the for loop just branches back to the loop test
```Plain
          B for1tst  // branch to test of outer loop
exit1:
```
- The second for loop looks like this in C:
    - `for (j = i - 1); j >= 0 && v[j] > v[j + 1]; j -= 1) {`
- The initialization portion of this loop is again one instruction
```Plain
SUBI X20, X19, #1  // j = i - 1
```
- The decrement of j at the end of the loop is also one instruction
```Plain
SUBI X20, X20, #1  // j -= 1
```
- The loop test has two parts
    - We exit the loop if either condition fails, so the first test must exit the loop if it fails (j < 0):
```Plain
for2tst: CMP X20, XZR   // compare X20 to 0 (j to 0)
         B.LT exit2     // go to exit2 if X20 < 0 (j < 0)
```
- This branch will skip over the second condition test
    - If it doesn’t skip, the j ≥ 0
- The second test exits if `v[j] > v[j + 1]` is not true, or exits if `v[j] <= v[j + 1]`
- First we create the address by multiplying j by 8 (since we need the byte address) and add it to the base address of v:
```Plain
LSL X10, X20, #3  // reg X10 = j * 8
ADD X11, X0, X10  // reg X11 = v + (j * 8)
```
- Now we load `v[j]`:
```Plain
LDUR X12, [X11, #0] // reg X12 = v[j]
```
- Since we know that the second element is just the following doubleword, we add 8 to the address in register X11 to get v[j + 1]:
```Plain
LDUR X13, [X11, #8] // reg X13 = v[j + 1]
```
- We test of `v[j] >= v[j + 1]` to exit the loop
```Plain
CMP X12, X13  // compare X12 to X13
B.LE exit2    // go to exit2 if X12 <= X13
```
- Combining the pieces, the skeleton of the second for loop looks like this
```Plain
         SUBI X20, X19, #1   // j = i - 1
for2tst: CMP X20, XZR        // compare X20 to 0 (j to 0)
         B.LT exit 2         // go to exit2 if X20 < 0 (j < 0)
         LSL X10, X20, #3    // reg X10 = j * 8
         ADD X11, X0, X10    // reg X11 = v + (j * 8)
         LDUR X12, [X11, #0] // reg X12 = v[j]
         LDUR X13, [X11, #8] // reg X13 = v[j + 1]
         CMP X12, X13        // compare X12 to X13
         B.LE exit2          // go to exit2 if X12 <= X13
            ...
            (body of second for loop)
            ...
         SUBI X20, X20, #1   // j -= 1
         B    for2tst        // jump to test of inner loop
exit2:
```
### The Procedure call in `sort`
- The next step is the body of the second for loop
- `swap(v, j);`
- Calling swap is easy enough
    - `BL swap`
### Passing Parameters in `sort`
- The problem comes when we want to pass parameters because the `sort` procedure needs the values in the registers X0 and X1, yet the swap procedure needs to have its parameters placed in those same registers
    - One solution is to copy the parameters for `sort` into other registers earlier in the procedure, making registers X0 and X1 available for the call of swap
    - We first copy X0 and X1 into X21 and X22 during the procedure:
```Plain
MOV X21, X0   // copy parameter X0 into X21
MOV X22, X1   // copy parameter X1 into X22
```
- Then we pass the parameters to `swap` with these two instructions:
```Plain
MOV X0, X21   // first swap parameter is v
MOV X1, X20   // second swap parameter is j
```
### Preserving Registers in `sort`
- Only remaining code is the saving and restoring of registers
- We must save the return address in register LR, since `sort` is a procedure and is called itself
- The `sort` procedure also uses the callee-saved regusters X19, X20, X21, and X22, so they must be saved
    - The prologue of the `sort` procedure is then
```Plain
SUBI SP, SP, #40     // make room on stake for 5 regs
STUR LR, [SP, #32]   // save LR on stack
STUR X22, [SP, #24]  // save X22 on stack
STUR X21, [SP, #16]  // save X21 on stack
STUR X20, [SP, #8]   // save X20 on stack
STUR X19, [SP, #0]   // save X19 on stack
```
### The Full Procedure `sort`
![[image 31.png]]