1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12
13    private TreeNode lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
14
15        if(root == null)
16            return null;
17        
18        if(root == p || root == q){
19            return root;
20        }
21        
22        TreeNode left  = lowestCommonAncestorUtil(root.left , p, q); 
23        TreeNode right = lowestCommonAncestorUtil(root.right, p, q);
24        
25
26        if(left != null && right != null){
27            return root;
28        }
29
30
31        return (left != null) ? left : right; 
32    }
33
34    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
35        return lowestCommonAncestorUtil(root, p, q); 
36    }
37}