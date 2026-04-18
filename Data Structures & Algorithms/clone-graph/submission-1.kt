/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    val cloneMap = mutableMapOf<Node, Node>()
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val temp = Node(node.`val`)
        cloneMap[node] = temp
        for (neighbor in node.neighbors) {
            if (!cloneMap.containsKey(neighbor)) cloneMap[neighbor!!] = cloneGraph(neighbor)!!
            temp.neighbors.add(cloneMap[neighbor])
        }

        return temp
    }
}
