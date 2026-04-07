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
21        diameter = 0;
22        if(root == null)
23            return 0;
24        getHeight(root) ;
25        return diameter;
26    }
27
28    private int getHeight(TreeNode root) {
29        if(root.left == null && root.right == null){
30            return 0;
31        }
32
33        int left = 0, right = 0;
34        if(root.left != null){
35            left = getHeight(root.left) + 1;
36        }
37        if(root.right != null){
38            right = getHeight(root.right) + 1;
39        }
40        
41        diameter = Math.max(diameter, left + right);
42        return Math.max(left, right);
43    }
44}