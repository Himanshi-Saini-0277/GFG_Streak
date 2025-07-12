class Solution {
    public int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int maxGold = mat[i][j + 1];
                
                if (i > 0) {
                    maxGold = Math.max(maxGold, mat[i - 1][j + 1]);
                }
                
                if (i < n - 1) {
                    maxGold = Math.max(maxGold, mat[i + 1][j + 1]);
                }
                
                mat[i][j] += maxGold;
            }
        }
        
        int maxGoldCollected = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGoldCollected = Math.max(maxGoldCollected, mat[i][0]);
        }
        
        return maxGoldCollected;
    }
}