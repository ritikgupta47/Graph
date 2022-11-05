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
    /*
     * Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
Initialize a color[] array for each node. Here are three states for colors[] array:
0: Haven't been colored yet.
1: Blue.
-1: Red.
For each node,

If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
If it has been colored, check if the current color is the same as the color that is going to be used to color it. 
     */
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
