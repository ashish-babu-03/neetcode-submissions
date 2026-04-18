class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val heap = PriorityQueue<Int>(reverseOrder())
        val queue = ArrayDeque<Pair<Int, Int>>()
        val freqMap = mutableMapOf<Char, Int>()
        var time = 0
        for (task in tasks) {
            freqMap[task] = (freqMap[task] ?: 0) + 1
        }
        heap.addAll(freqMap.values)
        while (heap.isNotEmpty() || queue.isNotEmpty()) {
            time++
            if (heap.isNotEmpty()) {
                var count = heap.poll()
                count--
                if (count > 0) queue.add(Pair(count, n+time))
            }
            if (queue.isNotEmpty() && queue.first().second == time){
                val task = queue.removeFirst()
                heap.add(task.first)
            }
        }

        return time
    }
}
