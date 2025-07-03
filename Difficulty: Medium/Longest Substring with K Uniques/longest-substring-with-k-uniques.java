class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int max=-1;
        int st=0;
        int i=1;
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        char[] ch=s.toCharArray();
        hm.put(ch[0],1);
        while(i<n){
            if(hm.containsKey(ch[i]))
            hm.put(ch[i],hm.getOrDefault(ch[i],0)+1);
            else if(hm.size()<k)
            hm.put(ch[i],hm.getOrDefault(ch[i],0)+1);
            else{
                max=Math.max(max,i-st);
                while(hm.size()==k){
                    hm.put(ch[st],hm.get(ch[st])-1);
                    if(hm.get(ch[st])==0) hm.remove(ch[st]);
                    st++;
                }
                hm.put(ch[i],hm.getOrDefault(ch[i],0)+1);
            }
            i++;

        }
        if(hm.size()==k) max=Math.max(max,i-st);
        return max;
    }
}