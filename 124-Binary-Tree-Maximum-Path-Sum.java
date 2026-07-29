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

    private int maxPathSum;

    private int maxPathSumUtil(TreeNode root) {
        
        if(root == null) return 0;

        int leftPathSum = maxPathSumUtil(root.left);
        int rightPathSum = maxPathSumUtil(root.right);

        if(leftPathSum < 0) leftPathSum = 0;
        if(rightPathSum < 0) rightPathSum = 0; 

        maxPathSum = Math.max(maxPathSum, root.val + leftPathSum + rightPathSum);
        
        return root.val + Math.max(0, Math.max(leftPathSum, rightPathSum));
    }

    public int maxPathSum(TreeNode root) {
        
        maxPathSum = Integer.MIN_VALUE;
        maxPathSumUtil(root) ;

        return maxPathSum;
    }
}