class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val queue = ArrayDeque<String>()
        val visitedSet = HashSet<String>()
        var count = 1
        fun isOneLetterApart(s1: String, s2: String): Boolean {
            var dif = 0
            for (i in s1.indices) if (s1[i] != s2[i]) dif++
            return dif == 1
        }
        queue.add(beginWord)
        while (queue.isNotEmpty()) {
            val level = queue.size
            repeat (level) {
            val top = queue.removeFirst()
            if (top == endWord) return count
            for (i in wordList) {
                if (i in visitedSet) continue
                if (!isOneLetterApart(i, top)) continue
                queue.add(i)
                visitedSet.add(i)
                }
            }
            count++
        }
        return 0
    }
}
