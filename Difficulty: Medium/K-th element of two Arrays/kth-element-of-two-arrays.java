//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int arr1[], int arr2[], int k) {
        // code here
        int count=0;
        int n=arr1.length;
        int m=arr2.length;
        int i=0;
        int j=0;
        int result=-1;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                result=arr1[i];
                count++;
                i++;
            }
            else{
                result=arr2[j];
                count++;
                j++;
            }
            if(count==k){
                return result;
            }
        }
        while(i<n){
            result=arr1[i];
            count++;
            i++;
            if(count==k) return result;
        }
        while(j<m){
            result=arr2[j];
            count++;
            j++;
            if(count==k) return result;
        }
        return result;
    }
}
