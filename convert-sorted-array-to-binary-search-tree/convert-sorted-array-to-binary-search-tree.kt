/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    lateinit var nums: IntArray
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        this.nums = nums
        return recursive(if (nums.isEmpty()) null else TreeNode(0), 0, nums.size - 1)
    }

    fun recursive(head: TreeNode?, i: Int, j: Int): TreeNode? {
        if (head != null) {
            val mid = (i + j).shr(1)
            head.`val` = nums[mid]
            if (i < mid) {
                head.left = TreeNode(0)
                recursive(head.left, i, mid - 1)
            }
            if (mid < j) {
                head.right = TreeNode(0)
                recursive(head.right, mid + 1, j)
            }
        }
        return head
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
