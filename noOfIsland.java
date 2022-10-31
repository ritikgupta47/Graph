/*            ****** LEETCODE 200 :  NUMBER OF ISLANDS
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all 
four edges of the grid are all surrounded by water.
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

public class noOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int row = 0; row < n ; row++){
            for(int col = 0; col < m ; col++){
                if(grid[row][col] == '1' && vis[row][col] == false){
                    count++;
                    dfs(row , col , grid , vis);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'
                || vis[row][col] == true) {
            return;
        }
        vis[row][col] = true;
        dfs(row + 1, col, grid, vis);
        dfs(row - 1, col, grid, vis);
        dfs(row, col + 1, grid, vis);
        dfs(row, col - 1, grid, vis);
    }
}
