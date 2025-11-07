class Solution {
    private int binarySearch(int idx,int target,int[][] jobs){
        int n=jobs.length, res=n;
        int s=idx, e=n-1;
        
        while(s<=e){
            int mid=s+(e-s)/2;
            if(jobs[mid][0]>=target){
                res=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        
        return res;
    }
    private int solve(int i, int[][] jobs, int[] dp){
        if(i>=jobs.length)return 0;
        if(dp[i]!=-1)return dp[i];
        
        int nextIdx = binarySearch(i+1,jobs[i][1],jobs);
        
        int take = jobs[i][2] + solve(nextIdx,jobs,dp);
        int notTake = solve(i+1,jobs,dp);
        
        return dp[i]=Math.max(take,notTake);
    }
    public int maxProfit(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        int[] dp=new int[jobs.length];
        Arrays.fill(dp,-1);
        
        return solve(0,jobs,dp);
    }
}
