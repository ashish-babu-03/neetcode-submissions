class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int size;
    int k;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        size = nums.length;
        k = target;
        backtrack(nums, 0, new ArrayList<>(), 0);
        return result;
    }

    void backtrack(int[] nums,int start, List<Integer> subset, int sum) {
        if (sum == k) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if(sum > k) return;

        for (int i = start; i< size; i++) {
            subset.add(nums[i]);
            backtrack(nums,i, subset,sum+nums[i]);
            subset.remove(subset.size() - 1);
        }
    }

}
