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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;

        StringBuilder tree1 = preOrder(root, new StringBuilder());
        StringBuilder tree2 = preOrder(subRoot, new StringBuilder());

        return (tree1.toString().contains(tree2.toString()));
    }

    public StringBuilder preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            return sb.append("#null");

        }

        sb.append("^").append(root.val);

        preOrder(root.left, sb);
        preOrder(root.right, sb);


        return sb;

    }
}
