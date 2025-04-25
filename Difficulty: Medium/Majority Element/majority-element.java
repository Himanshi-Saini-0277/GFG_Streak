//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int cnt=0;
        int ele=-1;
        for(int a:arr){
            if(cnt==0){
                ele=a;
                cnt++;
            }else if(a==ele){
                cnt++;
            }else{
                cnt--;
            }
            
        }
        
        int count=0;
        for(int num: arr){
            if(num==ele){
                count++;
            }
        }
        if(count>arr.length/2) return ele;
        return -1;
    }
}