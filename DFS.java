/*
 *          ***********  DFS OF GRAPH ***************** 
 * You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th
 vertex from left to right according to the graph.
 */


import java.util.*;
public class DFS {
    public static void main(String[] args) {
        
    }

    /// SC - O(N)   TC - O(N) + O(E)
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0 , vis , adj  , ls);
        return ls;
    }
    public static void dfs(int node , boolean vis[] , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        for(int nodes : adj.get(node)){
            if(vis[nodes] == false){
                dfs(nodes , vis , adj , ls);
            }
        }
    }
}
