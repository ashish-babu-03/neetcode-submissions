class Solution {
    fun maxArea(heights: IntArray): Int {
        var p = 0
        var q = heights.size-1
        var max = 0
        while (p<q) {
            max = max(max, ((q-p)*(min(heights[p], heights[q]))))
            when {
                heights[p] < heights[q] -> p++
                heights[p] > heights[q] -> q--
                else -> {p++ 
                q--}
            }
        }

        return max
    }
}
