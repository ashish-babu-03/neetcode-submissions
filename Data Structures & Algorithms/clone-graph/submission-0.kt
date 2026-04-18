/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    val cloneMap = mutableMapOf<Node, Node?>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
            val temp = Node(node.`val`)
            cloneMap[node] = temp
        for(n in node.neighbors ?: listOf()) {
            if (!cloneMap.containsKey(n)) { 
                cloneMap[n!!] = cloneGraph(n)
            }
            temp.neighbors.add(cloneMap[n])
        }
        return temp
    }
}
