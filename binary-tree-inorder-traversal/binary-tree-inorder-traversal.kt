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
    fun inorderTraversal(root: TreeNode?, ans: ArrayList<Int> = ArrayList()): List<Int> {
        if (root != null) {
            inorderTraversal(root.left, ans)
            ans.add(root.`val`)
            inorderTraversal(root.right, ans)
        }
        return ans
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
