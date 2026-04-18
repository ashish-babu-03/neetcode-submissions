/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var max = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        height(root)
        return max
    }

    fun height(node: TreeNode?): Int {
        if (node == null) return 0
        val left = height(node.left)
        val right = height(node.right)
        max = maxOf(max, left + right)
        return 1 + maxOf(left, right)
    }
}
