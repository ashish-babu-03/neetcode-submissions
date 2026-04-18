/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) != -1
    }

    fun height(root: TreeNode?): Int {
        if (root == null) return 0
        val left = height(root.left)
        val right = height(root.right)
        return if (abs(left - right) > 1 || left == -1 || right == -1) {
            -1
        } else {
            1 + maxOf(left, right)
        }
    }
}
