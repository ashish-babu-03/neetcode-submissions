/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var fast = head
        var slow = head

        while (fast != null && fast.next!=null) {
            slow = slow!!.next
            fast = fast?.next?.next
        }
        var curr = slow!!.next
        slow.next = null
        var prev: ListNode? = null
        while (curr != null) {
            var next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        var curr1 = head
        var curr2 = prev
        while (curr2 != null) {
            val t1 = curr1?.next
            val t2 = curr2?.next
            curr1?.next = curr2
            curr2.next = t1
            curr1 = t1
            curr2 = t2
        }
    }
}
