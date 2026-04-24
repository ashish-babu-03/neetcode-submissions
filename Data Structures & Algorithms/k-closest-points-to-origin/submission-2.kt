class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray>() { a,b ->
        (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        }

        for (point in points) {
            heap.add(point)
            if (heap.size > k) heap.poll()
        }

        return heap.toTypedArray()
    }
}
