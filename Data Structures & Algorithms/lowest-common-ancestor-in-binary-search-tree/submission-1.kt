/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pVal = p!!.`val`
        val qVal = q!!.`val`
        val rootVal = root!!.`val`
        if (pVal < rootVal && qVal < rootVal) return lowestCommonAncestor(root.left, p, q)
        if (pVal > rootVal && qVal > rootVal) return lowestCommonAncestor(root.right, p, q)
        return root
    }
}
