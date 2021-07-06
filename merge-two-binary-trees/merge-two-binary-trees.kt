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
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        var merged: TreeNode? = when {
            root1 != null || root2 != null -> TreeNode(0)
            else -> return null
        }
        recursive(merged!!, root1, root2)
        return merged
    }

    fun recursive(merged: TreeNode, r1: TreeNode?, r2: TreeNode?) {
        if (r1 != null) merged.`val` += r1.`val`
        if (r2 != null) merged.`val` += r2.`val`
        if (r1?.left != null || r2?.left != null) {
            merged.left = TreeNode(0)
            recursive(merged.left!!, r1?.left, r2?.left)
        }
        if (r1?.right != null || r2?.right != null) {
            merged.right = TreeNode(0)
            recursive(merged.right!!, r1?.right, r2?.right)
        }

    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val s = Solution()

    val root1 = TreeNode(1)
    root1.left = TreeNode(3)
    root1.left!!.left = TreeNode(5)
    root1.right = TreeNode(2)
    val root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.left!!.right = TreeNode(4)
    root2.right = TreeNode(3)
    root2.right!!.right = TreeNode(7)
    val ret1 = s.mergeTrees(root1, root2)

    val root3 = null
    val root4 = null
    val ret2 = s.mergeTrees(root3, root4)
}
