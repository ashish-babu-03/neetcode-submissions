class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        int n = nums.length;
        for (int i = 0;i <= n; i++) {
            int dif = target - nums[i]; 
            if (seen.containsKey(nums[i])) return new int[] {seen.get(nums[i]), i};
            else seen.put(dif, i);
        }

        return new int[] {};
    }
}
