/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var curr = dummy
        var curr1 = list1
        var curr2 = list2
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` <= curr2.`val`) {
                curr.next = curr1
                curr1 = curr1.next
            } else {
                curr.next = curr2
                curr2 = curr2.next
            }
            curr = curr.next!!
        }

        if (curr1 != null) curr.next = curr1
        if (curr2 != null) curr.next = curr2

        return dummy.next
    }
}
