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
    private int getIndexOfNode(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val)
                return i;
        }

        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postStart, int postEnd) {

        int value = postorder[postEnd];
        TreeNode node = new TreeNode(value);

        int indexOfNode = getIndexOfNode(inorder, inorderStart, inorderEnd, value);

        int leftLength = indexOfNode - inorderStart;
        if (leftLength > 0) {
            node.left = buildTree(inorder, postorder, inorderStart, indexOfNode - 1, postStart, postStart + leftLength - 1);
        }
//        int total = inorderEnd - inorderStart + 1 - leftLength - 1;
        int rightLength =  inorderEnd - inorderStart + 1 - leftLength - 1;
        if (rightLength > 0) {
            node.right = buildTree(inorder, postorder, indexOfNode + 1, inorderEnd, postEnd - rightLength, postEnd - 1);
        }
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}