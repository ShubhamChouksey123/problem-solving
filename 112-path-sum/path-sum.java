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
   


     public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {

        if (root == null)
            return false;

        currentSum = currentSum + root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == currentSum)
                return true;
        }

        return hasPathSum(root.left, targetSum, currentSum) || hasPathSum(root.right, targetSum, currentSum);

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        return hasPathSum(root, targetSum, 0);
    }
}