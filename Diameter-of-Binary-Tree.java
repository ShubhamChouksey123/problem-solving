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
32        if(root.left == null && root.right == null){
33            return 0;
34        }  
35        int left = 0, right = 0;  
36        if(root.left != null){
37            left  = diameterOfBinaryTreeUtil(root.left) + 1;
38        }
39        if(root.right != null){
40            right = diameterOfBinaryTreeUtil(root.right) + 1;
41        }
42
43        if(left  > diameter) diameter = left;
44        if(right > diameter) diameter = right;
45
46        if(left + right > diameter) diameter = left + right;
47        return Math.max(left, right);
48
49    }
50}