class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray ( nums.size ) {1}
        for (i in 0..nums.size - 1) {
            for (j in 0..i-1) {
                if (nums[j] < nums[i]) dp[i] = maxOf(dp[i], dp[j]+1)
            }
        }

        return dp.max()
    }
}
