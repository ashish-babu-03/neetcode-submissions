class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = 100, maxProfit = 0;
        for (int price : prices) {
            minBuy = Math.min(minBuy, price);
            maxProfit = Math.max(maxProfit, price - minBuy);
        }
        return maxProfit;
    }
}
