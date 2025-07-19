class Solution {
    public int vowelCount(String s) {
        // code here
        HashMap<Character, Integer> m = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                m.put(ch, m.getOrDefault(ch, 0) + 1);
            }
        }

        int factor = 1;
        int factorial = 1;
        int k = 1;

        for (int val : m.values()) {
            factor *= val;
            factorial *= k++;
        }
        if(m.size() == 0) return 0;
        if(m.size() == 1 && factor == 1) return 1;

        return factor * factorial;
    }
}