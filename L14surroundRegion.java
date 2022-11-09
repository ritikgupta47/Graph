/*
                        ***** LEETCODE 130 ; SURROUNDED REGION
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.

Example 2:

Input: board = [["X"]]
Output: [["X"]]
 */


// Just traverse through boundry check if there exists any 'O' mark all of its adjacent 'O' and following adjacents 'O' as '#' or whatever u want 
// the idea behind this logic is as it';s stated only O enclosed within 'X' from 4 sides can only be replaced with 'X' so if a 'O' is at boundry then it can't 
//be enclosed within 'X' as one side will always be open. 

/*
 The boundary elements in the matrix cannot be replaced with ‘X’ as they are not surrounded by ‘X’ from all 4 directions. This means if ‘O’ 
(or a set of ‘O’) is connected to a boundary ‘O’ then it can’t be replaced with ‘X’. 
The intuition is that we start from boundary elements having ‘O’ and go through its neighboring Os in 4 directions and mark them as visited to
 avoid replacing them with ‘X’. 
 */
public class L14surroundRegion {
    public static void main(String[] args) {
        char[][] a = {
            {'X' , 'X' , 'X', 'X'},
            {'X' , 'O' , 'O', 'X'},
            {'X' , 'X' , 'O', 'X'},
            {'X' , 'O' , 'X', 'X'}
        };
        int n = a.length;
        int m = a[0].length;
        //traverse first row
        for(int j = 0; j < m ; j++){
            //first row
            if(a[0][j] == 'O'){
                dfs(0,j,a);                
            }
            // second row
            if(a[n-1][j] == 'O'){
                dfs(n-1 , j , a);
            }
        }
        // traverse first col and last col
        for(int i = 0; i < n; i++){
            // first column
            if(a[i][0] == 'O'){
                dfs(i , 0 , a);
            }
            // last column
            if(a[i][m-1] == 'O'){
                dfs(i , m-1 , a);
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if( a[i][j] =='O'){
                    a[i][j] = 'X';
                }else if (a[i][j] == '#'){
                    a[i][j] = 'O';
                }
            }
        }
    }
    public static void dfs(int i , int j , char[][] a){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j] != 'O'){
            return;
        }
    
        a[i][j] = '#';
        dfs(i+1 , j , a);
        dfs(i-1 , j , a);
        dfs(i , j+1 , a);
        dfs(i , j-1 , a);
    }
}
