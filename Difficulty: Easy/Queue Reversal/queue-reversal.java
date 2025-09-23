class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        int[] tabs = new int[q.size()];
        
        for(int i = q.size()-1;i>=0;i--){
            tabs[i] = q.poll();
        }
        
        q.clear();
        
        for(int num : tabs){
            q.add(num);
        }
    }
}