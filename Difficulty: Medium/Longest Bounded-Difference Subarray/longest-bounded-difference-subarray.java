//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> dq=new LinkedList<>();
        ArrayList<Integer> obj=new ArrayList<>();
        int max=arr[0];
        int min=arr[0];
        dq.addFirst(0);
        
        Deque<Integer> ans=new LinkedList<>();
        int maxc=0;
        
        
        
        for(int i=1;i<arr.length;i++)
        {
            if((Math.abs(arr[i]-max)<=x) && (Math.abs(arr[i]-min)<=x))
            {
                dq.addLast(i);
                min=(min<arr[i])?min:arr[i];
                max=(max>arr[i])?max:arr[i];
            }
            else
            {
                if(dq.size()>maxc)
                {
                    maxc=dq.size();
                    ans=new LinkedList<>(dq);
                }
                else if(dq.size()==maxc && ans.getFirst()>dq.getFirst())
                {
                    ans=new LinkedList<>(dq);
                }
                
                
                Deque<Integer> dq2=new LinkedList<>();
                min=arr[i];
                max=arr[i];
                while(dq.peekLast()!=null && Math.abs(arr[dq.peekLast()]-arr[i])<=x)
                {
                    dq2.addFirst(dq.pollLast());
                    if(arr[dq2.peekFirst()]>max)max=arr[dq2.getFirst()];
                    if(arr[dq2.peekFirst()]<min)min=arr[dq2.getFirst()];
                }
                dq2.addLast(i);
                dq.clear();
                dq=dq2;
            }
        }
        
        
        if(dq.size()>maxc)
        {
            maxc=dq.size();
            ans=new LinkedList<>(dq);
        }
        else if(dq.size()==maxc && ans.getFirst()>dq.getFirst())
        {
            ans=new LinkedList<>(dq);
        }
        
        for(int i:ans)
        {
            obj.add(arr[i]);
        }
        
        return obj;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends