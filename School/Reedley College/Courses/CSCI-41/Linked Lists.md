---
Date Created: 2025-02-24T10:56
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #DataStructuresAndAlgorithms #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#6.1]]
    - [[#Intro to Linked Lists]]
        - [[#Linked Lists vs. Array and Vectors]]
        - [[#Node Organization]]
        - [[#Linked List Organization]]
        - [[#Empty List]]
        - [[#Declaring a Node]]
        - [[#Defining a Linked List]]
        - [[#The Null Pointer]]
- [[#6.2]]
    - [[#Create a New Node]]
    - [[#Appending a Node]]
        - [[#Code for Appending Node (C++)]]
- [[#6.3]]
    - [[#Inseting a Node into a Linked List]]
    - [[#Traversing a Linked List]]
- [[#6.4]]
    - [[#Deleting a Node]]
        - [[#Destroying a Linked List]]
- [[#7.1]]
    - [[#Doubly Linked Lists]]
        - [[#DoublyLinkedNode class]]
        - [[#DoublyLinkedList class]]
        - [[#Append Operation]]
        - [[#Prepend Operation]]
- [[#7.2]]
    - [[#Doubly-Linked Lists: Search and Insert]]
        - [[#Search Operation]]
        - [[#Insert-Node-After Operation]]
- [[#7.3]]
    - [[#Doubly-Linked Lists: Remove]]
        - [[#Remove-Node Operation]]
        - [[#DoubleLinkedList class’s Remove() member function]]
- [[#7.4]]
    - [[#Linked List Traversal]]
        - [[#Doubly-Linked List Reverse Traversal]]
- [[#7.5]]
    - [[#Sorting Linked Lists]]
        - [[#Sorting a Doubly-Linked List with Insertion Sort]]
        - [[#Sorting a Singly Linked List with Insertion Sort]]
- [[#7.6]]
    - [[#Linked List Dummy Nodes]]
        - [[#Singly-Linked List Member Functions with Dummy Nodes]]
        - [[#Doubly-Linked List Member Functions with Dummy Nodes]]
- [[#7.7]]
    - [[#Linked Lists: Recursion]]
        - [[#Forward Traversal]]
        - [[#SinglyLinkedList class Search() and SearchRecursive() Member Functions]]
        - [[#Reverse Traversal]]
- [[#7.8]]
    - [[#List]]
        - [[#List Container]]
        - [[#Common List Functions]]
        - [[#Iterating Through a List]]
        - [[#Inserting and Removing Elements using Iterators]]
- [[#7.9]]
    - [[#Circular Lists]]
---
# 6.1
## Intro to Linked Lists
- **Linked list:** set of data structures (nodes) that contain references to other data structures/nodes
![[image 34.png|image 34.png]]
- References may be addresses or array indices
- Data structures can be added to or removed from the linked list during execution
### Linked Lists vs. Array and Vectors
- Linked lists can grow and shrink as needed, unlike arrays, which have a fixed size
- Linked lists can insert a node between other nodes easily
![[image 1 19.png|image 1 19.png]]
### Node Organization
- A node contains:
    - Data: one or more data fields - may be organized as structure, object, etc.
    - A pointer that can point to another node
![[image 2 17.png|image 2 17.png]]
### Linked List Organization
- Linked list contains 0 or more nodes
- Has a list head to point to first node
- Last node points to `null` (address 0)
### Empty List
- If a list currently contains 0 nodes, it is the empty list
- In this case the list head points to `null`
![[image 3 16.png|image 3 16.png]]
### Declaring a Node
- Declare a node:
```C++
struct ListNode {
	int data;
	ListNode *next;
};
```
- No memory is allocated at this time
### Defining a Linked List
- Define a pointer for the head of the list
    - `ListNode *head = nullptr;`
- Head pointer initialized to `nullptr` to indicate an empty list
### The Null Pointer
- Is used to indicate end-of-list
- Should always be tested for before using a pointer:
    
    ```C++
    ListNode *p;
    while (!p)
    ```
    
  
# 6.2
## Create a New Node
- Allocate memory for the new node:
    - `newNode = new ListNode;`
- Initialize the contents of the node:
    - `newNode -> value = num;`
- Set the pointer field to `nullptr` :
    - `newNode -> next = nullptr;`
![[image 4 14.png|image 4 14.png]]
![[image 5 14.png|image 5 14.png]]
  
![[image 6 11.png|image 6 11.png]]
## Appending a Node
- Add a node to the end of the list
- Basic process:
    - Create the new node (as already described)
    - Add node to the end of the list:
        - If list is empty, set head pointer to this node
        - Else:
            - travese the list to the end
            - set pointer of last node to point to new node
![[image 7 9.png|image 7 9.png]]
### Code for Appending Node (C++)
```C++
void NumebrList::appendNode (double num) {
	ListNode *newNode;    //To point to a new node
	ListNode *nodePtr;    //To move through the list
	
	//Allocate a new node and store num there
	newNode = new ListNode;
	newNode->value = num;
	newNode->next = nullptr;
	
	//If there are no nodes in the list make newNode the first node
	if (!head) {
		head = newNode;
	}
	else { //Otherwise, insert newNode at end
		//Initialize nodePtr to head of list
		nodePtr = head;
		
		//Find the last node in the list
		while (nodePtr->next) {
			nodePtr = nodePtr->next;
		}
			
		//insert newNode as the last node
		nodePtr->next = newNode;
	}
}
```
  
# 6.3
## Inseting a Node into a Linked List
- Used to maintain a linked list in order
- Requires two pointers to traverse the list:
    - Pointer to locate the node with data value greater than that of node to be inserted
    - Pointer to ‘trail behind’ one node, to point to node before point of insertion
- New node is inserted between the nodes pointed at by these pointers
```C++
void NumberList::insertNode (double num) {
	ListNode *newNode;                 //A new node
	ListNode *nodePtr;                 //To traverse the list
	ListNode *previousNode = nullptr;  //The previous node
	
	//Allocate a new node and store num there
	newNode = new ListNode;
	newNode->value = num;
	
	//If there are no nodes in the list make newNode the first node
	if (!head) {
		head = newNode;
		newNode->next = nullptr;
	}
	else {  //Otherwise, insert new node
		//Position nodePtr at the head of list
		nodePtr = head;
		
		//Initialize previousNode to nullptr
		previousNode = nullptr;
		
		//skip all nodes whose value is less than num
		while (nodePtr != nullptr && nodePtr->value < num) {
			previousNode = nodePtr;
			nodePtr = nodePtr->next;
		}
		
		//If the new node is to be the 1st in the list, insert it before all other nodes
		if (previousNode == nullptr) {
			head = newNode;
			newNode->next = nodePtr;
		}
		else { //Otherwise insert after the previous node
			previousNode->next = newNode;
			newNode->next = nodePtr;
		}
	}
}
```
## Traversing a Linked List
- Visit each node in a linked list: display contents, validate data, etc.
- Basic process:
    - set a pointer to the contents of the head pointer
    - while pointer is not a null pointer
        - process data
        - go to the next node by setting the pointer to the pointer field of the current node in the list
    - end while
  
# 6.4
## Deleting a Node
- Used to remove a node from a linked list
- If list uses dynamic memory, then delete node from memory
- Requires two pointers: one to locate the node to be deleted, one to point to the node before the node to be deleted
```C++
void NumberList::deleteNode(double num) {
	ListNode *nodePtr;        //To traverse the list
	ListNode *previousNode;   //To point to the previous node
	
	//If the list is empty, do nothing
	if (!head)
		return;
		
	//Determine if the first node is the one
	if (head->value == num) {
		nodePtr = head->next;
		delete head;
		head = nodePtr;
	}
	else {
		//Initialize nodePtr to head of list
		nodePtr = head;
		
		//Skip all node whose value member is not equal to num
		while (nodePtr != nullptr && nodePtr->value != num)
		{
			previousNode = nodePtr;
			nodePtr = nodePtr->next;
		}
		
		/*If nodePtr is not at the end of the list, link the previous
		  node to the node after nodePtr, then delete nodePtr*/
		if (nodePtr)
		{
			previousNode->next = nodePtr->next;
			delete nodePtr;
		}
	}
}
```
### Destroying a Linked List
- Must remove all nodes used in the list
- To do this, use list traversal to visit each node
    - For each node,
        - Unlink the node from the list
        - If the list uses dynamic memory, then free the node’s memory
    - Set the list head to `nullptr`
```C++
NumberList::~NumberList() {
	ListNode *nodePtr;      //To traverse the list
	ListNode *nextNode;     //To point to the next node
	
	//Position nodePtr at the head of the list
	nodePtr = head;
	
	//While nodePtr is not at the end of the list...
	while (nodePtr != nullptr) {
		//Save a pointer to the next node
		nextNode = nodePtr->next;
		
		//Delete the current node
		delete nodePtr;
		
		//Position nodePtr at the next node
		nodePtr = nextNode;
	}
}
```
  
# 7.1
## Doubly Linked Lists
- A **doubly-linked list** is a data structure for implementing a list ADT, where each node has data, a pointer to the next node, and a pointer to the previous node
    - The list structure typically has pointers to the first node and the last node
![[image 8 7.png|image 8 7.png]]
### DoublyLinkedNode class
```C++
class DoublyLinkedNode {
public:
	int data;
	DoublyLinkedNode* next;
	DoublyLinkedNode* previous;
	
	DoublyLinkedNode(int initialData) {
		data = initial data;
		next = nullptr;
		previous = nullptr;
	}
};
```
### DoublyLinkedList class
```C++
class DoublyLinkedList {
private:
	DoublyLinkedNode* head;
	DoublyLinkedNode* tail;
	
public:
	DoublyLinkedList() {
		head = nullptr;
		tail = nullptr;
	}
};
```
### Append Operation
- Given a new node, the **append** operation for a doubly-linked list inserts the new node after the tail node
```C++
// Append() and AppendNode() are member
// functions in the DoublyLinkedList class
void Append(int item) {
   AppendNode(new DoublyLinkedNode(item));
}
void AppendNode(DoublyLinkedNode* newNode) {
   if (head == nullptr) {
      head = newNode;
      tail = newNode;
   }
   else {
      tail->next = newNode;
      newNode->previous = tail;
      tail = newNode;
   }
}
```
### Prepend Operation
- Given a new node, the **prepend** operation of a doubly-linked list inserts the new node before the head node and points the head pointer to the new node
```C++
void Prepend(int item) {
   DoublyLinkedNode* newNode = new DoublyLinkedNode(item);
   PrependNode(newNode);
}
void PrependNode(DoublyLinkedNode* newNode) {
   if (head == nullptr) {
      head = newNode;
      tail = newNode;
   }
   else {
      newNode->next = head;
      head->previous = newNode;
      head = newNode;
   }
}
```
  
# 7.2
## Doubly-Linked Lists: Search and Insert
### Search Operation
- Given a data value, a linked list **search** algorithm returns the first node whose data equals that data value, or null if no such node exists
```C++
DoublyLinkedNode* Search(int dataValue) const {
   DoublyLinkedNode* currentNode = head;
   while (currentNode) {
      if (currentNode->data == dataValue) {
         return currentNode;
      }
      currentNode = currentNode->next;
   }
   return nullptr;
}
```
### Insert-Node-After Operation
- Given a new node, the **insert-node-after** operation for a doubly-linked list inserts the new node after a provided existing list node
    - 3 scenarios
        - Insert into empty list
        - Insert after the list’s tail node
        - Insert between two existing list nodes
**InsertNodeAfter member function**
```C++
void InsertNodeAfter(DoublyLinkedNode* currentNode,
   DoublyLinkedNode* newNode) {
   if (head == nullptr) {
      head = newNode;
      tail = newNode;
   }
   else if (currentNode == tail) {
      tail->next = newNode;
      newNode->previous = tail;
      tail = newNode;
   }
   else {
      DoublyLinkedNode* successor = currentNode->next;
      newNode->next = successor;
      newNode->previous = currentNode;
      currentNode->next = newNode;
      successor->previous = newNode;
   }
}
```
**InsertAfter member function**
```C++
bool InsertAfter(int currentItem, int newItem) {
   DoublyLinkedNode* currentNode = Search(currentItem);
   if (currentNode) {
      DoublyLinkedNode* newNode = new DoublyLinkedNode(newItem);
      InsertNodeAfter(currentNode, newNode);
      return true;
   }
   return false; // currentItem not found
}
```
  
# 7.3
## Doubly-Linked Lists: Remove
### Remove-Node Operation
- The **remove-node** operation for a doubly-linked list removes a provided existing list node
- Algorithm determines the node’s successor (next node) and predecessor (previous node)
- Uses four separate checks to update each pointer
    - Successor exists: If the successor is not null (successor exists), the algorithm points the successor's previous pointer to the predecessor node
    - Predecessor exists: If the predecessor is not null (predecessor exists), the algorithm points the predecessor's next pointer to the successor node
    - Removing list's head node: If currentNode points to the list's head node, the algorithm points the list's head pointer to the successor node
    - Removing list's tail node: If currentNode points to the list's tail node, the algorithm points the list's tail pointer to the predecessor node
```C++
void RemoveNode(DoublyLinkedNode* currentNode) {
   DoublyLinkedNode* successor = currentNode->next;
   DoublyLinkedNode* predecessor = currentNode->previous;
   if (successor) {
      successor->previous = predecessor;
   }
   if (predecessor) {
      predecessor->next = successor;
   }
   if (currentNode == head) {
      head = successor;
   }
   if (currentNode == tail) {
      tail = predecessor;
   }
   delete currentNode;
}
```
### DoubleLinkedList class’s Remove() member function
```C++
bool Remove(int itemToRemove) {
   DoublyLinkedNode* nodeToRemove = Search(itemToRemove);
   if (nodeToRemove) {
      RemoveNode(nodeToRemove);
      return true;
   }
   
   return false; // not found
}
```
  
# 7.4
## Linked List Traversal
- A **list traversal** algorithm visits all nodes in the list once and performs an operation on each node
```C++
void Traverse() const {
   SinglyLinkedNode* curNode = head;
   while (curNode) {
      cout << curNode->data << " ";
      curNode = curNode->next;
   }
}
```
### Doubly-Linked List Reverse Traversal
- A doubly-linked list also supports a reverse traversal
- A **reverse traversal** visits all nodes starting with the list’s tail node and ending after visiting the list’s head node
```C++
void TraverseReverse() const {
   DoublyLinkedNode* curNode = tail; // Start at tail
   while (curNode) {
      cout << curNode->data << " ";
      curNode = curNode->previous;
   }
}
```
  
# 7.5
## Sorting Linked Lists
### Sorting a Doubly-Linked List with Insertion Sort
```C++
void InsertionSortDoublyLinked() {
   DoublyLinkedNode* currentNode = head->next;
   while (currentNode) {
      DoublyLinkedNode* nextNode = currentNode->next;
      DoublyLinkedNode* searchNode = currentNode->previous;
    
      while (searchNode && searchNode->data > currentNode->data) {
         searchNode = searchNode->previous;
      }
       
      // Move currentNode after searchNode
      MoveAfter(currentNode, searchNode);
      // Advance to next node
      currentNode = nextNode;
   }
}
```
- Best case complexity: $O(N)$
- Average case complexity: $O(N^2)$
**MoveAfter() (used in InsertionSortDoublyLinked())**
```C++
// Moves nodeToMove immediately after nodeBefore. If nodeBefore is null,
// nodeToMove is moved to the front of the list.
void MoveAfter(DoublyLinkedNode* nodeToMove, DoublyLinkedNode* nodeBefore) {
   // First remove nodeToMove from the list, but do not deallocate
   DoublyLinkedNode* successor = nodeToMove->next;
   DoublyLinkedNode* predecessor = nodeToMove->previous;
   if (successor) {
      successor->previous = predecessor;
   }
   if (predecessor) {
      predecessor->next = successor;
   }
   if (nodeToMove == head) {
      head = successor;
   }
   if (nodeToMove == tail) {
      tail = predecessor;
   }
   nodeToMove->next = nullptr;
   nodeToMove->previous = nullptr;
   
   // If nodeBefore is non-null, use InsertNodeAfter(), otherwise use
   // PrependNode()
   if (nodeBefore) {
      InsertNodeAfter(nodeBefore, nodeToMove);
   }
   else {
      PrependNode(nodeToMove);
   }
}
```
### Sorting a Singly Linked List with Insertion Sort
```C++
void InsertionSortSinglyLinked() {
   SinglyLinkedNode* previousNode = head;
   SinglyLinkedNode* currentNode = head->next;
   while (currentNode) {
      SinglyLinkedNode* nextNode = currentNode->next;
      SinglyLinkedNode* position = FindInsertionPosition(currentNode->data);
      if (position == previousNode) {
         previousNode = currentNode;
      }
      else {
         previousNode->next = nextNode;
         if (nextNode == nullptr) {
            tail = previousNode; // Remove tail
         }
         currentNode->next = nullptr;
         if (position == nullptr) {
            PrependNode(currentNode);
         }
         else {
            InsertNodeAfter(position, currentNode);
         }
      }
      currentNode = nextNode;
   }
}
```
**FindInsertionPosition() member function**
```C++
SinglyLinkedNode* FindInsertionPosition(int dataValue) const {
   SinglyLinkedNode* positionA = nullptr;
   SinglyLinkedNode* positionB = head;
   while (positionB && dataValue > positionB->data) {
      positionA = positionB;
      positionB = positionB->next;
   }
   return positionA;
}
```
  
# 7.6
## Linked List Dummy Nodes
- A linked list imploementation may use a **dummy node** (or **header node**): A node with an unused data member that always resides at the list head and cannot be removed.
    - Using a dummy node simplifies the algorithms for a linked list because the head and tail pointers are never null
![[image 9 6.png|image 9 6.png]]
### Singly-Linked List Member Functions with Dummy Nodes

> [!important] Append Operation
> 
> ```C++
> void AppendNode(SinglyLinkedNode* newNode) {
>    tail->next = newNode;
>    tail = newNode;
> }
> ```

> [!important] Prepend Operation
> 
> ```C++
> void PrependNode(SinglyLinkedNode* newNode) {
>    newNode->next = head->next;
>    head->next = newNode;
>    if (head == tail) {
>       // Empty list
>       tail = newNode;
>    }
> }
> ```

> [!important] Insert Node After
> 
> ```C++
> void InsertNodeAfter(SinglyLinkedNode* currentNode, SinglyLinkedNode* newNode) {
>    if (currentNode == nullptr) {
>       // Special case for prepending
>       PrependNode(newNode);
>    }
>    else if (currentNode == tail) {
>       AppendNode(newNode);
>    }
>    else {
>       newNode->next = currentNode->next;
>       currentNode->next = newNode;
>    }
> }
> ```

> [!important] Remove Node
> 
> ```C++
> bool Remove(int itemToRemove) {
>    // Traverse to the node with data equal to itemToRemove,
>    // keeping track of the previous node in the process
>    SinglyLinkedNode* previous = head;
>    SinglyLinkedNode* current = head->next;
>    while (current) {
>       if (current->data == itemToRemove) {
>          RemoveNodeAfter(previous);
>          return true;
>       }
>          
>       // Advance to next node
>       previous = current;
>       current = current->next;
>    }
>       
>    // Not found
>    return false;
> }
> ```

> [!important] Remove Node After
> 
> ```C++
> void RemoveNodeAfter(SinglyLinkedNode* currentNode) {
>    if (currentNode && currentNode->next) {
>       SinglyLinkedNode* nodeToRemove = currentNode->next;
>       SinglyLinkedNode* nodeAfterNodeToRemove = nodeToRemove->next;
>          
>       currentNode->next = nodeAfterNodeToRemove;
>          
>       if (nodeAfterNodeToRemove == nullptr) {
>          // Removed tail
>          tail = currentNode;
>       }
>          
>       delete nodeToRemove;
>    }
> }
> ```

> [!important] Search
> 
> ```C++
> SinglyLinkedNode* Search(int dataValue) const {
>    // head is a dummy node, so start the search at head->next
>    SinglyLinkedNode* currentNode = head->next;
>    while (currentNode) {
>       // Compare the node's data with dataValue
>       if (currentNode->data == dataValue) {
>          return currentNode;
>       }
>          
>       // Advance to next node
>       currentNode = currentNode->next;
>    }
>       
>    // Not found
>    return nullptr;
> }
> ```
### Doubly-Linked List Member Functions with Dummy Nodes

> [!important] Append Operation
> 
> ```C++
> void AppendNode(DoublyLinkedNode* newNode) {
>    tail->next = newNode;
>    newNode->previous = tail;
>    tail = newNode;
> }
> ```

> [!important] Prepend Operation
> 
> ```C++
> void PrependNode(DoublyLinkedNode* newNode) {
>    newNode->next = head->next;
>    newNode->previous = head;
>       
>    if (head->next) {
>       head->next->previous = newNode;
>    }
>    else {
>       tail = newNode;
>    }
>    head->next = newNode;
> }
> ```

> [!important] Insert Node After
> 
> ```C++
> void InsertNodeAfter(DoublyLinkedNode* currentNode, DoublyLinkedNode* newNode) {
>    if (currentNode == nullptr) {
>       // Special case for prepending
>       PrependNode(newNode);
>    }
>    else if (currentNode == tail) {
>       AppendNode(newNode);
>    }
>    else {
>       DoublyLinkedNode* successor = currentNode->next;
>       newNode->next = successor;
>       newNode->previous = currentNode;
>       currentNode->next = newNode;
>       successor->previous = newNode;
>    }
> }
> ```

> [!important] Remove & Remove Node
> 
> ```C++
> //REMOVE
> // Returns true if the item is found and removed, false if the item is not found
> bool Remove(int itemToRemove) {
>    DoublyLinkedNode* nodeToRemove = Search(itemToRemove);
>    if (nodeToRemove) {
>       RemoveNode(nodeToRemove);
>       return true;
>    }
>    
>    return false; // not found
> }
> 
> //REMOVE NODE
> void RemoveNode(DoublyLinkedNode* currentNode) {
>    // Cannot remove dummy node
>    if (currentNode == head) {
>       return;
>    }
>    
>    DoublyLinkedNode* successor = currentNode->next;
>    DoublyLinkedNode* predecessor = currentNode->previous;
>    
>    // Predecessor is always non-null
>    predecessor->next = successor;
>    
>    if (successor) {
>       successor->previous = predecessor;
>    }
>    if (currentNode == tail) {
>       tail = predecessor;
>    }
>       
>    delete currentNode;
> }
> ```

> [!important] Search
> 
> ```C++
> /*Returns the first node in the list with the speicfied data value, or nullptr if no such node exists*/
> 
> DoublyLinkedNode* Search(int dataValue) const {
>    // head is the dummy node, so start search at head->next
>    DoublyLinkedNode* currentNode = head->next;
>    while (currentNode) {
>       // Compare the node's data with dataValue
>       if (currentNode->data == dataValue) {
>          return currentNode;
>       }
>       
>       // Advance to next node
>       currentNode = currentNode->next;
>    }
>    
>    // Not found
>    return nullptr;
> }
> ```
![[image 10 6.png|image 10 6.png]]
  
# 7.7
## Linked Lists: Recursion
### Forward Traversal
- Can be inplemented using a recursive function with a node parameter
    - If non-null, the node is visited
    - Recursive all on node’s next pointer is made
![[image 11 6.png|image 11 6.png]]
### SinglyLinkedList class Search() and SearchRecursive() Member Functions
```C++
SinglyLinkedNode* Search(int key) const {
   return SearchRecursive(key, head);
}
SinglyLinkedNode* SearchRecursive(int key, SinglyLinkedNode* node) const {
   if (node) {
      if (node->data == key) {
         return node;
      }
      return SearchRecursive(key, node->next);
   }
   return nullptr;
}
```
### Reverse Traversal
- List is traversed in reverse order
![[image 12 6.png|image 12 6.png]]
  
# 7.8
## List
### List Container
- The **list** class defined within the C++ Standard Template Library (STL) defines a container of ordered elements, i.e., a sequence
    - List class supports functions for inserting, modifying, and removing elements
### Common List Functions
![[image 13 6.png|image 13 6.png]]
### Iterating Through a List
![[image 14 5.png|image 14 5.png]]
### Inserting and Removing Elements using Iterators
![[image 15 5.png|image 15 5.png]]
  
# 7.9
## Circular Lists
- A **circular linked list** is a linked list where the tail node’s next pointer points to the head of the list, instead of null
    - Can be used to represent a repeating process
```C++
void CircularListTraverse(DoubleLinkedNode* head) {
   if (head) {
      DoublyLinkedNode* current = head;
      do {
         Visit(current);
         current = current->next;
      } while (current != head);
   }
}
```
![[image 16 5.png|image 16 5.png]]