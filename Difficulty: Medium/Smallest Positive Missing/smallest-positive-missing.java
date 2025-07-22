class Solution {
    public int missingNumber(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
       int i=1;
        for(int val : arr){
            set.add(val);
        }
       while(!set.isEmpty()){
           if(!set.contains(i)){
               return i;
           }
           i++;
       }
        return -1;
    }
}
