class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(reverseOrder())
        for(stone in stones) heap.add(stone)

        while (heap.size > 1) heap.add(heap.poll() - heap.poll())

        return if (heap.isEmpty()) 0 else heap.peek()        
    }
}
