/*       Number of distinct island
 * Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s
 *  (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal
 *  to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
We have 2 equal islands, so we have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
.We have 4 islands, but 2 of themare equal, So we have 3 distinct islands.

 */



import java.util.*;
public class noOfDistinctIsland {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } };

        int n = grid.length;
        int m = grid[0].length;
        Set<String> distinct = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int baseRow = i;
                int baseCol = j;
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    StringBuilder ans = new StringBuilder();
                    dfs(i, j, baseRow, baseCol, vis, grid, ans);
                    distinct.add(ans.toString());
                }
            }
        }
        System.out.println(distinct.size());
    }

    public static void dfs(int i, int j, int baseRow, int baseCol, boolean[][] vis, int[][] grid, StringBuilder ans) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || vis[i][j] == true) {
            return;
        }
        vis[i][j] = true;
        ans.append(i - baseRow);
        ans.append(j - baseCol);

        dfs(i + 1, j, baseRow, baseCol, vis, grid, ans);
        dfs(i - 1, j, baseRow, baseCol, vis, grid, ans);
        dfs(i, j + 1, baseRow, baseCol, vis, grid, ans);
        dfs(i, j - 1, baseRow, baseCol, vis, grid, ans);
    }
}
