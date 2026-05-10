# Assignment 4: Graph Traversal and Representation System

## A. Project Overview
This project implements a Graph data structure using an **Adjacency List** representation in Java. The system supports the creation of directed graphs and provides implementations for two fundamental traversal algorithms: **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**.

* **Vertices**: Represent unique nodes in the graph, each identified by a unique ID.
* **Edges**: Represent directed connections between a source and a destination vertex.
* **Traversals**: Used to systematically visit every node for analysis or pathfinding.

## B. Class Descriptions
The project follows a modular Object-Oriented architecture:
1.  **Vertex.java**: Represents a node with a private unique identifier `id`.
2.  **Edge.java**: Represents a connection between a starting `source` vertex and an ending `destination` vertex.
3.  **Graph.java**: The core class managing the adjacency list structure. It handles adding vertices, adding edges, and executing traversal algorithms.
4.  **Experiment.java**: A utility class designed to handle the execution of tests and analyze performance.

## C. Algorithm Descriptions

### Breadth-First Search (BFS)
* **Logic**: Explores the graph level by level, starting from a specific node. It utilizes a queue to track nodes to visit.
* **Use Cases**: Shortest path in unweighted graphs and peer-to-peer networking.
* **Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.

### Depth-First Search (DFS)
* **Logic**: Explores as far as possible along each branch before backtracking. This implementation typically uses recursion.
* **Use Cases**: Cycle detection and topological sorting.
* **Complexity**: O(V + E).

## D. Experimental Results
Based on the program execution, the following performance data was recorded:

| Graph Size | BFS Time (ns) | DFS Time (ns) |
| :--- | :--- | :--- |
| **Small (10 vertices)** | 3,729,400 | 425,700 |
| **Medium (30 vertices)** | 691,000 | 818,500 |
| **Large (100 vertices)** | 2,794,300 | 2,339,700 |

### Observations and Patterns:
* **Scalability**: As the number of vertices and edges increases, execution time generally grows, showing a correlation with the O(V + E) complexity.
* **Initialization**: The higher BFS time on the small graph is likely due to the overhead of Java structure initialization during the first execution run.

## E. Analysis Questions
* **How does graph size affect BFS and DFS performance?** Execution time increases as the number of vertices and edges grows.
* **Which traversal is faster in your experiments?** In the large-scale test, DFS was slightly faster than BFS.
* **Do results match the expected complexity O(V+E)?** Yes, the results show a linear relationship between the graph size and processing time.
* **When is BFS preferred over DFS?** BFS is preferred when seeking the shortest path between nodes.
* **What are the limitations of DFS?** DFS can struggle with extremely deep graphs, potentially leading to stack overflow errors in recursive implementations.

## F. Reflection
Through this assignment, I learned how to represent complex relationships using an adjacency list and how to implement standard traversal algorithms. A key takeaway was seeing the practical difference between the "wide" search of BFS and the "deep" search of DFS. The main challenge was ensuring the performance measurements using `nanoTime()` were consistent across multiple runs.

## G. Screenshots
<img width="1919" height="1029" alt="Screenshot 2026-05-10 220421" src="https://github.com/user-attachments/assets/01dcd257-5051-4d28-a87a-5b0788e065d8" />
<img width="1914" height="1033" alt="Screenshot 2026-05-10 220357" src="https://github.com/user-attachments/assets/7236ae5d-99b6-4e01-9069-8ad4e384dc54" />

1.  **Graph structure output**: Verification of the adjacency list creation.
2.  **BFS/DFS traversal order**: The sequence of visited nodes for the small graph.
3.  **Performance results**: The final console output showing execution times for all sizes.
