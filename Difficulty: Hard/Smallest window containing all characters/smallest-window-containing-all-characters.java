class Solution {
    public String minWindow(String s, String p) {
        if (p.length() > s.length()) return "";
        
        int[] freq = new int[26];
        
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int left = 0;
        int count = p.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int right = 0; right < s.length(); right++) {
            
            if (freq[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            
            freq[s.charAt(right) - 'a']--;
            
            while (count == 0) {
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                freq[s.charAt(left) - 'a']++;
                
                if (freq[s.charAt(left) - 'a'] > 0) {
                    count++;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}