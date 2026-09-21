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
    
    public boolean isValidBST(TreeNode root, Long minValue, Long maxValue) {
        
        if(root == null) return true;
        if(root.val <= minValue || root.val >= maxValue) return false;

        return 
            isValidBST(root.left, minValue, (long)root.val) &&
            isValidBST(root.right, (long)root.val, maxValue);        

    }
    
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);   
    }
}