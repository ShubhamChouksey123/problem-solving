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
    public int getMinimumDifferenceUtil(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftValue = getMinimumDifferenceUtil(root.left);
        int rightValue = getMinimumDifferenceUtil(root.right);

        return Math.min(root.val - leftValue, rightValue - root.val);
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode root, Long minValue, Long maxValue) {

         if (root == null)
            return true;

        long value = root.val;
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }

        return isValidBSTUtil(root.left, minValue, value -1) && isValidBSTUtil(root.right, value + 1, maxValue);
    }
}