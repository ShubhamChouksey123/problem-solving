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

    public Integer minDiff = Integer.MAX_VALUE;

    public Integer prev = null;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }
        getMinimumDifference(root.left);

        if(prev != null){
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }

        prev = root.val;

        getMinimumDifference(root.right);

        return minDiff;

    }
}