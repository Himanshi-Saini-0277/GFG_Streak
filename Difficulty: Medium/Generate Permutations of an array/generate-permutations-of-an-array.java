class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(0, arr, result);
  
        
        return result;
    }

    private static void solve(int index, int[] arr, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            
            solve(index + 1, arr, result);
            
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
};