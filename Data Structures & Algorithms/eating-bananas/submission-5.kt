class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 0
        var r = piles.max()
        while (l < r) {
            val mid = (l+r)/2
            val timeTaken = piles.sumOf{Math.ceil(it/mid.toDouble()).toInt()}

            if (timeTaken <= h) r = mid
            else l = mid+1
        }

        return l 
    }
}
