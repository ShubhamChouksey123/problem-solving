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

    private int pathSumTargetCount = 0;
    private void findCount(List<Integer> nodeValues, int targetSum) {

        if (nodeValues.isEmpty()) {
            return;
        }

        long sum = 0;
        for (int i = nodeValues.size() - 1; i >= 0; i--) {
            sum += nodeValues.get(i);
            if (sum == targetSum) {
                pathSumTargetCount++;
            }
        }
    }

    private void pathSumUtil(TreeNode root, int targetSum, List<Integer> nodeValues) {

        if (root == null) {
            return;
        }

        nodeValues.add(root.val);
        findCount(nodeValues, targetSum);

        pathSumUtil(root.left, targetSum, nodeValues);
        pathSumUtil(root.right, targetSum, nodeValues);

        nodeValues.remove(nodeValues.size() - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {

        pathSumUtil(root, targetSum, new ArrayList<>());
        return pathSumTargetCount;
    }
}