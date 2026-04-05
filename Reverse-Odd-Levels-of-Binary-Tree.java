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
17    public TreeNode reverseOddLevels(TreeNode root) {
18        reverseOddLevelsUtil(root.left, root.right, 0);
19        return root;
20    }
21
22    public void reverseOddLevelsUtil(TreeNode node1, TreeNode node2, int level) {
23
24        if(node1 == null || node2 == null){
25            return; 
26        }
27
28        if(level %2 == 0){
29            int tmp = node1.val;
30            node1.val = node2.val;
31            node2.val = tmp;
32        }
33
34        reverseOddLevelsUtil(node1.left , node2.right, level + 1);
35        reverseOddLevelsUtil(node1.right, node2.left , level + 1); 
36    }
37}