/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        var max = 0
        
    fun findDepth(root: TreeNode?, depth: Int) {
        max = max(max, depth)
        if (root == null) return
        findDepth(root.left, depth +1)
        findDepth(root.right, depth +1)
    }
    findDepth(root, 0)
       return max
    }

}
