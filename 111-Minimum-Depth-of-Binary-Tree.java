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

    private int minDepth;

    private void inOrder(TreeNode root, int depth){

        if(root == null) return;

        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, depth); return;
        }

        inOrder(root.left, depth + 1);
        inOrder(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        
        minDepth = Integer.MAX_VALUE;
        inOrder(root, 1);
        return minDepth == Integer.MAX_VALUE ? 0  : minDepth;
    }
}