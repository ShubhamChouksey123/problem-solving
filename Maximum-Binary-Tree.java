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
18    private int getIndexOfMaximumValue(int[] nums, int start, int end){
19        int maxValue = Integer.MIN_VALUE; int ans = start;
20        for(int i = start; i <= end ; i++){
21            if(maxValue < nums[i]){
22                maxValue = nums[i]; ans = i;
23            }
24        }
25        return ans;
26    }
27
28    public TreeNode constructMaximumBinaryTreeUtil(int[] nums, int start, int end) {
29        if(start > end){
30            return null;
31        }
32        if(start == end){
33            return new TreeNode(nums[start]);
34        }
35
36        int indexOfRoot = getIndexOfMaximumValue(nums, start, end);
37        TreeNode root = new TreeNode(nums[indexOfRoot]);
38
39        root.left  = constructMaximumBinaryTreeUtil(nums, start, indexOfRoot -1);
40        root.right = constructMaximumBinaryTreeUtil(nums, indexOfRoot + 1, end);
41        return root;
42    }
43
44    public TreeNode constructMaximumBinaryTree(int[] nums) {
45        int n = nums.length;
46        return constructMaximumBinaryTreeUtil(nums, 0, n - 1);
47    }
48}