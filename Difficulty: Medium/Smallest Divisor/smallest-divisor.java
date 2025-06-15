class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        int n = arr.length;
        int start = 1;
        int end = arr[n-1];
        int ans = Integer.MAX_VALUE;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            int sum = getSum(arr,mid);
            
            if(sum > k){
                start = mid + 1;
            }
            else{
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    private int getSum(int[] arr, int div){
        
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            sum += (int)Math.ceil((double)arr[i]/div);
        }
        
        return sum;
    }
}