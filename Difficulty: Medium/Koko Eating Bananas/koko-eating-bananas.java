class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int left = 1;
        int right = getMax(arr);
        int result = right;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canFinish(arr, k, mid)){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canFinish(int[] arr, int k, int speed){
        int hours = 0;
        for(int pile : arr){
            hours += (pile + speed - 1) / speed;
        }
        
        return hours <= k;
    }
    
    private int getMax(int[] arr){
        int max = 0;
        for(int num : arr){
            max = Math.max(max, num);
        }
        
        return max;
    }
}
