class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var min = 1
        var max = piles.max()
        var minSpeed = Int.MAX_VALUE
        while (min <= max) {
            var totalHours = 0
            val midSpeed = (min+max)/2
            if (midSpeed == 0) break
            for(pile in piles) {
                totalHours += (pile + midSpeed -1)/midSpeed
                println(""+midSpeed+" "+totalHours+" "+minSpeed)
            }
            
            when {
                totalHours <= h -> {
                    minSpeed = midSpeed
                    max = midSpeed - 1
                }
                else -> min = midSpeed + 1
            }
        }

        return minSpeed
    }
}
