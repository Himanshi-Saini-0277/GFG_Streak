class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        int[] freq = new int[1_000_001];
        
        for(int a : arr) freq[a]++;
        int idx = 0, n = arr.length;
        
        for(int i = 0; i < freq.length; i++){
            while(freq[i] != 0 && idx < n){
                arr[idx] = i;
                freq[i]--;
                idx++;
            }
            if(idx == n) break;
        }
    }
}
