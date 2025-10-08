class Solution {
    
    int i = 0;
    int j = 0;
    
    public Node dfs(int[] pre, int post[], int data){
        if(data == post[j]){
            return null;
        }
        
        Node root = new Node(pre[i++]);
        
        root.left = dfs(pre, post, root.data);
        root.right = dfs(pre, post, root.data);
        j++;
        
        return root;
        
    }
    
    public Node constructTree(int[] pre, int[] post) {
        // code here
        return dfs(pre, post, -1);
    }
}