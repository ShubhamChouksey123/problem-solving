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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<>();
        rightSideViewUtil(root, 0, rightNodes);
        return rightNodes;
        
    }
    public void rightSideViewUtil(TreeNode root, int level, List<Integer> rightNodes) {


        if (root == null)
            return;

        if (rightNodes.size() <= level) {
            rightNodes.add(root.val);
        } else {
            rightNodes.set(level, root.val);
        }

        rightSideViewUtil(root.left, level + 1, rightNodes);
        rightSideViewUtil(root.right, level + 1, rightNodes);
    }
}