class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        // Does subRoot start exactly here?
        if (sameTree(root, subRoot)) {
            return true;
        }

        // Otherwise search for another starting point
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }


    public boolean sameTree(TreeNode root, TreeNode subRoot) {

        // Both ended together
        if (root == null && subRoot == null) {
            return true;
        }

        // Structure differs
        if (root == null || subRoot == null) {
            return false;
        }

        // Values differ
        if (root.val != subRoot.val) {
            return false;
        }

        // Both left AND right must match
        return sameTree(root.left, subRoot.left)
            && sameTree(root.right, subRoot.right);
    }
}