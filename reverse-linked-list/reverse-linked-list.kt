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
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head
        var next: ListNode?
        while (cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val root: ListNode? = ListNode(1)
    var node = root
    node!!.next = ListNode(2)
    node = node.next
    node!!.next = ListNode(3)
    node = node.next
    node!!.next = ListNode(4)
    node = node.next
    node!!.next = ListNode(5)
    val ans = Solution().reverseList(root)
}
