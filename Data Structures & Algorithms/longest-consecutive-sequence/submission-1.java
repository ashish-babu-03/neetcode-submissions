class Solution {
    public int longestConsecutive(int[] nums) {
        
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) numSet.add(num);
    
        int max = 0;
        for(int i = 0; i< nums.length;i++) {
            if (!numSet.contains((nums[i] - 1))) {
                int temp = nums[i];
                int t = 0;
                while (numSet.contains(temp)) {
                    temp++;
                    t++;
                }
                
                    max = Math.max(max, t);
            }
        }

        return max;
    }
}
