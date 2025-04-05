//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int res = 0;
        if(grid==null||grid.length==0)
        return res;
        
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(!vis[i][j] && grid[i][j] =='L')
                {
                    dfs(grid,i,j,vis);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][]grid,int i,int j,boolean[][]vis)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        return;
        
        if(vis[i][j] || grid[i][j] != 'L')
        return;
        
        vis[i][j] = true;
        dfs(grid,i-1,j-1,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i-1,j+1,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i+1,j+1,vis);
        dfs(grid,i+1,j,vis);
        dfs(grid,i+1,j-1,vis);
        dfs(grid,i,j-1,vis);
    }
}