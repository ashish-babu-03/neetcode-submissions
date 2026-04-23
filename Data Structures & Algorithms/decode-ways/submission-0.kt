class Solution {
    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length + 1) {0}
        dp[0] = 1
        for (i in 1..s.length) {
            if (s[i-1] != '0') dp[i] += dp[i-1]
            if (i >= 2) {
                val twoDigit = s.substring(i-2, i).toInt()
                if (twoDigit in 10..26) dp[i] += dp[i-2]
            }
        }

        return dp[s.length]
    }
}
