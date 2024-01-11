import java.util.*;

public class Dijkstra{
    static class Graph {
        int V;
        List<Edge>[] adjList;

        Graph(int vertices) {
            V = vertices;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int source, int destination, int weight) {
            adjList[source].add(new Edge(destination, weight));
            adjList[destination].add(new Edge(source, weight)); // For undirected graph
        }
    }

    static class Edge {
        int destination, weight;

        Edge(int dest, int wt) {
            destination = dest;
            weight = wt;
        }
    }

    static void dijkstra(Graph graph, int source) {
        int[] distances = new int[graph.V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        minHeap.offer(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();

            for (Edge neighbor : graph.adjList[current.destination]) {
                int newDistance = distances[current.destination] + neighbor.weight;
                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    minHeap.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < graph.V; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        for (int i = 0; i < E; i++) {
            System.out.print("Enter source, destination, and weight for edge " + (i + 1) + ": ");
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.print("Enter the source vertex: ");
        int sourceVertex = sc.nextInt();

        dijkstra(graph, sourceVertex);
        
    }
}
