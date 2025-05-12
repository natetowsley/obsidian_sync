---
Date Created: 2025-03-24T09:14
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#9.1]]
    - [[#Recursive Algorithms]]
        - [[#Recursive Algorithm to Compute the Factorial Function]]
        - [[#Recursive Algorithm to Compute the Power Set of a Set]]
        - [[#Recursive Algorithm to Reverse a String]]
        - [[#Recursive Algorithm to Compute Fibonacci Numbers]]
- [[#9.2]]
    - [[#Induction and Recursive Algorithms]]
        - [[#Inductive Proof to Show Correctness for ReverseString]]
- [[#9.3]]
    - [[#Analyzing the Time Complexity of Recursive Algorithms]]
        - [[#Deriving the Recurrence Relation]]
        - [[#The Two Steps in Analyzing the Time Complexity of a Recursive Algorithm]]
        - [[#Simplifying Recurrence Relations for Asymptotic Analysis]]
        - [[#Deriving a Simplified Recurrence Relation for Asymptotic Analysis]]
- [[#9.4]]
    - [[#Divide and Conquer Algorithms: Introduction and Mergesort]]
        - [[#Divide and Conquer FindMin]]
    - [[#MergeSort]]
    - [[#The Queue Data Structure]]
    - [[#The Merge Operation]]
        - [[#Simulating the Merge Operation]]
        - [[#Pseudocode for MergeSort]]
- [[#9.5]]
    - [[#Divide and Conquer Algorithms: Binary Search]]
        - [[#Recursive Binary Search]]
- [[#9.6]]
    - [[#Solving Linear Homogeneous Recurrence Relations]]
        - [[#Verifying an Expression Satisfies a Recurrence Relation]]
        - [[#Linear Homogeneous Recurrence Relations]]
- [[#9.7]]
    - [[#Solving Linear Nonhomogeneous Recurrence Relations]]
        - [[#The Associated Homogeneous Recurrence Relation]]
        - [[#Particular and Homogeneous Solutions]]
---
# 9.1
## Recursive Algorithms
- A **recursive algorithm** is an algorithm that calls itself
    - These calls to itself are known as **recursive calls**
### Recursive Algorithm to Compute the Factorial Function
![[image 40.png|image 40.png]]
  
![[image 1 25.png|image 1 25.png]]
### Recursive Algorithm to Compute the Power Set of a Set
![[image 2 23.png|image 2 23.png]]
![[image 3 22.png|image 3 22.png]]
**Proof of Correctness for PowerSet**
![[image 4 20.png|image 4 20.png]]
### Recursive Algorithm to Reverse a String
![[image 5 20.png|image 5 20.png]]
![[image 6 17.png|image 6 17.png]]
### Recursive Algorithm to Compute Fibonacci Numbers
![[image 7 15.png|image 7 15.png]]
![[image 8 13.png|image 8 13.png]]
  
# 9.2
## Induction and Recursive Algorithms
- Induction is a useful proof technique to prove facts about recursive algorithms such as establishing that a recursive algorithm gives the correct output for every possible valid input
    - First prove the base case works correctly
    - Inductive step then shows that the algorithm returns the correct value assuming that all of the recursive calls return the correct values
### Inductive Proof to Show Correctness for ReverseString
![[image 9 12.png|image 9 12.png]]
**Proof of Correctness for ReverseString**
![[image 10 12.png|image 10 12.png]]
  
# 9.3
## Analyzing the Time Complexity of Recursive Algorithms
### Deriving the Recurrence Relation
- The **time complexity** of an algorithm is a function $T(n)$ indicating the number of atomic operations performed by the algorithm on an input of size $n$
    - For a recursive algorithm, the function $T(n)$ is defined recursively by a recurrence realtion and initial values
**Deriving the Recurrence Relation that Defines the Time Complexity of a Recursive Algorithm**
![[image 11 12.png|image 11 12.png]]
### The Two Steps in Analyzing the Time Complexity of a Recursive Algorithm
![[image 12 11.png|image 12 11.png]]
### Simplifying Recurrence Relations for Asymptotic Analysis
![[image 13 11.png|image 13 11.png]]
### Deriving a Simplified Recurrence Relation for Asymptotic Analysis
![[image 14 9.png|image 14 9.png]]
  
# 9.4
## Divide and Conquer Algorithms: Introduction and Mergesort
- A **divide-and-conquer** algorithm solves a problem recursively by breaking the original input into smaller subproblems of roughly equal size
- Follow three basic steps
    - Break the input into smaller subproblems of the same type on smaller inputs
    - Solve each subproblem recursively
    - Combine the solutions of the subproblems to obtain a solution to the original problem
### Divide and Conquer FindMin
![[image 15 9.png|image 15 9.png]]
![[image 16 9.png|image 16 9.png]]
## MergeSort
- A **sorting algorithm** takes as input a list of items and returns the same list sorted in ascending order’
- **MergeSort** is a divide-and-conquer algorithm that sorts a list of items recursively by dividing the list into two sub-lists of roughly half the size, recursively sorting each sub-list, and merging the sorted sub-lists
![[image 17 8.png|image 17 8.png]]
## The Queue Data Structure
- A **data structure** is a way of organizing data in a computers so that the data can be accessed and updated efficiently
- A **queue** maintains items in an ordered list
    - New items can be added to one end of the queue called the **back**
    - Items can be removed from the other end of the queue called the **front**
**Simulating Operations on a Queue**
![[image 18 8.png|image 18 8.png]]
## The Merge Operation
- The input to the **Merge** operation are two sorted lists, A and B
- The output is a single list C that contains all the items from A and B in sorted order
### Simulating the Merge Operation
![[image 19 7.png|image 19 7.png]]
### Pseudocode for MergeSort
![[image 20 7.png|image 20 7.png]]
  
# 9.5
## Divide and Conquer Algorithms: Binary Search
- The goal of a **search algorithm** is to find a target item in a list
- **Binary Search** is an efficient algorithm to serarch for a target item in a sorted list
### Recursive Binary Search
- A recursive version of binary search takes two additional input values, _**low**_ and _**high**_
- If $n$ is the number of items in the list, then variables low and high must be in the range 1 throug hn and must satisfy the inequality low ≤ high
**Setting Variable low and high in Binary Search**
![[image 21 7.png|image 21 7.png]]
  
# 9.6
## Solving Linear Homogeneous Recurrence Relations
- A sequence that models a dynamical sstem is often described naturally by a recurrence relation
- Consider the Fibonacci sequence defined by the initial values and recurrence given below
![[image 22 7.png|image 22 7.png]]
- The method described in this section can be used to derive the following explicit formula corresponding to Fibonacci’s recursively defined sequence
![[image 23 7.png|image 23 7.png]]
- Finding an explicit formula for a recursively defined sequence is called **solving a recurrence relation**
### Verifying an Expression Satisfies a Recurrence Relation
![[image 24 7.png|image 24 7.png]]
### Linear Homogeneous Recurrence Relations
- Each number in a sequence defined by a **linear homogeneous** recurrence relation is a linear combination of numbers that occur earlier in the sequence
![[image 25 7.png|image 25 7.png]]
- In a **homogeneous** recurrence relation, the expression for $f_n$ contains no additional terms besides the ones that refer to earlier numbers in the sequence
**Examples Illustrating Linear and Nonlinear Recurrence Relations**
![[image 26 7.png|image 26 7.png]]
**Solving Linear Homogeneous Recurrence Relations: Distinct Roots**
![[image 27 7.png|image 27 7.png]]
  
# 9.7
## Solving Linear Nonhomogeneous Recurrence Relations
### The Associated Homogeneous Recurrence Relation
- A **nonhomogeneous linear recurrence relation** is a linear recurrence relation with additional terms that are either a constant or a function of $n$
- The recurrence relations below are all examples of nonhomogeneous linear recurrence relations
![[image 28 7.png|image 28 7.png]]
- The **associated homogeneous recurrence relation** is the recurrence relation with the additional nonhomogeneous terms dropped
![[image 29 7.png|image 29 7.png]]
### Particular and Homogeneous Solutions
- The solution to a nonhomogeneous linear recurrence relation is the sum of two parts: a **homogeneous solution** plus a **particular solution**
- If the sequence is $\{f_n\}$, then the homogeneous solution is denoted by $f_n^{(h)}$ and the particular solution is denoted by $f_n^{(p)}$
![[image 30 6.png|image 30 6.png]]
**Solvine Linear Nonhomogeneous Recurrence Relations**
![[image 31 5.png|image 31 5.png]]