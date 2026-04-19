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

        val queue = ArrayDeque<TreeNode?>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            var lastElement = 0
            repeat (level) {
                val top = queue.removeFirst()
                if (top!!.left != null) queue.addLast(top.left)
                if (top!!.right != null) queue.addLast(top.right)
                lastElement = top.`val`
            }
            result.add(lastElement)
        }

        return result
    }
}
