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
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            val tempList = mutableListOf<Int>()

            repeat (level) {
                val top = queue.removeFirst()
                if (top!!.left != null) queue.addLast(top.left)
                if (top!!.right != null) queue.addLast(top.right)
                tempList.add(top.`val`)
            }

            result.add(tempList)
        }

        return result
    }
}
