class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (s in strs) {
            val t = s.toCharArray().sorted().toString()
            map.getOrPut(t) {mutableListOf()}.add(s)
        }
        return map.map{it.value}
    }
}
