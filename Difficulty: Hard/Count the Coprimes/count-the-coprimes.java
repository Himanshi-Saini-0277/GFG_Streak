class Solution {
    static final int MAX = 10001;

    public int cntCoprime(int[] arr) {
        int n = arr.length;

        int[] freq = new int[MAX];
        for (int num : arr) {
            freq[num]++;
        }

        int[] cnt = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                cnt[i] += freq[j];
            }
        }

        int[] mobius = getMobius(MAX);

        long result = 0;
        for (int i = 1; i < MAX; i++) {
            if (cnt[i] >= 2) {
                long pairs = (1L * cnt[i] * (cnt[i] - 1)) / 2;
                result += 1L * mobius[i] * pairs;
            }
        }

        return (int) result;
    }

    private int[] getMobius(int n) {
        int[] mobius = new int[n];
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        Arrays.fill(mobius, 1);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; j < n; j += i) {
                    isPrime[j] = false;
                    mobius[j] *= -1;
                }
                for (long j = 1L * i * i; j < n; j += i * i) {
                    mobius[(int) j] = 0;
                }
            }
        }

        return mobius;
    }
}
