class KthLargest(k: Int, nums: IntArray) {
private val key = k
    val heap = PriorityQueue<Int>()

    init {
        for (num in nums) {
            heap.add(num)
            if (heap.size > k) heap.poll()
        }
    }
    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > key) heap.poll()

        return heap.peek()
    }
}
