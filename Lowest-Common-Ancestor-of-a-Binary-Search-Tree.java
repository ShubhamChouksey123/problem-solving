1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12
13    private TreeNode lowestCommonAncestor ;
14    
15    /**
16        pair returninf whether p and q found in this subtree or not 
17     */
18    public void lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
19        if(root == null){
20            return;
21        }
22
23        if(lowestCommonAncestor == null && p.val <= root.val && q.val >= root.val){
24            lowestCommonAncestor = root;
25            return ;
26        }
27
28        if(lowestCommonAncestor == null && (p == root || q == root)){
29            lowestCommonAncestor = root;
30            return ;
31        }
32
33        if(q.val < root.val){
34            lowestCommonAncestorUtil(root.left, p, q);
35            return ;
36        }
37
38        if(p.val > root.val){
39            lowestCommonAncestorUtil(root.right, p, q);
40            return;
41        }
42    }
43    
44    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
45        lowestCommonAncestor = null;
46
47        if(p.val > q.val){
48            lowestCommonAncestorUtil(root, q, p);
49        }else{
50            lowestCommonAncestorUtil(root, p, q);
51        }
52        
53        return lowestCommonAncestor;
54    }
55}