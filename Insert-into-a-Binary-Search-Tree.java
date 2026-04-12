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
18    private void insertIntoBSTUtil(TreeNode root, int val) {
19        
20        if(root.left != null && root.val > val){
21            insertIntoBSTUtil(root.left, val);
22            return; 
23        }
24
25        if(root.right != null && root.val < val){
26            insertIntoBSTUtil(root.right, val); return;
27        }
28
29        if(root.val < val && root.right == null){
30            root.right = new TreeNode(val);
31            return;
32        }
33
34        if(root.val > val && root.left == null){
35            root.left = new TreeNode(val);
36            return;
37        }
38    }
39    
40    public TreeNode insertIntoBST(TreeNode root, int val) {
41        
42        if(root == null){
43            return new TreeNode(val);
44        }
45        insertIntoBSTUtil(root, val); 
46        return root;
47    }
48}