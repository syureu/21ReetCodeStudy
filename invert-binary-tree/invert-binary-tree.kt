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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null) {
            root.left = root.right.also { root.right = root.left }
            invertTree(root.left)
            invertTree(root.right)
        }
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)
    root.right = TreeNode(7)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(9)
    Solution().invertTree(root)
}
