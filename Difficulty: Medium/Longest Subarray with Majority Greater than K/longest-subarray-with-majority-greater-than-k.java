class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            cnt += (arr[i] > k) ? 1 : -1;

            if (cnt > 0) {
                ans = i + 1;
            } else {
                if (map.containsKey(cnt - 1)) {
                    ans = Math.max(ans, i - map.get(cnt - 1));
                }
            }
            map.putIfAbsent(cnt, i);
        }
        return ans;
    }
}