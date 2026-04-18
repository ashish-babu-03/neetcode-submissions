class Solution {
    fun rob(nums: IntArray): Int {
        var prev2 = 0
        var prev1 = 0
        var loot = 0
        for (i in nums.indices) {
            loot = maxOf(nums[i]+prev2, prev1)
            prev2 = prev1
            prev1 = loot
        }

        return loot
    }
}
