/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        
        Node zs = zero;
        Node os = one;
        Node ts = two;
        
        while(head!=null) {
            Node nex = head.next;
            head.next = null;
            switch(head.data) {
                case 0:
                    zero.next = head;
                    zero = head;
                    break;
                case 1:
                    one.next = head;
                    one = head;
                    break;
                case 2:
                    two.next = head;
                    two = head;
                    break;
            }
            head = nex;
        }
        
        one.next = ts.next;
        zero.next = os.next;
        
        return zs.next;
    }
}