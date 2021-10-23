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
    fun flatten(root: TreeNode?): Unit {
        if (root != null) {
            if (root.left != null) {
                flatten(root.left)
                var left = root.left
                var right = root.right
                root.left = null
                root.right = left
                while (left!!.right != null) left = left.right
                left.right = right
            }
            if (root.right != null) {
                flatten(root.right)
            }
        }
    }
}
