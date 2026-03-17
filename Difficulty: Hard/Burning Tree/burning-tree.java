/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map;
    Node startNode;

    public void dfs(Node node, Node parent, int start) {
        if(node == null) return;

        if(node.data == start) startNode = node;

        map.put(node, parent);

        dfs(node.left, node, start);
        dfs(node.right, node, start);

    }
    
    public int minTime(Node root, int start) {
        map = new HashMap<>();
        startNode = null;

        dfs(root, null, start);

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.add(startNode);
        visited.add(startNode);

        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Node curr = q.remove();

                if(curr.left != null && visited.add(curr.left)) {
                    q.add(curr.left);
                }

                if(curr.right != null && visited.add(curr.right)) {
                    q.add(curr.right);
                }

                Node parentNode = map.get(curr);

                if(parentNode != null && visited.add(parentNode)) {
                    q.add(parentNode);
                }
            }

            time++;

        }

        return time - 1;
    }
}