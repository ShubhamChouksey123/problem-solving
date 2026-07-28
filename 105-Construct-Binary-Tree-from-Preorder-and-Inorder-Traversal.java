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
    
    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> valueToIndexInOrder, 
        int startPreOrder, int endPreOrder, int startInOrder, int endInOrder) {

        if(startInOrder > endInOrder) return null;

        TreeNode root = new TreeNode(preorder[startPreOrder]);
        int indexOfRoot = valueToIndexInOrder.get(root.val);
        int lengthOfLeftSubTree = indexOfRoot - startInOrder;

        root.left = buildTree(preorder, inorder, valueToIndexInOrder, 
            startPreOrder + 1, startPreOrder + lengthOfLeftSubTree, startInOrder, indexOfRoot - 1);

        root.right = buildTree(preorder, inorder, valueToIndexInOrder, 
            startPreOrder + 1 + lengthOfLeftSubTree, endPreOrder, indexOfRoot + 1, endInOrder);

        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> valueToIndexInOrder = new HashMap<>();
        int n = inorder.length;
        for(int i = 0 ; i < inorder.length ; i++){
            valueToIndexInOrder.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, inorder, valueToIndexInOrder, 0, n - 1, 0, n - 1);
        return root;
    }
}