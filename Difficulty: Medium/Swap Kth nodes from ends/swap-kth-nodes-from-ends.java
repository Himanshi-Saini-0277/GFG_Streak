/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    private int countNode(Node head){
        int c=0;
        while(head!=null){
            c++;
            head=head.next;
        }
        
        return c;
    }
    public Node swapKth(Node head, int k) {
        // code here
        Node f_num = head;
        Node l_num = head;
        Node swap = head;
        
        int c = countNode(head);
        int x = c-k+1;
        
        if(k>c) return head;
        
        while(k>0){
            k--;
            if(k>0){
                f_num=f_num.next;
            }
        }
        
        while(x>0){
            x--;
            if(x>0){
                l_num=l_num.next;
            }
        }
        
        int temp = f_num.data;
        f_num.data= l_num.data;
        l_num.data=temp;
        return head;
    }
}
