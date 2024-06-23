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
    
    public int maxDepthUtil(TreeNode root, int depth) {
        if(root == null){
            return depth;
        }

        return Math.max(maxDepthUtil(root.left, depth + 1), maxDepthUtil(root.right, depth + 1)); 
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxDepthUtil(root, 0);
    }
}