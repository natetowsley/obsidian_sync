---
Date Created: 2025-04-04T18:06
Favorite: false
📕 Courses:
  - "[[!!Computer Architecture and Organization]]"
---
###### tags: #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#3.2]]
    - [[#Addition and Subtraction]]
        - [[#Example of Binary Addition]]
        - [[#Example of Binary Subtraction]]
    - [[#Overflow]]
- [[#3.3]]
    - [[#Multiplication]]
        - [[#Multiplication Example]]
- [[#3.4]]
    - [[#Division]]
        - [[#Division Example]]
- [[#3.5]]
    - [[#Floating Point]]
        - [[#Floating-Point Representation]]
        - [[#Example of Floating-Point Representation]]
        - [[#Converting Bianry to Decimal Floating Point]]
---
# 3.2
## Addition and Subtraction
### Example of Binary Addition
![[image 43.png|image 43.png]]
### Example of Binary Subtraction
![[image 1 28.png|image 1 28.png]]
## Overflow
![[image 2 26.png|image 2 26.png]]
  
# 3.3
## Multiplication
### Multiplication Example
![[image 3 25.png|image 3 25.png]]
**The First Multiplication Algorithm**
![[image 4 23.png|image 4 23.png]]
  
# 3.4
## Division
### Division Example
![[image 5 23.png|image 5 23.png]]
$$\text{Dividend } = \text{ Quotient } * \text{ Divisor } + \text{ Remainder }$$
- **Dividend:** A number being divided
- **Divisor:** A number that the dividend is divided by
- **Quotient:** The primary result of a division; a number that when multiplied by the divisor and added to the remainder produces the dividend
- **Remainder:** The secondary result of a division; a number that when added to the product of the quotient and the divisor produces the dividend
**A Division Algorithm**
![[image 6 20.png|image 6 20.png]]
  
# 3.5
## Floating Point
- **Scientific Notation:** A notation that renders numbers with a single digit to the left of the decimal point
![[image 7 17.png|image 7 17.png]]
- **Normalized:** A number in floating-point notation that has no leading 0s
- **Floating Point:** Computer arithmetic that represents numbers in which the binary point is not fixed
### Floating-Point Representation
- **Fraction:** The value, generally between 0 and 1, placed in the fraction field. The fraction is also called the _mantissa_
- **Exponent:** In the numerical representation system of floating-point arithmetic, the value that is placed in the exponent field
![[image 8 15.png|image 8 15.png]]
- **Overflow:** A situation in which a positive exponenet becomes too large to fit in the exponenet field
- **Underflow:** A situation in which a negative exponent becomes too large to fit in the exponent field
- **Double Precision:** A floating-point value represented in a 64-bit doubleword
- **Single Precision:** A floating-point value represented in a 32-bit word
### Example of Floating-Point Representation
![[image 9 14.png|image 9 14.png]]
### Converting Bianry to Decimal Floating Point
![[image 10 14.png|image 10 14.png]]