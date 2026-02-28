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
18    public void binaryTreePathsUtils(TreeNode root, List<String> result, String s) {
19
20        if(root == null){
21            return; 
22        }
23
24        String currentPath;
25
26        if(s.length() > 0){
27            currentPath = s + "->" + String.valueOf(root.val);
28        }else{
29            currentPath = String.valueOf(root.val);
30        }
31
32        if(root.left == null && root.right == null){
33            result.add(currentPath);
34        }
35
36        
37        binaryTreePathsUtils(root.left, result, currentPath);
38        binaryTreePathsUtils(root.right, result, currentPath);    
39    }
40    
41    public List<String> binaryTreePaths(TreeNode root) {
42        List<String> result = new ArrayList<>();
43
44        binaryTreePathsUtils(root, result, "");
45        return result;
46    }
47}