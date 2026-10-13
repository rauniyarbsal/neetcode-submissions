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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return maxDiameter;

    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        int diameter = lh + rh;

        maxDiameter = Math.max(maxDiameter, diameter);

        return 1 + Math.max(lh, rh);
    }
}
