class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for (num in nums) {
            queue.add(num)
            if (queue.size > k) queue.poll()
        }
        return queue.peek()
    }
}
