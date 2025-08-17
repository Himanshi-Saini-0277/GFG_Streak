class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        int n = arr.length;
        int[] temp = new int[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        for (int i = 0; i < n; ++i) {
            temp[i] = arr[i];
            int diff = Math.abs(arr[i] - x);
            pq.offer (new int[] {diff, i});
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            int id = pq.peek()[1];
            pq.poll();
            arr[idx++] = temp[id];
        }
    }
}
