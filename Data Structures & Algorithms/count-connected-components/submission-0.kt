class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var parent = mutableMapOf<Int, Int>()
        var count = n
        for (i in 0..n-1) parent[i] = i
        fun findParent(x: Int): Int = if (parent[x] == x) x else findParent(parent[x]!!)
        
        for (edge in edges) {
            val rootA = findParent(edge[0])
            val rootB = findParent(edge[1])
            if (rootA != rootB) {
                parent[rootB] = rootA
                count--
            } 
        }

        return count
    }
}
