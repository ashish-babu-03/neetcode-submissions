class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = HashSet<Char>()
        var max = 0
        var l = 0
        for (r in s.indices) {
            while (seen.contains(s[r])) {
                seen.remove(s[l])
                l++
            }
            seen.add(s[r])
            max = maxOf(max, r - l+1)
        }

        return max
    }
}
