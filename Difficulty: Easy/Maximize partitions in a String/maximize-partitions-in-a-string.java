//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            int idx = map.get(arr[i]);
            int k=i;
            while(k<idx){
                idx = Math.max(idx,map.get(arr[k]));
                k++;
            }
            
            res++;
            i = idx;
        }
        return res;
    }
}