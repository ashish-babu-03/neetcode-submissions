/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sorted = intervals.sortedBy {it.start}
        val heap = PriorityQueue<Int>()

        for (interval in sorted) {
            if (heap.isNotEmpty() && heap.peek() <= interval.start) heap.poll()
            heap.add(interval.end) 
        }

        return heap.size
    }
}
