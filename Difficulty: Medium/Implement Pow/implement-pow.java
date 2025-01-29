//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        if (b==0) return 0;
         if (e==0) return 1;

          if (e<0) return 1/power( b,-e) ;
          
           double temp=power(b,e/2);
           
           if (e%2==0) {
                return temp*temp;
           }
           else{
               return b*temp*temp;
           }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends