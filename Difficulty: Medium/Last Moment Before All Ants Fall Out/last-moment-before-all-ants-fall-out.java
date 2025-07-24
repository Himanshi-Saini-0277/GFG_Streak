class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int m=0;
        for(int i=0; i<left.length; i++){
            int time=left[i];
            if(time>m){
                m=time;
            }
        }
        for (int i=0; i<right.length; i++){
            int time = n-right[i];
            if(time>m){
                m = time;
            }
        }
        return m;
    }
}