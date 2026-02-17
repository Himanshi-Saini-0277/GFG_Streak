
class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
         List<int[]> events = new ArrayList<>();

        for (int[] log : arr) {

            events.add(new int[]{log[0], +1});
            events.add(new int[]{log[1], -1});

        }


        Collections.sort(events, (a, b) -> {

            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];

        });

        int curr = 0;
        int maxPop = 0;

        for (int[] e : events) {

            curr += e[1];
            maxPop=Math .max(curr,maxPop);

        }
        return maxPop;
    }
}
