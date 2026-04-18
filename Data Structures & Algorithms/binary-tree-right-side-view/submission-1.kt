/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            var rightMost = 0
            repeat(level) {
                val node = queue.removeFirst()
                rightMost = node.`val`
                if (node.left != null) queue.addLast(node.left!!)
                if (node.right != null) queue.addLast(node.right!!)
            }
            result.add(rightMost)
        }

        return result
    }
}
