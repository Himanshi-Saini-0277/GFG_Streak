//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int n = arr.length, st = 0, en = n - 1;
        
        while (st < en) {
            if (arr[st] < arr[en])        
                return arr[st];
               
            int mid = st + (en - st) / 2;
            
            if (arr[en] < arr[mid]) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        
        return arr[st];
    }
}
