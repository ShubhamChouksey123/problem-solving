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

    private boolean isLeaf(TreeNode root) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private void removeLeafNodesUtil(TreeNode root, int target) {

        if (root == null)
            return;


        removeLeafNodesUtil(root.left, target);
        removeLeafNodesUtil(root.right, target);

        if (isLeaf(root.left) && root.left.val == target) {
            root.left = null;
        }

        if (isLeaf(root.right) && root.right.val == target) {
            root.right = null;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(target + 1);
        dummy.left = root;

        removeLeafNodesUtil(dummy, target);
        return dummy.left;
    }
}