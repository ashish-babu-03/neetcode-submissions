class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val strMap = HashMap<String, MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sorted().toString()
            strMap.getOrPut(key) {mutableListOf()}.add(str)
        }
        return strMap.map {it.value}
    }
}
