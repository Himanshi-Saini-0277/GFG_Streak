class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s1.length();i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(hm.containsKey(a)){
                if(hm.get(a) != b)
                return false;
            }
            else{
                if(!hs.add(b))
                return false;
                hm.put(a, b);
            }
        }
        
        return true;
    }
}