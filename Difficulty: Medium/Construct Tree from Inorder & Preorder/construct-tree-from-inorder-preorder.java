//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static int rootInInorder(int i, int j, int value, int [] inorder){
        for(int k = i; k<= j; k++){
            if(inorder[k] == value) return k;
        }
        return i;
    }
    
    public static Node constructBinaryTree(int [] inorder, int preorder[], int i1, int j1, int i2, int j2){
        if(i2 > j2) return null;
        Node root = new Node(preorder[i2]);
        int index = rootInInorder(i1, j1, preorder[i2], inorder);
        root.left = constructBinaryTree(inorder, preorder, i1, index - 1, i2 + 1, i2 + index - i1);
        root.right = constructBinaryTree(inorder, preorder, index + 1, j1, i2 + index - i1 + 1, j2);
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[]) {
       int n = inorder.length;
       return constructBinaryTree(inorder, preorder, 0, n - 1, 0, n - 1);
    }
}
