class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()
        var min = r
        while (l <= r) {
            val mid = (l+r) /2
            val totalHours = piles.sumOf { pile ->
                (pile + mid -1)/ mid
            }
            if (totalHours <= h) {
                min = mid
                r = mid-1
            } else {
                l = mid+1
            }
        }
        return min
    }
}
