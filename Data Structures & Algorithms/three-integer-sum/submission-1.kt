class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        for (i in nums.indices) {
            var p = i+1
            var q = nums.size - 1
            if (i > 0 && nums[i] == nums[i-1]) continue
            while (p < q) {
                val sum = nums[i] + nums[p] + nums[q]
                when {
                    sum < 0 -> p++
                    sum > 0 -> q--
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[p], nums[q]))
                        p++
                        q--
                        while (p < q && nums[p-1]==nums[p])p++
                        while (p < q && nums[q+1] == nums[q])q--
                    }
                }
            }
        }

        return result
    }
}
