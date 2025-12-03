class Solution {
    public int tsp(int[][] cost) {
        // code here
        int n = cost.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(cost, 1, 0, n, dp);

    }
   
    private int helper(int[][] cost, int mask, int city, int n, int[][] dp) {
        if (mask == (1 << n) - 1) {
            return cost[city][0];
        }
        if (dp[mask][city] != -1) return dp[mask][city];

        int ans = Integer.MAX_VALUE;
        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) == 0) { // if next city not visited
                int subProb = cost[city][next] + helper(cost, mask | (1 << next), next, n, dp);

                ans = Math.min(ans, subProb);
            }
        }
        return dp[mask][city] = ans;
    }
}