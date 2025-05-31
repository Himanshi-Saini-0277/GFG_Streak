class Solution {
    public int kthSmallest(int[][] matrix, int l) {
        // code here
        int n=matrix[0].length;
        int k=0;
        int ans[]=new int[n*n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[k]=matrix[i][j];
                k++;
            }
        }
        Arrays.sort(ans);
        return ans[l-1];
    }
}