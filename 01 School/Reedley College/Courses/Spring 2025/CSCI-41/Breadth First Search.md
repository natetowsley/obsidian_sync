#### Class: [[!!Programming Concepts and Methodology II (C++)]]
#### Tags : #ComputerScience #ComputerScience/DataStructuresAndAlgorithms 
#### Date: 05/13/2025
---
## Breadth First Traversal
- **Breadth first traversal** of a graph
    - Similar to traversing a binary tree level by level
    - Nodes at each level are visited from left to right
- Starting at the first vertex, the graph is traversed as much as possible
    - The next to next vertex not yet visited
- Use a queue to implement the breadth first search algorithm
![[image 7 22.png|image 7 22.png]]
- Breadth-first ordering of vertices:
    - 0, 1, 3, 4, 2, 5, 7, 8, 6, 9
![[Pasted image 20250513191756.png]]
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
---
# References
1. [[Graphs]]