class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val freqMap = HashMap<Char, Int>()
        for(c in s) freqMap[c] = (freqMap[c] ?: 0) + 1
        for (c in t) freqMap[c] = (freqMap[c] ?: 0) - 1

        return freqMap.all { it.value == 0}
    }
}
