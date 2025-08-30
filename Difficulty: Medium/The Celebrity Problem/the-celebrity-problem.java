class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(mat, a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(mat, candidate, i) || !knows(mat, i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    private boolean knows(int[][] mat, int i, int j) {
        return mat[i][j] == 1;
    }
}