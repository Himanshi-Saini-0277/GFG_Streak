//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String str, int k) {
        // code here.
        char s[]=str.toCharArray();
       
       for(int i=0;i<s.length;i++){
           if(k==0) break;
           int max=i;
           for(int j=i+1;j<s.length;j++){
               if(s[max]<=s[j]) max=j;
           }
           
           if(s[max]==s[i]) continue;
           else{
               swap(i,max,s);
               k--;
               
           }
       }
       
       return new String(s);
    }
    
    void swap(int i, int j , char s[]){
        char t=s[i];
        s[i]=s[j];
        s[j]=t;
    }
}