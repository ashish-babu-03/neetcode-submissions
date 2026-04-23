class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val n = nums.size
        fun robHouse(s: Int, e: Int): Int {
            var prev1 = 0
            var prev2 = 0
            var maxLoot = 0
            for(i in s..e) {
                maxLoot = maxOf(nums[i]+prev2, prev1)
                prev2 = prev1
                prev1 = maxLoot
            }
            return maxLoot

        }
        return maxOf(robHouse(0,n-2), robHouse(1,n-1))
    }
}
