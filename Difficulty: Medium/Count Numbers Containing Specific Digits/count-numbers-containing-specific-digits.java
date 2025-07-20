class Solution {
    public int countValid(int n, int[] arr) {
        // code here
        if (n == 1) {
            Arrays.sort(arr);
            if(arr[0]==0){
            return arr.length-1;}
            else{
                return arr.length;
            }
        }
        long totalNumbers = 9;
        for (int i = 0; i < n - 1; i++) {
            totalNumbers *= 10;
        }
        Set<Integer> arrSet = new HashSet<>();
        for (int digit : arr) {
            arrSet.add(digit);
        }

        int numUnavailableDigits = arr.length;
        int numAvailableNonArrDigits = 10 - numUnavailableDigits;

        long numbersWithoutArrDigits = 1;

        
        int firstDigitChoices = 0;
        for (int i = 1; i <= 9; i++) {
            if (!arrSet.contains(i)) {
                firstDigitChoices++;
            }
        }
        numbersWithoutArrDigits = firstDigitChoices;

      
        for (int i = 0; i < n - 1; i++) {
            numbersWithoutArrDigits *= numAvailableNonArrDigits;
        }

        return (int) (totalNumbers - numbersWithoutArrDigits);
    }
}