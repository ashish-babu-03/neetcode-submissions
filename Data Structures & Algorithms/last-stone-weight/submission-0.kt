class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>(reverseOrder())
        var result = 0
        for (stone in stones) {
            queue.add(stone)
        }

        while (queue.isNotEmpty()) {
            val x: Int = queue.poll()
            val y: Int? = queue.poll()
            if (y == null) {
                return x 
            }
            val dif = x - y
            if (dif > 0) queue.add(dif)
        }

        return result
    }
}
