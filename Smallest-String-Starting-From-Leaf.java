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
18    private String ans;
19    
20    private void smallestFromLeaf(TreeNode root, String cur) {
21        if(root == null){
22            return;
23        }
24        char c = (char)('a' + root.val);
25        String newPath = c + cur;
26        if(root.left == null && root.right == null){
27            if(ans.equals("") || newPath.compareTo(ans) < 0){
28                ans = new String(c + cur); 
29            }
30        }
31        smallestFromLeaf(root.left , newPath);
32        smallestFromLeaf(root.right, newPath);
33    }
34    
35    public String smallestFromLeaf(TreeNode root) {
36        ans = "";
37        smallestFromLeaf(root, ""); 
38        return ans;
39    }
40}