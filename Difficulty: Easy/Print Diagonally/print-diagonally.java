class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=mat.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int r=i;
                int k=j;
                if(mat[r][k]==-1) continue;
                while(r>=0 && r<n && k>=0 && k<n){
                    ans.add(mat[r][k]);
                    mat[r][k]=-1;
                    r++;
                    k--;
                }
            }
        }
        return ans;
    }
}
