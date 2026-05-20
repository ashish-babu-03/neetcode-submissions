class Solution {
    fun characterReplacement(s: String, k: Int): Int {
    val count = mutableMapOf<Char, Int>()
    var result = 0
    var maxFreq = 0
    var l = 0

    for (r in s.indices) {
        count[s[r]] = count.getOrDefault(s[r], 0) + 1
        maxFreq = maxOf(maxFreq, count[s[r]]!!)  // ✅ O(1) now

        if ((r - l + 1) - maxFreq > k) {
            count[s[l]] = count[s[l]]!! - 1
            l++
        }

        result = maxOf(result, r - l + 1)
    }

    return result
}
}
