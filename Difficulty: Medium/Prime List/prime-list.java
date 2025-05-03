//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    boolean check(int num,ArrayList<Integer> arr){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        arr.add(num);
        return true;
    }
    
    int find(int data, ArrayList<Integer> arr) {
        int l=0;
        int r=arr.size()-1;
        while(l<=r) {
        	int mid=(l+r)>>1;
        	if(data>arr.get(mid)) {
        		l=mid+1;
        	}else {
        		r=mid-1;
        	}        	
        }
        return r;
	}
    
    Node primeList(Node head) {
        ArrayList<Integer> arr=new ArrayList<>();        
        for(int i=2;i<10010;i++) check(i,arr);
        Node temp=head;
        while(temp!=null) {  	
        	int index=find(temp.val,arr);
        	int k=temp.val;
        	if(index==-1)temp.val=2;
        	else if(arr.size()-1==index) {
        		temp.val=arr.get(index);
        	}
        	else {
        		if(Math.abs(arr.get(index)-k)> Math.abs(arr.get(index+1)-k)){
        			temp.val=arr.get(index+1);
        		}else {
        			temp.val=arr.get(index);
        		}    		
        	}        	
        	temp=temp.next;        	
        }
        return head; 
    }
}