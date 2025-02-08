//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
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
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null)return null;
        
        if(!leaf(node)){
            ans.add(node.data);
        }
        
        left(node, ans);
        addleaves(node, ans);
        right(node, ans);
        
        return ans;
    }
    
    public static boolean leaf(Node node){
        return (node.left == null && node.right == null);
    }
    
    void left(Node root, ArrayList<Integer> ans){
        Node curr = root.left;
        
        while(curr != null){
            if(!leaf(curr)){
                ans.add(curr.data);
            }
            if(curr.left !=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    
    void right(Node root,ArrayList<Integer> ans){
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        
        while(curr != null){
            if(!leaf(curr)){
                st.push(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
         while(!st.isEmpty()){
                ans.add(st.pop());
            }
    }
    
    void addleaves(Node root, ArrayList<Integer> ans){
        if(root == null)return;
        
        if(leaf(root)){
            ans.add(root.data);
        }
        else{
            addleaves(root.left, ans);
            addleaves(root.right, ans);
        }
    }
}
