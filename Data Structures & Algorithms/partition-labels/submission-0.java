class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int start = 0;
        for (int i =0;i < s.length();i++) {
            max = Math.max(max, freqMap.get(s.charAt(i)));
            if (max == i) {
                result.add(i - start+1);
                start = i+1;
            }
        }
        return result;
    }
}
