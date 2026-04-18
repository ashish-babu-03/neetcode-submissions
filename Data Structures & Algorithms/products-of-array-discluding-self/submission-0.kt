class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = mutableListOf<Int>()
        val pre = nums.clone()
        val suf = nums.clone()
        for(i in 0..n-1) {
            if (i == 0) pre[i] = 1
            else pre[i] = pre[i-1] * nums[i-1]
            println(""+i+" "+pre[i])
        }
        for(i in n-1 downTo 0) {
            if (i == n-1) suf[i] = 1
            else 
            suf[i] = suf[i+1] * nums[i+1]
        }
        for (i in nums.indices){
            result.add(pre[i]*suf[i])
        }
        return result.toIntArray()

    }
}
