---
Date Created: 2025-03-13T11:02
Favorite: false
📕 Courses:
  - "[[Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#7.1]]
    - [[#An Introduction to Algorithms]]
        - [[#Algorithm to Compute the Sum of Three Numbers]]
        - [[#The if Statement and the if-else Statement]]
        - [[#The for Loop]]
        - [[#The while Loop]]
        - [[#Nested Loop]]
- [[#7.2]]
    - [[#Asymptotic Growth of Functions]]
        - [[#@import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')OOO﻿ Notation]]
        - [[#Proving that @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')fff﻿ is @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')O(g)O(g)O(g)﻿ ]]
        - [[#Proving that @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')fff﻿ is not @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')O(g)O(g)O(g)﻿]]
        - [[#Ω Notation]]
        - [[#Proving that @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')fff﻿ is @import url('https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.16.9/katex.min.css')Ω(g)Ω(g)Ω(g)﻿]]
        - [[#Θ Notation and Polynomials]]
        - [[#Asymptotic Growth of Polynomials]]
        - [[#Asymptotic Growth of Logarithm Functions with Different Bases]]
- [[#7.3]]
    - [[#Analysis of Algorithms]]
        - [[#Asymptotic Complexity]]
- [[#7.4]]
    - [[#Finite State Machines]]
        - [[#Components of a FSM]]
        - [[#Finite State Machines with Output]]
        - [[#Components of a Finite State Machine with Output]]
        - [[#Finite State Machines that Recognize Properties]]
        - [[#Components of a Finite State Machine that Recognizes a Property]]
- [[#7.5]]
    - [[#Turing Machines]]
        - [[#The Definition of a Turing Machine]]
        - [[#Components of a Turing Machine]]
---
# 7.1
## An Introduction to Algorithms
- An **algorithm** is a step-by-step method for solving a problem
    - A description of an algorithm specifies the input to the problem, the output to the problem, and the sequence of steps to be followed to obtain the output from the input
- Algorithms are often described in **pseudocode**, which is a language in between written English and a computer language
- An important type of step in an algorithm is an **assignment**, in which a variable is given a value
    - Assignment operator denoted by `x := y`
- The output of an algorithm is specified by a **return** statement
    - Ex: `Return(x)`
### Algorithm to Compute the Sum of Three Numbers
![[image 37.png|image 37.png]]
### The if Statement and the if-else Statement
- An **if statement** tests a condition and executes one or more instructions if the condition evaluates to true
    
    - In a single line if statement, a condition and instruction appear on the same line
    
    ![[image 1 22.png|image 1 22.png]]
    
    - An if statement can also be followed by a sequence of indented operations with a final end-if statement
        
        ![[image 2 20.png|image 2 20.png]]
        
- An **if-else statement** tests a condition, executes one or more instructions if the condition evaluates to true, and executes a different set of instructions if the condition evaluates to false
![[image 3 19.png|image 3 19.png]]
- Ex: If-else statement
![[image 4 17.png|image 4 17.png]]
### The for Loop
- In a **for loop**, a block of instructions is executed a fixed number of times as specified in the first line of the for loop, which defines an **index**, a starting value for the index, and a final value for the index
    - Each repetition of the block of instructions inside the for loop is called an **iteration**
In the first iteration, $i$ has the value of $s$. In the next iteration, $i = s+1$, and so on. In the final iteration, $i = t$. If $t ≥s$, then the for loop iterates $t-s+1$ times. If $t < s$, then the for loop is skipped and the algorithm proceeds with the line after the end-for.
![[image 5 17.png|image 5 17.png]]
### The while Loop
- A **while loop** iterates an unknown number of times, ending when a certain condition becomes false
![[image 6 14.png|image 6 14.png]]
### Nested Loop
- A **nested loop** is a loop that appears within another loop
![[image 7 12.png|image 7 12.png]]
  
# 7.2
## Asymptotic Growth of Functions
- The **asymptotic growth** of the function f is a measure of how fast the output f(n) grows as the input n grows
- The classification of functions using big O, big Theta (Θ), and big Omega (Ω) (called **asymptotic notation**)
### $O$ Notation
- The expression “f is O(g)” is read “f is Oh of g” and means that the function f(n) is less than or equal to g(n), if constant factors are omitted and small values for $n$ are ignored
    - If f is O(g), then there is a positive number c such that when f(n) and c * g(n) are graphed, the graph of c * g(n) eventually crosses f(n) and remains higher than f(n) as n gets large
![[image 8 10.png|image 8 10.png]]
**O Notation Example**
![[image 9 9.png|image 9 9.png]]
### Proving that $f$ is $O(g)$
- A mathematical proof that a function f is $O(g)$ gives specific values for c and $n_0$ and then uses algebra to prove that $f(n) <= c*g(n)$ whenever $n >= n_0$
    - The constants c and $n_0$ used in a proof are a **witness** to the fact that $f = O(g)$
    - Many different choices for the witness c and $n_0$ will suffice
![[image 10 9.png|image 10 9.png]]
### Proving that $f$ is not $O(g)$
- By definition, if $f$ is $O(g)$, then there must be a witness, c and $n_0$, showing that f is $O(g)$
    - Showing that f is not $O(g)$ requires showing that every possible combination of values for c and $n_0$, fails to be a witness
    - Must establish that for every $n_0$ and c, there is a value of n such that $n >= n_0$ and $f(n) > c* g(n)$
![[image 11 9.png|image 11 9.png]]
### **Ω Notation**
- The $O$ notation serves as the rough upper bound for functions (desregarding constants and small input values)
- The $Ω$ notation is similar, except that it provides a lower bound on the growth of the funciton
- Let $f$ and $g$ be functions from $Z^+$ to $R^{>=}$, then $f$ is $Ω(g)$ if there are poisitive real numbers c and $n_0$ such that for any $n∈ Z^+$ where $n >= n_0$
![[image 12 9.png|image 12 9.png]]
- The expresion “$f$ is $Ω(g)$” is read “f is **omega** of g”
![[image 13 9.png|image 13 9.png]]
### Proving that $f$ is $Ω(g)$
- In a proof that f is **Ω(g)**, many different choices for the constants c and $n_0$ suffice as a witness
    - If f(n) is a polynomial of degree k, then $f = Ω(n^k)$ only if the coefficient of the $n^k$ term in f(call it $a_k$) is positive
![[image 14 7.png|image 14 7.png]]
### **Θ Notation and Polynomials**
- The Θ notation indicates that two functions have the same rate of growth
- Let f and g be functions from $Z^+$ to $R^{>=}$, then f is $Θ(g)$ and f is $Ω(g)$
- The expression $f$ is $Θ(g)$ is read “f is **theta** of g(n)”
### Asymptotic Growth of Polynomials
![[image 15 7.png|image 15 7.png]]
### Asymptotic Growth of Logarithm Functions with Different Bases
- Let a and b be two real numbers greater than 1, then:
    - $Log_an$ is $Θ(log_bn)$
**Common Functions in Algorithmic Complexity**
![[image 16 7.png|image 16 7.png]]
  
# 7.3
## Analysis of Algorithms
- The amount of resources an algorithm uses is the algorithm’s **computational complexity**
- The primary resources to optimize are the time the algorithm requires to run (**time complexity**) and the amount of memory used (**space complexity**)
- **Time complexity**: defined by a function $f:Z^+ → Z^+$ such that f(n) is the maximum number of atomic operations performed by the algorithm on any input size n
![[image 17 6.png|image 17 6.png]]
### Asymptotic Complexity
- The **asymptotic time complexity** of an algorithm is the rate of asymptotic growth of the algorithm’s time complexity function $f(n)$
![[image 18 6.png|image 18 6.png]]
  
# 7.4
## Finite State Machines
- A **finite state machine (FSM)** consists of a finite set of states with transitions between the states triggered by different input actions
- FSM that controls a turnstile
![[image 19 5.png|image 19 5.png]]
![[image 20 5.png|image 20 5.png]]
- A finite state machine has a finite set of states
    - The FSM is always in one of the states
    - The current state is the only information that the FSM remembers about the past
- The FSM receives input from outside in the form of a sequence of actions
    - For turnstile above, the input set is $I =$ {COIN, PUSH}
- Reaction depends on the current state and input action
    - Turnstile is either LOCKED or UNLOCKED
- The reaction of a finite state machine to the input received is denoted by a **transition function**
    - Input to transition function is current state and the input action, so the domain is the Cartesian product set $Q * I$
- The output of the transition function on input (LOCKED, COIN) is UNLOCKED
    - Output of the transition fucntion for this particular style of FSM is just the next state to which the FSM transitions
    - The transition function is often denoted by the symbol **δ**
        - δ(LOCKED, COIN) = UNLOCKED
**State Transition Table for the Tunstile Finite State Machine**
![[image 21 5.png|image 21 5.png]]
### Components of a FSM
![[image 22 5.png|image 22 5.png]]
### Finite State Machines with Output
- **FSM with Output:** Produces a response that depends on the current state and the most recently received input
- EX: GUMBALL MACHINE
    - $Q = q_0, q_5, q_{10},q_{15},q_{20}$ (states)
    - $I = \{NICKEL, DIME, BUY\}$ (inputs)
    - $O = \{GUMBALL, RETURN, MESSAGE, NONE\}$ (outputs)
![[image 23 5.png|image 23 5.png]]
### Components of a Finite State Machine with Output
![[image 24 5.png|image 24 5.png]]
### Finite State Machines that Recognize Properties
- Instead of having input actions from a user, each input is a character from a finite alphabet
- An input string is accepted if the FSM ends up in an **accepting state** after each character in the string is processed
- Consider a finite state machine with the input alphabet {0, 1}, with two states {ODD, EVEN}
    - Odd (double outline) is the only accepting state
![[image 25 5.png|image 25 5.png]]
- The **parity of a string** is whether the number of 1s in the string is odd or even
### Components of a Finite State Machine that Recognizes a Property
![[image 26 5.png|image 26 5.png]]
  
# 7.5
## Turing Machines
- **Turing Machine:** A model of a computer developed to reason about general purpose computers
### The Definition of a Turing Machine
- Memory is a one dimensional tape divided into individual cells
- Each cell can hold one symbol from a finite **tape alphabet** denoted by $Γ$
- The tape is infinite from left to right but has a leftmost cell
- Every cell must contain a blank symbol (represented by *) and at least one other symbol
![[image 27 5.png|image 27 5.png]]
- A **configuration** of a Turing machine consists of the contents of the tape, the current state, and the tape cell to which the head is currenty pointing
![[image 28 5.png|image 28 5.png]]
### Components of a Turing Machine
![[image 29 5.png|image 29 5.png]]
**EX: Turing Machine that Accepts Strings with Two b’s**
![[image 30 4.png|image 30 4.png]]