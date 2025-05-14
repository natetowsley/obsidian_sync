---
Date Created: 2025-04-14T12:34
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
#### Tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#11.1]]
    - [[#Sum and Product Rules]]
        - [[#The Product Rule]]
        - [[#Counting Strings]]
        - [[#The Sum Rule]]
- [[#11.2]]
    - [[#The Bijection Rule]]
        - [[#The @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')kkk﻿-to-1 Rule]]
- [[#11.3]]
    - [[#The Generalized Product Rule]]
- [[#11.4]]
    - [[#Counting Permutations]]
- [[#11.5]]
    - [[#Counting Subsets]]
        - [[#Using the k-to-1 rule to count subsets]]
- [[#11.6]]
    - [[#Subset and Permutation Examples]]
- [[#11.7]]
    - [[#Counting by Complement]]
- [[#11.8]]
    - [[#Permutations with Repitions]]
- [[#11.9]]
    - [[#Counting Multisets]]
        - [[#Counting Solutions to Variables with a Fixed Sum]]
- [[#11.11]]
    - [[#Inclusion-Exclusion Principle]]
        - [[#Between Two Sets]]
        - [[#Between Three Sets]]
        - [[#Inclusion-Exclusion Principle Example]]
        - [[#The General Inclusion-Exclusion Principle]]
        - [[#The Inclusion-Exclusion Principle and the Sum Rule]]
---
# 11.1
## Sum and Product Rules
### The Product Rule
- The **product rule** provides a way to count sequences
![[image 45.png|image 45.png]]
- EX:
$$\begin{matrix} D = {\text{\{coffee, orange juice\}}} \\ M = {\text{\{pancakes, eggs\}}} \\ S = {\text{\{bacon, sausage, hash browns\}}} \end{matrix}$$
- The set of all possible choices is the same as the set of a triples where the first entry is a drink, the second entry is a main course, and the third entry is a side
    - The number of possible breakfast combinations is therefore
$$|D \times M\times S| = |D| *|M|*|S| = 2*2*3=12$$
![[image 1 30.png|image 1 30.png]]
### Counting Strings
- If $\sum$ is a set of characters (called an **alphabet**), then $\sum^n$ is the set of all strings of length $n$ containing characters that come from the set $\sum$
- The product rule can be applied directly to determine the number of strings of a given length over a finite alphabet:
![[image 2 28.png|image 2 28.png]]
- EX:
    - The number of binary strings of length $n$ is $2^n$ since the size of the alphabet is 2 (0 and 1)
- The product rule can also be used to detemine the number of strings in a set when one or more of the characters are restricted
    - Define $S$ to be a set of binary strings of length 5 that start and end with 0
    - A string is in the set $S$ if it has the form 0***0, where each * could be a 0 or a 1
$$|S| = |\{0\} \times \{0,1\} \times \{0,1\} \times\{0,1\} \times\{0\}| = 1*2*2*2*1 = 8$$
### The Sum Rule
- In constrast, the **sum rule** is applied when multiple choices are available, but only one selection is made
![[image 3 27.png|image 3 27.png]]
$$|C \ \cup\ H| = |C|+|H| = 2+3=5$$
**An Example of the Sum and Product Rule**
![[image 4 25.png|image 4 25.png]]
  
# 11.2
## The Bijection Rule
- The **bijection rule** says that if there is a bijection from one set to another, then the two sets have the same cardinality
- A function $f$ from a set $S$ to a set $T$ is called a **bijection** if and only if $f$ has a well-defined inverse
    - The **inverse** of a function $f$ that maps set $S$ to set $T$ is a function $g$ that maps $T$ to $S$ such that for every $s \in S$ and every $t \in T$, $f(s) = t$, if and only if $g(t) = s$
    - If a function $f$ has an inverse it is denoted by $f^{-1}$
**An example of the Bijection Rule**
![[image 5 25.png|image 5 25.png]]
### The $k$-to-1 Rule
$k$**-to-1 Correspondence**
![[image 6 22.png|image 6 22.png]]
- The **k-to-1 rule** uses a k-to-1 correspondence to count the number of elements in the range by counting the number of elements in the domain and dividing by $k$
$k$**-to-1 Rule**
![[image 7 19.png|image 7 19.png]]
**An example of the** $k$**-to-1 Rule**
![[image 8 17.png|image 8 17.png]]
  
# 11.3
## The Generalized Product Rule
- The **generalized product rule** says that in selecting an item from a set, if the number of choices at each step does not depend on the previous choices made, then the number of items in the set is the product of the number of choices in each step
![[image 9 16.png|image 9 16.png]]
**An example of the Generalized Product Rule**
![[image 10 16.png|image 10 16.png]]
  
# 11.4
## Counting Permutations
- One common application of the generalized product rule is in counting permutations
- An **r-permutation** is a sequence of r items with no repetitions, all taken from the same set
![[image 11 15.png|image 11 15.png]]
- A **permutation** (without the parameter r) is a sequence that contains each element of a finite set exactly once
**Permutations of the set** $\{a,b,c\}$
![[image 12 14.png|image 12 14.png]]
**The number of Permutations of a finite set**
![[image 13 14.png|image 13 14.png]]
  
# 11.5
## Counting Subsets
- A subset of size r is called an **r-subset**
### Using the k-to-1 rule to count subsets
$$\text{Colors}=\{\text{blue,green,orange,pink,red}\}$$
- The number of 3-permutations from the set of five colors is $P(5,3) =$${5!}\over2!$$=60$
$$\text{Number of 3-subsets of colors} = \frac{P(5,3)}{3!} = \frac{5!}{3!2!} = 10$$
**Mapping r-permutations to r-subsets**
**A small example**
![[image 14 12.png|image 14 12.png]]
  
# 11.6
## Subset and Permutation Examples
![[image 15 12.png|image 15 12.png]]
  
# 11.7
## Counting by Complement
- **Counting by complement** is a technique for counting the number of elements in a set $S$ that have a property by counting the total number of elements in $S$ and subtracting the number of elements in $S$ that do not have that property
- The principle of counting by complement can be written using set notation where $P$ is the subset of elements in $S$ that have the property
$$|P| = |S|-|\overline{P}|$$
**Counting by Complement: The Number of 8-bit Strings with at least one 0**
![[image 16 12.png|image 16 12.png]]
  
# 11.8
## Permutations with Repitions
- A **permutation with repetition** is an ordering of a set of items in which some of the items may be identical to each other
- EX:
    - There are $3!=6$ permutations of the letters CAT because the letters in CAT are all different
    - There are only $3$ different way to scramble the letters in DAD: ADD, DAD, DDA
**Counting the Number of Permutations of the letters in MISSISSIPPI**
![[image 17 11.png|image 17 11.png]]
  
# 11.9
## Counting Multisets
- A **multiset** is a collection that can have multiple instances of the same kind of item
- When the expression $\{1,2,2,3\}$ is viewed as a set, the repetitions don’t matter and $\{1,2,2,3\}=\{1,2,3\}$
    - However, when $\{1,2,2,3\}$ is viewed as a multiset, then the fact that there are two occurrences of 2 is important, and $\{1,2,2,3\} \not = \{1,2,3\}$
- Two multisets are equal if they have the same number of each type of element
    - The curly braces denote the fact that the order in which the elements are listed does not matter, so $\{1,2,2,3\} = \{2,1,2,3\}$
**Rules for Encoding a Selection of n Objects from m Varieties**
![[image 18 11.png|image 18 11.png]]
**Counting Multisets: Mapping Code Words to Cookie Selections**
![[image 19 10.png|image 19 10.png]]
**Counting Subsets with Repetitions: Mapping Cookie Selections to Code Words**
![[image 20 9.png|image 20 9.png]]
### Counting Solutions to Variables with a Fixed Sum
- Consider the equation
$$x_1+x_2+x_3+x_4 = 12$$
- There is a bijection between solutions to the equation and the number of ways to select 12 objects from four varieties
    - The varieties of objects are numbered from 1 to 4
    - For $i = 1,2,3,4,x_i$ is the number of objects selected from the $i^{th}$ variety
![[image 21 9.png|image 21 9.png]]
- Since each $x_i$ is a nonnegative integer, an assignment of values to variables corresponds to a valid selection of objects
- The variables sum to 12, so a total of 12 objects are selected
    - Similarly, a selection of 12 objects from 4 varieties corresponds to a valid assignment of values to variables, so that the sum of the variables is 12
    - Therefore, the number of solutions to the equation equals the number of ways to select 12 objects from 4 varieties
  
# 11.11
## Inclusion-Exclusion Principle
### Between Two Sets
- The **principle of inclusion-exclusion** is a technique for determining that cardinality of the union of sets that uses the cardinality of each individual set and the cardinality of the intersections of the sets
![[image 22 9.png|image 22 9.png]]
$$\text{Let }A \text{ and } B \text{be two finite sets, then } |A \cup B| = |A| + |B| - |A \cap B|$$
### Between Three Sets
- As the number of sets grows, the expression becomes more complex
![[image 23 8.png|image 23 8.png]]
$$\begin{matrix} \text{Let } A, B \text{and }C\text{ be three finite sets, then} \\ |A\cup B\cup C| = |A| + |B| + |C| - |A \cap B| - |B \cap C| - |A \cap C| + |A \cap B \cap C|\end{matrix}$$
### Inclusion-Exclusion Principle Example
![[image 24 8.png|image 24 8.png]]
### The General Inclusion-Exclusion Principle
![[image 25 8.png|image 25 8.png]]
### The Inclusion-Exclusion Principle and the Sum Rule
- A collection of sets is **mutually disjoint** if the intersection of every pair of sets in the collection is empty
- If the principle of inclusion-exclusion is applied to determine the union of a collection of mutually disjoint sets, then all the terms with the intersections are zero
    - Therefore, for a collection of mutually disjoint sets, the cardinality of the union of the sets is equal to the sum of the cardinality of each of the individual sets
$$|A_1 \cup A_2 \cup ... \cup A_n| = |A_1| + |A_2| + ... + |A_n|$$