/*
        ************BFS OF GRAPH***************

 * Given a directed graph. The task is to do Breadth First Traversal of this
 * graph starting from 0.
 * Note: One can move from node u to node v only if there's an edge from u to v
 * and find the BFS traversal of the graph starting from the 0th vertex, from
 * left to right according to the graph. Also, you should only take nodes
 * directly or indirectly connected from Node 0 in consideration.
 */

 import java.util.*;
 public class BFS{
    public static void main(String[] args) {
        
    }

    // bfs of graph
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            
            for(int it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
 }