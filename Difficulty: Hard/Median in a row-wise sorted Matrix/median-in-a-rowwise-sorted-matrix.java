class Solution {
    //public int median(int[][] mat) {
        // code here
        private int countSmallerEqual(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int median(int matrix[][]) {
        int R = matrix.length;
        int C = matrix[0].length;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            minVal = Math.min(minVal, matrix[i][0]);
            maxVal = Math.max(maxVal, matrix[i][C - 1]);
        }

        int desired = (R * C + 1) / 2;

        while (minVal < maxVal) {
            int mid = (minVal + maxVal) / 2;
            int count = 0;

            for (int i = 0; i < R; i++) {
                count += countSmallerEqual(matrix[i], mid);
            }

            if (count < desired)
                minVal = mid + 1;
            else
                maxVal = mid;
        }

        return minVal;

     }
}