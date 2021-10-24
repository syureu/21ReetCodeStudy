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

    lateinit var preorder: IntArray
    var prePt = 0
    val inIdx = HashMap<Int, Int>()

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        this.preorder = preorder
        inorder.forEachIndexed { index, i -> inIdx[i] = index }
        return recursive(0, preorder.size - 1)
    }

    fun recursive(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val root = TreeNode(preorder[prePt++])
        root.left = recursive(l, inIdx[root.`val`]!! - 1)
        root.right = recursive(inIdx[root.`val`]!! + 1, r)
        return root
    }
}