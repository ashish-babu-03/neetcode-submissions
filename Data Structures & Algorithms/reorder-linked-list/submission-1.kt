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
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast?.next?.next
        }
        val mid = slow!!.next
        slow.next = null
        var prev: ListNode? = null
        var curr = mid
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        var h1 = head
        var h2 = prev
        while (h2 != null) {
            val t1 = h1?.next
            val t2 = h2?.next
            h1?.next = h2
            h2.next = t1
            h1 = t1
            h2 = t2
        }
    }
}
