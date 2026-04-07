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
18    private Integer diameter;
19
20    public int diameterOfBinaryTree(TreeNode root) {
21
22        if(root == null){
23            return 0;
24        }
25        diameter = 0;
26        diameterOfBinaryTreeUtil(root);
27        return diameter;
28    }
29
30    public int diameterOfBinaryTreeUtil(TreeNode root) {
31        
32        int left = 0, right = 0;  
33        if(root.left != null){
34            left  = diameterOfBinaryTreeUtil(root.left) + 1;
35        }
36        if(root.right != null){
37            right = diameterOfBinaryTreeUtil(root.right) + 1;
38        }
39
40        if(left + right > diameter) diameter = left + right;
41        return Math.max(left, right);
42
43    }
44}