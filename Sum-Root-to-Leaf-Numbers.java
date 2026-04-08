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
18    Integer totalSum;
19
20    private void sumNumbers(TreeNode root, Integer currentSum) {
21
22        if(root == null){
23            return;
24        }
25
26        currentSum = currentSum * 10 + root.val;
27
28        if(root.left == null && root.right == null){
29            totalSum += currentSum;
30        }
31
32        sumNumbers(root.left , currentSum);
33        sumNumbers(root.right, currentSum);
34
35        
36        currentSum -= root.val;
37        currentSum /= 10;
38        
39    }
40    
41
42    public int sumNumbers(TreeNode root) {
43        totalSum = 0;
44        sumNumbers(root, 0);
45        return totalSum;
46    }
47}