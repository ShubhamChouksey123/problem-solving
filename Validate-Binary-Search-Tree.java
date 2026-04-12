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
17    
18    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
19        if(root == null)
20            return true;
21        
22        if(root.val <= minValue || root.val >= maxValue){
23            return false;
24        }
25
26        return isValidBST(root.left, minValue, root.val) & isValidBST(root.right, root.val, maxValue); 
27    }
28    
29    public boolean isValidBST(TreeNode root) {
30        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);    
31    }
32}