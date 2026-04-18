class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val h1 = mutableMapOf<Char, Int>()
        val h2 = mutableMapOf<Char, Int>()
        for(i in 0..s.length-1){
            val c1 =s.get(i)
            val c2 = t.get(i)
            if (h1[c1] != null){
                h1[c1] = h1[c1]!! + 1
            } else {
                h1[c1] = 1
            }

            if (h2[c2] != null) {
                h2[c2] = h2[c2]!! +1
            } else {
                h2[c2] = 1
            }
        }
        for (i in 0..s.length-1) {
            if (h1[s.get(i)] != h2[s.get(i)]) return false
        }
        return true
    }
}
