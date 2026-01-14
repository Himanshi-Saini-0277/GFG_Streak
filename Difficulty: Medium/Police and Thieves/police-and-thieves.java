class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int p =0 ; 
        int t = 0 ; 
        int count = 0 ; 
        while(p<arr.length && t<arr.length)
        {
            while(p<arr.length && arr[p]!='P') p++;
            while(t<arr.length && arr[t]!='T') t++;
             if(p>=arr.length || t>=arr.length ) break ; 
             
             if(Math.abs(p-t)<=k)
             {
                 count++;
                 arr[p]='C';
                 arr[t]='C';
             }
             else if(p<t) p++;
             else t++;
             
         }
         return count ; 
    }
}