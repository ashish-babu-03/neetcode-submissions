/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var count= 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return inOrderTraversal(root, k) ?: 0
    }
    fun inOrderTraversal(node: TreeNode?, k: Int): Int? {
        if (node== null) return null
        
        val left = inOrderTraversal(node.left, k)
        if (left != null) return left

        count++
        if (count == k) return node.`val`

        val right = inOrderTraversal(node.right, k)
        if (right != null) return right

        return null
    }
}
