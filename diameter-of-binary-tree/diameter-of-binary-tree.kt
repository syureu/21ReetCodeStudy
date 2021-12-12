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
    var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        recursive(root)
        return max
    }

    private fun recursive(root: TreeNode?): Int {
        if (root == null) return 0
        val left = recursive(root.left)
        val right = recursive(root.right)

        max = max.coerceAtLeast(left + right)
        return left.coerceAtLeast(right) + 1
    }
}