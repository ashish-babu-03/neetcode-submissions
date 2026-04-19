/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return countGoodNodes(root, Int.MIN_VALUE)
    }

    fun countGoodNodes(node: TreeNode?, max: Int): Int {
        if (node == null) return 0
        val maxSoFar = maxOf(max, node.`val`)
        val left = countGoodNodes(node.left, maxSoFar)
        val right = countGoodNodes(node.right, maxSoFar)
        val addCount = if(maxSoFar == node.`val`) 1 else 0
        return addCount + left + right
    }
}
