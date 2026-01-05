class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int s=0;
        for(int i=0; i<k;i++){
            s+=arr[i];
        }
        int m=s;
        for(int i=k;i<arr.length;i++){
            s=s+arr[i]-arr[i-k];
            m=Math.max(m,s);
        }
        return m;
    }
}