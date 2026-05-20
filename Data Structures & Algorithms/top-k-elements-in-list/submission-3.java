class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[n+1];
        for (int i = 0; i <= n ; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >=0 ;i--) {
            for (int num: bucket[i]) {
                result.add(num);
                if (result.size() == k) {
                    return result.stream().mapToInt(x -> x).toArray();
                }
            }
        }

        return new int[]{};
    }
}
