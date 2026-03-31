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
18    public void levelOrderUtil(TreeNode root, List<List<Integer>> levelOrderTraversal, int depth) {
19
20        if(root == null){
21            return;
22        }
23        if(levelOrderTraversal.size() < depth + 1){
24            levelOrderTraversal.add(new ArrayList<>());
25        }
26        levelOrderTraversal.get(depth).add(root.val);
27
28        levelOrderUtil(root.left, levelOrderTraversal, depth + 1);
29        levelOrderUtil(root.right, levelOrderTraversal, depth + 1);
30    }
31    
32    public List<List<Integer>> levelOrder(TreeNode root) {
33        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
34
35        levelOrderUtil(root, levelOrderTraversal, 0);
36        return levelOrderTraversal;
37    }
38}