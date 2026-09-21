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

    private long maxPath;

    public long pathSum(TreeNode root) {
        
        if(root == null) return 0;
        
        long leftPath = pathSum(root.left);
        long rightPath = pathSum(root.right);  

        long thisPathSum = root.val;
        if(leftPath >= 0){
            thisPathSum += leftPath;
        }
        if(rightPath >= 0){
            thisPathSum += rightPath;
        }

        maxPath = Math.max(maxPath, thisPathSum);
        return root.val + Math.max(Math.max(leftPath, rightPath), 0);
    }

    public int maxPathSum(TreeNode root) {
        
        maxPath = Integer.MIN_VALUE;
        pathSum(root);

        return (int)maxPath;
    }
}