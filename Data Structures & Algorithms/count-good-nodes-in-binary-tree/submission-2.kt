/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return countGoodNode(root, -100)
    }

    fun countGoodNode(node: TreeNode?, max: Int): Int {
        if (node == null) return 0
        val maxSoFar = maxOf(node.`val`, max)
        val left = countGoodNode(node.left, maxSoFar)
        val right = countGoodNode(node.right, maxSoFar)
        val addCount = if (maxSoFar == node.`val`) 1 else 0
        return addCount + left + right
    }
}
