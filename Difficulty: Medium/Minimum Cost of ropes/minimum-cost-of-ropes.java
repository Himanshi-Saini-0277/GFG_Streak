class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : arr) {
            pq.add(rope);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;

            totalCost += cost;
            pq.add(cost);
        }

        return totalCost;
    }
}