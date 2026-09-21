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

    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {

        if(start > end || start == -1 || end == -1) return null;

        TreeNode root = new TreeNode(preorder[start]);
       
        int rightStart = -1;
        for(int i = start + 1 ; i <= end ; i++){
            if(preorder[i] > root.val){
                rightStart = i; break;
            }
        }
        
        if(rightStart == -1){
            root.left = bstFromPreorder(preorder, start + 1, end); 
        }
        else{
            root.left = bstFromPreorder(preorder, start + 1, rightStart - 1);
            root.right = bstFromPreorder(preorder, rightStart, end);
        }
        
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        int n = preorder.length;
        return bstFromPreorder(preorder, 0, n - 1);
    }
}