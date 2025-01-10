//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int  find_distinct(int st,int end,int[] ar){
        HashSet<Integer> set=new HashSet<>();
        for(int i=st;i<end;i++) set.add(ar[i]);
        return set.size();
    }
    ArrayList<Integer> countDistinct(int arr[], int k) {
          ArrayList<Integer> al=new  ArrayList<Integer>();
        for(int i=0;i<=arr.length-k;i++){
            al.add(find_distinct(i,i+k,arr));
        }
        return al;
    }
}
