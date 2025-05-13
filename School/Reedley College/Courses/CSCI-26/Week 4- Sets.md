---
Date Created: 2025-02-12T19:09
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
#### Tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#4.1]]
    - [[#Sets and Subsets]]
        - [[#Set Basics]]
        - [[#Common Mathematical Sets]]
- [[#4.2]]
    - [[#Sets of Sets]]
- [[#4.3]]
    - [[#Union and Intersection]]
        - [[#Intersection]]
        - [[#Union]]
        - [[#Special Notation]]
- [[#4.4]]
    - [[#More Set Operations]]
        - [[#Summary of Set Operations]]
- [[#4.5]]
    - [[#Set Identities]]
- [[#4.6]]
    - [[#Cartesian Products]]
- [[#4.7]]
    - [[#Partitions]]
---
# 4.1
## Sets and Subsets
- **Set:** A collection of objects
    - Each object in a set is called an **element**
- **Roster notation:** A list of the elements in a set enclosed in curly braces
    - A = {2, 4, 6, 8, 10}
    - Order of elements is unimportant
    - Repeating elements do not change the set
### Set Basics
![[image 32.png|image 32.png]]
![[image 1 17.png|image 1 17.png]]
![[image 2 15.png|image 2 15.png]]
### Common Mathematical Sets
![[image 3 14.png|image 3 14.png]]
- In **set builder notation**, a set is defined by specifying that the set includes all elements in a larger set that also satisfy certain conditions
    - The notation looks like: A = {x ∈ S : P(x)}
        - S is the larger set from which the elements A are take
        - P(x) is some condition for membership in A
        - The colon symbol is read “such that”
        - The description for A above reads: “All x in S such that P(x).
- **Universal Set:** A set that contains all elements mentioned in a particular context
    - Usually denoted by the variblae **U**
- Sets are often represented pictorially with **Venn Diagrams**
- If every element in a set is also an element of another set, then the first set is a **Subset** of the other.
    - A ⊆ B
- If every element in set A is in set B but A ≠ B, then A is a **proper subset** of B
    - A ⊂ B
![[image 4 12.png|image 4 12.png]]
  
# 4.2
## Sets of Sets
- A set can contain elements that are sets themselves
    - A = { {1, 2} , ∅, {1, 2, 3}, {1} }
        - A has four elements
        - 1 is not an element of A
- The **Power set** of a set A, denoted **P(A)**, is the set of all subsets of A
    - Example: If A = {1, 2, 3} then
        - P(A) = { ∅, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3} }
    - Easier to do when going by size of set
![[image 5 12.png|image 5 12.png]]
- The number of elements in a power set is 2 to the power of |A|
    - |A| = 5, then |P(A)| = $2^5$
  
# 4.3
## Union and Intersection
### Intersection
- Let A and B be sets. The **intersection** of A and B can be denoted A **∩ B**
![[image 6 9.png|image 6 9.png]]
### Union
- The **union** of two sets, A and B, denoted A **∪** B and read “A union B”, is the set of all elements that are elements of A or B
    - An element of both A and B is valid, as well as any part of just one of the two sets
![[image 7 7.png|image 7 7.png]]
- Set operations can be combined to define even more sets
    - Ex: A **∩** (B ∪ C)
    - Use of parenthesis is important
![[image 8 5.png|image 8 5.png]]
### Special Notation
![[image 9 4.png|image 9 4.png]]
  
# 4.4
## More Set Operations
- The **difference** between two sets A and B, denoted A - B, is the set of elements that are in A but not is B
![[image 10 4.png|image 10 4.png]]
- The **symmetric difference** between two sets A and B denoted A ⊕ B, is the set of elements that are in either A or B, but not both
![[image 11 4.png|image 11 4.png]]
![[image 12 4.png|image 12 4.png]]
- The **complement** of a set A, denoted A’, is the set of all elements in U that are not elements of A
![[image 13 4.png|image 13 4.png]]
### Summary of Set Operations
![[image 14 3.png|image 14 3.png]]
  
# 4.5
## Set Identities
- A **set identity** is an equation involving sets that is true regardless of the contents of the sets in the expression
![[image 15 3.png|image 15 3.png]]
  
# 4.6
## Cartesian Products
- For two sets, A and B, the **Cartesian product** of A and B, denoted A x B, is the set of all ordered pairs in which the first entry is in A and the second entry is in B
$$A × B = {(a,b) : (a ∈ A) and (b ∈ B)}$$
![[image 16 3.png|image 16 3.png]]
- A cartesian product of a set A with itself is denoted as A x A or $A^2$
  
# 4.7
## Partitions
- Two sets, A and B, are **disjoint** if the intersection of the two sets is empty (A ∩ B = Ø)
- A sequence of sets, $A_1, A_2, ... , A_n$ is **pairwise disjoint** if every pair of distinct sets in the sequence is disjoint
- A **partition** of a non-empty set A is a collection of non-empty subsets of A such that each element of A is in exactly one of the subsets
    - A partition is true if
![[image 17 3.png|image 17 3.png]]
![[image 18 3.png|image 18 3.png]]