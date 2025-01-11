//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int[] fr = new int[26];
        int ans = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++) {
            fr[s.charAt(r) - 'a']++;
            while(fr[s.charAt(r) - 'a'] > 1) {
                fr[s.charAt(l) - 'a']--;
                l++;
            }
            ans = Math.max(r-l+1, ans);
        }
        
        return ans;
    }
}