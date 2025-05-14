---
Date Created: 2025-03-02T11:21
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
#### Tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#6.1]]
    - [[#Introduction to Binary Relations]]
- [[#6.2]]
    - [[#Properties of Binary Relations]]
        - [[#Reflexive and Anti-Reflexive Binary Relations]]
        - [[#Symmetric Binary Relations]]
        - [[#Anti-Symmetric Binary Relations]]
        - [[#Transistive Binary Relations]]
- [[#6.3]]
    - [[#Directed Graphs, Paths, and Cycles]]
        - [[#Walks in Directed Graphs]]
        - [[#Trails, Circuits, Paths, and Cycles]]
- [[#6.4]]
    - [[#Composition of Relations]]
- [[#6.5]]
    - [[#Graph Powers and The Transitive Closure]]
        - [[#The Graph Power Theorem]]
        - [[#The Transistive Closure]]
- [[#6.6]]
    - [[#Matrix Multiplication and Graph Powers]]
        - [[#Matrix Product]]
        - [[#Matrix Sum]]
- [[#6.7]]
    - [[#Partial Orders]]
        - [[#Upward Drawings of Partial Orders]]
- [[#6.8]]
    - [[#Strict Orders and Directed Acyclic Graphs]]
        - [[#Directed Acyclic Graphs]]
- [[#6.9]]
    - [[#Equivalence Relations]]
- [[#6.10]]
    - [[#N-ary Relations and Relational Databases]]
        - [[#The Selection Operator]]
        - [[#The Projection Operation]]
---
# 6.1
## Introduction to Binary Relations
- A **Binary Relation** between two sets A and B is a subset R of A x B
    - Binary refers to the fact that the realtion is a subset of the cartesian product of _two_ sets
- Ex: Suppose, for example, that S is the set of students at a university and C is the set of classes offered by the university. The relation E between s∈S and c∈C indicates whether a student is enrolled in a given class. Thus, s⁢E⁢c if student s is enrolled in class c. A student can be enrolled in more than one class, and a class can have more than one student enrolled in it. If a student s is not currently taking any classes, then no c exists such that s⁢E⁢c. Similarly, if a course c is not currently offered by the university, then no s exists such that s⁢E⁢c.
![[image 35.png|image 35.png]]
- The binary relation between two finite sets can be represented by an **arrow diagram**
![[image 1 20.png|image 1 20.png]]
- A **matrix representation** of relation R between A and B is a rectangular array of numbers with |A| rows and |B| columns
    - Each row corresponds to an element of A
    - Each column corresponds to an element of B
![[image 2 18.png|image 2 18.png]]
  
# 6.2
## Properties of Binary Relations
### Reflexive and Anti-Reflexive Binary Relations
- Suppose that R is a binary relation on set A
    - R is **reflexive** if and only if for every x ∈ A, xRx is not true
    - R is **anti-reflexive** if and only if for every x in the domain of R, it is not true that xRx
        - Also known as irreflexive
![[image 3 17.png|image 3 17.png]]
### Symmetric Binary Relations
- Suppose R is a relation on set A. R is **symmetric** if and only if for every pair, x and y ∈ A, xRy if and only if yRx
- A relation is symmetric if for every pair of elements x and y in the domain, one of the following situations holds:
    - xRy and yRx are both true
    - Neither xRy nor yRx is true
![[image 4 15.png|image 4 15.png]]
### Anti-Symmetric Binary Relations
- Suppose R is a relation on set A. R is **anti-symmetric** if and only if for every pair, x and y ∈ A, if x **≠** y then xRy and yRx cannot both be true
- A relation is anti-symmetric if for every pair of distinct elements in the domain one of the following situations holds:
    - xRy, but yRx is not true
    - yRx, but xRy is not true
    - Neither xRy nor yRx is true
![[image 5 15.png|image 5 15.png]]
### Transistive Binary Relations
- Suppose R is a relation on set A. R is **transistive** if and only if for every three elements, x, y, z ∈ A, if xRy and yRz, then xRz must also be true
![[image 6 12.png|image 6 12.png]]
  
# 6.3
## Directed Graphs, Paths, and Cycles
- A **directed graph** (or **digraph**) consists of a pair (V, E). V is a set of **vertices** and E, a set of **directed edges**, is a subset of $V * V$
    - An individual element of V is called a **vertex**
- The **in-degree** of a vertex is the number of edges pointing to it
- The **out-degree** of a vertex is the number of edges pointing out of it
![[image 7 10.png|image 7 10.png]]
### Walks in Directed Graphs
- A **walk** from $v_0$ to $v_1$ in a directed graph G is a sequence of alternating vertices and edges that starts and ends with a vertex
![[image 8 8.png|image 8 8.png]]
- The **length of a walk** is $l$, the number of edges in the walk
- An **open walk** is a walk in which the first and last vertices are not the same
- A **closed walk** is a walk in which the first and last vertices are the same
### Trails, Circuits, Paths, and Cycles
- A **trail** is a walk in which no edge occurs more than once
- a **path** is an open walk in which no vertex occurs more than once
- A **circuit** is a closed trail
- A **cycle** is a circuit of length at least 1 in which no vertex occurs more than once, except the first and last vertices which are the same
  
# 6.4
## Composition of Relations
- The **composition** of relations R and S on set A is another relation on A, denoted $S ∘ R$
    - The pair (a,c) ∈ $S ∘ R$ if and only if there is a b∈ A such that (a,b) ∈ R and (b,c) ∈ S
![[image 9 7.png|image 9 7.png]]
![[image 10 7.png|image 10 7.png]]
  
# 6.5
## Graph Powers and The Transitive Closure
### The Graph Power Theorem
- Leg G be a directed graph. Let u and v be any two vertices in G. There is an edge from u to v in $G^k$ if and only if there is a walk of length k from u to v in G
![[image 11 7.png|image 11 7.png]]
### The Transistive Closure
- The relation $R^+$ is the **transistive closure** of R and is the smallest relation that is both transistive and includes all the pairs from R
    - If G is a directed graph, then $G^+$ is the transistive closure of G
![[image 12 7.png|image 12 7.png]]
![[image 13 7.png|image 13 7.png]]
- Transistive closure of a relation
    - If there are three elements x,y,z ∈ A such the (x,y) ∈ R, (y,z) ∈ R and (x,z) ∉ R, then add (x,z) to R
![[image 14 6.png|image 14 6.png]]
  
# 6.6
## Matrix Multiplication and Graph Powers
- An $n ×m$ **matrix** over a set S is an array of elements from S with n rows and m columns
    - Each element in a matrix is called an **entry**
    - Entry in row i and column j of matrix A is denoted by $A_i,_j$
    - A matrix is called a **square matrix** if the number of rows is equal to the number of columns
![[image 15 6.png|image 15 6.png]]
- A directed graph G with n vertices can be represented by an n x n matrix over the set 0,1 called the **adjacency matrix** for G
    - If matrix A is the adjacency matrix for a graph G, then $A_i,_j$ = 1 if G contains an edge from vertex i to vertex j. Otherwise $A_i,_j$ = 0
![[image 16 6.png|image 16 6.png]]
- A **boolean matrix** is a matrix with entries from the set 0,1
    - Boolean addition and multiplication are used in adding and multiplying entries of a Boolean matrix
![[image 17 5.png|image 17 5.png]]
- The **dot product** of row i of A and column j of B is the sum of the product of each entry in row i from A with the corresponding entry in column j from B:
![[image 18 5.png|image 18 5.png]]
![[image 19 4.png|image 19 4.png]]
### Matrix Product
- If A and B are n x n matrices over the integers, then the **matrix product** of A and B, denoted AB or A * B, is another n x n matrix such that $(AB)_i,_j$ is the result of taking the dot product of row i of matrix A and column j of matrix B
![[image 20 4.png|image 20 4.png]]
- Matrix multiplication is associative, so if A, B, and C are all n x n matrices then A(BC) = (AB)C
- Matrix multiplication is not commutative, because there are matrices A and B for which AB **≠** BA. The $k^{th}$ **power of a matrix** A is the product of k copies of A
![[image 21 4.png|image 21 4.png]]
![[image 22 4.png|image 22 4.png]]
- If G is a directed graph, then the $k^{th}$ power of G ($G^k$) represents walks of length k in G. $G^k$ contains an edge from vertex v to vertex w if and only if G contains a walk of length exactly k from v to w
### Matrix Sum
- If A and B are two m x n matrices, then the **matrix sum** of A and B, denoted A + B, is also an m x n matrix such that $(A+B)_{i,j} = A_{i,j} + B_{i,j}$ for all 1 **≤** i **≤** m and 1 **≤** j **≤** n
![[image 23 4.png|image 23 4.png]]
  
# 6.7
## Partial Orders
- A relation R on set A is a **partial order** if it is reflexive, transitive, and anti-symmetric
    - The notation $a ≼ b$ is read “a is at most b”
![[image 24 4.png|image 24 4.png]]
### Upward Drawings of Partial Orders
- An **upward drawing** is a useful way to depict a partial order on a finite set
    - Each element is represented by a labeled point
    - Precedence relationships are shown by placing elements that are greater than other elements towards the top of the diagram
![[image 25 4.png|image 25 4.png]]
  
# 6.8
## Strict Orders and Directed Acyclic Graphs
- A relation R is a **strict order** if R is transistive and anti-reflexive
    - The notation a ≺ b is used to express aRb and is read “a is less than b”
- The definitions for a partial order carry over in a natural way to strict orders
    - Two elements, x and y, are **comparable** if x < y or y < x. Otherwise, the elements are **incomparable**
    - A strict order is a **total order** if every distinct pair of elements is comparable
    - An element x is a **minimal** element of there is no such y that y < x
    - An element x is a **maximal** element if there is no such y such that x < y
![[image 26 4.png|image 26 4.png]]
### Directed Acyclic Graphs
- A **directed acyclic graph (DAG)** is a directed graph that has no cycles
![[image 27 4.png|image 27 4.png]]
- A **topological** sort for a DAG is an ordering of the vertices that is consistent with the edges in the graph
    - If there is an edge (u, v), then u appears earlier than v in the topological sort
![[image 28 4.png|image 28 4.png]]
![[image 29 4.png|image 29 4.png]]
  
# 6.9
## Equivalence Relations
- A relation R is an **equivalence relation** if R is reflexive, symmetric, and transistive
    - Denoted a ~ b “a is equivalent to b”
![[image 30 3.png|image 30 3.png]]
  
# 6.10
## N-ary Relations and Relational Databases
- A relation on sets $A_1, A_2,..., A_n$ is a subset of $A_1 * A_2 * ... * A_n$
    - Each elemetn of the realtion is an n-tuple in which the $i^{th}$ entry in the n-tuple if from $A_i$
    - A relation on n sets is an **n-ary relation**
### The Selection Operator
- The **selection operator** chooses n-tuples from a relational database that satisfy particular conditions on their attributes
![[image 31 3.png|image 31 3.png]]
### The Projection Operation
- The **projection operation** takes a subset of the attributes and deletes all the other attributes in each of the n-tuples
    - An instance of the projection operation takes the form: Project[ list of attributes]
    - If the number of attributes in the list is m (with $m ≤ n$) then the result is a set of m-tuples
![[image 32 2.png|image 32 2.png]]