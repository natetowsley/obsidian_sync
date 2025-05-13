---
Date Created: 2025-02-03T09:33
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #DataStructuresAndAlgorithms  #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#Recursion Review]]
- [[#Search & Sort Review]]
- [[#Big O Notation]]
    - [[#Growth Rate of Various Functions]]
    - [[#Time for f(n) instructions on a computer that executes 1 billion instructions per second]]
- [[#Big O Definition]]
    - [[#Some Big-O Functions That Appear in ALgorithm Analysis]]
    - [[#Number of Comparisons for a List of Length n]]
---
# Recursion Review
[[Recursion]]
# Search & Sort Review
[[Search and Sort Algorithms|Search and Sort Algorithms]]
# Big O Notation
- After an algorithm is designed, it should be analyzed
- May be various ways to design a particular algorithm
    - Certain algorithms take very little computer time to execute
    - Others take a considerable amount of time
- Comparison program
    
    - Fixed number (11 operations)
    
    ```C++
    int main() {
    	int num1, num2, max;                              //line 0 (don't count definition)
    	cout << "enter first number: ";                   //line 1
    	cin >> num1;                                      //line 2
    	cout << endl;                                     //line 3
    	
    	cout << "enter second number: ";                  //line 4
    	cin >> num2;                                      //line 5
    	cout << endl;                                     //line 6
    	
    	if (num1 >= num2)                                 //line 7
    		max = num1;                                     //line 8
    	else                                              //line 9
    		max = num2;                                     //line 10
    		
    	cout << "The maximum number is: " << max << endl; //line 11
    }
    ```
    
- Sum and average program
    
    - 5 * 10 + 15 or 5 * 10 + 14 (whether `if` or `else` executes)
    - General: 5n + 15 or 5n + 14 → 5n (dominant for large n)
    
    ```undefined
    int main() {
        int num, sum, count, average;                     //Line 0
        cout << "Enter positive integers (-1 to stop)"    //Line 1
            << endl;
        count = 0;                                        //Line 2
        sum = 0;                                          //Line 3
    
        cin >> num;                                       //Line 4
        while (num != -1)                                 //Line 5
        {
            sum = sum + num;                              //Line 6
            count++;                                      //Line 7
            cin >> num;                                   //Line 8
        }
        cout << "The sum of numbers is: " << sum << endl; //Line 9
    
        if (count != 0)                                   //Line 10
            average = sum / count;                        //Line 11
        else                                              //Line 12
            average = 0;                                  //Line 13
    
        cout << "The average is: " << average << endl;    //Line 14
    }
    ```
    
- Certain operations typically dominate in algorithms
    - Sum operation in sum and average program
    - # comparisons in search algorithms
- Number of elements/size of list(n)
- Number of comparisons f(n)
- Varying measures
    - $n$
    - $log_2n$
    - $nlog_2n$
    - $n^2$
    - $2^n$
### Growth Rate of Various Functions
![[image 26.png|image 26.png]]
![[image 1 13.png|image 1 13.png]]
### Time for f(n) instructions on a computer that executes 1 billion instructions per second
![[image 2 12.png|image 2 12.png]]
- Let f be a function of n
- **Asymptotic:** The study of the function f as n becomes larger and larger without bound
![[image 3 11.png|image 3 11.png]]
- Let f and g be real-valued, non-negative functions
- f(n) is Big-O of g(n), written f(n) = O(g(n)) if there are constants c and $n_0$ such that f(n) ≤ cg(n) for all n ≥ $n_0$
  
# Big O Definition
- Describes how an algorithm’s run time behaves in relation to input size
- Function growth rate determined by highest order term
- All functions having same growth rate are Big O equivalent
- Rules:
    - If f(n) is sum of several terms, only highest order term is kept
    - If f(n) is product of several factors, omit constants
- **Lower Bound:** A function f(N) that is ≤ the best case T(N), for all values of N ≥ $n_0$
- **Upper Bound:** A function f(N) that is ≤ the worst case T(N), for all values of N ≥ $N_0$
### Some Big-O Functions That Appear in ALgorithm Analysis
![[image 4 10.png|image 4 10.png]]
- We can use Big-O notation to compare sequential and binary search algorithms
### Number of Comparisons for a List of Length _n_
![[image 5 10.png|image 5 10.png]]