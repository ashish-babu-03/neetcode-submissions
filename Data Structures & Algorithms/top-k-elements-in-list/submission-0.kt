class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val storeMap = mutableMapOf<Int,Int>()
        for (i in nums.indices) {
            if (storeMap[nums[i]] != null) {
                storeMap[nums[i]] = storeMap[nums[i]]!! + 1
            } else {
                storeMap[nums[i]] = 1
            }
        }
        val result = mutableListOf<Int>()
        for (i in 1..k) {
            var max = 0
            var maxElement = 0
            for (i in storeMap.keys) {
                if (max < storeMap[i]!! && !result.contains(i)) {
                    max = storeMap[i]!!
                    maxElement = i
                }
            }
            result.add(maxElement)
        }
        return result.toIntArray()
    }
}
