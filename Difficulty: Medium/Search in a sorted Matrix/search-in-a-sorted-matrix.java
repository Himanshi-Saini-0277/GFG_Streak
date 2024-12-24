//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int startrow=0;
        int endrow=mat.length-1;
        
        
        while(startrow<=endrow)
        {
            int startcol=0;
            int endcol=mat[0].length-1;
            if(mat[startrow][startcol]<=x  && mat[startrow][endcol]>=x)
            {
               while(startcol<=endcol)
               {
                   int mid=(startcol+endcol)/2;
                   
                   if(mat[startrow][mid]==x)
                   {
                       return true;
                   }
                   else if(mat[startrow][mid]<x)
                   {
                       startcol=mid+1;
                   }
                   else
                   {
                       endcol=mid-1;
                   }
               }
               
            }
            startrow++;
        }
        return false;
    }
}
