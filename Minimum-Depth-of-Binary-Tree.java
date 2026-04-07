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
17    public int minDepth(TreeNode root) {
18
19        if(root == null)
20            return 0;
21        if(root.left == null && root.right == null){
22            return 1;
23        }
24        int left = -1, right = -1; int minValue = Integer.MAX_VALUE;
25        if(root.left != null){
26            left  = minDepth(root.left); minValue = left;
27        }
28        if(root.right != null){
29            right = minDepth(root.right); minValue = Math.min(minValue, right);
30        }
31        
32        return minValue + 1;
33    }
34}