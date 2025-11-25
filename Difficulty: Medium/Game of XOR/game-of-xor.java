class Solution {
    public int subarrayXor(int[] arr) {
        // code here
        if(arr.length % 2 == 0)
            return 0;
        
        int xor = 0;
        
        for(int i = 0 ; i < arr.length; i += 2){
            xor ^= arr[i];
        }
        
        return xor;
    }
}