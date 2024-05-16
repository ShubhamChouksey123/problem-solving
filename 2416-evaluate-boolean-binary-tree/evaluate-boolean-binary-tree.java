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

    private boolean convertToBoolean(TreeNode root) {

        if (root == null)
            return false;

        return (root.val > 0) ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean isAttachedToLeaf(TreeNode root) {

        if (root == null || root.left == null || root.right == null) {
            return false;
        }
        if (isLeaf(root.left) && isLeaf(root.right)) {
            return true;
        }

        return false;
    }

    private boolean evaluateTreeUtil(TreeNode root) {

        if (root == null)
            return false;


        if (root.left == null || root.right == null) {
            return (root.val > 0) ? Boolean.TRUE : Boolean.FALSE;
        }

        if (isAttachedToLeaf(root)) {
            if (root.val == 2) {
                return convertToBoolean(root.left) || convertToBoolean(root.right);
            } else if (root.val == 3) {
                return convertToBoolean(root.left) && convertToBoolean(root.right);
            }
        }
        boolean left = evaluateTreeUtil(root.left);
        boolean right = evaluateTreeUtil(root.right);

        if (root.val == 2) {
            return left || right;
        } else if (root.val == 3) {
            return left && right;
        }

        return Boolean.FALSE;
    }

    public boolean evaluateTree(TreeNode root) {
        return evaluateTreeUtil(root);
    }
}