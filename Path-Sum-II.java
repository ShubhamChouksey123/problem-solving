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
17    private void pathSum(TreeNode root, int targetSum, List<Integer> nodeValues, int sum, List<List<Integer>> result) {
18
19        if(root == null){
20            return;
21        }
22        sum += root.val;
23        nodeValues.add(root.val);
24        
25        if(root.left == null && root.right == null){
26            if(sum == targetSum){
27                result.add(new ArrayList<>(nodeValues));
28            }
29        }
30
31        pathSum(root.left , targetSum, nodeValues, sum, result); 
32        pathSum(root.right, targetSum, nodeValues, sum, result); 
33
34        nodeValues.remove(nodeValues.size() - 1);
35        sum -= root.val;
36    }
37    
38    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
39        List<Integer> nodeValues = new ArrayList<>();
40        List<List<Integer>> result = new ArrayList<>();
41
42        pathSum(root, targetSum, nodeValues, 0, result);
43        return result;
44
45    }
46}