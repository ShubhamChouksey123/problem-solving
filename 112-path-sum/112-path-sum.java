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
    
    private boolean isLeaf(TreeNode root){
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
    
    private boolean hasPathSumUtil(TreeNode root, int targetSum, int sum) {
        
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && sum + root.val == targetSum){
            return true;
        }
        return hasPathSumUtil(root.left, targetSum,  sum + root.val) | 
            hasPathSumUtil(root.right, targetSum,  sum + root.val);
        
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return hasPathSumUtil( root,  targetSum, 0);
        
    }
}