class Solution {
    private int MAX = Integer.MAX_VALUE;
    public int cuts(String s) {
        // code here
        int n = s.length();
        if (s.charAt(0) == '0' || s.charAt(n - 1) == '0')   return -1;
        int res = solve(s, n - 1, n - 1, n, 0);
        if (res == MAX) return -1;
        return res;
    }

    private int solve(String s, int curr, int last, int n, int no) {
        if (curr == -1) {
            if (last == -1) return 0;
            return checkPower(no) ? 1 : MAX;
        }
        if (s.charAt(last) == '0')  return MAX;
        int take = MAX, nottake = MAX;
        int nextNo = no + (s.charAt(curr) == '1' ? 1 : 0) * (int)Math.pow(2, last - curr);

        if (s.charAt(curr) == '1' && checkPower(nextNo)) {
            int rem = solve(s, curr - 1, curr - 1, n, 0);
            if (rem != MAX) {
                take = 1 + rem;
            }
        }
        nottake = solve(s, curr - 1, last, n, nextNo);
        return Math.min(take, nottake);
    }
    
    private boolean checkPower(int no) {
        if (no == 1)    return true;
        if (no % 5 != 0)    return false;
        return checkPower(no / 5);
    }
}
