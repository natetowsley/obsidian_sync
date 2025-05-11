---
Date Created: 2025-04-27T13:22
Favorite: false
📕 Courses:
  - "[[Discrete Mathematics for Computer Science]]"
---

# Table of Contents
- [[#Table of Contents]]
- [[#12.1]]
    - [[#Introduction to Graphs]]
        - [[#Graph Terminology]]
        - [[#Number of Edges and Total Degree]]
        - [[#Common Graphs]]
- [[#12.2]]
    - [[#Graph Representations]]
        - [[#Adjacency list Representation for Graphs]]
        - [[#Matrix Representation for Graphs]]
- [[#12.3]]
    - [[#Graph Isomorphism]]
        - [[#Isomorphic Graphs]]
- [[#12.4]]
    - [[#Walks, Trails, Circuits, Paths, and Cycles]]
        - [[#A Walk in an Undirected Graph]]
- [[#12.5]]
    - [[#Graph Connectivity]]
        - [[#Connected Components]]
        - [[#k-Connectivity]]
- [[#12.6]]
    - [[#Euler Circuits and Trails]]
        - [[#Finding an Euler Circuit and the Proof of Sufficient Conditions for an Euler Circuit]]
        - [[#Euler Trails]]
- [[#12.7]]
    - [[#Hamiltonian Cycles and Paths]]
- [[#12.8]]
    - [[#Planar Graphs]]
- [[#12.9]]
    - [[#Graph Coloring]]
---
# 12.1
## Introduction to Graphs
- In an **undirected graph**, the edges are unordered pairs of vertices, which are useful for modeling relationships that are symmetric
    - An undirected graph can be used to model sibling relationships within a family
    - Unlike parent/ child relationships in which two people have different roles, sibling relationships are symmetric
- A graph consists of a pair of sets $(V, E)$ where $V$ is a set of vertices and $E$ is a set of edges
    - A graph is **finite** if the vertex set is finite
    - A single element of $V$ is called a **vertex** and is usually represented pictorially by a dot with a label
**An Undirected Graph**
![[image 47.png|image 47.png]]
- **Parallel Edges** are multiple edges between the same pair of vertices
    - There can be two different roads between the same two cities
    - A graph can also have a **self-loop**, which is an edge between a vertex and itself
        - The graph below has two parallel edges between $a$ and $b$ and a self-loop at $c$
**A Graph with Parallel Edges and a Self-Loop**
![[image 1 32.png|image 1 32.png]]
- If a graph does not have parallel edges or self-loops, it is a **simple graph**
- In a simple graph, an edge connecting vertex $a$ and vertex $b$ is denoted as $\{a,b\}$
    - In defining graphs with parallel edges, the edges must have an additional label besides the two endpoints to destinguish between different parallel edges
- An undirected edge is denoted $\{a,b\}$ and is the same as $\{b,a\}$
- A direceted edge is denoted $(a,b)$
![[image 2 30.png|image 2 30.png]]
### Graph Terminology
![[image 3 29.png|image 3 29.png]]
- If there is an edge between two vertices, the vertices are **adjacent**. In the graph above, $d$ and $e$ are adjacent, but $d$ and $b$ are not adjacent
- Vertices $b$ and $e$ are the **endpoints** of edge $\{b,e\}$. The edge $\{b,e\}$ is **incident** to vertices $b$ and $e$
- A vertex $c$ is a **neighbor** of vertex $b$ if and only if $\{b,c\}$ is an edge. Above, the neighbors of $b$ are the veritces $a, c, \text{and }e$
- In a simple graph, the **degree** of a vertex is the number of neighbors it has. Above, the degree of $b$ is 3 and the degree of vertex $a$ is 2
    - The degree of vertex b is denoted by deg(b)
- The **total degree** of a graph is the sum of the degrees of all of the vertices. The total degree of the graph above is $2+3+3+2+2 = 12$
- In a **regular graph**, all the vertices have the same degree. In a **d-regular graph**, all the vertices have degree $d$
    - The graph above is not regular because $deg(a) \not= deg(b)$
    - However, the graph below is 3-regular
**A 3-Regular Graph**
![[image 4 27.png|image 4 27.png]]
- A graph $H = (V_H, E_H)$ is a **subgraph** of a graph $G = (V_G, E_G)$ if $V_H \subseteq V_G \text{ and } E_H \subseteq E_G$
    - Any graph $G$ is a subgraph of itself
**An Example of a Subgraph**
![[image 5 27.png|image 5 27.png]]
### Number of Edges and Total Degree
$$\text{Let }G = (V,E) \text{ be an undirected graph. Then twice the number of edges is equal to the total degree: }\sum_{\substack{v\in V}} deg(v) = 2 * |E|$$
![[image 6 24.png|image 6 24.png]]
### Common Graphs
![[image 7 21.png|image 7 21.png]]
- $K_n$ is called the **complete graph** on $n$ vertices
    - $K_n$ has an edge between every pair of vertices
    - The figure shows $K_6$. $K_n$ is sometimes called a **clique** of size $n$ or an $n$-clique
- $C_n$ is called a cycle on $n$ vertices
    - The edges connect the vertices in a ring
    - The picture above depicts $C_7$. Note that $C_n$ is well defined only for $n$ ≥ $3$
- The n-dimensional hypercube, denoted $Q_n$, has $2^n$ vertices. Each vertex is labeled with an n-bit string. Two vertices are connected by an edge if their corresponding labels differ by only one bit
    - The figure above shows a diagram of the 3-dimensional hypercube
- $K_{n,m}$ has $n + m$ vertices. The vertices are divided into two sets: one with $m$ vertices and one set with $n$ vertices
    - There are no edges between vertices in the same set, but there is an edge between every vertex in one set and every vertex in the other set
    - The diagram shows a diagram of $K_{3,4}$
  
# 12.2
## Graph Representations
![[image 8 19.png|image 8 19.png]]
- The two graphs look different because they are drawn differently, however they are actually the same graph because they have the same vertex and edge sets as shown:
![[image 9 18.png|image 9 18.png]]
### Adjacency list Representation for Graphs
- In the **adjacency list representation** of a graph, each vertex has a list of all its neighbors
- Since the graph is undirected if vertex $a$ is in $b$’s list of neighbors, then $b$ must also be in $a$’s list of neighbors
    
    ![[image 10 18.png|image 10 18.png]]
    
### Matrix Representation for Graphs
- The **matrix representation** for a graph with $n$ vertices is an $n \text{ by } n$ matrix with entries that are all either 0 or 1, indicating whether or not each edge is present
- If the matrix is labeled $M$, then $M_{i,j} = 1$ if and only if $\{i,j\}$ is an edge in the graph
![[image 11 17.png|image 11 17.png]]
  
# 12.3
## Graph Isomorphism
![[image 12 16.png|image 12 16.png]]
- The difference between these two similar graphs is that the vertices are labeled differently
![[image 13 16.png|image 13 16.png]]
### **Isomorphic Graphs**
![[image 14 14.png|image 14 14.png]]
![[image 15 14.png|image 15 14.png]]
- The **degree sequence** of a graph is a list of the degrees of all of the vertices in non-increasing order
![[image 16 14.png|image 16 14.png]]
  
# 12.4
## Walks, Trails, Circuits, Paths, and Cycles
### A Walk in an Undirected Graph
- A **walk** from $v_0$ to $v_1$ in an undirected graph $G$ is a sequence of alternating vertices and edges that starts and ends with a vertex:
$$\braket{\blue{v_0},\red{\{v_0,v_1\}},\blue{v_1},\red{\{v_1,v_2\}},\blue{v_2},...,\blue{v_{l-1}},\red{\{v_{l-1},v_l\}},\blue{v_l}}$$
- The vertices just before an after each edge are the two endpoints of that edge
- Since the edges in a walk are completely determined by the vertices, a walk can also be denoted by the sequence of vertices:
$$\braket{\blue{v_0},\blue{v_1},...,\blue{v_1}}$$
- The sequence of vertices is a walk only if $\{v_{i-1}, v_i\} \in E$ for each $i = 1,2,...,l$
- Two consecutive vertices $...,v_{i-1},v_i,...$ in a walk represent an occurrence of the edge $\{v_{i-1}, v_i\}$ in the walk
- The **length of a walk** is $l$, the number of edges in the walk
    - A sequence with a single vertex, such as $\braket{v}$, is a walk of length 0
- An **open walk** is a walk in which the first and last vertices are not the same
- A **closed walk** is a walk in which the first and last vertices are the same
![[image 17 13.png|image 17 13.png]]
![[image 18 12.png|image 18 12.png]]
- A **trail** is a walk in which no edge occurs more than once
- A **path** is an open walk in which no vertex occurs more than once
- A **circuit** is a closed trail
- A **cycle** is a circuit of length at 1 in which no vertex occurs more than once, except the first and last vertices which are the same
  
# 12.5
## Graph Connectivity
### Connected Components
- In an undirected graph, if there is a path from vertex $v$ to vertex $w$, then there is also a path from $w$ to $v$
    - The two vertices, $v$ and $w$, are **connected**
    - A vertex is always connected to itself
- The property of being connected can be extended to sets of vertices and the entire graph:
    - A set of vertices in a graph is connected if every pair of vertices in the set is connected
    - A graph is connected if every pair of vertices in the graph is connected, and is **disconnected** otherwise
- A **connected component** consists of a maximal set of connected vertices and all the edges between any two vertices in the set
    - The word “maximal” means that if any vertex is added to a connected component, then the setof vertices will no longer be connected
- A vertex that is not connected with any other vertex is called an **isolated vertex** and is therefore a connected component with only one vertex
![[image 19 11.png|image 19 11.png]]
### k-Connectivity
**k-vertex-connected graph**
- An undirected graph $G$ is **k-vertex-connected** if the graph contains at least $k+1$ vertices and remains connected after any $k-1$ vertices are removed from the graph
- The **vertex connectivity** of a graph is the largest k such that the graph is k-vertex-connected
    - The vertex connectivity of a graph $G$ is denoted $κ(G)$
![[image 20 10.png|image 20 10.png]]
**k-edge-connected graph**
- An undirected graph $G$ is **k-edge-connected** if removing any $k-1$ or fewer edges results in a connected graph
- The **edge connectivity** of a graph is the largest k such that the graph is k-edge-connected
    - The edge connectivity of a graph $G$ is denoted $λ(G)$
![[image 21 10.png|image 21 10.png]]
  
# 12.6
## Euler Circuits and Trails
- An **Euler Circuit** in an undirected graph is a circuit that contains every edge and every vertex
- A circuit, by definition, has no repeated edges, so an Euler circuit contains each edge exactly once
![[image 22 10.png|image 22 10.png]]
- Odd degree vertex implies no Euler circuit
![[image 23 9.png|image 23 9.png]]
### Finding an Euler Circuit and the Proof of Sufficient Conditions for an Euler Circuit
![[image 24 9.png|image 24 9.png]]
![[image 25 9.png|image 25 9.png]]
### Euler Trails
- An **Euler Trail** is an open trail that includes every edge and every vertex
- A trail, by definition, has no repeated edges, so an Euler trail contains each edge exactly once
    - In an open trail, the first and last vertices are not equal
![[image 26 8.png|image 26 8.png]]
  
# 12.7
## Hamiltonian Cycles and Paths
- A **Hamiltonian Cycle** in an undirected graph is a cycle that includes every vertex in the graph
- A cycle, by definition, has no repeated vertices or edges, except for the vertex that is the beginning and end of the cycle
    - Therefore, every vertex in the graph appears exactly once in a Hamiltonian cycle except the beginning and end
- A **Hamiltonian Path** in an undirected graph is a path that includes every vertex in the graph
    - A path, by definition, has no repeated vertices or edges, so every vertex appears exactly once in a Hamiltonial path
![[image 27 8.png|image 27 8.png]]
  
# 12.8
## Planar Graphs
- An **embedding** for $G = (V, E)$ is an assignment of the vertices to points in the plane and an assignment of each edge to a continuos curve
- The curve for each edge must start and end at the two points corresponding to the endpoints of the edge
**Two Embeddings of the Same Graph**
![[image 28 8.png|image 28 8.png]]
- An embedding is a **planar embedding** if none of the edges cross
- There is a **crossing** between two edges in an embedding if their curves intersec at a point that is not a common endpoint
![[image 29 8.png|image 29 8.png]]
  
# 12.9
## Graph Coloring
![[image 30 7.png|image 30 7.png]]