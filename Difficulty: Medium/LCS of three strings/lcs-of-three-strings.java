class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        int[][][] dp = new int[n+1][m+1][l+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    char c1 = s1.charAt(i - 1);
                    char c2 = s2.charAt(j - 1);
                    char c3 = s3.charAt(k - 1);

                    if (c1 == c2 && c2 == c3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k],
                                     dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }
        return dp[n][m][l];
    }
}