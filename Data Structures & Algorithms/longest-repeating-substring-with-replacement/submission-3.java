class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, result = 0, maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int r = 0;r<s.length();r++) {
            char c = s.charAt(r);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            while (r - l + 1 - maxFreq > k) {
                char lc = s.charAt(l);
                freqMap.put(lc, freqMap.getOrDefault(lc, 0) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
