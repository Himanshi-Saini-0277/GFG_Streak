class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int matSum=0;
        int maxRSum=0, maxCSum=0;
        
        for(int i=0; i<n; i++) {
            int iRSum=0, iCSum=0;
            for(int j=0; j<n; j++) {
                iRSum+=mat[i][j];
                
                iCSum+=mat[j][i];
                
                matSum+= mat[i][j];
            }
            maxRSum = Math.max(iRSum, maxRSum);
            maxCSum = Math.max(iCSum, maxCSum);
        }
        int max = Math.max(maxRSum, maxCSum);
        
        return (max*n)-matSum;
    }
}