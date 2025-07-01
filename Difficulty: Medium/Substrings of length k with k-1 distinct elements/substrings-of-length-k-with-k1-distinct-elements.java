class Solution {
    public int substrCount(String s, int k) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < k; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(map.keySet().size() == k - 1)
            ans++;
        for(int i = k; i < s.length(); i++){
            if(map.containsKey(s.charAt(i-k))){
                if(map.get(s.charAt(i-k)) == 1){
                    map.remove(s.charAt(i-k));
                }else{
                    map.put(s.charAt(i-k),map.get(s.charAt(i-k))-1);
                }
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.keySet().size() == k - 1)
            ans++;
        }
        return ans;
    }
}