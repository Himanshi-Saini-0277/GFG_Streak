class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0 , -1);
        int n = a1.length;
        int maxLen = 0;
        int s1 = 0;
        int s2 = 0;
        
        for(int i = 0 ; i < n ; i++){
            s1 += a1[i];
            s2 += a2[i];
            
            int diff = s2 - s1;
            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen , (i - map.get(diff)));
            }else{
                map.put(diff , i);
            }
        }
        
        return maxLen;
    }
}