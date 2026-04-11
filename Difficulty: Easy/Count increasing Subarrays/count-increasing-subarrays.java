class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int n = arr.length;
        
        long totalSubArr = 0;
        long ans = 0;
        long incEleCount = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > arr[i-1]){
                incEleCount++;
            }else{
                totalSubArr = (incEleCount * (incEleCount + 1)) / 2;
                ans += (totalSubArr - incEleCount);
                incEleCount = 1;
            }
        }
        totalSubArr = (incEleCount * (incEleCount + 1)) / 2;
        ans += (totalSubArr - incEleCount);
        
        return (int)ans;
    }
}
