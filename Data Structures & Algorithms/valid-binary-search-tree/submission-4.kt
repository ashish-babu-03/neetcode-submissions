/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    fun isValidBST(node: TreeNode?, min: Int, max: Int): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) return false
        return isValidBST(node.left, min, node.`val`) && 
        isValidBST(node.right, node.`val`, max)
    }
}
