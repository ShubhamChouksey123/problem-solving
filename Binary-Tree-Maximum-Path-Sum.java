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
18    private Integer maxPathSum;
19    
20    private int maxPathSumUtil(TreeNode root) {
21        if(root == null)
22            return 0;
23        
24
25        int leftSum  = maxPathSumUtil(root.left);
26        int rightSum = maxPathSumUtil(root.right);
27
28        int pathSum = root.val;
29        if(leftSum > 0){
30            pathSum += leftSum;
31        }
32        if(rightSum > 0){
33            pathSum += rightSum;
34        }
35        if(pathSum > maxPathSum) maxPathSum = pathSum;
36
37        return Math.max(Math.max(leftSum, rightSum), 0) + root.val;
38    }
39
40    public int maxPathSum(TreeNode root) {
41        maxPathSum = Integer.MIN_VALUE;
42        maxPathSumUtil(root);
43        return maxPathSum;
44    }
45
46}