import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testGraphBySize(10, "Small");
        testGraphBySize(30, "Medium");
        testGraphBySize(100, "Large");
    }

    private static void testGraphBySize(int size, String label) {
        Graph g = new Graph();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }


        for (int i = 0; i < size; i++) {
            g.addEdge(i, rand.nextInt(size));
            g.addEdge(i, rand.nextInt(size));
        }

        Experiment.runTraversals(g, 0, label);
    }
}