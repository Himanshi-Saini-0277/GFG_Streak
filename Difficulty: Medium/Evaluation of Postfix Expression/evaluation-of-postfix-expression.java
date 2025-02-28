//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        int ele1,ele2,n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].equals("+")){
                ele1=st.pop();
                ele2=st.pop();
                st.push(ele2+ele1);
            }
            else if(arr[i].equals("-")){
                ele1=st.pop();
                ele2=st.pop();
                st.push(ele2-ele1);
            }
            else if(arr[i].equals("*")){
                ele1=st.pop();
                ele2=st.pop();
                st.push(ele2*ele1);
            }
            else if(arr[i].equals("/")){
                ele1=st.pop();
                ele2=st.pop();
                st.push(ele2/ele1);
            }
            else {
                st.push(Integer.parseInt(arr[i]));
            }
        }
        return st.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends