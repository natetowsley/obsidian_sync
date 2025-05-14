#### Class: [[!!Programming Concepts and Methodology II (C++)]]
#### Tags : #ComputerScience #ComputerScience/DataStructuresAndAlgorithms 
#### Date: 05/13/2025
---
## Depth First Traversal
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
```C++
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
---
# References
1. [[Graphs]]