---
Date Created: 2025-04-19T14:46
Favorite: false
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#15.1]]
    - [[#Overloading the << Operator]]
        - [[#VoteCounter Class Demo]]
    - [[#Overloading the >> Operator]]
        - [[#WaitingLine Class]]
    - [[#Extending cin and cout]]
        - [[#WaitingLine Class with Stream Friend Functions]]
- [[#15.2]]
    - [[#Operator Overloading]]
        - [[#Overloading TimeHrMn's + Operator]]
        - [[#Overloading the + Operator Multiple Times]]
- [[#15.3]]
    - [[#Overloading Comparison Operators]]
        - [[#Overloading the Equality == Operator]]
        - [[#Overloading the < Operator]]
        - [[#Overloading All Equality and Relational Operators]]
---
# 15.1
## Overloading the << Operator
- The C++ operator is known as the **insertion operator**
    - A C++ class can overload the insertion operator by creating a member function named operator<<
- EX:
    - A `VoteCounter` class may count a vote for a candidate by using the << operator
    - The candidate’s name is passed as a string argument, and the `VoteCounter` object is returned
    - The member function declaration is `VoteCounter& operator<<(const string* candidate);`
### `VoteCounter` Class Demo
```C++
\#include <iostream>
\#include <queue>
using namespace std;
class VoteCounter
{
private:
   int ACount, BCount, CCount;
public:
   VoteCounter() { ACount = BCount = CCount = 0; }
   VoteCounter& operator<<(const string& candidateName);
   string GetResults();
};
VoteCounter& VoteCounter::operator<<(const string& candidateName) {
   if ("Candidate A" == candidateName)
      ACount++;
   else if ("Candidate B" == candidateName)
      BCount++;
   else if ("Candidate C" == candidateName)
      CCount++;
      
   return *this;
}
string VoteCounter::GetResults() {
   if (ACount > BCount) {
      if (ACount > CCount)
         return "Candidate A wins!";
      else if (ACount < CCount)
         return "Candidate C wins!";
      else
         return "Tie between candidates A & C!";
   }
   else if (ACount < BCount) {
      if (BCount > CCount)
         return "Candidate B wins!";
      else if (BCount < CCount)
         return "Candidate C wins!";
      else
         return "Tie between candidates B & C!";
   }
   else {
      if (BCount == CCount)
         return "Tie between all 3 candidates!";
      else
         return "Tie between candidates A & B!";
   }
}
int main() {
   const string candidateNames[] = { 
      "Candidate A", "Candidate B", "Candidate C"
   };
   const int voteIndices[] = {
      2, 1, 0, 1, 2, 0, 0, 1, 2, 1, 0, 1, 0, 0, 1, 2, 0, 0, 1
   };
   const int voteCount = sizeof(voteIndices) / sizeof(int);
   
   // Cast the votes
   cout << "Counting votes..." << endl;
   VoteCounter counter;
   for (int i = 0; i < voteCount; i++) {
      int voteIndex = voteIndices[i];
      counter << candidateNames[voteIndex];
   }
   
   // Reveal the winner
   cout << counter.GetResults() << endl;
   return 0;
}
```
  
## Overloading the >> Operator
- The C++ >> operator is known as the **extraction operator**
    - A C++ class can overload the extraction operator by creating a member function named operator>>
- EX:
    - The `WaitingLine` class uses the insertion operator to add a string to the back of the line and the extraction operator to remove a string from the front of the line
### `WaitingLine` Class
```C++
class WaitingLine
{
public:
   WaitingLine& operator<<(const string& name) {
      // Add the name to the end of the line
      line.push(name);
       
      cout << name << " enters the back of the line" << endl;
       
      return *this;
   }
   WaitingLine& operator>>(string& frontName) {
      // Copy the name at the front of the line to frontName, then remove
      frontName = line.front();
      line.pop();
       
      return *this;
   }
   
   queue<string> line;
};
```
  
## Extending `cin` and `cout`
- By default, a programmer-defined C++ class does not work with `cin` and `cout`
- Statements like `cin >> line1` or `cout << line1`, where line1 is a `WaitingLine` object, cause a compiler error
    - But the functionality of `cin` or `cout` can be extended by implementing certain friend functions in the C++ class
### `WaitingLine` Class with Stream Friend Functions
```C++
class WaitingLine
{
public:
   WaitingLine& operator<<(const string& name) {
      // Add the name to the end of the line
      line.push(name);
       
      cout << name << " enters the back of the line" << endl;
       
      return *this;
   }
   
   WaitingLine& operator>>(string& frontName) {
      // Copy the name at the front of the line to frontName, then remove
      frontName = line.front();
      line.pop();
       
      return *this;
   }
   
   friend ostream& operator<<(ostream& out, const WaitingLine& line) {
      out << "(front)";
      queue<string> lineCopy = line.line;
      while (!lineCopy.empty()) {
         string lineItem = lineCopy.front();
         lineCopy.pop();
         out << " " << lineItem;
      }
      out << " (back)";
      return out;
   }
   
   friend istream& operator>>(istream& in, WaitingLine& line) {
      string inString;
      in >> inString;
      line << inString;
      return in;
   }
   
   queue<string> line;
};
```
  
# 15.2
## Operator Overloading
- C++ allows a programmer to redefine the functionality of built-in operators like +, -, and *, to operate on programmer-defined objects, in a process known as **operator overloading**
- Suppose a class `TimeHrMn` has data members `Hours` and `Minutes`
    - Overloading + would allow two `TimeHrMn` objects to be added with the + operator
Without Operator Overloading
With Operator Overloading
---
---
```C++
TimeHrMn time1(3, 22);
TimeHrMn time2(2, 50);
TimeHrMn timeTot;
timeTot.hours = time1.hours + time2.hours;
timeTot.minutes = time1.minutes + time2.minutes;
timeTot.Print();
```
```C++
TimeHrMn time1(3, 22);
TimeHrMn time2(2, 50);
TimeHrMn timeTot;
timeTot = time1 + time2;
timeTot.Print();
```
### Overloading `TimeHrMn`'s + Operator
- To overload +, the programmer creates a member function named operator+
- Although + requires left and right operands as in `time1 + time2`, the member function only requires the right operand (rhs: right-hand-side) as the parameter because the left operand is the calling object
    - Equivalent to `time1.operator+(time2)`
`**TimeHrMn**` **Class implementation with overloaded + operator**
```C++
\#include <iostream>
using namespace std;
class TimeHrMn {
public:
   TimeHrMn(int timeHours = 0, int timeMinutes = 0);
   void Print() const;
   TimeHrMn operator+(TimeHrMn rhs) ;
private:
   int hours;
   int minutes;
};
// Overload + operator for TimeHrMn
TimeHrMn TimeHrMn::operator+(TimeHrMn rhs) {
   TimeHrMn timeTotal;
   
   timeTotal.hours   = hours   + rhs.hours;
   timeTotal.minutes = minutes + rhs.minutes;
   
   return timeTotal;
}
TimeHrMn::TimeHrMn(int timeHours, int timeMinutes) {
   hours  = timeHours;
   minutes = timeMinutes;
}
void TimeHrMn::Print() const {
   cout << "H:" << hours << ", " << "M:" << minutes << endl;
}
```
### Overloading the + Operator Multiple Times
- When an operator like + has been overloaded, the compiler determines which + operation to invoke based on the operand types
- A programmer can define several functions that overload the same operator, as long as each involves different types so that the compiler can determine which to invoke
```C++
\#include <iostream>
using namespace std;
class TimeHrMn {
public:
   TimeHrMn(int timeHours = 0, int timeMinutes = 0);
   void Print() const;
   TimeHrMn operator+(TimeHrMn rhs);
   TimeHrMn operator+(int rhsHours);
private:
   int hours;
   int minutes;
};
// Operands: TimeHrMn, TimeHrMn. Call this "A"
TimeHrMn TimeHrMn::operator+(TimeHrMn rhs) {
   TimeHrMn timeTotal;
   
   timeTotal.hours   = hours   + rhs.hours;
   timeTotal.minutes = minutes + rhs.minutes;
   
   return timeTotal;
}
// Operands: TimeHrMn, int. Call this "B"
TimeHrMn TimeHrMn::operator+(int rhsHours) {
   TimeHrMn timeTotal;
   
   timeTotal.hours = hours + rhsHours;
   timeTotal.minutes = minutes; // Stays same
   
   return timeTotal;
}
TimeHrMn::TimeHrMn(int timeHours, int timeMinutes) {
   hours  = timeHours;
   minutes = timeMinutes;
   
   return;
}
void TimeHrMn::Print() const {
   cout << "H:" << hours << ", " << "M:" << minutes << endl;
}
int main() {
   TimeHrMn time1(3, 22);
   TimeHrMn time2(2, 50);
   TimeHrMn sumTime;
   int num;
   num = 91;
   
   sumTime = time1 + time2; // Invokes "A"
   sumTime.Print();
   
   sumTime = time1 + 10;    // Invokes "B"
   sumTime.Print();
   
   cout << num + 8 << endl; // Invokes built-in add
   
   // sumTime = 10 + time1; // ERROR: No (int, TimeHrMn)
   
   return 0;
}
```
  
# 15.3
## Overloading Comparison Operators
### Overloading the Equality `==` Operator
- A programmer can overload the equality operator to allow comparing objects of a programmer-defined class for equality
- To overload `==`, the programmer creates a function named `operator==` that returns bool and takes two const reference arguments of the class type for the left-hand-side and right-hand-side operands
- EX:
    - To overload `==` for a Review class, the programmer defines a function `bool operator==(const Review& lhs, const Review& rhs)`
```C++
bool operator==(const Review& lhs, const Review& rhs) {
  return (lhs.GetRating() == rhs.GetRating()) &&
         (lhs.GetComment() == rhs.GetComment());
}
//EXAMPLE IMPLEMENTATION
if (myReview == bestReview) {
  cout << "Must be my favorite" << endl;
}
```
### Overloading the < Operator
- A programmer can also overload relational operators like the less than operator (<)
- The < operator should return true if the object on the left side of the < operator is less than the object on the right side of the operator
```C++
\#include <iostream>
\#include <string>
\#include <vector>
using namespace std;
class Review {
public:
   void SetRatingAndComment(int revRating, string revComment) {
      rating = revRating;
      comment = revComment;
   }
   int GetRating() const { return rating; }
   string GetComment() const { return comment; }
   
private:
   int rating = -1;
   string comment = "NoComment";
};
// Equality (==) operator for two Review objects
bool operator==(const Review& lhs, const Review& rhs) {
   return (lhs.GetRating() == rhs.GetRating()) && 
          (lhs.GetComment() == rhs.GetComment());
}
// Less-than (<) operator for two Review objects
bool operator<(const Review& lhs, const Review& rhs) {
   return lhs.GetRating() < rhs.GetRating();
}
int main() {
   vector<Review> reviewList;
   Review currentReview;
   Review lowestReview;
   int currentRating;
   string currentComment;
   int i;
   
   cout << "Type rating + comments. To end: -1" << endl;
   cin >> currentRating;
   while (currentRating >= 0) {
      getline(cin, currentComment); // Gets rest of line
      currentReview.SetRatingAndComment(currentRating, currentComment);
      reviewList.push_back(currentReview);
      cin >> currentRating;
   }
   
   // Find and output lowest review
   lowestReview = reviewList.at(0);
   for (i = 1; i < reviewList.size(); ++i) {
      if (reviewList.at(i) < lowestReview ) {
         lowestReview = reviewList.at(i);
      }
   }
   
   cout << endl;
   cout << lowestReview.GetRating() << " "
        << lowestReview.GetComment() << endl;
   
   return 0;
}
```
### Overloading All Equality and Relational Operators
- A common approach is to first overload the `==` and `<` operators and then overload the other comparison operators using `==` and `<`
Overloading `!=` using `==`:
---
```C++
bool operator!=(const Review& lhs, const Review& rhs) {
	return !(lhs == rhs);
}
```
Overloading `>`,`<=`, and `>=` using `<`:
```C++
bool operator>(const Review& lhs, const Review& rhs) {
	return rhs < lhs;
}
bool operator<=(const Review& lhs, const Review& rhs) {
	return !(lhs > rhs);
}
bool operator>=(const Review& lhs, const Review& rhs) {
	return !(lhs < rhs);
}
```