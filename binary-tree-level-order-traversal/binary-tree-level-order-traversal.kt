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
    fun levelOrder(root: TreeNode?, depth: Int = 0, ans: ArrayList<ArrayList<Int>> = ArrayList()): List<List<Int>> {
        if (root == null) return ans
        if (ans.size == depth) ans.add(ArrayList())
        ans[depth].add(root.`val`)
        levelOrder(root.left, depth + 1, ans)
        levelOrder(root.right, depth + 1, ans)
        return ans
    }
}