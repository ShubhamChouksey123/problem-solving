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
17    public boolean isBalanced(TreeNode root) {
18        
19        return checkHeight(root) != -1;
20    }
21
22    public int checkHeight(TreeNode root) {
23        
24        if(root == null){
25            return 0;
26        }
27
28        int left = 0, right = 0;
29        if(root.left != null){
30            left = checkHeight(root.left);
31        }
32        if(left == -1) return -1;
33        if(root.right != null){
34            right = checkHeight(root.right);
35        }
36        if(right == -1) return -1;
37        if(Math.abs(left - right) > 1){
38            return -1;
39        }
40
41        return Math.max(left, right) + 1;
42    }
43}