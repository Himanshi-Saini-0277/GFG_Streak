class Solution {
    public int maxSum(int arr[]) {
        // code here
        if(arr.length<2){
            return -1;
        }
        int maxSum=0;
        int i=0;
        int j=1;
        while (j<arr.length){
            int sum = arr[i]+arr[j];
            if(sum>maxSum){
                maxSum=sum;
            }
            i++;
            j++;
        }

        return maxSum;
    }
}