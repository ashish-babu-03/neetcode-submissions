class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
         val sum = mutableMapOf<Int, Int>()
         for (i in 0..nums.size-1) {
            val dif = target - nums[i]
            if (sum[nums[i]] != null) {
                return intArrayOf(sum[nums[i]]!!, i)
            } else {
                sum[dif] = i
            }
         }
         return intArrayOf()
    }
}