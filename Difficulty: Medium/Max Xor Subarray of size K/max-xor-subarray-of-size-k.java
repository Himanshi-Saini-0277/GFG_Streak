class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int xor=0,max=0;
        for(int i=0;i<k;i++){
            xor^=arr[i];
        }
        max=xor;
        for(int i=k;i<arr.length;i++){
            xor^=arr[i];
            xor^=arr[i-k];
            max=Math.max(max,xor);
        }
        return max;
    }
}
