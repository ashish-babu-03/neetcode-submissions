/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val indexMap = inorder.withIndex().associate { it.value to it.index }
        return buildTree(preorder, 0, preorder.size - 1, 0, indexMap)
    }
    fun buildTree(preorder: IntArray, preStart: Int, preEnd: Int, inoStart: Int, map: Map<Int, Int>): TreeNode? {
        if (preStart > preEnd) return null
        val root = preorder[preStart]
        val mid = map[root]!! 
        val leftSize = mid - inoStart

        val rootNode = TreeNode(root)
        rootNode.left = buildTree(preorder, preStart+1, preStart + leftSize, inoStart, map)
        rootNode.right = buildTree(preorder, preStart + leftSize + 1, preEnd, mid+1, map)

        return rootNode
    }
}
