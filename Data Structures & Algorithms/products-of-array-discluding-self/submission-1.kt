class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size

        val preProd = IntArray(n+1) { 1 }
        for (i in 1..n) preProd[i] = nums[i-1] * preProd[i-1]

        val sufProd = IntArray(n) { 1 }
        for (i in n-2 downTo 0) sufProd[i] = nums[i+1] * sufProd[i+1]

        val result = IntArray(n) { 1 }
        for (i in 0..n-1) result[i] = preProd[i] * sufProd[i]


        return result
    }
}
