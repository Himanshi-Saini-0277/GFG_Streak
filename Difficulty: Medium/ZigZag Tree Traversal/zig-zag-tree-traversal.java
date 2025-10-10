/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Deque<Node> dq = new LinkedList<>();
        dq.add(root);
        
        boolean leftToRight = true;
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            ArrayList<Integer> level = new ArrayList<>(size);
            
            for (int i = 0; i < size; i++) {
                Node node;
                
                if (leftToRight) {
                    node = dq.pollFirst();
                    level.add(node.data);
                    if (node.left != null) dq.addLast(node.left);
                    if (node.right != null) dq.addLast(node.right);
                } else {
                    node = dq.pollLast();
                    level.add(node.data);
                    if (node.right != null) dq.addFirst(node.right);
                    if (node.left != null) dq.addFirst(node.left);
                }
            }
            
            res.addAll(level);
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}