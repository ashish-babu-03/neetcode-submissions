class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        var result = 0
        for (num in numsSet) {
            var temp = 0
            if (!numsSet.contains(num - 1)) {
                var ele = num
                while (numsSet.contains(ele)) {
                    ele++
                    temp++
                }
            }
            result = max(result, temp)
        }

        return result
    }
}
