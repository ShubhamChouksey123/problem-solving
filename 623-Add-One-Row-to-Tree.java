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

    public void addOneRowUtil(TreeNode root, int val, int depth, int level) {

        if(root == null) return;

        if(level == depth - 1) {
            TreeNode leftNewNode = new TreeNode(val);
            leftNewNode.left = root.left;
            root.left = leftNewNode;

            TreeNode rightNewNode = new TreeNode(val);
            rightNewNode.right = root.right;
            root.right = rightNewNode;
            return;
        }

        addOneRowUtil(root.left, val, depth, level + 1);
        addOneRowUtil(root.right, val, depth, level + 1);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth == 1) return new TreeNode(val, root, null);

        addOneRowUtil(root, val, depth, 1);
        return root;
    }
}