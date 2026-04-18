/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var dummy = ListNode(0)
        for (node in lists) {
            val newNode = ListNode(0)
            var curr1: ListNode? = dummy.next
            var curr2: ListNode? = node
            var curr: ListNode? = newNode
            while (curr1 != null && curr2 != null) {
                if (curr1.`val` <= curr2.`val`) {
                    curr!!.next = ListNode(curr1!!.`val`)
                    curr1 = curr1.next
                } else {
                    curr!!.next = ListNode(curr2.`val`)
                    curr2 = curr2.next
                }
                curr = curr!!.next
            }
            if (curr1 != null) curr!!.next = curr1
            if (curr2 != null) curr!!.next = curr2
            dummy.next = newNode.next
        }
        return dummy.next
    }
}
