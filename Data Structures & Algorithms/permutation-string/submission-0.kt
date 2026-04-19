class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Count = IntArray(26)
        val s2Count = IntArray(26)
        for (c in s1) s1Count[c - 'a']++

        var l = 0
        for (r in s2.indices) {
            s2Count[s2[r] - 'a']++
            if (r - l+1 > s1.length) {
                s2Count[s2[l] - 'a']--
                l++
            }
            if (s1Count.contentEquals(s2Count)) return true
        }

        return false
    }
}
