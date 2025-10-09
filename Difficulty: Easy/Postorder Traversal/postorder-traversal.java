/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;
    
        Stack<Node> st = new Stack<>();
        Node curr = root;
        Node lastVisited = null;
    
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = st.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    postorder.add(peekNode.data);
                    lastVisited = st.pop();
                }
            }
        }
        return postorder;
    }
}