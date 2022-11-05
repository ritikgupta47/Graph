import java.util.*;
public class cycleInDirected {
    public static void main(String[] args) {
        
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] helper = new boolean[V];
        
        for(int i = 0 ; i < V; i++){
            if(vis[i] == false){
                if(dfs(adj , i , helper , vis) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj , int i , boolean[] vis , boolean[] helper){
        vis[i] = true;
        helper[i] = true;
        for(int k : adj.get(i)){
            if(helper[k] == true) return true;
            if(vis[k] == false){
                return dfs(adj, k, vis, helper);
            }
        }
        helper[i] = false;
        return false;
    }
}
