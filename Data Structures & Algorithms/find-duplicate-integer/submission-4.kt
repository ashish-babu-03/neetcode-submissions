class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var fast = nums[0]
        var slow = nums[0]
        do {
            fast = nums[nums[fast]]
            slow = nums[slow]
        } while (slow != fast)
        var slow2 = nums[0]
        while (slow2 != slow) {
            slow2 = nums[slow2]
            slow = nums[slow]
        }
        return slow
    }
}
