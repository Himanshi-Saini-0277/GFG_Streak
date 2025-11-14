class Solution {
    public static int mergeStones(int[] stones, int k) {
        // code here
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + stones[i];

        long[][] dp = new long[n][n];
        final long INF = Long.MAX_VALUE / 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dp[i][j] = 0L;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = INF;
                for (int m = i; m < j; m += (k - 1)) {
                    long left = dp[i][m];
                    long right = dp[m + 1][j];
                    if (left == INF || right == INF) continue;
                    dp[i][j] = Math.min(dp[i][j], left + right);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] = dp[i][j] == INF ? INF : dp[i][j] + (pref[j + 1] - pref[i]);
                }
            }
        }

        long ans = dp[0][n - 1];
        return ans >= INF ? -1 : (int) ans;
    }
}
