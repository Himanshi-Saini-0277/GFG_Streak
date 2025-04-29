//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        int zero = 0, one = 0, two = 0;
        Node curr = head;
        while(curr!=null){
            if(curr.data==0){
                zero++;
            }
            else if(curr.data==1){
                one++;
            }
            else{
                two++;
            }
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr!=null){
            if(zero!=0){
                curr.data = 0;
                zero--;
            }
            else if(one!=0){
                curr.data = 1;
                one--;
            }
            else if(two!=0){
                curr.data = 2;
                two--;
            }
            curr = curr.next;
        }
        
        return head;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends