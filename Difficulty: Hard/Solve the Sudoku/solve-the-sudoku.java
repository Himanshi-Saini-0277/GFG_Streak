//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static void solveSudoku(int[][] mat) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] grids = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = mat[i][j];
                if (num != 0) {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    grids[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        solve(mat, rows, cols, grids);
    }

    static boolean isValid(int row, int col, int num, boolean[][] rows, boolean[][] cols, boolean[][] grids) {

        return !rows[row][num] && !cols[col][num] && !grids[(row / 3) * 3 + (col / 3)][num];
    }

    static boolean solve(int[][] mat, boolean[][] rows, boolean[][] cols, boolean[][] grids) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num, rows, cols, grids)) {
                            mat[row][col] = num;

                            rows[row][num] = true;
                            cols[col][num] = true;
                            grids[(row / 3) * 3 + (col / 3)][num] = true;

                            if (solve(mat, rows, cols, grids)) {
                                return true;
                            }

                            mat[row][col] = 0;
                            rows[row][num] = false;
                            cols[col][num] = false;
                            grids[(row / 3) * 3 + (col / 3)][num] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}