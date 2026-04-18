/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var node = head
        var count = 0
        while(count < k) {
            if (node == null) return head
            node = node!!.next
            count++
        }

        var prev: ListNode? = null
        var curr: ListNode? = head

        repeat(k) {
            val next = curr!!.next
            curr.next = prev
            prev = curr
            curr = next
        }
        head!!.next = reverseKGroup(curr, k)

        return prev 
    }
}
