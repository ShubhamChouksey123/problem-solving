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
18    private int index;
19
20    private TreeNode bstFromPreorderUtil(int[] preorder, Integer minValue, Integer maxValue) {
21
22        if(index == preorder.length)
23            return null;
24
25        if(preorder[index] > maxValue)  return null;
26        
27        TreeNode root = new TreeNode(preorder[index++]);
28        
29        if(index < preorder.length && preorder[index] < root.val){
30            root.left = bstFromPreorderUtil(preorder, preorder[index], root.val);
31            
32        }
33        if(index < preorder.length && preorder[index] > root.val){
34            root.right = bstFromPreorderUtil(preorder, root.val, maxValue);    
35        }
36        return root;
37    }
38
39    public TreeNode bstFromPreorder(int[] preorder) {
40        return bstFromPreorderUtil(preorder, 0, Integer.MAX_VALUE); 
41    }   
42}