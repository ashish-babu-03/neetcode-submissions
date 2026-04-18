class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice  = 100
        var maxProfit = 0
        for (price in prices) {
            minPrice = min(minPrice, price)
            maxProfit = max(maxProfit, price-minPrice)
        }
        return maxProfit
    }
}
