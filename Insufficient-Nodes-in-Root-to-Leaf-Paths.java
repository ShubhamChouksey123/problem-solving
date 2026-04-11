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
18    private boolean sufficientSubsetUtil(TreeNode root, int limit, int sum) {
19    
20        sum = sum + root.val;
21        if(root.left == null && root.right == null){
22            if(sum < limit){
23                return false;
24            }
25            return true;
26        }
27        boolean left = false, right = false;
28        if(root.left != null){
29            left = sufficientSubsetUtil(root.left , limit, sum); 
30            if(!left) root.left = null;
31        }
32        if(root.right != null){
33            right =  sufficientSubsetUtil(root.right, limit, sum); 
34            if(!right) root.right = null; 
35        }
36
37        if(left || right){
38            return true;
39        } 
40        return false;
41    }
42    
43    public TreeNode sufficientSubset(TreeNode root, int limit) {
44        
45        boolean isSufficient = sufficientSubsetUtil(root, limit, 0); 
46        if(!isSufficient){
47            return null;
48        }
49        return root;
50    }
51}