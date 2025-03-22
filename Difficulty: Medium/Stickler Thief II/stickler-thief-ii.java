//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
        // code here
    int stealing(int ind, int arr[], int dp[], int start) {
        if (ind < start) return 0;

        if (dp[ind] != -1) return dp[ind];

        int notsteal = stealing(ind - 1, arr, dp, start);
        int steal = arr[ind] + stealing(ind - 2, arr, dp, start);

        return dp[ind] = Math.max(notsteal, steal);
    }

    int maxValue(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0]; 

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int case1 = stealing(n - 2, arr, dp1, 0);
        int case2 = stealing(n - 1, arr, dp2, 1);

        return Math.max(case1, case2);
    }
}
