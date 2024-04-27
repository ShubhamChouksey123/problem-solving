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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zigzag = new ArrayList<>();
        zigzagLevelOrderUtil(root, 0, zigzag);
        return zigzag;
    }

    public void zigzagLevelOrderUtil(TreeNode root, int level, List<List<Integer>> zigzag) {

        if (root == null)
            return;

        if (zigzag.size() <= level) {
            List<Integer> row = new ArrayList<>();
            row.add(root.val);
            zigzag.add(row);
        } else {
            if (level % 2 == 0) {
                zigzag.get(level).add(root.val);
            } else {
                zigzag.get(level).add(0, root.val);
            }
        }
        zigzagLevelOrderUtil(root.left, level + 1, zigzag);
        zigzagLevelOrderUtil(root.right, level + 1, zigzag);

    }
}