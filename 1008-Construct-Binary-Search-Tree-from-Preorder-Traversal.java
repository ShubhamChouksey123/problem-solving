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

    private TreeNode bstFromPreorderUtil(int[] preorder, Integer minValue, Integer maxValue) {

        if(index == preorder.length)
            return null;

        if(preorder[index] > maxValue)  return null;
        
        TreeNode root = new TreeNode(preorder[index++]);
        
        if(index < preorder.length && preorder[index] < root.val){
            root.left = bstFromPreorderUtil(preorder, minValue, root.val);
            
        }
        if(index < preorder.length && preorder[index] > root.val){
            root.right = bstFromPreorderUtil(preorder, root.val, maxValue);    
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder, 0, Integer.MAX_VALUE); 
    }   
}