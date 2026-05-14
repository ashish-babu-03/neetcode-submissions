class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val charFreq = HashMap<Char, Int>()
        for (c in s) charFreq[c] = (charFreq[c] ?: 0) + 1
        for (c in t) charFreq[c] = (charFreq[c] ?: 0) - 1

        return charFreq.values.all {it == 0}
    }
}
