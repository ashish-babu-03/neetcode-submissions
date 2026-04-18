class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val visited = mutableSetOf<Int>()
        val visiting = mutableSetOf<Int>()
        for (courses in prerequisites) map.getOrPut(courses[0]) {mutableListOf()}.add(courses[1])
        
        fun dfs(course: Int): Boolean {
            if (course in visiting) return false
            if (course in visited) return true
            visiting.add(course)
            val preRequisite = map[course] ?: emptyList()
            for (i in preRequisite) {
                if (!dfs(i)) return false
            }
            visiting.remove(course)
            return true
        }

        for(i in 0..numCourses-1) {
            if (!dfs(i)) return false
        }

        return true
    }
}
