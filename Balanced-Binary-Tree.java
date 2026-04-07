1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    private int getHeight(TreeNode root) {
18        if(root == null)
19            return 0;
20
21        return Math.max(getHeight(root.left), getHeight(root.right)) + 1 ;
22    }
23    
24    public boolean isBalanced(TreeNode root) {
25
26        if(root == null)
27            return true;
28
29        int leftHeight  = getHeight(root.left);
30        int rightHeight = getHeight(root.right);
31
32        if(Math.abs(leftHeight - rightHeight) > 1)
33            return false;
34        return isBalanced(root.left) && isBalanced(root.right);
35    }
36}