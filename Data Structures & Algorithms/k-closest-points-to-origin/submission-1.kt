class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queue = PriorityQueue<IntArray>() { a, b ->
        (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        }
        for(point in points) queue.add(point)
        val result = mutableListOf<IntArray>()
        repeat(k) {
            result.add(queue.poll())
        }
        return result.toTypedArray()
    }
}
