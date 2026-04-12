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
18    public int rangeSumBST(TreeNode root, int low, int high) {
19        if(root == null)
20            return 0;
21
22        int sum = 0;
23        if(root.val >= low && root.val <= high){
24            sum += root.val;
25        }   
26        if(root.val > low){
27            sum += rangeSumBST(root.left, low, Math.min(root.val - 1, high)); 
28        }
29        if(root.val < high){
30            sum += rangeSumBST(root.right, Math.max(root.val + 1, low), high); 
31        }
32        return sum;
33    }
34}