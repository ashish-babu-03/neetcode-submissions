class MedianFinder {
    val minHeap = PriorityQueue<Double>()
    val maxHeap = PriorityQueue<Double>(reverseOrder())

    fun addNum(num: Int) {
        maxHeap.add(num.toDouble())
        if (minHeap.isEmpty() || minHeap.peek() < maxHeap.peek()) minHeap.add(maxHeap.poll())
        if (maxHeap.size - minHeap.size > 1) minHeap.add(maxHeap.poll())
        if (minHeap.size - maxHeap.size > 1) maxHeap.add(minHeap.poll())
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) maxHeap.peek()
        else if (minHeap.size > maxHeap.size)  minHeap.peek()
        else (minHeap.peek() + maxHeap.peek())/2
    }
}
