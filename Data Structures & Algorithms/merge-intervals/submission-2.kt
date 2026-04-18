class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableSetOf<IntArray>()
        for (i in intervals) {
            if (result.isEmpty()) result.add(i)
            else {
                val prev = result.last()
                val next = i
                if (prev[1] >= next[0]) {
                    result.remove(prev)
                    val first = minOf(prev[0], next[0])
                    val last = maxOf(prev[1], next[1])
                    result.add(intArrayOf(first, last))
                }
                else result.add(i) 
            }
        }
        return result.toTypedArray()
    }
}
