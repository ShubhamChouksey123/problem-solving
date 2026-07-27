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
    public void reverseOddLevels(TreeNode root1, TreeNode root2, int level) {
        
        if(root1 == null) return;

        if(level % 2 != 0){
            int tmp = root1.val;
            root1.val = root2.val;
            root2.val = tmp; 
            
        }
        
        reverseOddLevels(root1.left, root2.right, level + 1);
        reverseOddLevels(root1.right, root2.left, level + 1); 

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        
        reverseOddLevels(root.left, root.right, 1);
        return root;
    }
}