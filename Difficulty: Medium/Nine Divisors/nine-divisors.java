class Solution {
    public static int count(int n) {
        // code here
        int i = 2;
        int ans = 3;
        int num = n*n;
        for(int j=i;j<n;j++){
            if(num%j==0) ans+=2;
            if(ans>9) return ans;
        }
        return ans;
    }
    public static int countNumbers(int n) {
        if(n<36) return 0;
        int i = 6;
        int ans = 0;
        while((i*i)<=n){
            if(count(i)==9){
                ans++;
            }
            i++;
        }
        return ans;
    }
}