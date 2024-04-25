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
    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        averageOfLevelsUtil(root, sums, counts, 0);


        for (int i = 0; i < sums.size(); i++) {
            sums.set(i, sums.get(i) / counts.get(i));
        }
        return sums;
    }

    public void averageOfLevelsUtil(TreeNode root, List<Double> sums, List<Integer> counts, int level) {

        if (root == null) {
            return;
        }

        if (sums.size() < level + 1) {
            sums.add((double) root.val);
            counts.add(1);
        } else {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        }


        averageOfLevelsUtil(root.left, sums, counts, level + 1);
        averageOfLevelsUtil(root.right, sums, counts, level + 1);

    }
}