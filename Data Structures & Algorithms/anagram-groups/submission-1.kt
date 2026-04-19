class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val strMap = HashMap<String, MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sorted().toString()
            strMap.getOrPut(key) {mutableListOf()}.add(str)
        }
        // val result = mutableList<List<String>>()
        // for ((key,value) in strMap) result.add(value)
        return strMap.map {it.value}
    }
}
