class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);
        Set<String> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = n - 1, j = n - 1;
        maxHeap.add(new Pair(i, j, a[i] + b[j]));
        visited.add(i + "," + j);
        
        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);
            i = current.i;
            j = current.j;
            
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.add(new Pair(i - 1, j, a[i - 1] + b[j]));
                visited.add((i - 1) + "," + j);
            }
            
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.add(new Pair(i, j - 1, a[i] + b[j - 1]));
                visited.add(i + "," + (j - 1));
            }
        }
        
        return result;
    }

    static class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}