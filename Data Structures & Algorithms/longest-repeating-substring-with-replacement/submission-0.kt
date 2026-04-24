class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var result = 0 
        var maxFreq = 0
        var l = 0
        for (r in s.indices) {
            count[s[r] - 'A']++
            maxFreq = maxOf(maxFreq, count[s[r] - 'A'])
            if ((r-l+1) - maxFreq > k) {
                count[s[l] - 'A']--
                l++
            }

            result = maxOf(r-l+1, result)
        }

        return result
    }
}
