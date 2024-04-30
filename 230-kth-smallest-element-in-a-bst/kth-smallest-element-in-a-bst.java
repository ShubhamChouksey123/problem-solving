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

    public Integer nodeVisitedCount = 0;
    public Integer kthSmallestNode = 0;
    public void kthSmallestUtil(TreeNode root, int k) {

        if (root == null)
            return;

        kthSmallestUtil(root.left, k);

        nodeVisitedCount++;
        if (nodeVisitedCount == k) {
            kthSmallestNode = root.val;
        }
//        System.out.println("root.val : " + root.val);
        kthSmallestUtil(root.right, k);

    }

    public int kthSmallest(TreeNode root, int k) {
        this.kthSmallestNode = 0;
        kthSmallestUtil(root, k);
        return kthSmallestNode;
    }

}