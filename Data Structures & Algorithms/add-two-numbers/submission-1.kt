/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        var curr1 = head
        var newNode = Node(0)
        var curr2: Node? = newNode
        val nodeMap = HashMap<Node, Node>()
        while (curr1 != null && curr2 != null) {
            val node = Node(curr1.`val`)
            nodeMap[curr1] = node
            curr2!!.next = node
            curr2 = curr2!!.next
            curr1 = curr1!!.next
        }
        
        curr1 = head
        curr2 = newNode.next

        while (curr1 != null && curr2 != null) {
            curr2.random = nodeMap[curr1.random]
            curr1 = curr1?.next
            curr2 = curr2?.next
        }

        return newNode.next
    }
}
