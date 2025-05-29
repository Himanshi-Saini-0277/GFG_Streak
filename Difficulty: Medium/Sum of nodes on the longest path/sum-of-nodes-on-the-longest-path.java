/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public int sumOfLongRootToLeafPath(Node root) {
        map.put(0,root.data);
        int res = Math.max(findLongestPath(root.left,root.data,1),findLongestPath(root.right,root.data,1));
        return map.get(res-1);
    }

    private int findLongestPath(Node node,int s,int h) {
        if (node == null) return h;
        s+=node.data;
        map.put(h,Math.max(map.getOrDefault(h,0),s));
        return Math.max(findLongestPath(node.left,s,h+1),findLongestPath(node.right,s,h+1));
    }
}