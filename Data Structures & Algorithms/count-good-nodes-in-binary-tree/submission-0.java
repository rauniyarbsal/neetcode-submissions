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
        if(root == null) return 0;

        return findGoodNodes(root, root.val);
        
    }

    public int findGoodNodes(TreeNode node, int maxSoFar){
        if(node == null) return 0;

        int currentGood = (node.val >= maxSoFar) ? 1 : 0;

        maxSoFar = Math.max(maxSoFar, node.val);

        int left = findGoodNodes(node.left, maxSoFar);
        int right = findGoodNodes(node.right, maxSoFar);

        return currentGood + left + right;
    }
}
