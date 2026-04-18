class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val n = strs.size
        val result = mutableListOf<List<String>>()
        val target = mutableMapOf<String, MutableList<String>>()
        for (i in strs.indices) {
            val str = strs[i]
            var sameString = ""
            val chars = mutableListOf<Char>()
            for(j in 0..str.length-1){
                chars.add(str.get(j))
            }
            chars.sort()
            for(j in chars) {
                sameString += j
            }
            if (target[sameString] != null) {
                target[sameString]!!.add(str)
            } else {
                target[sameString] = mutableListOf(str)
            }
        }
        for (i in target.values) {
            result.add(i.toList())
        }
        return result.toList()
    }
}
