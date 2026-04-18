class Solution {
    fun findMin(nums: IntArray): Int {
        var p = 0
        var q = nums.size - 1
        while (p < q) {
            val mid = (p+q)/2
            if (nums[mid] > nums[q]) p = mid+1
            else q = mid
        }
return nums[p]
    }
}
