class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val visited = mutableSetOf<Int>()
        val visiting = mutableSetOf<Int>()

        for (course in prerequisites) map.getOrPut(course[0]) {mutableListOf()}.add(course[1])

        fun dfs(course: Int): Boolean {
            if (visiting.contains(course)) return false
            if (course in visited) return true
            visiting.add(course)
            for (c in map.getOrDefault(course, emptyList())) {
                if (!dfs(c)) return false
            }
            visited.add(course)
            visiting.remove(course)
            return true
        }

        for (i in 0..numCourses-1) {
            if (!dfs(i)) return listOf<Int>().toIntArray()
        }
        return visited.toIntArray()
    }
}
