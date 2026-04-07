class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        // code here
        int n = men.length;

        int[][] womanRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int rank = 0; rank < n; rank++) {
                womanRank[w][women[w][rank]] = rank;
            }
        }

        int[] wife = new int[n];
        int[] husband = new int[n];
        for (int i = 0; i < n; i++) {
            wife[i] = -1;
            husband[i] = -1;
        }

        int[] nextProposal = new int[n];

        java.util.Queue<Integer> freeMen = new java.util.ArrayDeque<>();
        for (int m = 0; m < n; m++) {
            freeMen.offer(m);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][nextProposal[m]];
            nextProposal[m]++;

            if (husband[w] == -1) {
                husband[w] = m;
                wife[m] = w;
            } else {
                int currentMan = husband[w];

                if (womanRank[w][m] < womanRank[w][currentMan]) {
                    husband[w] = m;
                    wife[m] = w;
                    wife[currentMan] = -1;
                    freeMen.offer(currentMan);
                } else {
                    freeMen.offer(m);
                }
            }
        }

        return wife;
    }
}