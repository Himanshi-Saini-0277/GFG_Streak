/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    public int findMedian(Node root) {
        // Code here
        inorder(root);
        int n = list.size();
        if(n % 2 == 0){
            return list.get((n/2)-1);
        }
        else{
            return list.get(((n+1)/2)-1);
        }
    }
}