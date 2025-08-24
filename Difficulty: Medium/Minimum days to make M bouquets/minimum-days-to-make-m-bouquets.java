class Solution {
    public static int minDaysBloom(int[] a, int flowers, int boq) {
        int l=a[0],h=a[0];
        if(boq*flowers>a.length){
            return -1;
        }
        for(int i=1;i<a.length;i++){
            if(a[i]<l){
                l=a[i];
            }
            if(a[i]>h){
                h=a[i];
            }
        }
        int re=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(find(a,boq,flowers,m)){
                re=m;
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return re;
    }
    
    public static boolean find(int[] a,int boq,int flowers,int m){
        int bc=0,adj=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=m){
                adj++;
                if(adj==flowers){
                    bc++;
                    if(bc==boq){
                        return true; 
                    }
                    adj=0;
                }
            }
            else{
                adj=0;
            }
        }
        return false;
    }
}