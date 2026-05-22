/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNode(root, Integer.MIN_VALUE);
    }
    int countGoodNode(TreeNode node, int max) {
        if (node == null) return 0;
        int maxSoFar = Math.max(node.val, max);
        int left = countGoodNode(node.left, maxSoFar);
        int right = countGoodNode(node.right, maxSoFar);
        int addCount = 0;
        if (maxSoFar == node.val) addCount = 1;
        return addCount + left + right;
    }
}
