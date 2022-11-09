/*
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color 
as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. 
Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */


public class L9floodFill {
    public static void main(String[] args) {
        int[][] image = {
                { '1', '1', '1', },
                { '1', '1', '0', },
                { '1', '0', '1', }
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, image[sr][sc], vis);
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] image, int i, int j, int color, int currColor, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != currColor
                || vis[i][j] == true) {
            return;
        }
        vis[i][j] = true;
        image[i][j] = color;
        dfs(image, i + 1, j, color, currColor, vis);
        dfs(image, i - 1, j, color, currColor, vis);
        dfs(image, i, j - 1, color, currColor, vis);
        dfs(image, i, j + 1, color, currColor, vis);
    }
}
