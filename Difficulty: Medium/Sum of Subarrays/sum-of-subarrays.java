class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n=arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i] * (i + 1) * (n - i);
        return sum;
    }
}
