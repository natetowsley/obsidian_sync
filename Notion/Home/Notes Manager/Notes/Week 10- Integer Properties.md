---
Date Created: 2025-04-01T17:19
Favorite: false
📕 Courses:
  - "[[Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#10.1]]
    - [[#The Division Algorithm]]
        - [[#Procedural Version of the Division Algorithm]]
- [[#10.2]]
    - [[#Modular Arithmetic]]
        - [[#Multiplication and Addition mod 5]]
        - [[#Congruence mod @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')mmm﻿]]
        - [[#Precedence of the mod Operation]]
- [[#10.3]]
    - [[#Prime Factorizations]]
        - [[#GCD and LCM from Prime Factorization]]
- [[#10.4]]
    - [[#Factoring and Primality Testing]]
        - [[#Primality Testing]]
        - [[#Factoring]]
- [[#10.5]]
    - [[#Greatest Common Divisor and Euclid’s Algorithm]]
        - [[#GCD Theorem]]
        - [[#Sample Execution of Euclid’s Algorithm]]
        - [[#The Multiplicative Inverse mod n]]
- [[#10.6]]
    - [[#Number Representation]]
        - [[#Hexadecimal Numbers]]
        - [[#Convertine Decimal Numbers to Base b]]
- [[#10.7]]
    - [[#Fast Exponentiation]]
        - [[#An Iterative Algorithm for Fast Exponentiation]]
        - [[#An Iterative Algorithm for Fast Modular Exopnentiation]]
- [[#10.8]]
    - [[#Introduction to Cryptography]]
        - [[#Messages as Numbers]]
        - [[#A Simple Cryptosystem]]
---
# 10.1
## The Division Algorithm
- Let $n$ be an integer and let $d$ be a positive integer
    - Then, there are unique integers $q$ and $r$, with 0 ≤ $r$ ≤ $d - 1$, such that $n = qd + r$
- In the Division Algorithm, the number $q$ is called the **quotient**, and the number $r$ is called the **remainder**
    - The operations **div** and **mod** produce the quotient and the remainder as a function of $n$ and $d$
![[image 42.png|image 42.png]]
### Procedural Version of the Division Algorithm
![[image 1 27.png|image 1 27.png]]
  
# 10.2
## Modular Arithmetic
- If an integer $m > 1$ is selected, then $mod$ $m$ is a function that takes a single integer x as input and ouputs x mod m, resulting in a number from the set 0, 1, 2, …, m - 1
### Multiplication and Addition mod 5
![[image 2 25.png|image 2 25.png]]
**Application 1: Hash Function**
- A common way to organize data is to maintain an array called a _**hash table**_ that is slightly larger than the number of data items to be stored. A _**hash function**_ is used to map each data item to a location in the array
**Application 2: Pseudo-Random Number Generators**
- Many computer applications use random numbers. However, truly random numbers are not easy to generate. As a substitute for random numbers, computers use functions called _**pseudo-random number generators**_ that produce numbers having many of the statistical properties of random numbers but are deterministically generated. Devising good pseudo-random number generators is an ongoing research topic in computer science. Meanwhile, a variety of pseudo-random number generators are regularly used in practice  
      
      
    
### Congruence mod $m$
- For a fixed m, an equivalence relation can be defined over the integers in which two integers x and y are equivalent if and only if x mod m = y mod m
![[image 3 24.png|image 3 24.png]]
### Precedence of the mod Operation
- The precedence of the mod operation is the same as multiplication and division, so the mod operation takes precedence over addition/subtraction
$$6+2mod7 = 6+(2mod7) = 8$$
$$6 * 2mod7 = (6*2)mod7 = 5$$
**Computing Arithmetic Operations mod m**
![[image 4 22.png|image 4 22.png]]
  
# 10.3
## Prime Factorizations
- Every positive integer greater than 1 can be expressed as a product of primes called its **prime factorization**
- The fact that every integer greater than one has a unique prime factorization is central to number theory and is called **The Fundamental Theorem of Arithmetic**
- The **multiplicity** of a prime factor p in a prime factorization is the number of times p appears in the product of primes
**Examples of Prime Factorization in Nondecreasing Order**
![[image 5 22.png|image 5 22.png]]
### GCD and LCM from Prime Factorization
![[1a0f243e-c904-48ee-b628-355251d74dbc.png]]
  
# 10.4
## Factoring and Primality Testing
### Primality Testing
- Input: Integer $N$ greater than 1
- Output: “Prime” if $N$ is prime and “Composite” if $N$ is composite
### Factoring
- Input: Integer $N$ greater than 1
- Output: “Prime” if $N$ is prime. If $N$ is composite, return two integers greater than 1 with a product that is $N$
**Brute Force Algorithm for Factoring**
![[image 6 19.png|image 6 19.png]]
  
# 10.5
## Greatest Common Divisor and Euclid’s Algorithm
### GCD Theorem
- Let x and y be two positive integers. Then…
$$GCD(x,y) = GCD(y\text{~mod~}x,x)$$
### Sample Execution of Euclid’s Algorithm
![[image 7 16.png|image 7 16.png]]
1. Euclid’s Agorithm computes $GCD(675, 210)$ by starting with $y = 675$ and $x = 210$, and computing $r = y \text{~mod~}x$
2. $r = y\text{~mod~}x=675\text{~mod~}210 = 45$
3. The variables are reassigned so that $y = 210, x= 45,\text{~and~} r=210\text{~mod~}45=30$
4. In the next iteration $y = 45,x=30,\text{~and~}r=45\text{~mod~}30 =15$. In the last iteration $y=30,x=15,\text{~and~} r=30\text{~mod~}15=0$
5. Since $r=0$, the algorithm is finished. $GCD(675, 210)$ is the current value of $x$, which is 15
**Euclid’s Algorithm for Finding the Greatest Common Divisor**
![[image 8 14.png|image 8 14.png]]
### The Multiplicative Inverse mod n
- A **multiplicative inverse mod n** (or just inverse mod n) of an integer x, is an integer $s\in1,2,...,(n-1)$ such that sx mod n = 1
  
# 10.6
## Number Representation
### Hexadecimal Numbers
- In **hexadecimal** notation (or **hex** for short), numbers are represented base 16
    - The 16 digits in hex are the usual 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 along with A, B, C, D, E, F
![[image 9 13.png|image 9 13.png]]
### Convertine Decimal Numbers to Base b
**Converting a Decimal Number to its Base 7 Expansion**
![[image 10 13.png|image 10 13.png]]
**Converting a Decimal Number to its Base b Expansion**
![[image 11 13.png|image 11 13.png]]
**Algorithm to find the Base b Expansion for a Positive Integer**
![[image 12 12.png|image 12 12.png]]
  
# 10.7
## Fast Exponentiation
**An Illustration of Fast Integer Exponentiation**
![[image 13 12.png|image 13 12.png]]
![[image 14 10.png|image 14 10.png]]
### An Iterative Algorithm for Fast Exponentiation
![[image 15 10.png|image 15 10.png]]
**A Sample Run of the Iterative Fast Exponentiation Algorithm**
![[image 16 10.png|image 16 10.png]]
![[image 17 9.png|image 17 9.png]]
### An Iterative Algorithm for Fast Modular Exopnentiation
![[image 18 9.png|image 18 9.png]]
  
# 10.8
## Introduction to Cryptography
- **Cryptography** is the science of protecting and authenticating data and communication
    - One important aspect of cryptography is the practice of sending messages securely in the presence of eavesdroppers who can learn the transmitted information
- A cryptosystem is a system by which a **sender** sends a message to a **receiver**
- The sender **encrypts** the message so that if an eavesdropper learns the transmitted message, the eavesdropper will be unable to recover the original message
    - The unencrypted message is called the **plaintext** and the encrypted message is called the **ciphertext**
- The receiver must have a **secret key** that allows the receiver to **decrypt** the ciphertext to obtain the original plaintext
### Messages as Numbers
- Modern cryptosystems rely on number theory in which the encryption and decryption procedures are mathematical functions with integers as input and output
**Converting a Text Message into a Numerical Message**
![[image 19 8.png|image 19 8.png]]
### A Simple Cryptosystem
**Encryption function**
![[image 20 8.png|image 20 8.png]]
**Decryption function**
![[image 21 8.png|image 21 8.png]]
![[image 22 8.png|image 22 8.png]]