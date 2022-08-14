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
    
    private Integer maxVal = 0;
    
    public Integer diameterOfBinaryTreeUtil(TreeNode root) {
        
        if(root == null)
            return 0;
        
        
        if(root.left == null && root.right == null)
            return 0;
        
        Integer leftDia = 0;
        Integer rightDia = 0;
        
        if(root.left != null){
             leftDia = diameterOfBinaryTreeUtil(root.left) + 1;
        }
        if(root.right != null){
             rightDia = diameterOfBinaryTreeUtil(root.right) + 1;
        }
        
        maxVal = Math.max(maxVal, leftDia + rightDia);
        
        return Math.max(leftDia , rightDia);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        Integer dia = diameterOfBinaryTreeUtil(root);
        return maxVal.intValue();
     }
}

/**

[1]
[1, 2]
[1, 2, 3]

*/