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
    fun rob(root: TreeNode?): Int {
        val ret = recursive(root)
        return ret.unused.coerceAtLeast(ret.used)
    }

    private fun recursive(node: TreeNode?): Ret {
        if (node == null) return Ret(0, 0)
        val left = recursive(node.left)
        val right = recursive(node.right)
        return Ret(
            (left.unused + right.unused)
                .coerceAtLeast(left.unused + right.used)
                .coerceAtLeast(left.used + right.unused)
                .coerceAtLeast(left.used + right.used),
            node.`val` + left.unused + right.unused
        )
    }
}

data class Ret(val unused: Int, val used: Int)