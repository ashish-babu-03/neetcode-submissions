class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.zip(speed)
        val stack = ArrayDeque<Double>()
        val sortedPair = pair.sortedByDescending { it.first }
        for ((position, speed) in sortedPair) {
            val timeTaken = (target-position).toDouble()/speed
            if (stack.isEmpty || stack.last() < timeTaken) stack.add(timeTaken)
        }

        return stack.size
    }
}
