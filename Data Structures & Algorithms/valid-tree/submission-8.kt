class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n-1) return false
        val parent = mutableMapOf<Int, Int>()
        for (i in 0..n-1) parent[i] = i
        fun findParent(x: Int): Int {
            return if (parent[x] == x) x
            else findParent(parent[x]!!)
        }

        for (edge in edges) {
            val rootA = findParent(edge[0])
            val rootB = findParent(edge[1])
            if (rootA == rootB) return false
            parent[rootB] = rootA
        }
        return true
    }
}
