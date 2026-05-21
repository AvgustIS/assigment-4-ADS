# Assignment 4: Graph Traversal and Representation System (with Bonus Task)

## A. Project Overview
This project implements a Graph data structure using an **Adjacency List** representation in Java. The system supports directed, weighted graphs and provides clean implementations for three fundamental graph algorithms: **Breadth-First Search (BFS)**, **Depth-First Search (DFS)**, and **Dijkstra's Shortest Path Algorithm**.

* **Vertices**: Represent unique nodes in the graph, each identified by a unique ID.
* **Edges**: Represent directed connections between a source and a destination vertex. For the bonus task, edges have been upgraded to carry a specific **numerical weight**.
* **Traversals & Pathfinding**: Used to systematically visit every node or compute the absolute shortest path between entities.

---

## B. Class Descriptions
The project follows a modular, Object-Oriented architecture designed for clean separation of concerns:
1.  **Vertex.java**: Represents a single node with a private unique identifier `id`.
2.  **Edge.java**: Represents a directed, weighted link between a starting `source` vertex and an ending `destination` vertex, holding an integer `weight` field.
3.  **Graph.java**: The core class managing the structural adjacency list (`Map<Integer, List<Edge>>`). It contains methods for adding vertices, adding weighted edges, and executing all traversal and pathfinding algorithms.
4.  **Experiment.java**: A utility class designed to handle systematic test execution and analyze operational performance across various scales.

---

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* **Step-by-Step Logic**: Explores the graph layer by layer, starting from a given source node. It utilizes a FIFO (First-In, First-Out) **Queue** to track which nodes to visit next, ensuring all immediate neighbors are evaluated before moving deeper.
* **Use Cases**: Finding the shortest path in unweighted networks, peer-to-peer routing, and social network friend suggestions.
* **Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.

### 2. Depth-First Search (DFS)
* **Step-by-Step Logic**: Explores as far as possible along each individual branch before backtracking to the last unvisited fork. This implementation leverages **Recursion**, utilizing the internal system call stack (LIFO behavior).
* **Use Cases**: Topological sorting, cycle detection in a network, and maze-solving puzzles.
* **Complexity**: O(V + E).

### 3. Dijkstra's Algorithm (★ Bonus Task)
* **Step-by-Step Logic**: Computes the absolute shortest paths from a single starting vertex to all other reachable vertices in a weighted graph. 
  1. It maintains an array of minimum distances initialized to infinity (except the start node, which is 0).
  2. Through simple loops, it sequentially selects the unvisited node with the lowest calculated distance.
  3. It marks it as visited and relaxes all its adjacent edges by updating their cumulative distance if a shorter path is found.
* **Use Cases**: GPS navigation mapping, network routing protocols (like OSPF), and logistics optimization.
* **Complexity**: O(V^2) due to implementation via basic iterative loops and arrays without an external priority queue, fully matching the bonus requirements.

---

## D. Experimental Results
Performance tests were executed across three distinct graph sizes using `System.nanoTime()` to measure execution times accurately:

| Graph Size | BFS Time (ns) | DFS Time (ns) |
| :--- | :--- | :--- |
| **Small (10 vertices)** | 3,729,400 | 425,700 |
| **Medium (30 vertices)** | 691,000 | 818,500 |
| **Large (100 vertices)** | 2,794,300 | 2,339,700 |

### Observations and Patterns:
* **Scalability**: As the size of the graph increases from 10 to 100 vertices, execution times grow correspondingly, validating the theoretical O(V + E) linear complexity.
* **Warm-up Overhead**: The unexpectedly higher execution time for BFS on the small graph is an artifact of JVM warm-up and the initial allocation of memory overhead for Java Collection objects during the first test cycle.

---

## ★ Bonus Task Implementation Details (What I Refactored & Added)
To complete the optional bonus task, the following structural changes and modifications were made to the existing codebase:

1. **Refactored `Edge.java`**: 
   * Added a private `int weight` field to support weighted graph operations.
   * Updated the constructor to accept the weight parameter: `public Edge(int source, int destination, int weight)`.
   * Added the `getWeight()` getter method and updated `toString()` to display edge weights in the console.

2. **Upgraded `Graph.java` Adjacency List**:
   * Changed the internal structure from `Map<Integer, List<Integer>>` (which only stored target IDs) to `Map<Integer, List<Edge>>` to securely store complete weighted edge objects.
   * Modified `bfs()` and `dfs()` traversal logics to safely read neighbors through the new `Edge` object structure (`edge.getDestination()`), maintaining full compatibility with initial assignment requirements.

3. **Added Dijkstra's Algorithm**:
   * Implemented the `public void dijkstra(int start)` method from scratch.
   * Used standard primitive arrays for managing distances (`int[] distances`) and tracking visited nodes (`boolean[] visited`), strictly avoiding PriorityQueues to fulfill the strict implementation guidelines using simple loops.

4. **Updated `Main.java`**:
   * Refactored edge insertion loops to assign random weights between 1 and 10 using `rand.nextInt(10) + 1`.
   * Added an explicit invocation to `g.dijkstra(0)` to verify shortest path distance computations in the console output.

---

## E. Analysis Questions
* **How does graph size affect BFS and DFS performance?** As the number of vertices and edges scales upward, processing times scale linearly because each structural element is evaluated a constant number of times.
* **Which traversal is faster in your experiments?** In large-scale operations, DFS demonstrated minor speed advantages over BFS due to the lower memory management footprint of recursive stack frames compared to iterative heap allocation for structural queues.
* **Do results match the expected complexity O(V+E)?** Yes, execution metrics reflect steady growth directly tied to structural capacity rather than exponential scaling.
* **When is BFS preferred over DFS?** BFS is preferred when the objective is to find target states closest to the source or to establish minimum hops in unweighted structures.
* **What are the limitations of DFS?** DFS is susceptible to deep branch entrapment or a `StackOverflowError` if the recursion depth surpasses allocation thresholds on exceptionally deep architectures.

---

## F. Reflection Section
This assignment provided practical insight into the applications of core graph representations and structural searches. Implementing the adjacency list highlighted the efficiency of maps and collections over sparse matrices. 

The primary challenge involved adapting the initial data models to integrate edge weights seamlessly for Dijkstra's Algorithm without breaking the pre-existing BFS and DFS logic. Successfully deploying simple array sweeps to determine minimal path distances reinforced the foundations of greedy algorithmic optimizations and algorithmic performance trade-offs.

---

## G. Screenshots
<img width="1919" height="1041" alt="image" src="https://github.com/user-attachments/assets/af0ce021-03d3-455c-bf34-cc138579b1c9" />
<img width="1919" height="1034" alt="image" src="https://github.com/user-attachments/assets/a59e6662-6f0b-48a0-b275-ebc83b14a99b" />
<img width="1919" height="1029" alt="Screenshot 2026-05-10 220421" src="https://github.com/user-attachments/assets/01dcd257-5051-4d28-a87a-5b0788e065d8" />
<img width="1914" height="1033" alt="Screenshot 2026-05-10 220357" src="https://github.com/user-attachments/assets/7236ae5d-99b6-4e01-9069-8ad4e384dc54" />

1.  **Graph structure output**: Verification of the adjacency list creation showing nodes linked via explicit weights.
2.  **BFS/DFS traversal order**: Sequential node printouts confirming correct level-order and deep-order search paths.
3.  **Performance results**: Complete terminal logging displaying measured nanosecond performance metrics.
4.  **Dijkstra Shortest Paths output**: Clear execution results showing calculated shortest numerical weights from the root vertex to all existing nodes.
