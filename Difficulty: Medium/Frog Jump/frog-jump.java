class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if (n == 1) return 0;
        
        int prev2 = 0;
        int prev1 = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++) {
            int jumpOne = prev1 + Math.abs(height[i] - height[i - 1]);
            int jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}