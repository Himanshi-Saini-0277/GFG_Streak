//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(k==1) return head;
        return reversechecksum(head,head,k);
    }
    public static Node reversechecksum(Node head, Node k, int c){
        if(k==null){
            return null;
        }
        Node tail = head;
        k = k_round(k,c);
        Node ans = reversechecksum(k,k,c);
        Node ans2 = reversal(head);
        tail.next = ans;
        return ans2;
    }

    private static Node reversal(Node head) {
        Node i = head;
        Node j = head;
        Node temp = null;
        while(j!=null){
            j = j.next;
            i.next = temp;
            temp = i;
            i =j;
        }
        return temp;
    }

    private static Node k_round(Node k, int c) {
        int cc =0;
        while (k!=null && cc<c){
            k = k.next;
            cc++;
            if(cc==c-1 && k!=null && k.next != null){
                Node tp = k;
                k = k.next;
                tp.next = null;
                cc++;
            }
        }
        return k;
    }
}
