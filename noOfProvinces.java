/*
                    ***** LEETCODE 547 : NUMBER OF PROVINCES  *********
There are n cities. Some of them are connected, while some are not. If city a is connected directly with 
city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are 
directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces. */

import java.util.*;

public class noOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // changing adjecency matrix to list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                count++;
                dfs(i, adj, vis);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int i : adj.get(node)) {
            if (vis[i] == false) {
                dfs(i, adj, vis);
            }
        }
    }
}
