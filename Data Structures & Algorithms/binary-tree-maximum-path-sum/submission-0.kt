/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var result = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        maxPath(root)
        return result
    }

    fun maxPath(node: TreeNode?): Int {
        if (node == null) return 0
        val left = maxOf(0, maxPath(node.left))
        val right = maxOf(0, maxPath(node.right))
result = maxOf(result, node.`val`+left+right)

        return node.`val`+maxOf(left, right)
    }
}
