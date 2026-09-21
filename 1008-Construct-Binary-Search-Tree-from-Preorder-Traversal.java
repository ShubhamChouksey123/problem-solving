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
    
    private int index;

    private TreeNode bstFromPreorder(int[] preorder, int minValue, int maxValue) {
        
        int n = preorder.length;
        if(index == n) return null;

        if(minValue > maxValue) return null;
        if(preorder[index] > maxValue) return null;

        TreeNode root = new TreeNode(preorder[index++]);

        if(index < n && preorder[index] < root.val){
            root.left = bstFromPreorder(preorder, minValue, root.val);
        }
        if(index < n && preorder[index] > root.val){
            root.right = bstFromPreorder(preorder, root.val, maxValue);
        }
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        index = 0;
        return bstFromPreorder(preorder, 0, 1001);
    }
}