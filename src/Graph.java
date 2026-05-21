import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Edge(from, to, weight));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjList.getOrDefault(vertex, new ArrayList<>())) {
                int neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
            int neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int numVertices = adjList.size();
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < numVertices; i++) {
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && distances[v] < minDistance) {
                    minDistance = distances[v];
                    minVertex = v;
                }
            }

            if (minVertex == -1) break;

            visited[minVertex] = true;

            for (Edge edge : adjList.getOrDefault(minVertex, new ArrayList<>())) {
                int neighbor = edge.getDestination();
                if (!visited[neighbor]) {
                    int currentDist = distances[minVertex] + edge.getWeight();
                    if (currentDist < distances[neighbor]) {
                        distances[neighbor] = currentDist;
                    }
                }
            }
        }

        System.out.println("\n Dijkstra Shortest Paths from node " + start);
        for (int i = 0; i < numVertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("To node " + i + " -> Unreachable");
            } else {
                System.out.println("To node " + i + " -> Shortest Distance: " + distances[i]);
            }
        }
    }

    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}