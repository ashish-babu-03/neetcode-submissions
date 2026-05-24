class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int l = 0;
        for (char c: s1.toCharArray()) s1Count[c - 'a']++;

        for (int r = 0; r < s2.length(); r++) {
            s2Count[s2.charAt(r) - 'a']++;
            while (r - l + 1 > s1.length()) {
                s2Count[s2.charAt(l) - 'a']--;
                l++;
            }

            if (Arrays.equals(s1Count, s2Count)) return true;
        }
        return false;
    }
}
