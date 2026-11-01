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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ArrayList<Integer> levelOrderList = new ArrayList<>();
            int queueSize = q.size();
            

            for(int i=0; i < queueSize; i++){
                TreeNode node = q.poll();

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                levelOrderList.add(node.val);
            }

            ans.add(levelOrderList);
        }

        return ans;
    }
}
