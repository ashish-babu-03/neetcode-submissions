/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var c1 = l1
        var c2 = l2
        var curr: ListNode? = dummy
        var carry = 0
        while (c1 != null || c2 != null || carry != 0) {
            val sum = (c1?.`val` ?: 0) + (c2?.`val` ?: 0) + carry
            carry = sum /10
            curr!!.next = ListNode(sum % 10)
            curr = curr?.next
            c1 = c1?.next
            c2 = c2?.next
        }
        return dummy.next
    }
}
