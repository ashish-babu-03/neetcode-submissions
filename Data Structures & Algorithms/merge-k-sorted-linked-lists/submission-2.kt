/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var result: ListNode? = null
        for (list in lists) result = mergeLists(result, list)
        return result
    }

    fun mergeLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var curr1 = l1
        var curr2 = l2
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` < curr2.`val`) {
                curr!!.next = curr1
                curr1 = curr1.next
            } else {
                curr!!.next = curr2
                curr2 = curr2.next
            }
            curr = curr.next!!
        }
        if (curr1 != null) curr.next = curr1
        if (curr2 != null) curr.next = curr2

        return dummy.next
    }
}
