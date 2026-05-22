class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int size = 0;
    int[] numArray;
    public List<List<Integer>> subsets(int[] nums) {
        numArray = nums;
        size = nums.length;
        backtrack(0, new ArrayList<>());
        return result;
    }

    void backtrack(int start, List<Integer> combo) {
        result.add(new ArrayList<>(combo));
        for (int i = start; i < size;i++) {
            combo.add(numArray[i]);
            backtrack(i + 1, combo);
            combo.remove(combo.size() - 1);
        }
    }
}
