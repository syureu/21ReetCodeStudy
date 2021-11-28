import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    // Encodes a URL to a shortened URL.
    private val q = LinkedList<TreeNode?>()

    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        q.offer(root)
        while (q.isNotEmpty()) {
            val node = q.poll()
            sb.append(node?.`val` ?: "null")
            if (node != null) {
                q.offer(node.left)
                q.offer(node.right)
            }
            if (q.isNotEmpty()) {
                sb.append(',')
            }
        }
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "" || data == "null") return null
        q.clear()
        val split = data.split(",").map { if (it != "null") it.toInt() else -50000 }
        val ret = TreeNode(split[0])
        q.offer(ret)
        var i = 1
        while (q.isNotEmpty()) {
            val node = q.poll()!!
            if (split[i] != -50000) {
                node.left = TreeNode(split[i])
                q.offer(node.left)
            }
            i++
            if (split[i] != -50000) {
                node.right = TreeNode(split[i])
                q.offer(node.right)
            }
            i++
        }
        return ret
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */