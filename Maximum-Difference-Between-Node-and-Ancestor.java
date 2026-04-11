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
18    private Integer maxRange;
19
20    private void maxAncestorDiffUtil(TreeNode root, int minRangeSoFar, int maxRangeSoFar) {
21
22        if(root == null){
23            return ; 
24        }
25
26        maxRange = Math.max(maxRange, Math.abs(root.val - minRangeSoFar));
27        maxRange = Math.max(maxRange, Math.abs(root.val - maxRangeSoFar));
28
29        minRangeSoFar = Math.min(minRangeSoFar, root.val);
30        maxRangeSoFar = Math.max(maxRangeSoFar, root.val);
31
32
33        maxAncestorDiffUtil(root.left, minRangeSoFar, maxRangeSoFar);
34        maxAncestorDiffUtil(root.right, minRangeSoFar, maxRangeSoFar);
35    }
36    
37    public int maxAncestorDiff(TreeNode root) {
38        maxRange = 0;
39        if(root != null){
40            maxAncestorDiffUtil(root, root.val, root.val);
41        }
42        return maxRange;
43        
44    }
45}