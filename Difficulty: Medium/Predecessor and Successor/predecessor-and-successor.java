/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> ansList = new ArrayList<>();
        ansList.add(null);
        ansList.add(null);
        
        Node curr = root;
        while(curr != null){
            if(curr.data > key){
                ansList.set(1 , curr);
                curr = curr.left;
            }else if(curr.data < key){
                ansList.set(0 , curr);
                curr = curr.right;
            }else{
                if(curr.left != null){
                    Node temp = curr.left;
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    ansList.set(0 , temp);
                }
                if(curr.right != null){
                    Node temp = curr.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    ansList.set(1 , temp);
                }
                break;
            }
        }
        
        return ansList;
    }
}