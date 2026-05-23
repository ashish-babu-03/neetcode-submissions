class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];
        for(int num: nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new ArrayList[n + 1];
        for (int i = 0;i<=n;i++) {
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        int idx = 0;
        for (int i = n;i >=0;i--) {
            for (int val: bucket[i]) {
                if (idx == k) return result;
                result[idx++] = val;
            }
        }

        return result;
    }
}
