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

    public Integer maxPathSum = Integer.MIN_VALUE;

    public int maxPathSumUtil(TreeNode root) {

        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            this.maxPathSum = Math.max(root.val, this.maxPathSum);
            return root.val;

        }

        int thisRootSum = root.val;
        int leftSum = 0;
        if (root.left != null) {
            leftSum = maxPathSumUtil(root.left);
        }
        int rightSum = 0;
        if (root.right != null) {
            rightSum = maxPathSumUtil(root.right);
        }

        this.maxPathSum = Math.max(root.val, this.maxPathSum);
        this.maxPathSum = Math.max(root.val + leftSum, this.maxPathSum);
        this.maxPathSum = Math.max(root.val + rightSum, this.maxPathSum);
        this.maxPathSum = Math.max(root.val + leftSum + rightSum, this.maxPathSum);

        int a = root.val;
        int b = root.val + leftSum;
        int c = root.val + rightSum;
        int d = root.val + leftSum + rightSum;
        return Math.max(a, Math.max(b, c));
    }

    public int maxPathSum(TreeNode root) {

        this.maxPathSum = Integer.MIN_VALUE;
        maxPathSumUtil(root);

        System.out.println("maxPathSum : " + this.maxPathSum);
        return this.maxPathSum;

    }
}