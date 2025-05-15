---
Date Created: 2025-04-07T10:39
Favorite: false
tags: []
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
###### tags: #ComputerScience/DataStructuresAndAlgorithms #ComputerScience
# Table of Contents
- [[#Table of Contents]]
- [[#21.1]]
    - [[#Definition and Application of Binary Trees]]
        - [[#Binary Tree Terminology]]
        - [[#Uses of Binary Trees]]
        - [[#Searching In a Binary Tree]]
- [[#21.2]]
    - [[#Creating/ Inserting Nodes into a BST]]
        - [[#Binary Search Tree Operations]]
        - [[#Binary Search Tree Node]]
        - [[#Creating a New Node]]
        - [[#Inserting a Node in a Binary Search Tree]]
        - [[#Binary Search Tree Insertion Function]]
        - [[#BinarySearch Tree Class’ Contains() and InsertKey() Member Functions]]
- [[#21.3]]
    - [[#Traversing and Searching BSTs]]
        - [[#Traversing a Binary Tree]]
        - [[#Searching in a Binary Tree]]
        - [[#BSTNode Class]]
        - [[#BinarySearchTree Class Constructor and Destructor]]
- [[#21.4]]
    - [[#Deleting Nodes from BSTs]]
        - [[#Deleting a Node from a Binary Tree - Leaf Node]]
        - [[#Deleting a Node from a Binary Tree - One Child]]
        - [[#Deleting a Node from a Binary Tree - Two Children]]
        - [[#BinarySearchTree Class’ Remove() Member Function(Promoting Successor)]]
- [[#21.5]]
    - [[#Template Considerations for Binary Search Trees]]
---
# 21.1
## Definition and Application of Binary Trees
- **Binary Tree:** A nonlinear linked list in which each node may point to 0, 1 or 2 other nodes
- Each node contains one or more data fields and two pointers
![[image 44.png|image 44.png]]
### Binary Tree Terminology
- **Tree Pointer:** Like a head pointer for a linked list, it pointes to the first node in the binary tree
- **Root Node:** The node at the top of the tree
- **Leaf Nodes:** Nodes that have no children
![[image 1 29.png|image 1 29.png]]
- **Child Nodes, Children:** Nodes below a given node
![[image 2 27.png|image 2 27.png]]
- **Parent Node:** Node above a given node
![[image 3 26.png|image 3 26.png]]
- **Subtree:** The portion of a tree from a node down to the leaves
![[image 4 24.png|image 4 24.png]]
- A node’s **depth** is the number of edges on the path from the root to the node
    - The root node has a depth of 0
![[image 5 24.png|image 5 24.png]]
### Uses of Binary Trees
- **Binary Search Tree:** Data organized in a binary tree to simplify searches
- Left subtree of a node contains data values < the data in the node
- Right subtree of a node contains values > the data in the node
### Searching In a Binary Tree
1. Start at root node
2. Examine node data:
    1. Is it desired value? Done
    2. Else, is desired data < node data? Repeat step 2 with left subtree
    3. Else, is desired data > node data? Repeat step 2 with right subtree
3. Continue until desired value found or a null pointer reached
**Example**
- To locate the node containing 43,
    - Examine root node (31) first
    - Since 43 > 31, examine the right child of the node containing 31, (59)
    - Since 43 < 59, examine the left child of the node containing 59, (43)
    - The node containing 43 has been found
![[image 6 21.png|image 6 21.png]]
  
# 21.2
## Creating/ Inserting Nodes into a BST
### Binary Search Tree Operations
- Create a binary search tree - organize data into a binary search tree
- Insert a node into a binary tree - put node into tree in its correct position to maintain order
- Find a node in a binary tree - locate a node with particular data value
- Delete a node from a binary tree - remove a node and adjust links to maintain binary tree
### Binary Search Tree Node
- A node in a binary tree is like a node in a linked list, with two node pointer fields:
```C++
struct TreeNode {
	int value;
	TreeNode* left;
	TreeNode* right;
}
```
### Creating a New Node
- Allocate memory for new node:
    - `newNode = new TreeNode;`
- Initialize the contents of the node:
    - `newNode->value = num;`
- Set the pointers to `nullptr`:
    
    ```C++
    newNode->left
    = newNode->right
    = nullptr;
    ```
    
![[image 7 18.png|image 7 18.png]]
### Inserting a Node in a Binary Search Tree
1. If tree is empty, insert the new node as the root node
2. Else, compare tnew node against left or right child, depending on whether data value os new node is < or > root node
3. Continue comparing and choosing left or right subtree until null pointer is found
4. Set this null pointer to point to new node
![[image 8 16.png|image 8 16.png]]
### Binary Search Tree Insertion Function
```C++
void InsertNode(BSTNode* newNode) {
	if (root == nullptr) {
		root = newNode;
	}
	else {
		BSTNode* currentNode = root;
		while (currentNode != nullptr) {
			if (newNode->key < currentNode->key) {
				if (currentNode->left == nullptr) {
					currentNode->left = newNode;
					currentNode = nullptr;
					}
				else {
					currentNode = currentNode->left;
				}
			}
			else {
				if (currentNode->right == nullptr) {
					currentNode->right = newNode;
					currentNode = nullptr;
				}
				else {
					currentNode = currentNode->right;
				}
			}
		}
	}
}
```
### BinarySearch Tree Class’ Contains() and InsertKey() Member Functions
```C++
bool Contains(int key) {
	return Search(key) != nullptr;
}
```
```C++
bool InsertKey(int key) {
	if (Contains(key)) {
		//duplicate keys not allowed
		return false;
	}
	
	InsertNode(new BSTNode(key));
	return true;
}
```
  
# 21.3
## Traversing and Searching BSTs
### Traversing a Binary Tree
![[image 6 21.png|image 6 21.png]]
- Three traversal methods:
    1. **Inorder:**
        1. Traverse left subtree of node
        2. Process data in node
        3. Traverse right subtree of node
            
            ![[image 9 15.png|image 9 15.png]]
            
    2. **Preorder:**
        
        1. Process data in node
        2. Traverse left subtree of node
        3. Traverse right subtree of node
        
        ![[image 10 15.png|image 10 15.png]]
        
    3. **Postorder:**
        
        1. Traverse left subtree of node
        2. Traverse right subtree of node
        3. Process data in node
        
        ![[image 11 14.png|image 11 14.png]]
        
          
        
```C++
/*Given a binary tree, print its node in inorder*/
void printInorder(struct Node* node) {
	if (node == NULL) {return;}
	
	/*first recur on left child*/
	printInorder(node->left);
	
	/*then print the data of node*/
	cout << node->date << " ";
	
	/*now recur on right child*/
	printInorder(node->right);
}
```
```C++
/*Given a binary tree, print its node in preorder*/
void printPreorder(struct Node* node)
{
	if (node == NULL) {return;}
	
	/*first print the data of node*/
	cout << node->date << " ";
	
	/*then recur on left subtree*/
	printPreorder(node->left);
	
	/*now recur on right subtree*/
	printPreorder(node->right);
}
```
```C++
/*Given a binary tree, print its node in postorder*/
void printPostorder(struct Node* node)
{
	if (node == NULL) {return;}
	/*first recur on left subtree*/
	printPostorder(node->left);
	
	/*then recur on right subtree*/
	printPostorder(node->right);
	
	/*now print the data of node*/
	cout << node->date << " ";
}
```
### Searching in a Binary Tree
- Start at root node, traverse the tree looking for value
- Stop when value found or null pointer
- Can be implemented as a `bool` function
```C++
bool searchNode(int num) {
	TreeNode* node = root;
	
	while (node != nullptr) {
		if (node->value == num) {
			return true;
		}
		else if (num < node->value) {
			node = node->left;
		}
		else {
			node = node->right;
		}
	}
	return false;
}
```
![[image 12 13.png|image 12 13.png]]
**Minimum Binary Tree Heights for N Nodes are equivalent to** $\lfloor log_2N \rfloor$
![[image 13 13.png|image 13 13.png]]
### BSTNode Class
```C++
class BSTNode {
public:
	int key;
	BSTNode* left;
	BSTNode* right;
	
	BSTNode(int nodeKey, BSTNode* leftChild = nullptr, BSTNode* rightChild = nullptr) {
		key = nodeKey;
		left = leftChild;
		right = rightChild;
	}
};
```
### BinarySearchTree Class Constructor and Destructor
```C++
class BinarySearchTree {
private:
	BSTNode* root;
	
	void DeleteTree(BSTNode* subtreeRoot) {
		if (subtreeRoot != nullptr) {
			DeleteTree(subtreeRoot->left);
			DeleteTree(subtreeRoot->right);
			delete subtreeRoot;
		}
	}
public:
	BinarySearchTree() {
		root = nullptr;
	}
	
	~BinarySearchTree() {
		DeleteTree(root);
	}
};
```
# 21.4
## Deleting Nodes from BSTs
### Deleting a Node from a Binary Tree - Leaf Node
- If node to be deleted is a leaf node, replace parent node’s pointer to it with null pointer, then delete the node
![[image 14 11.png|image 14 11.png]]
![[image 15 11.png|image 15 11.png]]
### Deleting a Node from a Binary Tree - One Child
- If node to be deleted has one child node, adjust pointers so that parent of node to be deleted points to child of node to be deleted, then delete the node
![[image 16 11.png|image 16 11.png]]
![[image 17 10.png|image 17 10.png]]
### Deleting a Node from a Binary Tree - Two Children
- If node to be deleted has left and right children…
    - “Promote” one child to take the place of the deleted node
    - Locate correct position for other child in subtree of promoted child
- A convention: promote the right child, position left subtree underneath
![[image 18 10.png|image 18 10.png]]
![[image 19 9.png|image 19 9.png]]
### BinarySearchTree Class’ Remove() Member Function(Promoting Successor)
```C++
bool Remove(int key) {
   BSTNode* parent = nullptr;
   BSTNode* currentNode = root;
   // Search for the node
   while (currentNode) {
      // Check if currentNode has a matching key
      if (currentNode->key == key) {
         if (currentNode->left == nullptr && currentNode->right == nullptr) {
            // Remove leaf
               
            if (parent == nullptr) { // Node is root
               root = nullptr;
            }
            else if (parent->left == currentNode) { 
               parent->left = nullptr;
            }
            else {
               parent->right = nullptr;
            }
            delete currentNode;
            return true; // Node found and removed
         }
         else if (currentNode->left && currentNode->right == nullptr) {
            // Remove node with only left child
               
            if (parent == nullptr) { // Node is root
               root = currentNode->left;
            }
            else if (parent->left == currentNode) {
               parent->left = currentNode->left;
            }
            else {
               parent->right = currentNode->left;
            }
            delete currentNode;
            return true; // Node found and removed
         }
         else if (currentNode->left == nullptr && currentNode->right) {
            // Remove node with only right child
               
            if (parent == nullptr) { // Node is root
               root = currentNode->right;
            }
            else if (parent->left == currentNode) {
               parent->left = currentNode->right;
            }
            else {
               parent->right = currentNode->right;
            }
            delete currentNode;
            return true; // Node found and removed
         }
         else {
            // Remove node with two children
               
            // Find successor (leftmost child of right subtree)
            BSTNode* successor = currentNode->right;
            while (successor->left) {
               successor = successor->left;
            }
            currentNode->key = successor->key; // Copy successor's key to current node
            parent = currentNode;
               
            // Reassign currentNode and key so that loop continues with new key
            currentNode = currentNode->right;
            key = successor->key;
         }
      }
      else if (currentNode->key < key) {
         // Search right
            
         parent = currentNode;
         currentNode = currentNode->right;
      }
      else {
         // Search left
            
         parent = currentNode;
         currentNode = currentNode->left;
      }
   }
   return false; // Node not found
}
```
  
# 21.5
### Template Considerations for Binary Search Trees
- Binary tree can be implemented as a template, allowing flexibility in determining type of data stored
- Implementation must support relational operators >, <, and == to allow comparison of nodes
---
# References
1. [[Week 14 - Trees]]
2. [[Balanced Trees & Heaps]]