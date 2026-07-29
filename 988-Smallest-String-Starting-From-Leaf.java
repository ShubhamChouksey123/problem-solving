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
    
    private String smallestString;

    private void smallestFromLeafUtil(TreeNode root, StringBuilder builder) {

        if(root == null) return;
        char c = (char)('a' + root.val);
        builder.append(c);
        
        if(root.left == null && root.right == null){
            StringBuilder leafToRoot = new StringBuilder(builder);
            String s = leafToRoot.reverse().toString();
            if(smallestString == null || s.compareTo(smallestString) < 0){
                smallestString = s;   
            }
        }

        smallestFromLeafUtil(root.left, builder);
        smallestFromLeafUtil(root.right, builder);

        builder.deleteCharAt(builder.length() - 1);
    }
    
    public String smallestFromLeaf(TreeNode root) {

        smallestFromLeafUtil(root, new StringBuilder());
        return smallestString;
    }
}