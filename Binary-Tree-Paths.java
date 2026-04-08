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
18    private void binaryTreePaths(TreeNode root, String cur, List<String> result) {
19        
20        if(root == null){
21            return;
22        }
23        if(cur.length() > 0){
24            cur = cur + "->" + root.val;
25        }else{
26            cur = String.valueOf(root.val);
27        }
28        if(root.left == null && root.right == null){
29            result.add(new String(cur)); return;
30        }
31        
32        binaryTreePaths(root.left, cur, result);
33        binaryTreePaths(root.right, cur, result); 
34    }
35    
36    public List<String> binaryTreePaths(TreeNode root) {
37        List<String> result = new ArrayList<>();
38
39        binaryTreePaths(root, "", result);
40        return result; 
41    }
42}