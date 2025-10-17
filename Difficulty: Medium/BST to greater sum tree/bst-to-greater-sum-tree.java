/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    private static int sum = 0;
    
    public static void transformTree(Node root) {
        sum = 0;
        dfs(root);
    }
    
    private static void dfs(Node root) {
        if(root != null) {
            dfs(root.right);
            int val = root.data;
            root.data = sum;
            sum += val;
            dfs(root.left);
            
        }
    }
}