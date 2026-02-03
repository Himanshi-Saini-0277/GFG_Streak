class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices){
            if (price < minPrice)
                minPrice = price; 
            else
                maxProfit = Math.max(maxProfit, price - minPrice); 
        }
        return maxProfit;
    }
}