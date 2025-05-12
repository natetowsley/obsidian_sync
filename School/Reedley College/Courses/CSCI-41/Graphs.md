---
Date Created: 2025-05-05T09:44
Favorite: false
tags:
  - Data-Structures-&-Algorithms
📕 Courses:
  - "[[!!Programming Concepts and Methodology II (C++)]]"
---
[https://flocus.com/minimalist-pomodoro-timer/](https://flocus.com/minimalist-pomodoro-timer/)
# Table of Contents
- [[#Table of Contents]]
- [[#20.1]]
    - [[#Introduction]]
    - [[#Graph Definitions and Notations]]
    - [[#Graph Representation]]
        - [[#Adjacency Matrix]]
        - [[#Adjacency Lists]]
    - [[#Operations on Graph]]
    - [[#Graphs as ADTs]]
    - [[#Graph Traversals]]
        - [[#Depth First Traversal]]
        - [[#DFS Algorithm]]
        - [[#Breadth First Traversal]]
        - [[#BFS Algorithm]]
    - [[#Weighted Graphs]]
    - [[#Vertex, Edge, and Graph Classes]]
        - [[#Vertex Class]]
        - [[#Edge Class]]
        - [[#Graph Class]]
        - [[#Graph Class Member Functions]]
---
# 20.1
## Introduction
- Konigsberg bridge problem
    - The river Pregel flows around the island Kneiphof and then divides into two branches
![[image 48.png|image 48.png]]
- Starting at one land area, can you cross all bridges exactly once and return to the start?
    - In 1736, Euler represented the problem as a graph and answered the question: No
![[image 1 33.png|image 1 33.png]]
- Over the past 200 years, graph theory has been applied to a variety of problems, including
    - Model electrical circuits, finding the shortest route, project planning, linguistics, genetics, social science, etc
## Graph Definitions and Notations
- $a \in X$: $a$ is an element of the set $X$
- **Subset** $(Y \underline{\subset} X)$: Every element of $Y$ is also an element of $X$
- **Intersection** $(A \cap B)$: Contains all the elements in $A$ and $B$
    - $A \cap B = \{x | x \in A \text{ and } x \in B\}$
- **Union** $(A \cup B)$: Set of all the elements that are in $A$ or in $B$
    - $A \cup B = \{x|x \in A \text{ or } x \in B\}$
- $A \times B$: Set of all the ordered pairs of elements of $A$ and $B$
    - $A \times B = \{(a,b) | a \in A, b \int B \}$
- **Graph G:** $G = (V,E)$
    - $V$ is a finite nonempty set of **vertices** of $G$
    - $E \underline{\subset} V\times V$
    - Elements in $E$ are the pairs of elements of $V$
    - $E$ is called set of **edges**
- **Directed Graph** or **digraph**: Elements of $E(G)$ are ordered pairs
- **Undirected Graph**: Elements not ordered pairs
- If $(u, v)$ is an edge in a directed graph
    - **Origin:** $u$
    - **Destination:** $v$
- **Subgraph** $H$ of $G$: if $V(H) \underline{\subset}V(G)$ and $E(H) \underline{\subset} E(G)$
    - Every vertex and edge of $H$ is in $G$

> [!important] **Null Graph (Empty Graph)**
> 
> ![[image 2 31.png|image 2 31.png]]

> [!important] **Undirected Graphs**
> 
> ![[image 3 30.png|image 3 30.png]]

> [!important] **Directed Graphs**
> 
> ![[image 4 28.png|image 4 28.png]]
- **Adjacent:** There is an edge from one vertex to the other; i.e., $(u, v) \in E(G)$
- **Incident:** If edge $e = (u,v)$, then $e$ is incident on $u$ and $v$
    - **Loop:** Edge incident on a single vertex
- **Parallel Edges:** Associated with the same pair of vertices
- **Simple Graph:** Has no loops or parallel edges
- **Path:** Sequence of vertices $u_1, u_2, ..., u_n$ such that $u = u_1, u_n = v$, and $(u_i,u_{i+1})$ is an edge for all $i = 1,2,..., n-1$
- **Connected vertices:** There is a path from $u$ to $v$
- **Simple Path:** Path in which all vertices, except possibly the first and last, are distinct
- **Cycle**: Simple path in which the first and last vertices are the same
- **Connected:** Path exists from any vertex to any other vertex
    - **Component:** Maximal subset of connected vertices
- In a connected graph $G$, if there is an edge from $u$ to $v$, i.e., $(u,v) \in E(G)$, then $u$ is **adjacent to** $v$ and $v$ is **adjacent from** $u$
- **Strongly connected:** Any two vertices in $G$ are connected
## Graph Representation
- To write programs that process and manipulate graphs:
    - Must store graphs in computer memory
- A graph can be represented in several ways:
    - Adjacency matrices
    - Adjacency lists
### Adjacency Matrix
- $G$: graph with $n$ vertices $(n > 0)$
    - $V(G) = \{v_1,v_2,...,v_n\}$
- **Adjacency matrix** $(A_G \text{ of } G)$: two-dimensional $n \times n$ matrix such that:
$$A_G(i,j) = \begin{cases} 1 & \text{ if } (v_i, v_j) \in E(G) \\ 0 & \text{ otherwise} \end{cases}$$
- Adjacency matrix of an undirected graph is symmetric
### Adjacency Lists
- $G$: graph with $n$ vertices $(n > 0)$
    - $V(G) = \{v_1,v_2,...,v_n\}$
- Linked list corresponding to each vertex, $v$,
    - Each node of linked list contains the vertex, $u$, such that $(u,v) \in E(G)$
    - Each node has two components, such as `vertex` and `link`
- EX:
![[image 5 28.png|image 5 28.png]]
![[image 6 25.png|image 6 25.png]]
## Operations on Graph
- Operations commonly performed on a graph
    - Create the graph
    - Clear the graph
        - Makes the graph empty
    - Determine whether the graph is empty
    - Traverse the graph
    - Print the graph
- The adjacency list (linked list) representation
    - For each vertex, $v$, vertices adjacent to $v$ are stored in linked list associated with $v$
        - In a directed graph, vertices adjacent to $v$ are called **immediate successors**
    - To manage data in linked list, use class `unorderedLinkedList`
## Graphs as ADTs
- We implement graphs as an abstract data type (ADT), including functions to:
    - Create/ clear the graph
    - Print the graph
    - Traverse the graph
    - Determine the graph’s size
## Graph Traversals
- Traversing a graph is similar to traversing a binary tree, except that:
    - A graph might have cycles
    - Might not be able to traverse the entire graph from a single vertex
- Most common graph traversal algorithms
    - Depth first traversal
    - Breadth first traversal’
### Depth First Traversal
- **Depth first traversal** at a given node, $v$
    - Mark node $v$ as visited
    - Visit the node
    - `for` each vertex $u$ adjacent to $v$
        - `if` $u$ is not visited
            - start the depth first traversal at $u$
- This is a recursive algorithm
![[image 7 22.png|image 7 22.png]]
- Depth-first ordering of vertices
    - 0, 1, 4, 3, 2, 5, 7, 8, 6, 9
### DFS Algorithm
```Python
void DepthFirstSearch(Vertex* startVertex,
	VertexVisitor& visitor) {
	std::stack<Vertex*> vertexStack;
   std::unordered_set<Vertex*> visitedSet;     
   vertexStack.push(startVertex);
       
   while (vertexStack.size() > 0) {
      Vertex* curVertex = vertexStack.top();
      vertexStack.pop();
      if (0 == visitedSet.count(curVertex)) {
         visitor.Visit(curVertex);
         visitedSet.insert(curVertex);
         for (Edge* edge : *GetEdgesFrom(curVertex)) {
            vertexStack.push(edge->toVertex);
         }
      }
   }
}
```
### Breadth First Traversal
- **Breadth first traversal** of a graph
    - Similar to traversing a binary tree level by level
    - Nodes at each level are visited from left to right
- Starting at the first vertex, the graph is traversed as much as possible
    - The ngo to next vertex not yet visited
- Use a queue to implement the breadth first search algorithm
![[image 7 22.png|image 7 22.png]]
- Breadth-first ordering of vertices:
    - 0, 1, 3, 4, 2, 5, 7, 8, 6, 9
### BFS Algorithm
```C++
void BreadthFirstSearch (Vertex* startVertex, 
	VertexVisitor& visitor) {
	std::unordered_set<Vertex*> discoveredSet;
   std::queue<Vertex*> frontierQueue;
   frontierQueue.push(startVertex);
   discoveredSet.insert(startVertex);
   while (frontierQueue.size() > 0) {
      Vertex* currentVertex = frontierQueue.front();
      frontierQueue.pop();
      visitor.Visit(currentVertex);
      for (Edge* edge : *GetEdgesFrom(currentVertex)) {
         if (0 == discoveredSet.count(edge->toVertex)) {
            frontierQueue.push(edge->toVertex);
            discoveredSet.insert(edge->toVertex);
         }
      }
   }
}
```
## Weighted Graphs
- A **weighted graph** associates a weight with each edge
    - A graph edge’s **weight**, or **cost**, represents some numerical value between vertex items, such as flight cost between airports, connection speed between computers, or travel time between cities
    - May be directed or undirected
![[image 8 20.png|image 8 20.png]]
![[image 9 19.png|image 9 19.png]]
## Vertex, Edge, and Graph Classes
### Vertex Class
```C++
class Vertex {
public:
	string label;
	
	Vertex(const string& vertexLabel) {
		label = vertexLabel;
	}
};
```
### Edge Class
```C++
class Edge {
public:
	Vertex* fromVertex;
	Vertex* toVertex;
	double weight;
	
	Edge(Vertex* from, Vertex* to, double edgeWeight) {
		fromVertex = from;
		toVertex = to;
		weight = edgeWeight;
	}
};
```
### Graph Class
```C++
class Graph {
private:
	// Maps a vertex to a vector of all edges that start from that vertex
    std::unordered_map<Vertex*, std::vector<Edge*>*> fromEdges;
    
    // Maps a vertex to a vector of all edges that go to that vertex
    std::unordered_map<Vertex*, std::vector<Edge*>*> toEdges;
public:
    // Returns an unordered_set of all of this graph's edges
    std::unordered_set<Edge*> GetEdges() const {
        std::unordered_set<Edge*> edgesSet;
        for (auto& keyValue : fromEdges) {
            std::vector<Edge*>* edges = keyValue.second;
            for (Edge* edge : *edges) {
                edgesSet.insert(edge);
            }
        }
        return edgesSet;
    }
    // Returns a vector of edges with the specified fromVertex
    const std::vector<Edge*>* GetEdgesFrom(Vertex* fromVertex) const {
        return fromEdges.at(fromVertex);
    }
    
    // Returns a vector of edges with the specified toVertex
    const std::vector<Edge*>* GetEdgesTo(Vertex* toVertex) const {
        return toEdges.at(toVertex);
    }
    // Returns a vertex with a matching label, or nullptr if no such vertex exists
    Vertex* GetVertex(const std::string& vertexLabel) {
        for (auto& keyValue : fromEdges) {
            Vertex* vertex = keyValue.first;
            if (vertex->label == vertexLabel) {
                return keyValue.first;
            }
        }
        return nullptr;
    }
    
    // Returns a vector of all of this graph's vertices
    std::vector<Vertex*> GetVertices() const {
        std::vector<Vertex*> vertices;
        for (auto& keyValue : fromEdges) {
            vertices.push_back(keyValue.first);
        }
        return vertices;
    }
    
    // ... remainder of class omitted
};
```
### Graph Class Member Functions
```C++
virtual ~Graph() {
   // Get the set of vertices and the set of edges
   std::unordered_set<Vertex*> distinctVertices;
   std::unordered_set<Edge*> distinctEdges;
   for (auto& keyValue : fromEdges) {
      distinctVertices.insert(keyValue.first);
      for (Edge* edge : *keyValue.second) {
         distinctEdges.insert(edge);
      }
      // Free dynamically allocated vector of edges
      delete keyValue.second;
   }
   for (auto& keyValue : toEdges) {
      distinctVertices.insert(keyValue.first);
      for (Edge* edge : *keyValue.second) {
         distinctEdges.insert(edge);
      }
      // Free dynamically allocated vector of edges
      delete keyValue.second;
   }
        
   // Clear each map
   fromEdges.clear();
   toEdges.clear();
        
   // Free each edge and each vertex
   for (Edge* edge : distinctEdges) {
      delete edge;
   }
   for (Vertex* vertex : distinctVertices) {
      delete vertex;
   }
}
    
Vertex* AddVertex(const std::string& newVertexLabel) {
   // Create the new Vertex object
   Vertex* newVertex = new Vertex(newVertexLabel);
        
   // Every vertex must exist as a key in both maps
   fromEdges[newVertex] = new std::vector<Edge*>();
   toEdges[newVertex] = new std::vector<Edge*>();
        
   return newVertex;
}
    
Edge* AddDirectedEdge(Vertex* fromVertex, Vertex* toVertex, double weight = 1.0) {
   // Don't add the same edge twice
   if (HasEdge(fromVertex, toVertex)) {
      return nullptr;
   }
        
   // Create the Edge object
   Edge* newEdge = new Edge(fromVertex, toVertex, weight);
        
   // Add the edge to the appropriate vector in both maps
   fromEdges[fromVertex]->push_back(newEdge);
   toEdges[toVertex]->push_back(newEdge);
        
   return newEdge;
}
    
std::pair<Edge*, Edge*> AddUndirectedEdge(Vertex* vertexA, Vertex* vertexB, 
   double weight = 1.0) {
   return std::pair<Edge*, Edge*>(
      AddDirectedEdge(vertexA, vertexB, weight),
      AddDirectedEdge(vertexB, vertexA, weight));
}
    
// Returns true if this graph has an edge from fromVertex to toVertex
bool HasEdge(Vertex* fromVertex, Vertex* toVertex) const {
   if (0 == fromEdges.count(fromVertex)) {
      // fromVertex is not in this graph
      return false;
   }
        
   // Search the vector of edges for an edge that goes to toVertex
   std::vector<Edge*>& edges = *fromEdges.at(fromVertex);
   for (Edge* edge : edges) {
      if (edge->toVertex == toVertex) {
         return true;
      }
   }
        
   return false;
}
```