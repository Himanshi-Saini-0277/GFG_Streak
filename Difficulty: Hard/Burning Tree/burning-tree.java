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
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        Node start=null;
        HashMap<Node,ArrayList<Node>> map=new HashMap<>();
        while(que.size()>0){
           Node temp=que.poll();
           if(temp.data==target) start=temp;
           if(temp.left!=null){
               que.add(temp.left);
               if(map.get(temp)!=null){
                   map.get(temp).add(temp.left);
                   
               }
               else{
                   map.put(temp,new ArrayList<>());
                   map.get(temp).add(temp.left);
               }
               
                if(map.get(temp.left)!=null){
                   map.get(temp.left).add(temp);
                   
               }
               else{
                    map.put(temp.left,new ArrayList<>());
                   map.get(temp.left).add(temp);
               }
           }
           if(temp.right!=null){
               que.add(temp.right);
               if(map.get(temp)!=null){
                   map.get(temp).add(temp.right);
                   
               }
               else{
                   map.put(temp,new ArrayList<>());
                   map.get(temp).add(temp.right);
               }
               
                if(map.get(temp.right)!=null){
                   map.get(temp.right).add(temp);
                   
               }
               else{
                    map.put(temp.right,new ArrayList<>());
                   map.get(temp.right).add(temp);
               }
           }
        }
        start.data=0;
        que.add(start);
        int max=0;
        
       HashMap<Node,Integer> vis=new HashMap<>();
        while(que.size()>0){
            
           Node temp=que.poll();
           if(max<temp.data) max=temp.data;
           if(map.get(temp)!=null){
               vis.put(temp,1);
           for(Node i:map.get(temp)){
               if(vis.get(i)==null){
                   vis.put(i,1);
                   i.data=temp.data+1;
                   que.add(i);
               }
           }}
            
        }
        return max;
    }
}