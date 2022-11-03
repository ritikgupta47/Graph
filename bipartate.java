import java.util.*;

public class bipartate {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 },
                { 0, 2 },
                { 0, 1, 3 },
                { 0, 2 } };

        System.out.println(isBipartite(graph));
    }
    // bfs
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int it : graph[node]) {
                        if (color[it] == 0) {
                            q.add(it);
                            color[it] = -color[node];
                        } else if (color[it] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
