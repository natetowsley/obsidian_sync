---
Date Created: 2025-03-18T15:07
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
#### Tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#8.1]]
    - [[#Sequences]]
        - [[#Sequence Basics]]
        - [[#Increasing and Decreasing Sequences]]
        - [[#Geometric Sequences]]
        - [[#Arithmetic Sequences]]
- [[#8.2]]
    - [[#Recurrence Relations]]
- [[#8.3]]
    - [[#Summation]]
        - [[#Pulling Out a Final Term from a Summation]]
        - [[#Change of Variables in Summations]]
        - [[#Closed Forms for Sums]]
- [[#8.4]]
    - [[#Mathematical Induction]]
        - [[#The Two Components of an Inductive Proof]]
        - [[#Why Induction Works]]
        - [[#Proving an Identity by Induction]]
        - [[#Proving an Inequality by Induction]]
- [[#8.5]]
    - [[#Divisibility Proof by Induction]]
- [[#8.6]]
    - [[#Strong Induction and Well-Ordering]]
        - [[#Expanded Expressong of the Inductive Step for Weak and Strong Induction]]
- [[#8.7]]
    - [[#Loop Invariants]]
        - [[#Program Correctness]]
        - [[#Examples of Program Preconditions and Postconditions]]
        - [[#The Four Steps of Using a Loop Invariant]]
- [[#8.8]]
    - [[#Recursive Definitions]]
        - [[#Using the Recursive Definition of n! to Compute 4!]]
    - [[#Recursively Defined Sets]]
    - [[#Binary Strings]]
        - [[#Constructing a Binary String Using the Recursive Definition]]
        - [[#Recursive Definition for the Length of a Binary String]]
        - [[#Recursive Definition for Perfect Binary Trees]]
- [[#8.9]]
    - [[#Structural Induction]]
        - [[#Outline for a Proof Uing Structural Induction]]
---
# 8.1
## Sequences
- A **sequence** is a special type of function in which the domain is a set of consecutive integers
- When a function is specified as a sequence, using subscripts to denote the input to the function is more common, so $g_k$ is used instead of $g(k)$
    - A value $g_k$ is called a **term** of a sequence, and **k** is the **index** of $g_k$
    - The entire sequence is denoted by $\{g_k\}$
- A sequence with a finite domain is called a **finite sequence**
    - A finite sequence has an **initial index** $m$ and a **final index** $n$, where $n$ ≥ $m$
    - Then $a_m$ is the **initial term** and $a_n$ is the **final term**
- A sequence with an infinite domain is called an **infinite sequence**
    - The indices go to infinity if the positive direction
- A sequence can be specified by an **explicit formula** showing how the value of term $a_k$ depends on $k$
    - EX: $d_k = 2^k$ for $k$ ≥ $1$
        - The infinite sequence $\{d_k\}$ starts with: 2, 4, 8, 16
### Sequence Basics
![[image 39.png|image 39.png]]
### Increasing and Decreasing Sequences
- A sequence is **increasing** if for every two consecutive indices, $k$ and $k + 1$, in the domain, $a_k < a_{k+1}$
- A sequence is **nondecreasing** if for every two consecutive indices, $k$ and $k + 1$, in the domain, $a_k$ ≤ $a_{k+1}$
    - An increasing sequence is always nondecreasing
![[image 1 24.png|image 1 24.png]]
- A sequence is **decreasing** if for every two consecutive indices, $k$ and $k + 1$, in the domain $a_k > a_{k+1}$
- A sequence is **nonincreasing** if for every two consecutive indices $k$ and $k + 1$, in the domain $a_k$ ≥ $a_{k+1}$
![[image 2 22.png|image 2 22.png]]
### Geometric Sequences
- A **geometric sequence** is a sequence of real numbers where each term after the initial term is found by taking the previous term and multiplying by a fixed number called the **common ratio**
    - A geometric sequence can be finite or infinite
![[image 3 21.png|image 3 21.png]]
### Arithmetic Sequences
- An **arithmetic sequence** is a sequence of real numbers where each term after the initial term is found by taking the previous term and adding a fixed number called the **common difference**
    - An arithmetic sequence can be finite or infinite
![[image 4 19.png|image 4 19.png]]
  
# 8.2
## Recurrence Relations
- A rule that defines a term $a_n$ as a function of previous terms in the sequence is called a **recurrence relation**
    - EX: In an arithmetic sequence, each number is obtained by adding a fixed value to the previous number
**Recurrence Relation Defining an Arithmetic Sequence**
![[image 5 19.png|image 5 19.png]]
**Recurrence Relation Defining a Geometric Sequence**
![[image 6 16.png|image 6 16.png]]
- **Fibonacci Sequence:** Fibonacci defined the sequence in an attempt to mathematically describe the population growth of rabbits
    - The rabbits must be at least one month old before they can reproduce
    - Every pair of reproducing rabbits gives birth to a new pair of rabbits, one male and one female, over the course of a month
![[image 7 14.png|image 7 14.png]]
- Fibonacci’s rabbit colony is an example of a dynamical system
- A **dynamical system** is a system that changes over time
    - The state of the system at any point in time is determined by a set of well-defined rules that depend on the past states of the system
- In a **discrete time dynamical system**, time is divided into descrete time intervals, and the state of the system stays fixed within each time interval
  
# 8.3
## Summation
- **Summation Notation** is used to express the sum of terms in a numerical sequence
- EX: Given sequence
$$a_s, a_{s+1}, ..., a_t$$
- The notation to express the sum of the terms in that sequence is:
$$\overset{}{\sum_{i=s}^{t} a_i = a_s + a_{s+1}+...+a_t}$$
- In the summation $\overset{}{\sum_{i=s}^{t} a_i}$, the variable $i$ is called he **index** of the summation
    - The value $s$ is the **lower limit** and $t$ is the **upper limit** of the summation
        - Any variable name could be used for the index instead of $i$, but variables $i,j,k$ and $l$ are the most common
![[image 8 12.png|image 8 12.png]]
### Pulling Out a Final Term from a Summation
- In working with summations, pulling out or adding in a final term to a summation is often useful:
![[image 9 11.png|image 9 11.png]]
![[image 10 11.png|image 10 11.png]]
### Change of Variables in Summations
- When a variable is used to denote the lower or upper limit of a sum, the value of the variable must be provided to evaluate the sum
    - In the summation below, the value of the sum depends on the variable $n$
![[image 11 11.png|image 11 11.png]]
- By contrast, the variable $j$ used for the index is internal to the sum and can be replaced with any other variable name
![[image 12 10.png|image 12 10.png]]
- More complex substitiutions can be done for the index variable, which require that the upper and lower limit be adjusted
![[image 13 10.png|image 13 10.png]]
### Closed Forms for Sums
- A **closed form** for a sum is a mathematical expression that expresses the value of the sum without summation notation
**Closed Form for the Sum of Terms in an Arithmetic Sequence**
![[image 14 8.png|image 14 8.png]]
- EX: In the sum $5+8+11+14+17+20+23$, the initial term $a = 5$, the common difference $d = 3$, and the number of terms in the sum $n = 7$ the theorem says that:
![[image 15 8.png|image 15 8.png]]
**Closed Form for the Sum of Terms in a Geometric Sequence**
![[image 16 8.png|image 16 8.png]]
- EX: In the sum $3+6+12+24+48+96$, the initial term $a=3$, the common ratio $r = 2$, and the number of terms in the sum $n=6$ the theorem says that:
![[image 17 7.png|image 17 7.png]]
  
# 8.4
## Mathematical Induction
### The Two Components of an Inductive Proof
- The **base case** establishes that the theorem is true for the first value in the sequence
    - The genie grants Alladin three wishes on day 1
- The **inductive step** establishes that if the theorem is true for $k$, then the theorem also holds for $k + 1$
    - If Alladin has three wishes on day $k$, then he can get three wishes for day $k + 1$ (by using the third wish to ask for three more wishes the next day)
- The **principla of mathematical induction** states that if the base case (for $n = 1$) is true and the inductive step is true, then the theorem holds for all positive integers
### Why Induction Works
![[image 18 7.png|image 18 7.png]]
### Proving an Identity by Induction
![[image 19 6.png|image 19 6.png]]
### Proving an Inequality by Induction
![[image 20 6.png|image 20 6.png]]
  
# 8.5
## Divisibility Proof by Induction
![[image 21 6.png|image 21 6.png]]
  
# 8.6
## Strong Induction and Well-Ordering
- The **principle of strong induction** assumes that the fact to be proven holds for all values less than or equal to $k$ and proves that the fact holds for $k + 1$
    - By contrast the standard form of induction only assumes that the fact holds for $k$ in proving that it holds for $k + 1$
- **Base case:** $S(0)$ and $S(1)$ are true
- **Inductive Step:** For every $K$ ≥ $1$, $(S(0)\wedge S(1) \wedge ... \wedge S(k))$
### Expanded Expressong of the Inductive Step for Weak and Strong Induction
![[image 22 6.png|image 22 6.png]]
  
# 8.7
## Loop Invariants
### Program Correctness
- The field of **program verification** is concerned with formally proving that programs perform corectly
- A program’s correct behavior is defined by stating that if a **precondition** is true before the program starts, then the program will end after a finite number of steps and a **postcondition** is true after the program ends
### Examples of Program Preconditions and Postconditions
![[image 23 6.png|image 23 6.png]]
### The Four Steps of Using a Loop Invariant
![[image 24 6.png|image 24 6.png]]
  
# 8.8
## Recursive Definitions
- The **factorial** function $f(n) = n!$ for $n$ ≥ $0$ can be defined as: $f(n) = n! = n * (n-1) ... 1$
    - A disadvantsge of the definition above is that the reader must infer what goes on between the $(n-1)$ and the $1$ terms
    - Also the value of $0!$ is not clear from the definition
- A more precise definition is $n! = f(n)$ such that:
$$\begin{matrix} f(0) = 1 \\ f(n) = n*f(n-1) \text{ for n ≥ 1} \end{matrix}$$
- The second definition is a recursive definition
- In a **recursive definition** of a function, the value of the function is defined in terms of the output value of the function on smaller input values
- One can use the recursive definition for $n!$ to determine the value of the factorial function on a particular value for $n$ by starting at $0$, multiplying $0!$ by $1$ to get the value of $1!$ then multiplying by $2$ to get $2!$ and so on until the desired $n!$ has been reached
    - This process is called recursion
- **Recursion** is the process of computing the value of a function using the result of the function on smaller input values
### Using the Recursive Definition of n! to Compute 4!
![[image 25 6.png|image 25 6.png]]
## Recursively Defined Sets
- A **basis** explicitly states that one or more specific elements are in the set
- A **recursive rule** shows how to construct additional elements in the set from elements already known to be in the set (often more than one rule)
- An **exclusion statement** states that an element is in the set only if it is given in the basis or can be constructed by applying the recursive rules repeatedly to elements given the basis
**Constructing a Properly Nested String or Parentheses Recursively**
![[image 26 6.png|image 26 6.png]]
## Binary Strings
- The set $B^k$, where $B = \{0, 1\}$, is defined to be the set of all binary strings of length $k$
- The set of all binary strings without any restriction on length (denoted by $B^*$) is an infinite set
- The **empty string** (denoted by the symbol **λ**) is the unique string whose length is $0$
    - Since $B^0$ is the set of all binary strings of length $0$, $B^0 = λ$
    - $B^*$ includes all of $B^k$ for any $k ≥ 0$
- One way to define $B^*$ is by an infinite union
![[image 27 6.png|image 27 6.png]]
### Constructing a Binary String Using the Recursive Definition
![[image 28 6.png|image 28 6.png]]
### Recursive Definition for the Length of a Binary String
- The length $|x|$ of a binary string $x$ is a function that maps every binary string to a nonnegative integer
- The length of a binary string can be defined recursively based on the recursive definition of $\{0, 1\}^*$
    - Base case: $|λ| = 0$
    - Recursive rule: if $x \in B^*$ then,
        - $|x0| = |x| + 1$
        - $|x1| = |x| + 1$
### Recursive Definition for Perfect Binary Trees
- A tree has **vertices** and **edges** that connect pairs of vertices
    - Each perfect binary tree has a designated vertex called the **root**
![[image 29 6.png|image 29 6.png]]
**Using the Recursive Rule to Construct Perfect Binary Trees from Smaller Ones**
![[image 30 5.png|image 30 5.png]]
  
# 8.9
## Structural Induction
- **Structural Induction** is a type of induction used to prove theorems about recursively defined sets that follows the structure of the recursive definition
- A string of parentheses is **balanced** if the number of left parenthesis is equal to the number of right parenthesis
![[image 31 4.png|image 31 4.png]]
### Outline for a Proof Uing Structural Induction
![[image 32 3.png|image 32 3.png]]