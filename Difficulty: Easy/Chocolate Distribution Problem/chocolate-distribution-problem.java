// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int n = arr.size() ;
        int nums[] = new int[n] ;
        
        int i = 0 ;
        for(int n1 : arr)
        {
            nums[i++] = n1 ;
        }
        
        Arrays.sort(nums) ;
        
        int left = 0 ;
        int currSum = 0 ;
        int minDiff = Integer.MAX_VALUE ;
        
        minDiff = nums[m - 1] - nums[left++] ;
        
        for(int right = m ; right < n ; right++)
        {
            minDiff = Math.min(minDiff , nums[right] - nums[left++]) ;
        }
        
        return minDiff ;
    }
}