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
    private int count = 0;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        findSmallest(root, k);
        return ans;
    }

    public void findSmallest(TreeNode node, int k){
        if(node == null || count >= k) return;

        findSmallest(node.left, k);

        count++;

        if(count == k){

            ans = node.val;
            return;
        }

        findSmallest(node.right, k);

    }
}
