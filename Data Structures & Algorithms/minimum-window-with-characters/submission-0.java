class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int have = 0, total = need.size(), l = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int r = 0;r < s.length();r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) have++;

            while (have == total) {
                if (r - l+1 < minLen) {
                    minLen = r - l +1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && need.get(leftChar) > window.get(leftChar)) have--;

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
