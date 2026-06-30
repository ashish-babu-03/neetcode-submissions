class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], currentSum = nums[0];
        for (int i = 1;i<nums.length;i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            sum = Math.max(sum, currentSum);
        }

        return sum;
    }
}
