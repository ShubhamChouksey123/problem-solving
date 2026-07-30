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

    private int maxDifference;
    
    private Pair<Integer, Integer> maxAncestorDiffUtil(TreeNode root) {
        
        if(root == null) return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);

        Pair<Integer, Integer> minMaxLeftSubTree = maxAncestorDiffUtil(root.left);
        Pair<Integer, Integer> minMaxRightSubTree = maxAncestorDiffUtil(root.right);

        int childMinValue = Math.min(minMaxLeftSubTree.getKey(), minMaxRightSubTree.getKey());
        int childMaxValue = Math.max(minMaxLeftSubTree.getValue(), minMaxRightSubTree.getValue());

        if(childMinValue != Integer.MAX_VALUE){
            maxDifference = Math.max(maxDifference, Math.abs(childMinValue - root.val));
        }
        if(childMaxValue != Integer.MIN_VALUE){
            maxDifference = Math.max(maxDifference, Math.abs(childMaxValue - root.val));
        }
        
        return new Pair<>(Math.min(childMinValue, root.val), Math.max(childMaxValue, root.val));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        maxDifference = 0;
        maxAncestorDiffUtil(root) ; 
        return maxDifference;  
    }
}