import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        Graph g = new Graph();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size; i++) {
            g.addEdge(i, rand.nextInt(size), rand.nextInt(10) + 1);
            g.addEdge(i, rand.nextInt(size), rand.nextInt(10) + 1);
        }

        System.out.println("Graph Structure with Weights:");
        g.printGraph();

        System.out.print("\nBFS Order: ");
        g.bfs(0);

        System.out.print("DFS Order: ");
        g.dfs(0);

        g.dijkstra(0);
    }
}