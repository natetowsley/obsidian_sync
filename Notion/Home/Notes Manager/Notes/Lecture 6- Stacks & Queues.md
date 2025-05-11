---
Date Created: 2025-03-10T10:50
Favorite: false
tags:
  - Data-Structures-&-Algorithms
📕 Courses:
  - "[[Programming Concepts and Methodology II (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#19.1]]
    - [[#Introduction to the Stack ADT]]
        - [[#A LIFO Structure]]
        - [[#Stack Operations and Functions]]
        - [[#Common Stack ADT Operations]]
        - [[#ArrayStack Class]]
- [[#19.2]]
    - [[#Dynamic Stacks]]
        - [[#Implementing a Stack]]
        - [[#StackNode Class]]
        - [[#Stack Class Member Variables Constructor]]
        - [[#Push and Pop Operations]]
- [[#19.3]]
    - [[#Introduction to the Queue ADT]]
        - [[#QueueNode Class]]
        - [[#Queue Class Member Variables and Constructor]]
        - [[#Queue Locations and Operations]]
        - [[#Common Queue ADT Operations]]
        - [[#Enqueue and Dequeue Operations]]
        - [[#dequeue Issue, Solutions]]
        - [[#Queue Position at End of Array]]
    - [[#Detecting Full and Empty Queues with Circular Arrays]]
        - [[#Array-Based Queue Resize Operation]]
- [[#19.4]]
    - [[#Dynamic Queues]]
        - [[#Implementing a Queue]]
- [[#19.5]]
    - [[#Deque Abstract Data Type]]
        - [[#Common Deque ADT Operations]]
---
# 19.1
## Introduction to the Stack ADT
- **Stack:** a LIFO (last in, first out) data structure
- Ex:
    - Plates in a cafeteria
    - Return addresses for function calls
- Implementation
    - Static: fixed size, implemented as array
    - Dynamic: variable size, implemented as linked list
### A LIFO Structure
![[image 36.png|image 36.png]]
### Stack Operations and Functions
- Operations:
    - push: add a value onto the top of the stack
    - pop: remove a value from the top of the stack
- Functions:
    - `isFull: true` if the stack is currently full, i.e., has no more space to hold additional elements
    - `isEmpty: true` if the stack currently contains no elements
- A stack that can hold `char` values:
![[image 1 21.png|image 1 21.png]]
![[image 2 19.png|image 2 19.png]]
### Common Stack ADT Operations
![[image 3 18.png|image 3 18.png]]
### ArrayStack Class
```C++
class ArrayStack {
private:
   int allocationSize;
   int* array;
   int length;
   int maxLength;
   
   void Resize() {
      // Allocate new array and copy existing items
      int newSize = allocationSize * 2;
      int* newArray = new int[newSize];
      for (int i = 0; i < length; i++) {
         newArray[i] = array[i];
      }
        
      // Free old array and assign new
      delete[] array;
      array = newArray;
      allocationSize = newSize;
   }
public:
   ArrayStack(int optionalMaxLength = -1) {
      allocationSize = 1;
      array = new int[allocationSize];
      length = 0;
      maxLength = optionalMaxLength;
   }
    
   virtual ~ArrayStack() {
      delete[] array;
   }
   
   int GetLength() const {
      return length;
   }
    
   int GetMaxLength() const {
      return maxLength;
   }
    
   bool Push(int item) {
      // If at max length, return false
      if (length == maxLength) {
         return false;
      }
      
      // Resize if length equals allocation size
      if (length == allocationSize) {
         Resize();
      }
        
      // Push the item and return true
      array[length] = item;
      length++;
      return true;
   }
    
   int Pop() {
      length--;
      return array[length];
   }
};
```
  
# 19.2
## Dynamic Stacks
- Grow and shrink as necessary
- Can’t ever be full as long as memory is available
- Implemented as a linked list
### Implementing a Stack
- Programmers can program their own routines to implement stack functions
- Can also use the implementation of stack available in the STL
### StackNode Class
```C++
//Node to store an item in a linked-list-based stack
class StackNode {
public:
	int data;
	StackNode* next;
	
	StackNode(int dataValue, StackNode* nextNode) {
		data = dataValue;
		next = nextNode;
	}
};
```
### Stack Class Member Variables Constructor
```C++
class Stack {
private:
	StackNode* top;
	
public:
	Stack() {
		top = nullptr;
	}
};
```
### Push and Pop Operations
```C++
void Push(int newData) {
	top = new StackNode(newData, top);
}
```
```C++
int Pop() {
	//Copy tp node's data
	StackNode* poppedNode = top;
	int poppedItem = top->data;
	
	//Remove top node
	top = top->next;
	
	//Delete former top node
	delete poppedNode;
	
	//Return the popped item
	return poppedItem;
}
```
# 19.3
## Introduction to the Queue ADT
- **Queue:** a FIFO (first in, first out) data structure
- Ex:
    - People in line at the theatre box office
    - Print jobs sent to a printer
- Implementation:
    - Static: fixed size, implemented as array
    - Dynamic: variable size, implemented as linked list
### QueueNode Class
```C++
//Node to store an item in a linked-list-based queue
class QueueNode {
public:
	int data;
	QueueNode* next;
	
	QueueNode(int dataValue, QueueNode* nextNode = nullptr) {
		data = dataValue;
		next = nextNode;
	}
};
```
### Queue Class Member Variables and Constructor
```C++
class Queue {
private:
	QueueNode* front;
	QueueNode* end;
	
public:
	Queue() {
		front = nullptr;
		end = nullptr;
	}
};
```
### Queue Locations and Operations
- **rear:** position where elements are added
- **front:** position from where elements are removed
- **enqueue:** add an element to the rear of the queue
- **dequeue:** remove an element from the front of a queue
- A currently empty queue that can hold `char` values:
![[image 4 16.png|image 4 16.png]]
- `enqueue('E');`
![[image 5 16.png|image 5 16.png]]
- `enqueue('K');`
![[image 6 13.png|image 6 13.png]]
- `enqueue('G');`
![[image 7 11.png|image 7 11.png]]
- `dequeue(); //remove E`
![[image 8 9.png|image 8 9.png]]
- `dequeue(); //remove K`
![[image 9 8.png|image 9 8.png]]
### Common Queue ADT Operations
![[image 10 8.png|image 10 8.png]]
### Enqueue and Dequeue Operations
```C++
void Enqueue(int newData) {
   QueueNode* newNode;
   newNode = new QueueNode(newData);
   if (nullptr == front) {
      front = newNode;
   }
   else {
      end->next = newNode;
   }
   end = newNode;
}
```
```C++
int Dequeue() {
   QueueNode* dequeuedNode = front;
   int dequeuedItem = front->data;
   front = front->next;
   delete dequeuedNode;
   if (nullptr == front) {
      end = nullptr;
   }
   return dequeuedItem;
}
```
  
### `dequeue` Issue, Solutions
- When removing an element from a queue, remaining elements must shift to front
- Solutions:
    - Let front index move as elements are removed (works as long as rear index is not at end of array)
    - Use above solution, and also let rear index “wrap around” to front of array, treating array as circular instead of linear (more complex enqueue, dequeue code)
### Queue Position at End of Array
![[image 11 8.png|image 11 8.png]]
## Detecting Full and Empty Queues with Circular Arrays
- Problem:
    - Both front and rear indices move through array
    - How to detect if queue is full or empty
- Solution:
    - Use a counter to keep track of the items in queue
### Array-Based Queue Resize Operation
```C++
void Resize() {
   int newSize = allocationSize * 2;
   if (maxLength >= 0 && newSize > maxLength) {
      newSize = maxLength;
   }
   int* newArray = new int[newSize];
   for (int i = 0; i < length; i++) {
      int itemIndex = (frontIndex + i) % allocationSize;
      newArray[i] = array[itemIndex];
   }
   delete[] array;
   array = newArray;
   allocationSize = newSize;
   frontIndex = 0;
}
```
  
# 19.4
## Dynamic Queues
- Like a stack, a queue can be implemented using a linked list
- Allows dynamic sizing, avoids issue of shifting elements or wrapping indices
![[image 12 8.png|image 12 8.png]]
### Implementing a Queue
- Programmers can program their own routines to implement queue operations
- Can also use the implementation of queue and dequeue available in the STL
  
# 19.5
## Deque Abstract Data Type
- A **deque** (”deck”) is an ADT in which items can be inserted and removed at both the front and back
    - **Push-front:** Inserts an item at the front of the deque
    - **Push-back:** Inserts an item at the back of the deque
    - **Pop-front:** Removes and returns the item at the front of the deque
    - **Pop-back:** Removes and returns the item at the back of the deque
### Common Deque ADT Operations
![[image 13 8.png|image 13 8.png]]