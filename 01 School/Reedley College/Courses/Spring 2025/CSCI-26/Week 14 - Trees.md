#### Class: [[!!Discrete Mathematics for Computer Science]]
#### Tags : #ComputerScience #ComputerScience/DataStructuresAndAlgorithms 
#### Date: 05/13/2025

---
# 14.1
## Introduction to Trees
- A **tree** is an undirected graph that is connected and has no cycles
- Tree can be __free__ or __rooted__
![[Pasted image 20250513175138.png]]
- The **height** of a tree is the highest level of any vertex
### Terminology Related to Rooted Trees
- Every vertex in a rooted tree has a unique **parent** except for the root, which does not have a parent
- An **ancestor** of a vertex is any vertex on the path from the root to said vertex
	- If x is an ancestor of y, then y is the **descendant** of x
- If x is the parent of y, then y is the **child** of x
- A **leaf** is a vertex that has no children
- Two vertices are **siblings** if they have the same parent
![[Pasted image 20250513180403.png]]

# 14.2
## Tree Application Examples
### Game Trees
- A game tree shows all possible playing strategies of both players in a game
- Each vertex in the tree represents a configuration of the game and an indication of whose turn it is to play next
![[Pasted image 20250513181532.png]]

# 14.3
## Properties of Trees
- Unique paths in trees
	- Theorem: There is a unique path between every pair of vertices in a tree
- Number of leaves in a tree
	- Theorem: Any free tree with at least two vertices has at least two leaves
- Number of edges in a tree
	- Let ***T*** be a tree with ***n*** vertices and ***m*** edges, then m = n - 1

# 14.4
## Tree Traversals
- A tree **traversal** is a procedure performed on a tree to process the information stored in the vertices by systematically visiting each vertex
- In a **pre-order traversal**, a vertex is visited before its descendants
- In a **post-order traversal**, a vertex is visited after its descendants
### Pre-Order Traversal Pseudocode
![[Pasted image 20250513185113.png]]
![[Pasted image 20250513185340.png]]
### Post-Order Traversal Pseudocode
![[Pasted image 20250513185145.png]]
![[Pasted image 20250513185415.png]]

# 14.5
## Spanning Trees and Graph Traversals
- A **spanning tree** of a connected graph ***G*** is a subgraph of ***G*** that contains all the vertices in ***G*** and is a tree
![[Pasted image 20250513185932.png]]
### [[Depth First Search]]
- The algorithm for depth-first search has a loop that iterates through all the neighbors of a vertex v
	- The order in which the neighbors of v are considered affects the order in which the edges are added to the tree
![[Pasted image 20250513191013.png]]
### [[Breadth First Search]]
- Visits vertices in the graph according to their proximity to the start vertex
- Maintains a list of vertices to be visited soon
- Vertices are added to the back of the list and the next vertex to visit is taken from the front of the list
![[Pasted image 20250513191214.png]]
# 14.6
## Minimum Spanning Trees
- A **weighted graph** is a graph G = (V, E), along with a function w: E -> R
	- The function w assigns a real number to every edge
![[Pasted image 20250513192810.png]]
### Minimum Spanning Tree
- A **minimum spanning tree** (MST) of a weighted graph, is a spanning tree ***T*** of ***G*** with a weight that is no larger than any other
---
# References
1. [[Trees]]
2. [[Balanced Trees & Heaps]]
3. [[Depth First Search]]
4. [[Breadth First Search]]