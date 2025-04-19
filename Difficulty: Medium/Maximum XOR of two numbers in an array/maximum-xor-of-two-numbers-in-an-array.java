//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class TrieNode{
        TrieNode[] children = new TrieNode[2];
    }
    
    private void insert(TrieNode root, int num){
        TrieNode node = root;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(node.children[bit] == null){
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }
    
    private int findMaxXor(TrieNode root, int num){
        TrieNode node = root;
        int maxXor = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            int oppositeBit = bit ^ 1;
            if(node.children[oppositeBit] != null){
                maxXor |= (1 << i);
                node = node.children[oppositeBit];
            }else{
                node = node.children[bit];
            }
        }
        return maxXor;
    }
    
    public int maxXor(int[] arr) {
        // code here
        TrieNode root = new TrieNode();
        int maxResult = 0;
        
        for(int num : arr){
            insert(root, num);
        }
        
        for(int num : arr){
            maxResult = Math.max(maxResult, findMaxXor(root, num));
        }
        
        return maxResult;
    }
}