/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        var curr1: Node? = head
        val newNode = Node(0)
        var curr2: Node? = newNode
        val map = mutableMapOf<Node, Node>()
        while (curr1 != null && curr2 != null) {
            val newNode = Node(curr1.`val`)
            curr2.next = newNode
            map[curr1] = newNode
            curr1 = curr1?.next
            curr2 = curr2?.next
        }
        curr1 = head
        curr2 = newNode.next
        while (curr1 != null && curr2 != null) {
            curr2.random = map[curr1.random]
            curr1 = curr1?.next
            curr2 = curr2?.next
        }
        return newNode.next
    }
}
