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

    private void insertIntoBSTUtil(TreeNode root, int val) {

        if(root == null) return;

        if(root.left == null && root.right == null){
            if(root.val > val){
                root.left = new TreeNode(val);
            }
            else{
                root.right = new TreeNode(val);
            }
            return;
        }

        if(root.left != null && root.val > val) insertIntoBSTUtil(root.left, val);
        else if(root.right != null && root.val < val) insertIntoBSTUtil(root.right, val);
        else if(root.val > val) root.left = new TreeNode(val);
        else root.right = new TreeNode(val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) return new TreeNode(val);

        insertIntoBSTUtil(root, val);
        return root;
    }
}