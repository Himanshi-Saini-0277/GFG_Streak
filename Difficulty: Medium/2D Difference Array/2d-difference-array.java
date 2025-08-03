class Solution {
    public static void helper(int[][] mat , int v , int r1 , int c1 , int r2 , int c2){
        
        for(int i = r1 ; i<=r2 ; i++){
            for(int j = c1 ; j<=c2 ; j++){
                mat[i][j] += v ; 
            }
        }
    }
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0 ; i<opr.length ; i++){
            helper(mat,opr[i][0],opr[i][1],opr[i][2],opr[i][3],opr[i][4]);
        }
        
        for(int i = 0 ; i<mat.length ; i++){
           ArrayList<Integer> a = new ArrayList<>();
           for(int j = 0 ; j<mat[0].length ;j++){
               a.add(mat[i][j]);
           }
           ans.add(new ArrayList<>(a));
        }
        
        return ans ; 
    }
}