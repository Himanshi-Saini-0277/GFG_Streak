class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i<k; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ans.add(map.size());
        int l =0;
        for(int i =k ; i<arr.length; i++){
            map.put(arr[l],map.get(arr[l])-1);
            if(map.get(arr[l])==0) map.remove(arr[l]);
            l++;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            ans.add(map.size());
        }
        return ans;
    }
}