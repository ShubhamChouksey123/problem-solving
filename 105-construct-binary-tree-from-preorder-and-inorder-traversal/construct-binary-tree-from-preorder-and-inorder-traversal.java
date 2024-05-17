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
    

    private int getIndexOfRootInOrder(int[] inorder, int inStart, int inEnd, int rootNode) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNode) {
                return i;
            }
        }
        return 0;
    }

    private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }
        int rootNodeValue = preorder[preStart];
        TreeNode rootNode = new TreeNode(rootNodeValue);
        int rootIndexInorder = getIndexOfRootInOrder(inorder, inStart, inEnd, rootNodeValue);

        int leftLength = rootIndexInorder - inStart;
        int rightLength = inEnd - rootIndexInorder;

        if (leftLength >= 1) {
            rootNode.left = buildTreeUtil(preorder, inorder, preStart + 1, preStart + leftLength, inStart, rootIndexInorder - 1);
        }

        if (rightLength >= 1) {
            rootNode.right = buildTreeUtil(preorder, inorder, preStart + leftLength + 1, preEnd, rootIndexInorder + 1, inEnd);
        }

        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeUtil(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


}