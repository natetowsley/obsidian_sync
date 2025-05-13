---
Date Created: 2025-05-09T20:00
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
#### Tags: #ComputerScience 
# Table of Contents
- [[#Table of Contents]]
- [[#13.1]]
    - [[#Generating Permutiations and Combinations]]
        - [[#Lexicoragraphic Order]]
        - [[#Generating Permutations]]
- [[#13.2]]
    - [[#Binomila Coefficients and Combinatorial Identities]]
        - [[#Identities and Combinatorial Proofs]]
        - [[#Bijection Between k-subsets and (n-k)-subsets]]
        - [[#The Binomial Theorem]]
        - [[#The Binomial Theorem]]
        - [[#Pascal’s Triangle]]
- [[#13.3]]
    - [[#The Pigeonhole Principle]]
---
# 13.1
## Generating Permutiations and Combinations
### Lexicoragraphic Order
- **Lexicographic Order** is a way of ordering n-tuples in which two n-tuples are compared according to the first entry where they differ
    - Words in a dictionary are ordered in lexicographic order
**Comparing n-tuples lexicographically**
![[image 49.png|image 49.png]]
### Generating Permutations
- A **permutation** of the set $\{1,2,...,n\}$ is an ordered n-tuple in which each number in $\{1,2,...,n\}$ appears exactly once
**Algorithm to Generate Permutations in Lexicographic Order**
![[image 1 34.png|image 1 34.png]]
**Finding the Next Permutation in Lexicographic Order**
![[image 2 32.png|image 2 32.png]]
**Algorithm to Generate the Next Permutation in Lexicographic Order**
![[image 3 31.png|image 3 31.png]]
- The next algorithm takes as input two natural numbers, r and n, such taht r ≤ n, and outputs all the r-subsets of the set $\{1,2,...,n-1,n\}$
    - The elements in a subset are always listed in increasing order
    - Generated according to lexicographic order to ensure that each subset is generated exactly once
- The 3-subsets of the set $\{1,2,3,4,5\}$ are listed below in lexicographic order:
![[image 4 29.png|image 4 29.png]]
**Algorithm to Generate r-subsets in Lexicographic Order**
![[image 5 29.png|image 5 29.png]]
**Finding the next r-subset in Lexicographic Order**
![[image 6 26.png|image 6 26.png]]
  
# 13.2
## Binomila Coefficients and Combinatorial Identities
### Identities and Combinatorial Proofs
- An **identity** is a theorem stating that two mathematical expressions are equal
- An identity that involves expressions related to counting is called a combinatorial identity
**A simple combinatorial identity**
- For any nonnegative integers $n$ and $k$ such that $k$ ≤ $n$:
![[image 7 23.png|image 7 23.png]]
- An algebraic proof of the identity shows that each of the expressions above is equivalent to
$$n!\over{k!(n-k)!}$$
- A proof that uses counting principles is called **combinatorial proof**
    - Usually involve defining a set $S$ and counting the number of elements in $S$ to get a mathematical expression for the number of items in the set
    - Then, the elements in $S$ are counted by an alternate method method to get a different mathematical expression
    - Since the two expressions evaluate to the same quantity(the number of elements in $S$), the two expressions must be equal
### Bijection Between k-subsets and (n-k)-subsets
![[image 8 21.png|image 8 21.png]]
### The Binomial Theorem
- The binomial $(a + b)^3$ can be expanded to a sum of terms as follows:
![[image 9 20.png|image 9 20.png]]
- There is a term for every string in the set $a$, $b^3$.
    - Since the variables a and b commute, many of these terms can be folded together (EX: $aab +aba+baa=3a^2b$)
    - After collapsing all equivalent terms, the binomial can be expressed as:
![[image 10 19.png|image 10 19.png]]
- The coefficients in the expansions of $(a+b)^n$ for positive integer $n$ are called **binomial coefficients**
- The **Binomial Theorem** says that the coefficient of $a^kb^{n-k}$ in $(a+b)^n$ is $\begin{pmatrix}n\\k\end{pmatrix}$ , which is also equal to $\begin{pmatrix} n\\{n-k}\end{pmatrix}$
### The Binomial Theorem
- For any nonnegative integer $n$ and any real numbers $a$ and $b$:
![[image 11 18.png|image 11 18.png]]
### Pascal’s Triangle
- The $17^{th}$ century French mathematician, Blaise Pascal, developed a triangular chart that contains all the numbers of the form $\begin{pmatrix} n \\ k \end{pmatrix}$
- The chart below showing **Pascal’s triangle** can be used to derive the value of a particular $\begin{pmatrix} n \\ k \end{pmatrix}$
    - The $n^{th}$ row of Pascal’s Triangle contains the $n + 1$ binomial coefficients of the form $\begin{pmatrix} n \\ k \end{pmatrix}$ as shown below
![[image 12 17.png|image 12 17.png]]
- All blue terms can be replaced by 1 because $\begin{pmatrix} n \\ 0 \end{pmatrix} = \begin{pmatrix} n \\ n \end{pmatrix} = 1$
- **Pascal’s Identity** says that the number of ways to select a set of $k$ items from a set of $n$ items is equal to the number of ways to select $k -1$ from $n-1$ plus the number of ways to select $k$ from $n - 1$
- For any positive $n$ and $k$ such that $k < n$:
$$\begin{pmatrix} n \\ k \end{pmatrix} = \begin{pmatrix} n-1 \\ k-1 \end{pmatrix} + \begin{pmatrix} n-1 \\ k \end{pmatrix}$$
![[image 13 17.png|image 13 17.png]]
  
# 13.3
## The Pigeonhole Principle
- The **pigeonhole principle** says that if $n + 1$ pigeons are placed in $n$ boxes, then at least one box must contain more than one pigeon
![[image 14 15.png|image 14 15.png]]
n = 9
**Pigeonhole Principle with Locations in Square Area**
![[image 15 15.png|image 15 15.png]]