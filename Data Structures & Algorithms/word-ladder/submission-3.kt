class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        fun isOneLetterDiff(str1: String, str2: String): Boolean {
            var diff = 0
            for (i in str1.indices) {
                if (str1[i] != str2[i]) diff++
            }
            return diff == 1
        }
        val visited = HashSet<String>()
        val queue = ArrayDeque<String>()
        queue.add(beginWord)
        var count = 1

        while (queue.isNotEmpty()) {
            val level = queue.size
            var isUpdated = false
            repeat (level) {
                val top = queue.removeFirst()
                if (top == endWord) return count
                for(word in wordList) {
                    if(word in visited || !isOneLetterDiff(word, top)) continue
                    isUpdated = true
                    queue.add(word)
                    visited.add(word)
                }
            }
            if (isUpdated) count++
        }

        return 0
    }
}
