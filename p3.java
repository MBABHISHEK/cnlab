import java.util.*;

public class BellmanFordAlgorithm {

    static final int INF = Integer.MAX_VALUE;

    public static void bellmanFord(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        printArr(dist, V);
    }

    public static void printArr(int[] dist, int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF VERTICES\n");
        int n=sc.nextInt();
         System.out.println("ENTER THE Graph\n");
          int [][]graph=new int[n][n];

          for (int i=0; i<n; i++) 
          {
            for (int j=0; j<n; j++) 
              graph[i][j]=sc.nextInt();

          }

        bellmanFord(graph, 0);
    }
}
