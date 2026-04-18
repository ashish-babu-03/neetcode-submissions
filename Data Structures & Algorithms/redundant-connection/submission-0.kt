class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = mutableMapOf<Int, Int>()
        var result = intArrayOf()
        val vertices = mutableSetOf<Int>()
        for (i in edges) {
            vertices.add(i[0])
            vertices.add(i[1])
        }
        for (i in 0..vertices.size) parent[i] = i

        fun find(x: Int): Int = if (parent[x] == x) x else find(parent[x]!!)
        for (i in edges) {
            val a = find(i[0])
            val b = find(i[1])
            if (find(a) == find(b)) result = intArrayOf(i[0],i[1])
            else parent[b] = a
        }

        return result
    }
}
