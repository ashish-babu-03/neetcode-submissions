class Solution {
    public int characterReplacement(String s, int k) {
        int[] sCount = new int[26];
        int maxFreq = 0, result = 0, l = 0;
        for(int r = 0; r < s.length(); r++) {
            sCount[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, sCount[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) {
                sCount[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
