class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(str);
        }

        return new ArrayList(map.values());
    }
}
