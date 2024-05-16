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
     public TreeNode flattenUtility(TreeNode root) {

        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null) {
            root.left = flattenUtility(root.left);
        }
        if (root.right != null) {
            root.right = flattenUtility(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left != null) {
            /**
             * both not null
             */
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode lastNode = root.right;
            while (lastNode != null && lastNode.right != null) {
                lastNode = lastNode.right;
            }
            lastNode.right = right;

        }

        return root;
    }

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        flattenUtility(root);

    }
}