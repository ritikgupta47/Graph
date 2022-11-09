/*
 *  LINK -- https://takeuforward.org/data-structure/topological-sort-using-dfs/
 * 
 *  It means linear ordering of vertices such that there is an edge u—-> v, u appears before v in the ordering. 
 */


import java.util.*;
public class L21topoDFS {
    public static void main(String[] args) {
        
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        int[] ans = new int[V];
        int count = 0;
        while (!st.isEmpty()) {
            ans[count] = st.pop();
            count++;
        }
        return ans;
    }

    private static void dfs(int i, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;
        for (int node : adj.get(i)) {
            if (vis[node] == 0) {
                dfs(node, vis, st, adj);
            }
        }
        st.push(i);
    }
}
