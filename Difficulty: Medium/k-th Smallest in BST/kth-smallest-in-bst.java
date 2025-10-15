/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int kthSmallest(Node root, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        pretraversal(root, ans);
        if(k>ans.size()){
            return -1;
        }
        return ans.get(k-1);
    }
    
    void pretraversal(Node node, ArrayList<Integer> arr){
        if(node.left != null) pretraversal(node.left, arr);
        arr.add(node.data);
        if(node.right != null) pretraversal(node.right, arr);
        
        return;
    }
}