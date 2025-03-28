//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n=start.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = finish[i];
            arr[i][1] = start[i];
        }
         Arrays.sort(arr,(a, b) -> Integer.compare(a[0], b[0]));
         int fin=-1;
         int ans=0;
         for(int i=0;i<arr.length;i++){
             if(arr[i][1]>fin){
                 ans++;
                 fin=arr[i][0];
             }
         }
         return ans;
    }
}
