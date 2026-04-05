class Solution {
    int solve(int i, vector<int>& arr, int target, vector<vector<int>>& dp){
        if (i >= arr.size()){
            return (target == 0);
        }
        if (dp[i][target+1000] != -1) return dp[i][target+1000];
        int ans = 0;
        ans += solve(i+1, arr, target-arr[i], dp);
        ans += solve(i+1, arr, target+arr[i], dp);
        return dp[i][target+1000] = ans;
    }
  public:
    int totalWays(vector<int>& arr, int target) {
        //  code here
        vector<vector<int>> dp(arr.size(), vector<int>(2001, -1));
        return solve(0, arr, target, dp);
    }
};