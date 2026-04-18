class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.zip(speed)
        val sorted = pair.sortedByDescending{it.first}
        val stack = ArrayDeque<Double>()
        for ((pos, speed) in sorted) {
            val t = (target - pos).toDouble()/speed
            if (stack.isEmpty() || stack.last() < t) {
                stack.add(t)
            }
        }
        return stack.size
    }
}
