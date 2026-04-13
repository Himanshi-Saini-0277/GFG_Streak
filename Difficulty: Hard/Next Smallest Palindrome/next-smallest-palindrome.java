class Solution {
    static int[] nextPalindrome(int[] num) {
        // code here
        int n=num.length;

        boolean allNine=true;

        for(int d:num)

        if(d!=9){

            allNine=false;

            break;

        }

        if(allNine){

        int[]ans=new int[n+1];

        ans[0]=1;

        ans[n]=1;

        return ans;

        }

        int[]ans=Arrays.copyOf(num,n);

        int mid=n/2;

        for(int i=0;i<mid;i++)

        ans[n-i-1]=ans[i];

        if(isSmallerOrEqual(ans,num)){

        int i=(n%2==0)?mid-1:mid;

        int carry=1;

        while(i>=0&&carry>0){

        ans[i]+=carry;

        carry=ans[i]/10;

        ans[i]%=10;

        ans[n-1-i]=ans[i];

        i--;

        }

        }

        return ans;

    }

    private static boolean isSmallerOrEqual(int[]a,int[]b){

        for(int i=0;i<a.length;i++){

          if(a[i]<b[i]) return true;

          if(a[i]>b[i]) return false;

        }

        return true;
    }
}