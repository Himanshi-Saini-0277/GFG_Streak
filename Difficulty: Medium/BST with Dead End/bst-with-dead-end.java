/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution
{   
    public static boolean isDeadEnd(Node root){
        return helper(root,1,Integer.MAX_VALUE);
    }
    
    public static boolean helper(Node root,int minVal,int maxVal){
        if(root==null)return false;
        
        if(minVal==maxVal){
            return true;
        }
        
        return helper(root.left,minVal,root.data-1)||helper(root.right,root.data+1,maxVal);
    }
}

