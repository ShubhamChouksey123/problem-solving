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
    public int sumNumbers(TreeNode root) {

        if (root == null)
            return 0;

        return sumNumbersUtil(root, "");
    }


    public int sumNumbersUtil(TreeNode root, String number) {

        if (root == null) {
            return 0;
        }

        number = number + root.val;

        if (root.left == null && root.right == null) {
            return Integer.parseInt(number);
        }

        int leftSum = sumNumbersUtil(root.left, number);
        int rightSum = sumNumbersUtil(root.right, number);

        return leftSum + rightSum;
    }
}