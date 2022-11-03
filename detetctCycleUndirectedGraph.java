import java.util.*;

public class detetctCycleUndirectedGraph {
    public static void main(String[] args) {
        
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj , int v){
        boolean vis[] = new boolean[v];
        for(int i = 0; i < v ; i++){
            if(vis[i] == false){
                // function call; 
            }
        }
        return false;
    }
    static boolean DFS(ArrayList<ArrayList<Integer>> adj , int src , boolean[] vis , int parent){
        vis[src] = true;
        for(int node : adj.get(src)){
            if(vis[node] == false){
                if(DFS(adj , node , vis ,  src)){
                    return true;
                }else if(node != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
