public class Experiment {

    public static void runTraversals(Graph g, int startNode, String sizeLabel) {
        System.out.println("\n Testing " + sizeLabel + " Graph ");

        long startTime = System.nanoTime(); // [cite: 68]
        System.out.print("BFS Order: ");
        g.bfs(startNode);
        long endTime = System.nanoTime(); // [cite: 69]
        long bfsDuration = endTime - startTime;

        startTime = System.nanoTime();
        System.out.print("\nDFS Order: ");
        g.dfs(startNode);
        endTime = System.nanoTime();
        long dfsDuration = endTime - startTime;

        System.out.println("\nBFS Time: " + bfsDuration + " ns");
        System.out.println("DFS Time: " + dfsDuration + " ns");
    }
}