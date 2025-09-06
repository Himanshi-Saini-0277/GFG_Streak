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
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countNodesInLoop(slow);
            }
        }
        return 0; 
    }

    private static int countNodesInLoop(Node nodeInLoop) {
        int count = 1;
        Node temp = nodeInLoop.next;

        while (temp != nodeInLoop) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}