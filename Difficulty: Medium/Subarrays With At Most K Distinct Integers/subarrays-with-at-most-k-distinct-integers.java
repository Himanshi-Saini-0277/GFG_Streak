class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int r = 0,  l = 0, n = arr.length, count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(;r<n; r++){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            for(;hm.size()>k && l<r; l++){
                hm.put(arr[l],hm.get(arr[l])-1);
                if(hm.get(arr[l]) == 0){
                    hm.remove(arr[l]);
                }
            }
            
            count += r - l + 1;
        }
        
        return count;
    }
}
