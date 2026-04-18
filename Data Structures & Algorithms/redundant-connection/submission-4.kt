class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = mutableMapOf<Int, Int>()
        var result = intArrayOf()
        for (i in 1..edges.size) parent[i] = i

        fun find(x: Int): Int = if (parent[x] == x) x else find(parent[x]!!)
        for (i in edges) {
            val a = i[0]
            val b = i[1]
            if (find(a) == find(b)) result = intArrayOf(a, b)
            else parent[find(b)] = find(a)
        }

        return result
    }
}
