class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int size;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        size = nums.length;
        used = new boolean[size];
        backtrack(nums, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, List<Integer> combo) {
        if (nums.length == combo.size()) {
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int i = 0;i< size;i++) {
            if (used[i]) continue;
            combo.add(nums[i]);
            used[i] = true;
            backtrack(nums, combo);
            combo.remove(combo.size() - 1);
            used[i] = false;
        }
    }
}
