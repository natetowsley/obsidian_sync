---
Date Created: 2025-01-27T11:56
Favorite: false
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#2.1]]
    - [[#Predicates and Quantifiers]]
    - [[#Universal Quatifier]]
    - [[#Existential Quantifier]]
- [[#2.2]]
    - [[#Quantified Statements]]
- [[#2.3]]
    - [[#De Morgan’s Law for Quantified Statements]]
- [[#2.4]]
    - [[#Nested Quantifiers]]
    - [[#De Morgan’s Law with Nested Quantifiers]]
- [[#2.5]]
    - [[#More Nested Quantified Statements]]
    - [[#Moving Quantifiers in Logical Statements]]
- [[#2.6]]
    - [[#Rules of Inference with Propositions]]
- [[#2.7]]
    - [[#Rules of Inference with Quantifiers]]
---
# 2.1
## Predicates and Quantifiers
- A logical statement with a truth value that is a function of one or more varibales is called a **prediacte**
![[image 23.png|image 23.png]]
- The **domain** of a variable in a predicate is the set of al possible values for the variable
- Predicates do not have to be mathematical
## Universal Quatifier
- The ∀ symbol is a universal quantifier
    - The symbol represents a proposition that is true for all possible values of a variable in their domain
    - ∀ = “for all”
- ∀xP(x) is read “for all **x**, **P(x)**” or “for every **x**, **P(x)**”
- A **counterexample** for a universally quantified statement is an element in the domain for which the predicate is false.
    - A single counterexample is sufficient to show that a universally quantified statement is false.
## Existential Quantifier
- The symbol ∃ is an existential quantifier
    - ∃xP(x)
    - The symbol is read “there exists an x, such that P(x)”
    - This is a proposition and is true if and only if P(x) is true for at least one value x in the domain of x
  
# 2.2
## Quantified Statements
- A logical statement that includes a universal or existential quantifier is called a **quantified statement**
    - The universal and existential quantifiers are generically called **quantifiers**
- Variable **x** in the predicate **P(x)** is called a **free variable** because the variable is free to take on any value in the domain
- The variable **x** in the statement **∀xP(x)** is a **bound variable** because the variable is bound to a quantifier
    - A statement with no free variables is a proposition because the statement’s truth value can be determined
    - If all varibles are bound the expression is a proposition
  
# 2.3
## De Morgan’s Law for Quantified Statements
- The negation operation can be applied to a quantified statement, such as **¬**∀xF(x)
- If the domain for the varuable **x** is the set of all birds and the predicate F(x) is “x can fly”, then the statement **¬**∀xF(x) is equivalent to ∃x**¬**F(x) 
    - “Not every bird can fly” equivalent to “There exists a bird that cannot fly”
![[image 1 11.png|image 1 11.png]]
  
# 2.4
## Nested Quantifiers
- If a predicate has more than one variable, each variable must be bound by a separate quantifier.
- A logical expression with more than one quantifier that binds different variables in the same predicate has **nested quantifiers**
- Quantifiers are applied from left to right
![[image 2 10.png|image 2 10.png]]
![[image 3 9.png|image 3 9.png]]
## De Morgan’s Law with Nested Quantifiers
- Everytime the negation sign moves past a quantifier, the quantifier changes type from universal to existential or from existential to universal
![[image 4 8.png|image 4 8.png]]
  
# 2.5
## More Nested Quantified Statements
- Symbol ≠ used when two variables are not equal
![[image 5 8.png|image 5 8.png]]
- The statement ∀x∀yM(x,y) is false because M(Fred, Fred) and M(Marge, Marge) are both false
- The statement ∀x∀y((x ≠ y) → M(x,y)) is true
    - For every pair, if x and y are not equal, then x sent an email to y, in this case
## Moving Quantifiers in Logical Statements
- A quantifier can always be moved to the left if the quantifiers identify different variables
  
![[image 6 6.png|image 6 6.png]]
- Quantifiers can be moved left, however must maintain the same order as to not change the meaning of the expression
  
# 2.6
## Rules of Inference with Propositions
- The validity of an argument can be established by applying the rules on inference and laws of propositional logic in a **logical proof**
  
# 2.7
## Rules of Inference with Quantifiers
- A value tha can be plugged for variable x is called and **element** of the domain of x.
    - An **arbitrary** element of a domain has no special properties other than those shared by all the elements of the domain
    - A **particular** element of the domain may have properties that are not shared by all the elements of the domain
- The rules **existential instantiation** and **universal instantiation** replace a quantified variable with an element of the domain
- The rules **existential generalization** and **universal generalization** replace an element of the domain with a quantified variable.
![[image 7 5.png|image 7 5.png]]
![[image 8 3.png|image 8 3.png]]