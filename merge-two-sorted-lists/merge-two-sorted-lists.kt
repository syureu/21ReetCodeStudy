/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1pt = l1
        var l2pt = l2
        var head: ListNode?
        var node: ListNode?
        if ((l1?.`val` ?: Int.MAX_VALUE) < (l2?.`val` ?: Int.MAX_VALUE)) {
            head = l1
            l1pt = l1pt?.next
        } else {
            head = l2
            l2pt = l2pt?.next
        }
        node = head
        while (l1pt != null || l2pt != null) {
            if ((l1pt?.`val` ?: Int.MAX_VALUE) < (l2pt?.`val` ?: Int.MAX_VALUE)) {
                node!!.next = ListNode(l1pt!!.`val`)
                node = node.next
                l1pt = l1pt.next
            } else {
                node!!.next = ListNode(l2pt!!.`val`)
                node = node.next
                l2pt = l2pt.next
            }
        }
        return head
    }
}