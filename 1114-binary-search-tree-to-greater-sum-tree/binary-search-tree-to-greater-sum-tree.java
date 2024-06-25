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
    
    private int sum = 0;

    private void bstToGstUtil(TreeNode root) {
        if(root == null){
            return ;
        }
        bstToGstUtil(root.right);
        sum += root.val;
        root.val = sum;

        bstToGstUtil(root.left); 
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return null;
        }
        bstToGstUtil(root) ;
        return root;
    }
}