/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        
    var sb = StringBuilder()
    fun dfs(node: TreeNode?) {
        if(node == null) {
            sb.append("N,")
            return
        }

        sb.append("${node.`val`},")
        dfs(node.left)
        dfs(node.right)
    }

    dfs(root)
    return sb.toString()

    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val queue = ArrayDeque(data.split(","))
        
        fun dfs(): TreeNode? {
            val v1 = queue.removeFirst()
            if (v1 == "N" || v1 == "") return null

            val root = TreeNode(v1.toInt())
            root.left = dfs()
            root.right = dfs()
            return root
        }

        return dfs()
    }
}
