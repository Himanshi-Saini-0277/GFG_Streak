class Solution {
    public int minMen(int arr[]) {
        // code here
        int n = arr.length;

        int coveredTill = 0;
        int count = 0;

        while (coveredTill < n) {
            int farthest = coveredTill;

            for (int i = 0; i < n; i++) {
                if (arr[i] == -1) continue;

                int start = Math.max(0, i - arr[i]);
                int end   = Math.min(n - 1, i + arr[i]);

                if (start <= coveredTill) {
                    farthest = Math.max(farthest, end + 1);
                }
            }

            if (farthest == coveredTill) {
                return -1;
            }

            coveredTill = farthest;
            count++;
        }

        return count;
    }
}