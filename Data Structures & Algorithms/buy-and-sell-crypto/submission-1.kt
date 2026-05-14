class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPurchase = prices.max()
        var maxProfit = 0
        for (price in prices) {
            minPurchase = minOf(minPurchase, price)
            maxProfit = maxOf(maxProfit,price - minPurchase)
        }

        return maxProfit
    }
}
