//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>
        (Collections.reverseOrder());
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        ArrayList<Double>list=new ArrayList<>();
        for(int val:arr){
            if(maxHeap.isEmpty()||maxHeap.peek()>=val){
                maxHeap.add(val);
            }else{
                minHeap.add(val);
            }
            if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }else if(maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size()==minHeap.size()){
                list.add(maxHeap.peek()/2.0+minHeap.peek()/2.0);
            }else{
                list.add((double)maxHeap.peek());
            }
        }
        return list;
    }
}