class Solution {
    fun maxProduct(nums: IntArray): Int {
        var maxProd = nums[0]
        var minProd = nums[0]
        var result = nums[0]
        for (i in 1 until nums.size) {
            val temp = minProd
            minProd = minOf(nums[i], maxProd * nums[i], temp * nums[i])
            maxProd = maxOf(nums[i], maxProd * nums[i], temp * nums[i])
            result = maxOf(result, maxProd)
        }

        return result
    }
}
