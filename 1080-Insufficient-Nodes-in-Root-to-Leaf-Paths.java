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
    
    private int sufficientSubsetUtil(TreeNode root, int limit, int ancestralSum) {
        
        if(root == null) return 0;

        int pathSum = ancestralSum + root.val;
        if(root.left == null && root.right == null){
            if(pathSum < limit) return Integer.MIN_VALUE;
        }

        int leftSubTreePathSum = sufficientSubsetUtil(root.left, limit, pathSum);
        int rightSubTreePathSum = sufficientSubsetUtil(root.right, limit, pathSum);

        if(leftSubTreePathSum == Integer.MIN_VALUE && root.right == null){
            return Integer.MIN_VALUE;
        }
        if(rightSubTreePathSum == Integer.MIN_VALUE && root.left == null){
            return Integer.MIN_VALUE;
        }
        if(leftSubTreePathSum == Integer.MIN_VALUE){
            root.left = null;   
        }
        if(rightSubTreePathSum == Integer.MIN_VALUE){
            root.right = null;   
        }

        if(leftSubTreePathSum == Integer.MIN_VALUE && rightSubTreePathSum == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return 0;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int sum = sufficientSubsetUtil(root, limit, 0);


        if(sum == Integer.MIN_VALUE) return null;
        return root;
    }
}