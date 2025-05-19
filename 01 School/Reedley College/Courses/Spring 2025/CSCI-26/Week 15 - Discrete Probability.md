---
📕 Courses:
  - "[[!!Discrete Mathematics for Computer Science]]"
tags:
  - ComputerScience
Date Created:
---
---
# 15.1
## Probability of an Event
- Algorithms can be designed to make random choices in order to avoid actions that correlate badly with input data
	- Probability theory is used to analyze the behavior and running time of randomized algorithms
- Computer systems are often simulated and tested using randomized models for user behavior
- A computer chip manufacturer need to predict the likelihood that a chip contains a defect depending on different features of the fabrication environment
	- Probability theory is used to analyze different environments and predict this likelihood
- Probability is one of the primary tools in machine learning, in which computers are used to discover patterns and rules in large sets of data
	- Bayes' theorem about conditional probabilities provides a way to reason formally about the likelihood of different causes given a set of observed data
### Experiments and Outcomes
- An ***experiment*** is a procedure that results in one out of a number of possible ***outcomes***
- The set of all possible outcomes is called the ***sample space*** of the experiment
	- A subset of the sample space is called an ***event***
### Discrete vs. Continuous Probability
- ***Discrete Probability*** is concerned with experiments in which the sample space is a finite or countably infinite set
	- A set is ***countably infinite*** is there is a one-to-one correspondence between the elements of the set and the integers
- An infinite set that is not countably infinite is ***uncountably infinite***

### Probability Distributions
- A ***probability distribution*** over the outcomes of an experiment with a countable sample space ***S*** is a function ***p*** from ***S*** to the set of real numbers in the interval from 0 to 1 with the property that:
![[Pasted image 20250515165930.png]]

# 15.2
## Unions and Complements of Events
### Calculating Probabilities for Unions of Events
- Two events are ***mutually exclusive*** if the two events are disjoint (the intersection of the two events is empty)
	- It follows from the definition of the probability of an event that if $E_1$ and $E_2$ are mutually exclusive, then:
	![[Pasted image 20250519112802.png]]
### The Complement of an Event
- The ***complement*** of an event $E$ is $S-E$ and is denoted by $\overline{E}$ 
	- Since $E$ and $\overline{E}$ are disjoint events, $p(E) + p(\overline{E}) = 1$
	- It follows that
![[Pasted image 20250519113337.png]]

# 15.3
## Conditional Probability and Independence
- The ***conditional probability*** of $E$ given $F$ is
![[Pasted image 20250519161258.png]]
- If the distribution is uniform, then:  ![[Pasted image 20250519161439.png]]
	- and the conditional probability becomes: ![[Pasted image 20250519161512.png]]
---
# References
1. 