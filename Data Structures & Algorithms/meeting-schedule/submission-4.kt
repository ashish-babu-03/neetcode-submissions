/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        if (intervals.isEmpty()) return true
        val sortedIntervals = intervals.sortedBy { it.end }
        var end = sortedIntervals[0].end
        for (i in 1..sortedIntervals.size-1) {
            if (end > sortedIntervals[i].start) return false
            else end = sortedIntervals[i].end
        }
        return true
    }
}
