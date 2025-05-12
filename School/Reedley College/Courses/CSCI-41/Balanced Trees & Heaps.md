---
Date Created: 2025-04-21T13:05
Favorite: false
tags:
  - Data-Structures-&-Algorithms
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#14.1]]
    - [[#Motivation]]
    - [[#AVL (Adelson-Velskii and Landis) Trees]]
    - [[#AVL Tree Insert and Remove]]
        - [[#Balance Condition Violation]]
    - [[#AVL Trees Complexity]]
    - [[#Single Rotation (Case 1)]]
        - [[#Single Rotation Left-Left (2,1) Case]]
        - [[#Single Rotation Right-Right (-2,-1) Case]]
    - [[#Double Rotation (Case 2)]]
        - [[#Double Rotation Right-Left (-2, 1) Case]]
        - [[#Double Rotation Left-Right (2, -1) Case]]
    - [[#Delete Algorithm]]
    - [[#AVLNode Class with Utility Functions]]
    - [[#AVLTree Class’s InsertKey() and InsertNode() Member Functions]]
    - [[#AVLTree Class’s RemoveNode() Member Function]]
- [[#Heaps]]
    - [[#Adding a Node to a Heap]]
    - [[#Removing the Top of a Heap]]
    - [[#Implementing a Heap]]
        - [[#Important Points about the Implementation]]
        - [[#Finding Indexes]]
        - [[#Heapify Down Function]]
        - [[#Heapify Up Function]]
        - [[#MaxHeap Class]]
---
# 14.1
## Motivation
- Complete binary tree is hard to build when we allow dynamic insert and remove
    - We want a tree that has the following properties:
        - Tree height = O(log(N))
        - Allows dynamic insert and remove with O(log(N)) time complexity
    - The AVL tree is one of this kind of trees
![[image 46.png|image 46.png]]
## AVL (Adelson-Velskii and Landis) Trees
- An AVL Tree is a binary search tree such that for every internal node v of T, the _heights of the children of v can differ by at most 1_
![[image 1 31.png|image 1 31.png]]
- AVL tree is a binary search tree with balance condition
    - To ensure depth of the tree is O(log(N))
    - And consequently, search/insert/remove complexity bound O(log(N))
- Balance condition
    - For every node in the tree, height of left and right subtree can differ by at most 1
## AVL Tree Insert and Remove
- Do binary search tree insert and remove
- The balance condition can be violated sometimes
    - Do something to fix it: rotations
    - After rotations, the balance of the whole tree is maintained
### Balance Condition Violation
- If condition violated after a node insertion
    - Which nodes do we need to rotate?
    - Only nodes on path from insertion point to root may have their balance altered
- Rebalance the tree through rotation at the _deepest node_ with balance violation
    - The entire tree will be rebalanced
- Violation cases at node k (deepest node)
    1. An insertion into left subtree of left child of k — left-left (2,1) case
        
        ![[image 2 29.png|image 2 29.png]]
        
    2. An insertion into right subtree of left child of k — left-right (2,-1) case
        
        ![[image 3 28.png|image 3 28.png]]
        
    3. An insertion into left subtree of right child — right-left (-2,1) case
        
        ![[image 4 26.png|image 4 26.png]]
        
    4. An insertion into right subtree of right child of k — right-right (-2,-1) case
        
        ![[image 5 26.png|image 5 26.png]]
        
- Cases 1 and 4 equivalent: Single rotation to rebalance
- Cases 2 and 3 equivalent: Double rotation to rebalance
## AVL Trees Complexity
- Overhead
    - Extra space for maintaining height information at each node
    - Insertion and deletion become more complicated, but still O(log N)
- Advantage
    - Worst case O(log(N)) for insert, delete, and search
## Single Rotation (Case 1)
![[image 6 23.png|image 6 23.png]]
- Replace node $k_2$ by node $k_1$
- Set node $k_2$ to be right child of node $k_1$
- Set subtree $Y$ to be the left child of node $k_2$
- Case 4 is similar
```C++
void rotateWithLeftChild(AvlNode*&k2) {
	AvlNode* k1 = k2->left;
	k2->left = k1->right;
	k1->right = k2;
	k2->height = max(height(k2->left), height(k2->right)) + 1;
	k1->height = max(height(k1->left), k2->height) + 1;
	k2 = k1;
}
```
![[image 7 20.png|image 7 20.png]]
### Single Rotation Left-Left (2,1) Case
```C++
if (balanceFactor > 1) {
	if (key < node->left->key) { //left-left (2,1) case
		return rightRotate(node);
	}
}
Node* rightRotate(Node* y) {
	Node* x = y->left;
	Node* T3 = x->right;
	x->right = y;
	y->left = T3;
	y->height = max(height(y->left), height(y->right)) + 1;
	x->height = max(height(x->left), height(x->right)) + 1;
}
```
![[image 8 18.png|image 8 18.png]]
### Single Rotation Right-Right (-2,-1) Case
```C++
if (balanceFactor < -1) {
	if (key > node->right->key) { //right-right (-2,-1) case
		return leftRotate(node);
	}
}
Node* leftRotate(Node* x) {
	Node* y = x->right;
	Node* T2 = y->left;
	y->left = x;
	x->right = T2;
	x->height = max(height(x->left), height(x->right)) + 1;
	y->height = max(height(y->left), height(y->right)) + 1;
	return y;
}
```
![[image 9 17.png|image 9 17.png]]
## Double Rotation (Case 2)
- Left-Right double rotation to fix case 2
- First rotate between $k_1$ and $k_2$
- The rotate between $k_2$ and $k_3$
- Case 3 is similar
### Double Rotation Right-Left (-2, 1) Case
```C++
if (balanceFactor < -1) {
	if (key > node ->right->key) { //right-right (-2, -1) case
		return leftRotate(node); //above
	}
	else if (key < node->right->key) { //right-left (-2, 1) case
		node->right = rightRotate(node->right);
		return leftRotate(node);
	}
}
```
![[image 10 17.png|image 10 17.png]]
### Double Rotation Left-Right (2, -1) Case
```C++
if (balanceFactor > 1) {
	else if (key > node->left->key) { //left-right (2, -1) case
		node->left = leftRotate(node->left);
		return rightRotate(node);
	}
}
```
![[image 11 16.png|image 11 16.png]]
## Delete Algorithm
- Node always deleted as a leaf
- BFs of nodes gets updated
- Rotate as necessary to rebalance
- Step 1: Locate node to be deleted (key)
```C++
if (key < root->key) {
	root->left = deleteNode(root->left, key);
}
else if (key > root->key) {
	root->right = deleteNode(root->right, key);
}
else { //see below
```
- Step 2: Delete the node
    - Three cases for node to be deleted:
        1. Is a leaf, just remove it
        2. Has one child ->
            - Substitute what was node to be deleted with child
            - Delete child
        3. Has two children, find in order successor of the node (that is, the node with a minimum value of a key in the right subtree)
```C++
else { //found key at root
	if ((root->left == NULL) || (root->right == NULL)) { //node has one child
		Node* temp = root->left ? root->left : root->right; //find which
		if (temp == NULL) { //case 1: node to be deleted is a leaf, remove it
			temp == root;
			root == NULL;
		}
		else {
			*root = *temp;
		}
	free(temp); //deallocate temp
	}
	else { //node to be deleted has two children
		//find node with minimum value of key in right subtree
		Node* temp = nodeWithMimumValue(root->right);
		root->key = temp->key;
		root->right = deleteNode(root->right, temp->key);
	}
}
```
## AVLNode Class with Utility Functions
- An AVLNode class has private memory variables for a key, parent, left child, right child, and height
    - Each variable except for height has accompanying getter and setter functions
- AVLNode has some utility functions:
    - GetBalance() computes the node’s balance factor by subtracting the right subtree height from the left subtree heigt
    - UpdateHeight() updates the node’s height value by taking the maximum of the two child subtree heights and adding 1
    - ReplaceChild() replaces one of the node’s existing child pointers with a new value, using either SetLeft() or SetRight() to perform replacement
```C++
class AVLNode {
private:
   int key;
   AVLNode* parent;
   AVLNode* left;
   AVLNode* right;
   int height;
public:
   // Constructs an AVLNode with the given key
   AVLNode(int nodeKey) {
      key = nodeKey;
      parent = nullptr;
      left = nullptr;
      right = nullptr;
      height = 0;
   }
   
   // Calculates this node's balance factor, defined as:
   // height(left subtree) - height(right subtree)
   int GetBalance() const {
      // Get current height of left subtree, or -1 if null
      int leftHeight = -1;
      if (left) {
         leftHeight = left->height;
      }
            
      // Get current height of right subtree, or -1 if null
      int rightHeight = -1;
      if (right) {
         rightHeight = right->height;
      }
            
      // Calculate the balance factor.
      return leftHeight - rightHeight;
   }
   
   // Returns this node's key
   int GetKey() const {
      return key;
   }
   
   // Returns this node's left child node
   AVLNode* GetLeft() const {
      return left;
   }
   
   // Returns this node's parent node
   AVLNode* GetParent() const {
      return parent;
   }
   
   // Returns this node's right child node
   AVLNode* GetRight() const {
      return right;
   }
   
   // Replaces a current child with a new child. Determines if the current
   // child is the left or right, then calls SetLeft() or SetRight() with the
   // new node appropriately. Returns true if the new child is assigned, false
   // otherwise.
   bool ReplaceChild(AVLNode* currentChild, AVLNode* newChild) {
      if (left == currentChild) {
         SetLeft(newChild);
         return true;
      }
      else if (right == currentChild) {
         SetRight(newChild);
         return true;
      }
      
      // currentChild is not a child of this node
      return false;
   }
   
   // Reassigns this node's key with the new key
   void SetKey(int newKey) {
      key = newKey;
   }
   
   // Reassigns this node's left child with the new child. If non-null, the
   // new left child's parent is assigned with a pointer to this node.
   // After assigning the new child, this node's height is updated.
   void SetLeft(AVLNode* newLeftChild) {
      // Assign new left child
      left = newLeftChild;
      
      // If new child is non-null, assign parent
      if (left) {
         left->parent = this;
      }
      
      // A new child may change this node's height, so call UpdateHeight()
      UpdateHeight();
   }
   
   // Reassigns this node's parent node with the new parent
   void SetParent(AVLNode* newParent) {
      parent = newParent;
   }
   
   // Reassigns this node's right child with the new child. If non-null, the
   // new right child's parent is assigned with a pointer to this node.
   // After assigning the new child, this node's height is updated.
   void SetRight(AVLNode* newRightChild) {
      // Assign new right child
      right = newRightChild;
      
      // If new child is non-null, assign parent
      if (right) {
         right->parent = this;
      }
      
      // A new child may change this node's height, so call UpdateHeight()
      UpdateHeight();
   }
   
   // Recalculates the current height of the subtree rooted at this node.
   // Usually called after a subtree has been modified.
   void UpdateHeight() {
      // Get current height of left subtree, or -1 if null
      int leftHeight = -1;
      if (left) {
         leftHeight = left->height;
      }
            
      // Get current height of right subtree, or -1 if null
      int rightHeight = -1;
      if (right) {
         rightHeight = right->height;
      }
      // Assign height with calculated node height
      height = ((leftHeight > rightHeight) ? leftHeight : rightHeight) + 1;
   }
};
```
## AVLTree Class’s InsertKey() and InsertNode() Member Functions
```C++
bool InsertKey(int key) {
   if (Contains(key)) {
      return false;
   }
      
   InsertNode(new AVLNode(key));
   return true;
}
```
```C++
void InsertNode(AVLNode* node) {
   // Check if tree is empty
   if (!root) {
      root = node;
   }
   else {
      // Step 1 - do a regular binary search tree insert
      AVLNode* currentNode = root;
      while (currentNode) {
         // Choose to go left or right
         if (node->GetKey() < currentNode->GetKey()) {
            // Go left. If left child is null, insert the new
            // node here
            if (currentNode->GetLeft() == nullptr) {
               currentNode->SetLeft(node);
               currentNode = nullptr;
            }
            else {
               // Go left and do the loop again
               currentNode = currentNode->GetLeft();
            }
         }
         else {
            // Go right. If the right child is null, insert the
            // new node here
            if (currentNode->GetRight() == nullptr) {
               currentNode->SetRight(node);
               currentNode = nullptr;
            }
            else {
               // Go right and do the loop again
               currentNode = currentNode->GetRight();
            }
         }
      }
      // Step 2 - Rebalance along a path from the new node's parent up
      // to the root
      node = node->GetParent();
      while (node) {
         Rebalance(node);
         node = node->GetParent();
      }
   }
}
```
## AVLTree Class’s RemoveNode() Member Function
```C++
bool RemoveNode(AVLNode* nodeToRemove) {
   // Base case: 
   if (!nodeToRemove) {
      return false;
   }
     
   // nodeToRemove's parent is needed for rebalancing
   AVLNode* parent = nodeToRemove->GetParent();
     
   // Case 1: Internal node with 2 children
   if (nodeToRemove->GetLeft() && nodeToRemove->GetRight()) {
      // Find successor
      AVLNode* successorNode = nodeToRemove->GetRight();
      while (successorNode->GetLeft()) {
         successorNode = successorNode->GetLeft();
      }
         
      // Copy the value from the node
      nodeToRemove->SetKey(successorNode->GetKey());
         
      // Recursively remove successor
      RemoveNode(successorNode);
         
      // Nothing left to do since the recursive call will have rebalanced
      return true;
   }
 
   // Case 2: Root node (with 1 or 0 children)
   else if (nodeToRemove == root) {
      if (nodeToRemove->GetLeft()) {
         root = nodeToRemove->GetLeft();
      }
      else {
         root = nodeToRemove->GetRight();
      }
      if (root) {
         root->SetParent(nullptr);
      }
      delete nodeToRemove;
      return true;
   }
   
   // Case 3: Internal with left child only
   else if (nodeToRemove->GetLeft()) {
      parent->ReplaceChild(nodeToRemove, nodeToRemove->GetLeft());
   }
     
   // Case 4: Internal with right child only OR leaf
   else {
      parent->ReplaceChild(nodeToRemove, nodeToRemove->GetRight());
   }
   
   // nodeToRemove is removed from the tree and can be deleted
   delete nodeToRemove;
     
   // Anything that was below nodeToRemove that has persisted is already 
   // correctly balanced, but ancestors of nodeToRemove may need rebalancing.
   AVLNode* nodeToRebalance = parent;
   while (nodeToRebalance) {
      Rebalance(nodeToRebalance);         
      nodeToRebalance = nodeToRebalance->GetParent();
   }
 
   return true;
}
```
  
# Heaps
- A **heap** is a certain kind of complete binary tree
- When a complete binary tree is built, its first node must be the root
    - The second node is always the left child of the root
    - The third node is always the right child of the root
    - The next nodes always fille the next level from left-to-right
    - When a level is filled we begin at the left of the next level
![[image 12 15.png|image 12 15.png]]
- Each node in a heap contains a key the can be compared to other nodes’ keys
- The “heap property” requires that each node’s key is ≥ the keys of its children
## Adding a Node to a Heap
![[image 13 15.png|image 13 15.png]]
- Put new node in the next available spot
- Push the new node upward, swapping with its parent until the new node reaches an acceptable location
    - swap 42 and 27
    - swap 42 and 35
![[image 14 13.png|image 14 13.png]]
- We stop pushing upward when
    - The parent has a key that is ≥ the key of the new node
    - The new node reaches the root
- The process of pushing the new node upward is called **reheapification upward**
## Removing the Top of a Heap
- Move the last node onto the root
![[image 15 13.png|image 15 13.png]]
- Push the out of place node downward, swapping with its larger child until the new node reaches an acceptable location
    - Swap 27 and 42
    - Swap 27 and 35
- We stop pushing downward when
    - The children all have keys ≤ the out of place node
    - The node reaches the leaf
- The process of pushing the new node downward is called **reheapification downward**
## Implementing a Heap
- We will store the data from the nodes in a partially-filled array
![[image 16 13.png|image 16 13.png]]
![[image 17 12.png|image 17 12.png]]
### Important Points about the Implementation
- The links between the tree’s nodes are not actually stored as pointers, or in any other way
- The only way we “know” that “the array is a tree” is from the way we manipulate the data
- If you know the index of a node, then it is easy to figure out the indexes of that node’s parent and children
### Finding Indexes
```C++
//Parent of A[i]
int PARENT(int i) {
	return (i - 1) / 2;
}
//Left Child of A[i]
int LEFT(int i) {
	return (2 * i + 1);
}
//Right Child of A[i]
int RIGHT(int i) {
	return (2 * i + 2);
}
```
### Heapify Down Function
```C++
void heapify_down(int i) {
	//get left and right child of node at index i
	int left = LEFT();
	int right = RIGHT();
	
	int largest = i;
	
	// Compare A[i] with its left and right child
	// and find largest value
	if (left < size() && A[left] > A[i]) {
		largest = left;
	}
	
	if (right < size() && A[right} > A[i]) {
		largest = right;
	}
	
	// Swap with child having greater value and call
	// Heapify down on the child
	if (largest != i) {
		swap(A[i], A[largest]);
		heapify_down(largest);
	}
}
```
### Heapify Up Function
```C++
void heapify_up(int i) {
	// check if node at index i and its
	// parent violates the heap property
	if (i && A[PARENT(i)] < A[i]) {
		// swap the two if heap property is violated
		swap(A[i], A[PARENT(i)]);
		
		//call Heapify-up on the parent
		heapify_up(PARENT(i));
	}
}
```
### MaxHeap Class
```C++
class MaxHeap {
private:
   int* heapArray;
   int allocationSize;
   int heapSize;
    
   void ResizeArray() {
      int newAllocationSize = allocationSize * 2;
      int* newArray = new int[newAllocationSize];
      if (newArray) {
         // Copy from existing array to new array
         for (int i = 0; i < allocationSize; i++) {
            newArray[i] = heapArray[i];
         }
         
         // Delete old array and set pointer to new
         delete[] heapArray;
         heapArray = newArray;
            
         // Update allocation size
         allocationSize = newAllocationSize;
      }
   }
public:
   MaxHeap() {
      allocationSize = 1;
      heapArray = new int[allocationSize];
      heapSize = 0;
   }
    
   virtual ~MaxHeap() {
      delete[] heapArray;
   }
   
   ...
};
```