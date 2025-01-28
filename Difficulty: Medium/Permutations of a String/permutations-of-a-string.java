//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void helper(char[] arr, int idx, HashSet<String> set){
        if(idx == arr.length){
            set.add(new String(arr));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            swap(arr, i, idx);
            helper(arr, idx + 1, set);
            swap(arr, i, idx);
        }
    }
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> set = new HashSet<>();
        helper(s.toCharArray(), 0, set);
        return new ArrayList<>(set);
    }
}