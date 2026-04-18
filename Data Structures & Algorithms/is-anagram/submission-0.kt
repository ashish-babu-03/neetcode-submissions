class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val p2 = s.length
        val set1 = mutableListOf<Char>()
        val set2 = mutableListOf<Char>()
        for (i in 0..p2-1) {
            set1.add(s.get(i))
            set2.add(t.get(i))
        }
        set1.sort()
        set2.sort()
        if(set1.size != set2.size) return false
        for (i in 0..set1.size-1) {
            if (set1.get(i) != set2.get(i)) return false
        }

        return true
    }
}
