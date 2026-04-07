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
18        return getHeight(root) != -1;
19    }
20
21    public int getHeight(TreeNode root) {     
22        
23        if(root == null){
24            return 0;
25        }
26
27        int left = getHeight(root.left);
28        if(left == -1) return -1;
29
30        int right = getHeight(root.right);
31        if(right == -1) return -1;
32
33        if(Math.abs(left - right) > 1){
34            return -1;
35        }
36        return Math.max(left, right) + 1;
37    }
38}