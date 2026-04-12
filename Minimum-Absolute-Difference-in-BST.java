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
17    private Integer previousNodeValue;
18    private Integer minDifference;
19    
20    private void inOrder(TreeNode root) {
21        if(root == null){
22            return;
23        }
24
25        inOrder(root.left);
26        
27        int difference = Math.abs(root.val - previousNodeValue);
28        if(difference < minDifference){
29            minDifference = difference;
30        }
31        previousNodeValue = root.val;
32
33        inOrder(root.right);
34    }
35
36    public int getMinimumDifference(TreeNode root) {
37        minDifference =  (int)Math.pow(10, 5) + 1;
38        previousNodeValue = (int)Math.pow(10, 5) + 1;
39
40        inOrder(root);
41        return minDifference;
42    }
43}