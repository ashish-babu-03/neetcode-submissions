/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        return countGoodNodes(root, root.`val`)
    }

    fun countGoodNodes(node: TreeNode?, max: Int): Int {
        if (node == null) return 0
        var maxSoFar = max(max, node.`val`)
        val leftGoodNode = countGoodNodes(node.left, maxSoFar)
        val rightGoodNode = countGoodNodes(node.right, maxSoFar) 
        val addCount = if (node.`val` >= max) 1 else 0
        return leftGoodNode + rightGoodNode + addCount
    }
}
