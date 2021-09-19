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
    fun rightSideView(root: TreeNode?, depth: Int = 0, ans: ArrayList<Int> = ArrayList()): List<Int> {
        if (root != null) {
            if (ans.size == depth) ans.add(root.`val`)
            rightSideView(root.right, depth + 1, ans)
            rightSideView(root.left, depth + 1, ans)
        }
        return ans
    }
}