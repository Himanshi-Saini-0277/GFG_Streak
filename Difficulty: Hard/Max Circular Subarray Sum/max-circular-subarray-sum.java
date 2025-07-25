class Solution {
    public int maxCircularSum(int a[]) {
        // code here
        int min = 0, max = Integer.MIN_VALUE, total = 0, minSum = 0, maxSum = 0;
        for(int ele : a) {
            total += ele;
            minSum += ele;
            maxSum += ele;

            min = Math.min(min, minSum);
            if(minSum > 0) minSum = 0;
            max = Math.max(max, maxSum);
            if(maxSum < 0) maxSum = 0;
        }
        
        if(max < 0) return max;
        return Math.max(max, (total - min));
    }
}
