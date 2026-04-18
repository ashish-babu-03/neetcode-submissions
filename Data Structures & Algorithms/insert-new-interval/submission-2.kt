class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var isInserted = false
        for (interval in intervals) {
            if (interval[1] < newInterval[0]) result.add(interval)
            else if (interval[0] > newInterval[1]) {
                if (!isInserted) {
                isInserted = true
                result.add(newInterval)
                }
                result.add(interval)
            } else {
                newInterval[0] = minOf(newInterval[0], interval[0])
                newInterval[1] = maxOf(newInterval[1], interval[1])
            }
        }
            if (!isInserted)result.add(newInterval)
            return result.toTypedArray()
    }
}
