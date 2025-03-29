//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] sorted = new int[profit.length];
        boolean[] job = new boolean[profit.length];

        System.arraycopy(profit, 0, sorted, 0, profit.length);
        Arrays.sort(sorted);
        reverseArray(sorted);

        int[] maxProfit = {0};
        int jobs = 0;

        for (int i = 0; i < profit.length; i++) {
            int curr = sorted[i];
            int index = findJob(profit, curr);
            jobs += DoneOrNot(deadline[index], job, maxProfit, curr);
        }

        result.add(jobs);
        result.add(maxProfit[0]);
        return result;
    }

    public static int DoneOrNot(int d, boolean[] j, int[] m, int c) {
        while (d > 0) {
            if (!j[d - 1]) {
                m[0] += c;
                j[d - 1] = true;
                return 1;
            }
            d--;
        }
        return 0;
    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int findJob(int[] profit, int n) {
        int ind = 0;
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] == n) {
                ind = i;
                profit[i] = 0;
                break;
            }
        }
        return ind;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends