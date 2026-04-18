/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result
        var queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            var list = mutableListOf<Int>()

            repeat(level) {
                var root = queue.removeFirst()
                list.add(root.`val`)
                if (root.left != null) queue.addLast(root.left)
                if (root.right != null) queue.addLast(root.right)
            }
            result.add(list)
        }

        return result
    }
}
