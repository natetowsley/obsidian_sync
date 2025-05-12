---
Date Created: 2025-02-17T09:04
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#5.1]]
    - [[#Definitions of Functions]]
        - [[#Function Equality]]
- [[#5.2]]
    - [[#Floor and Ceiling Functions]]
        - [[#The Floor Function]]
        - [[#The Ceiling Function]]
- [[#5.3]]
    - [[#Properties of Functions]]
        - [[#Relative Sizes of the Domain and Target from Function Properties]]
- [[#5.4]]
    - [[#The Inverse of a Function]]
- [[#5.5]]
    - [[#Composition of Functions]]
        - [[#Compositions of a Function and its Inverse]]
- [[#5.6]]
    - [[#Logarithms and Exponents]]
- [[#5.7]]
    - [[#An Introduction to Boolean Algebra]]
        - [[#Laws of Boolean Algebra]]
- [[#5.8]]
    - [[#Boolean Functions]]
        - [[#An Input/Output Table for a Boolean Function]]
- [[#5.9]]
    - [[#Disjunctive and Conjunctive Normal Form]]
        - [[#Disjunctive Normal Form]]
        - [[#Conjunctive Normal Form]]
- [[#5.10]]
    - [[#Functional Completeness]]
- [[#5.11]]
    - [[#Booleans Satisfiability]]
        - [[#Boolean Satisfiability with DNF and CNF Expressions]]
- [[#5.12]]
    - [[#Gates and Circuits]]
        - [[#The Three Basic Gates]]
        - [[#Simple Circuits]]
        - [[#Constructing a Boolean Expression from a Circuit]]
---
# 5.1
## Definitions of Functions
- A **function** f that maps elements of a set X to elements of a set Y is a subset of X x Y such that for every x ∈ X, there is exactly on y ∈ Y for which (x, y) ∈ f
    - f: X → Y is the notation to express the fact that f is a function from X to Y. The set X is called the **domain** of f, and the set Y is the **target** of f. Another word for target is sometimes used is **co-domain**. The fact that f maps x to y (or (x,y) ∈ f) can also be denoted as f(x) = y
- In a fucntion, all elements of a functions domain must be mapped exactly once for the function to be valid
    - Elements of the target can be mapped to multiple times
![[image 33.png|image 33.png]]
- If a function maps an element of the domain to zero elements or more than one element of the target, then the function is not **well-defined**
![[image 1 18.png|image 1 18.png]]
- The **range** of a function is all elements in the target which have an element of the domain mapped to them
### Function Equality
- If two functions, f and g, share the same domain and the same target then they are equal, and f(x) = g(x) for every element x in the domain, then the notation f = g denotes the fact that the functions are equal
  
# 5.2
## Floor and Ceiling Functions
### The Floor Function
- The **floor function** maps a real number to the nearest integer in the downward direction
![[image 2 16.png|image 2 16.png]]
- The floor function comes up so often in mathematics that it has its own notation
    - $floor(x) = ⌊x⌋$
- Example: $⌊4.32⌋ = 4$ and $⌊4⌋ = 4$
    - Negative numbers also rounded to the nearest integer in downward direction:
        - $⌊-4.32⌋ = -5$
### The Ceiling Function
- The **ceiling function** rounds a real number to the nearest integer in the upward direction
![[image 3 15.png|image 3 15.png]]
- Like the floor function, the ceiling function also has its own notation
    - $ceiling(x) = ⌈x⌉$
- Example: $⌈4.32⌉ = 5$ and $⌈4⌉ = 4$
    - Negative numbers roun ded to nearest integer in upward direction as well
        - $⌈4.32⌉ = -4$
![[image 4 13.png|image 4 13.png]]
  
# 5.3
## Properties of Functions
- A function f: X → Y is **one-to-one** or **injective** if $x_1 ≠ x_2$ implies that $f(x_1) ≠ f(x_2)$. That is, f maps defferent eleents in X to different elements in Y
- A function A function f: X → Y is **onto** or **surjective** if the range of f is equal to the target Y. That is, for every y ∈ Y, there is an x ∈ X such that f(x) = y
- A function is **bijective** if it is both one-to-one and onto. A bijective function is called a **bijection**. A bijection is also called a **one-to-one correspondence**
### Relative Sizes of the Domain and Target from Function Properties
![[image 5 13.png|image 5 13.png]]
  
# 5.4
## The Inverse of a Function
- If a function f: X → Y is a bijection, then the **inverse** of f is obtained by exchanging the first and second entries in each pair in f. The inverse of $f$ is denoted $f^{-1}$
$$f^{-1} = {(y, x) : (x,y) ∈ f}$$
- Reversing each pair in a function f does not always result in a well-defined function. Therefore, some functions do not have an inverse
![[image 6 10.png|image 6 10.png]]
  
# 5.5
## Composition of Functions
- Applying a function to the result of another function is called **composition**
- $f$ and $g$ are two functions, where $f: X -> Y$ and $g : Y -> Z$
    - The composition of $g$ and $f$ denoted $g ∘ f$, is the function $(g∘ f) : X -> Z$, such that for all $x ∈ X$, $(g ∘ f)(x) = g(F(x))$
![[image 7 8.png|image 7 8.png]]
### Compositions of a Function and its Inverse
![[image 8 6.png|image 8 6.png]]
  
# 5.6
## Logarithms and Exponents
- The **exponential function** $exp_b : R -> R^+$ is defined as:
$$exp_b = b^x$$
where b is a positive real number and b **≠** 1. The parameter b is called the **base of the exponent** in the expression $b^x$. The input x to the function $b^x$ is called the exponent
![[image 9 5.png|image 9 5.png]]
- The exponential function is one-to-one and onto, and therefore has an inverse
- The **logarithm function** is the inverse of the exponential function
- For real number $b > 0$ and $b ≠ 1, log_b : R^+-> R$ is defined as
$$b^x = y <-> log_by = x$$
- The parameter b is called the **base of the logarithm** in the expression $log_by$
![[image 10 5.png|image 10 5.png]]
![[image 11 5.png|image 11 5.png]]
  
# 5.7
## An Introduction to Boolean Algebra
- **Boolean algebra:** A set of rules and operations for working with variables with values that are 0 or 1
- **Boolean multiplication:** denoted by **⋅**, applies to two elements from {0, 1} and obeys the standard rules for multiplication. The results of the multiplication operation are the same as the logical ∧ “and” operator
![[image 12 5.png|image 12 5.png]]
- **Boolean addition:** denoted by +, applies to two elements from {0, 1} and obeys the standard rules for addition, except for **1 + 1**. An outcome of **2** is not allowed because all values in Boolean algebra must be **0** or **1.** The results of the addition operation are the same as the logical ∨ "or" operation
![[image 13 5.png|image 13 5.png]]
- The **complement** of an element, denoted with a bar symbol, reverses that element’s value. Complementing a Boolean value is analogous to applying the **¬** “not” operation in logic
![[image 14 4.png|image 14 4.png]]
![[image 15 4.png|image 15 4.png]]
### Laws of Boolean Algebra
![[image 16 4.png|image 16 4.png]]
  
# 5.8
## Boolean Functions
- A boolean function maps one or more Boolean input values to the set {0, 1}
    - Let B = {0, 1}. Then $B^k$ is the set of all k-tuples over the set B. A boolean function with k input variables maps $B^k$ to B
- One way to define a boolean function is to provide an **input/ output table** that shows the output value of the function for every possible combination of input values
### An Input/Output Table for a Boolean Function
- A boolean function with $k$ input variables requires an input/output table with $2^k$ rows
- $2^k$ is large, even for modest values of $k$, so using a table to define a boolean function is only feasible for functions with a smaller number of input variables
    
    ![[image 17 4.png|image 17 4.png]]
    
![[image 18 4.png|image 18 4.png]]
- A boolean expression that is equivalent to a boolean function defined by an input/output table is constructed using literals and minterms
    - A **literal** is a boolean variable or the complement of a boolean variable (for example $x$ or $\bar{x}$)
    - In a boolean function with input variables $v_1, v_2, ... , v_k$, a **minterm** is a product of literals $u_1u_2...u_k$ such that each $u_j$ is either $v_j$ or ${\bar{v_j}}$
        - Ex: xyz is a minterm above, but xy is not
  
# 5.9
## Disjunctive and Conjunctive Normal Form
### Disjunctive Normal Form
- A boolean expression that is a sum of products of literals is in **disjunctive normal form (DNF)**
**Definition/Example**
![[image 19 3.png|image 19 3.png]]
![[image 20 3.png|image 20 3.png]]
### Conjunctive Normal Form
- A boolean expresion that is a product of sums of literals is in **conjunctive normal form(CNF)**
    - Each term in the product that is a sum of literals is called a **clause**
![[image 21 3.png|image 21 3.png]]
![[image 22 3.png|image 22 3.png]]
  
# 5.10
## Functional Completeness
- A set of operations is **functionally complete** if any boolean function can be expressed using only operations from the set
![[image 23 3.png|image 23 3.png]]
- The **NAND** operation (not and) is denoted by the symbol **↑**
    - The expression $x↑y$ is equivalent to $\overline{xy}$
- The **NOR** operation (not or) is denoted by the symbol **↓**
    - The expression $x↓y$ is equivalent to $\overline{x+y}$
![[image 24 3.png|image 24 3.png]]
- $\bar{x}$ is equivalent to an expression that uses only NAND operations
- $xy$ is equivalent to an expression that uses only NAND operations
![[image 25 3.png|image 25 3.png]]
![[image 26 3.png|image 26 3.png]]
  
# 5.11
## Booleans Satisfiability
- The **Boolean Satisfiability** problem (SAT for short) takes a boolean expression as input and asks whether the values of the varibales can be set so that the expression evaluates to 1
- If the input variables can be set so that a boolean expression evaluate to 1, then the expression is **satisiable**, otherwise the expression is **unsatisfiable**
![[image 27 3.png|image 27 3.png]]
### **Boolean Satisfiability with DNF and CNF Expressions**
![[image 28 3.png|image 28 3.png]]
  
# 5.12
## Gates and Circuits
- Boolean algebra is used to describe and design circuits used in electronic devices
- Circuits are built from electrical devices called **gates**
    - A gate recieves some number of Boolean input values and produces an output based on the values of the inputs
    - The **AND** gate computes boolean multiplication
    - The **OR** gate computes boolean addition
    - The **inverter** computes the complement
    - The shape of the gate indicates the particular operation that the gate computes
### The Three Basic Gates
![[image 29 3.png|image 29 3.png]]
### Simple Circuits
![[image 30 2.png|image 30 2.png]]
### Constructing a Boolean Expression from a Circuit
![[image 31 2.png|image 31 2.png]]