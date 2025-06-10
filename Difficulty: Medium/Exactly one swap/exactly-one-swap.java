class Solution {
    int countStrings(String s) {
        // code here
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int ln = s.length();
        
        int ans = 0;
        for (int count : freqMap.values()) {
            ans += (count * (count - 1)) / 2;
        }

        int res = (ln * (ln - 1)) / 2 - ans;
        if (ans != 0) {
            res += 1;
        }

        return res;
    }
}