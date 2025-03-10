//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        
         for(int i=0;i<=n;i++)
         {
          dp[i][0] = i;
         }
         for(int j=0;j<=m;j++)
         {
            dp[0][j] = j;
         }
         for(int i=1;i<=n;i++)
         {
             for(int j=1;j<=m;j++)
             {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                     dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])); 
                }
             }
         }
        return dp[n][m];
    }
}