class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray( s.length+1 ) { false }
        dp[0] = true
        for (i in 1..s.length) {
            for (j in 0..i) {
                if (dp[j] && s.substring(j,i) in wordDict) dp[i] = true
            }
        }
        
        return dp[s.length]
    }
}
