class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans += i - idx;
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int idx = st.pop();
            ans += n - idx;
        }

        return ans;
    }
}
