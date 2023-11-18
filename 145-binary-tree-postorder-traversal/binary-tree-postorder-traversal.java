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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderArray = new ArrayList<>();
        postorderTraversalUtil(root,  postorderArray);
        return postorderArray;
    }

     public void postorderTraversalUtil(TreeNode root, List<Integer> postorderArray) {
        
        if(root == null)
            return;
        postorderTraversalUtil(root.left, postorderArray);
        postorderTraversalUtil(root.right, postorderArray);
        postorderArray.add(root.val);
    }
}