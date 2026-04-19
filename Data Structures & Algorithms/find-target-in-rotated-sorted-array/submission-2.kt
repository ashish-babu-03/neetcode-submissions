class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = (l+r)/2
            if (nums[mid] == target) return mid
            if (nums[mid] > nums[r]) {
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }

        return -1
    }
}
