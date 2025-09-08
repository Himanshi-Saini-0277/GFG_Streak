/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node Head) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        Node head=Head;
        while(head!=null){
            pq.offer(head.data);
            head=head.next;
        }
        Node front=new Node(pq.poll());
        Node tail=front;
        while(!pq.isEmpty()){
            Node node=new Node(pq.poll());
            if(front.next==null){
                front.next=node;
                tail=node;
            }else{
                tail.next=node;
                tail=tail.next;
            }
        }
        return front;
    }
}