class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int sum = 0, fact = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - '0') * (i + 1) * fact;
            fact = 10 * fact + 1;
        }
        return sum;
    }
}