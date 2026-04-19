class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sumMap = HashMap<Int, Int>()
        var result = intArrayOf()
        for(i in nums.indices) {
            val dif = target - nums[i]
            if (sumMap.containsKey(nums[i])) {
                return intArrayOf(sumMap[nums[i]]!!, i)
            } else {
                sumMap[dif] = i
            }
        }
        return result
    }
}
