class Solution {
    int distinctSubseq(String str) {
        // code here
        int mod = 1000000007;
        int n = str.length();
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            
            dp[i] = (dp[i-1] * 2) % mod;
            
            char ch = str.charAt(i-1);
            
            if(map.containsKey(ch)){
                dp[i] = (dp[i] - dp[ map.get(ch) ] + mod) % mod;
            }
            
            map.put(ch, i-1);
        }
        
        return dp[n];
    }
}