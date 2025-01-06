//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        int n=arr.length;
        int a=arr[0];
       int b=arr[n-1];
        List<Integer> ans=new ArrayList<>();
        if(n<=1)
        return ans;
        
        int i=0;
        int j=n-1;
        while(i<j)
        {
            int sum=arr[i]+arr[j];
            int currDiff=Math.abs(sum-target);
            if(diff==currDiff)
            {
                if(Math.abs(arr[i]-arr[j])>Math.abs(a-b))
                {
                    a=arr[i];
                    b=arr[j];
                }
            }
            else if(currDiff<diff)
            {
                diff=currDiff;
                a=arr[i];
                b=arr[j];
            }
            if(target<sum)
            {
                j--;
            }
            else{
                i++;
            }
        }
        ans.add(a);
        ans.add(b);
    return ans;
    }
}