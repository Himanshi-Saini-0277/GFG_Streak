class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        ArrayList<Integer> row=new ArrayList<>();
        ArrayList<Integer> col=new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int k=0;k<row.size();k++){
           for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row.get(k)==i || col.get(k)==j ){
                    mat[i][j]=0;
                }
                    
                }
            }
        }        
    }
}