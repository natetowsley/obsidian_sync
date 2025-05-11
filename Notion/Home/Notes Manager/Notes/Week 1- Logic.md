---
Date Created: 2025-01-13T09:29
Favorite: false
📕 Courses:
  - "[[Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#1.1]]
    - [[#Propositions and Logical Operation]]
    - [[#The Conjunction Operator]]
- [[#1.2]]
    - [[#Compound Propositions]]
        - [[#Truth Tables with Compound Propositions]]
- [[#1.3]]
    - [[#Conditional Statements]]
        - [[#The Converse, Contrapositive, and Inverse]]
    - [[#The Biconditional Operation]]
        - [[#Compound propositions with conditional and biconditional operations]]
- [[#1.4]]
    - [[#Logical Equivalence]]
    - [[#De Morgan’s Laws]]
- [[#1.5]]
    - [[#Laws of Propositional Logic]]
- [[#1.6]]
    - [[#Logical Reasioning]]
  
---
# 1.1
## Propositions and Logical Operation
- **Logic** is the study of formal reasioning
- The most basic element in logic is a proposition
    - A **proposition** is a statement that is either true or false
## The Conjunction Operator
- **Proposition Variables** such as **p**, **q**, and **r** are used to denote arbitrary propositions, as in:
    - **p:** January has **31** days
    - **q:** February has 33 days
- A **compound proposition** is created by connecting individual propositions with locical operations
- Logical operation combines propositions using a particular composition rule
    - The **Conjunction Operator** (^) is the “and” operator
        - p ^ q is read “p and q”
    - The **Conjunction Operator** (v) is the “or” operator
        - p v q is read “p and q”
    - The **Conjunction Operator** (⊕) is the “exclusive and”(XOR) operator
        - p ⊕ q is true when exactly one proposition is true
    - “-” is the **negation** operator, which reverses the truth value of a single proposition
        
        ![[image 12.png|image 12.png]]
        
  
- **Truth Tables** show the truth value of a compound proposition for every possible combination of truth values for the varuables in the compound proposition
![[image 1 9.png|image 1 9.png]]
# 1.2
## Compound Propositions
- A compound proposition is a proposition formed by combining two or more propositions using logical connectives
    - ex: p ^ q v r
    - ex: -(p v r) ^ q
### Truth Tables with Compound Propositions
- A truth table is a mathematical table used to determine the truth value of a compound proposition for all possible truth values of its components
- Often good practice to break up long propositions into their smaller pieces
- Truth table for -(p v r) ^ q
    
    ![[image 2 8.png|image 2 8.png]]
    
# 1.3
## Conditional Statements
- A compound proposition that uses a conditional operation is called a **conditional proposition**
- The (→) operator resembles “then”
    - p → q is read “if p, then q”
    - IF HYPOTHESIS IS FALSE, CONDITIONAL IS TRUE
        - False only if p is true and q is false
### The Converse, Contrapositive, and Inverse
|**Propotition**|_**p → q**_|Ex: If it is raining today, the game will be cancelled|
|---|---|---|
|**Converse**|q → p|If the game is cancelled, it is raining today|
|**Contrapositive**|-q → -p|If the game is not cancelled, then it is not raining today|
|**Inverse**|-p → -q|If it is not raining today, the game will not be cancelled|
## The Biconditional Operation
- If _**p**_ and _**q**_ are propositions, the proposition “p if and only if q” is expressed with the **biconditional operation** is is denoted p ↔ q
- The (↔) operator resembles “if and only if”
    - p ↔ q is read “p if and only if q”
    - True if p and q have the same truth value
### Compound propositions with conditional and biconditional operations
- The conditional and biconditional operations can be combined with other logical operations, as in (p→q)∧r
- If parentheses are not used to explicitly indicate the order in which to apply the operations, then **∧,∨, and ¬ is applied before → or ↔**
  
# 1.4
## Logical Equivalence
- Logical equivalence is similar to mathematical equivalence
    - In math ‘=’ shows equivalence
    - In logic, ‘**≡’** shows equivalence
        - Ex: P → -P **≡ -**P
- A compound proposition is a _**tautology**_ if the proposition is always true, regardless of the truth value of the individual propositions that occur in it
- A _**contradiction**_ is similar, being a compound proposition that is always false, regardless of the individual truth values
**Tautology Contradiction**
![[image 3 7.png|image 3 7.png]]
  
![[image 4 6.png|image 4 6.png]]
- Two compound propositions are **logically equivalent** if they have the same truth value regardless of the truth values of their individual propositions
## De Morgan’s Laws
- Logical equivalences that show how to correctly distribute a negation operation inside a parenthesized expression
- The first De Morgan’s law is:
![[image 5 6.png|image 5 6.png]]

> [!important] When the negation operation is distributed inside the parenthesis, the disjunction operation changes to a conjunction operation (OR to AND)
1. -(P ^ Q) ≡ -P V **-**Q
2. -(P V Q) **≡ -**P ^ -Q
- Useful for simplifying complex logical/ compound expressions
  
# 1.5
## Laws of Propositional Logic
- If two propositions are logically equivalent, then one can bne substituted for the other within a more complex proposition
![[image 6 4.png|image 6 4.png]]
  
# 1.6
## Logical Reasioning
- The language of logic allows one to formally establish the truth of logical statements, assuming that a set of hypotheses is true
    - An **Argument** is a sequence of propositions, called **hypotheses**, followed by a final proposition, called the **conclusion**
    - An argument is **valid** if the conclusion is true for every truth assignment to the variables that causes all of the hypotheses to be true
    - Otherwise, the argument is **invalid**
        
        ![[image 7 3.png|image 7 3.png]]
        
- h_1 … h_n are the hypotheses, and c is the conclusion
- The symbol “∴” reads “therefore”