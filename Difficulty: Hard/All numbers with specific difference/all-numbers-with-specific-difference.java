class Solution {
    long getCount(int n, int d) {
        long l = 1, r = n, ans = -1;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long sum = 0, x = m;

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            if (m - sum >= d) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans == -1 ? 0 : n - ans + 1;
    }
};