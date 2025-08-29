class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        if (s.length() < p.length()) return "";

       
        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqS = new int[26];
        int start = 0, minLen = Integer.MAX_VALUE, startIndex = -1;
        int count = 0; 

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqS[c - 'a']++;

            
            if (freqP[c - 'a'] > 0 && freqS[c - 'a'] <= freqP[c - 'a']) {
                count++;
            }

            
            while (count == p.length()) {
               
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }

                
                char leftChar = s.charAt(start);
                freqS[leftChar - 'a']--;
                if (freqP[leftChar - 'a'] > 0 && freqS[leftChar - 'a'] < freqP[leftChar - 'a']) {
                    count--;
                }
                start++;
            }
        }

        if (startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc")); 
        System.out.println(smallestWindow("zoomlazapzo", "oza"));    
        System.out.println(smallestWindow("zoom", "zooe")); 
    }
}